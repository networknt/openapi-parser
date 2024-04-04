/*
 * Copyright (c) 2016 Network New Technologies Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.networknt.openapi;

import com.networknt.oas.OpenApiParser;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.SecurityScheme;
import com.networknt.oas.model.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * This class load and cache openapi.json in a static block so that it can be
 * shared by security for scope validation and validator for schema validation
 *
 * This handler supports openapi.yml, openapi.yaml and openapi.json and above
 * is the loading sequence.
 *
 * Due to the high demand, we have changed this class from singleton to normal
 * class to support multiple instances of specifications in light-rest-4j.
 *
 * Some of our users want to use one light-gateway to support multiple backend
 * services to reduce the resource utilization.
 *
 * @author Steve Hu
 */
public class OpenApiHelper {
    static final Logger logger = LoggerFactory.getLogger(OpenApiHelper.class);

    public OpenApi3 openApi3;
    public List<String> oauth2Names;
    public String basePath;

    public OpenApiHelper(String spec) {
        try {
            openApi3 = (OpenApi3) new OpenApiParser().parse(spec, new URL("https://oas.lightapi.net/"));
        } catch (MalformedURLException e) {
            logger.error("MalformedURLException", e);
        }
        if(openApi3 == null) {
            logger.error("Unable to load openapi.json");
            throw new RuntimeException("Unable to load openapi.json");
        } else {
            oauth2Names = getOAuth2Name();
            basePath = getBasePath();
        }

    }


    /**
     * merge inject map to openapi map
     * @param openapi {@link Map} openapi
     * @param inject {@link Map} openapi
     * @return {@link Map} merged openapi
     */
    public static Map<String, Object> merge(Map<String, Object> openapi, Map<String, Object> inject) {
        if(openapi == null) {
            // in the case of light-gateway with multiple specs disabled, openapi is null,
            // but we still need the validation for the admin endpoint access.
            return inject;
        }
        if (inject == null) {
            return openapi;
        }
        for (Map.Entry<String, Object> entry : inject.entrySet()) {
            openapi.merge(entry.getKey(), entry.getValue(), new Merger());
        }
        return openapi;
    }

    // merge in case of map, add in case of list
    static class Merger implements BiFunction {
        @Override
        public Object apply(Object o, Object i) {
            if (o instanceof Map && i instanceof Map) {
                for (Map.Entry<String, Object> entry : ((Map<String, Object>) i).entrySet()) {
                    ((Map<String, Object>) o).merge(entry.getKey(), entry.getValue(), new Merger());
                }
            } else if (o instanceof List && i instanceof List) {
                ((List<Object>) o).addAll((List)i);
            } else {
                // if has the same key, return the injected
                return i;
            }
            return o;
        }
    }

    public Optional<NormalisedPath> findMatchingApiPath(final NormalisedPath requestPath) {
        if(openApi3 != null) {
            return openApi3.getPaths().keySet()
                    .stream()
                    .map(p -> (NormalisedPath) new ApiNormalisedPath(p, basePath))
                    .filter(p -> pathMatches(requestPath, p))
                    .findFirst();
        } else {
            return Optional.empty();
        }
    }

    private List<String> getOAuth2Name() {
        List<String> names = new ArrayList<>();
        Map<String, SecurityScheme> defMap = openApi3.getSecuritySchemes();
        if(defMap != null) {
            for(Map.Entry<String, SecurityScheme> entry : defMap.entrySet()) {
                if(entry.getValue().getType().equals("oauth2")) {
                    names.add(entry.getKey());
                }
            }
        }
        return names;
    }

    private String getBasePath() {

        String basePath = "";
        String url = null;
        if (openApi3.getServers().size() > 0) {
            Server server = openApi3.getServer(0);
            url = server.getUrl();
        }
        if (url != null) {
            // find "://" index
            int protocolIndex = url.indexOf("://");
            if (protocolIndex != -1) {
                int pathIndex = url.indexOf('/', protocolIndex + 3);
                if (pathIndex > 0) {
                    basePath = url.substring(pathIndex);
                }
            } else {
                // support openapi Relative URLs
                basePath = url.startsWith("/") ? url : "";
            }
        }
        return basePath;
    }

    /**
     * This method should only be called in the multiple specification use case to set the base path
     * based on the OpenApiHandler config with the pathSpecMapping. For single specification use case,
     * this method should be called to overwrite the basePath from the handler.yml configuration in
     * case the openapi.yaml cannot derive the basePath from the server section.
     * @param basePath string
     */
    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    private boolean pathMatches(final NormalisedPath requestPath, final NormalisedPath apiPath) {
        if (requestPath.parts().size() != apiPath.parts().size()) {
            return false;
        }
        for (int i = 0; i < requestPath.parts().size(); i++) {
            if (requestPath.part(i).equalsIgnoreCase(apiPath.part(i)) || apiPath.isParam(i)) {
                continue;
            }
            return false;
        }
        return true;
    }
}
