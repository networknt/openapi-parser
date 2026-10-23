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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import static java.util.Objects.requireNonNull;

/**
 * This utility normalize the RESTful API path so that they can be
 * handled identically.
 *
 * @author Steve Hu
 */
public class ApiNormalisedPath implements NormalisedPath {
    // Base paths are configuration, not request input. Bound the cache for callers
    // that construct paths with dynamically changing configurations.
    private static final ConcurrentHashMap<String, Pattern> BASE_PATTERNS = new ConcurrentHashMap<>();

    Logger logger = LoggerFactory.getLogger(ApiNormalisedPath.class);
    private final List<String> pathParts;
    private final String original;
    private final String normalised;

    /**
     * Construct normalized path
     * @param path original path
     * @param basePath the path you want to overwrite
     *                 - must not be null; use the helper base path explicitly
     *                 - put "" empty String will not trigger any overwrites
     *                 - put regex will remove a matching leading base path at a segment boundary
     */
    public ApiNormalisedPath(final String path, final String basePath) {
        if (logger.isDebugEnabled()) logger.debug("path = {}, base path is set to: {}", path, basePath);
        this.original = requireNonNull(path, "A path is required");
        this.normalised = normalise(path, basePath);
        if (logger.isDebugEnabled()) logger.debug("normalised = " + this.normalised);
        this.pathParts = List.of(normalised.split("/"));
    }

    @Override
    public List<String> parts() {
        return pathParts;
    }

    @Override
    public String part(int index) {
        return pathParts.get(index);
    }

    @Override
    public boolean isParam(int index) {
        final String part = part(index);
        return part.startsWith("{") && part.endsWith("}");
    }

    @Override
    public String paramName(int index) {
        if (!isParam(index)) {
            return null;
        }
        final String part = part(index);
        return part.substring(1, part.length() - 1);
    }

    @Override
    public String original() {
        return original;
    }

    @Override
    public String normalised() {
        return normalised;
    }

    private String normalise(String requestPath, String basePath) {
        requireNonNull(basePath, "A base path is required; use an empty string for specification paths");
        if ("/".equals(basePath)) {
            // Preserve the historical root behavior, including //pets -> /pets.
            if (requestPath.startsWith("/")) requestPath = requestPath.substring(1);
        } else if (!basePath.isEmpty()) {
            Pattern pattern = basePattern(basePath);
            requestPath = pattern.matcher(requestPath).replaceFirst("");
        }
        return requestPath.startsWith("/") ? requestPath : "/" + requestPath;
    }

    private static Pattern basePattern(String basePath) {
        Pattern cached = BASE_PATTERNS.get(basePath);
        if (cached != null) return cached;

        // Hits do not acquire this monitor. Serialize only misses so insertion
        // and eviction preserve the exact size bound under concurrent churn.
        synchronized (BASE_PATTERNS) {
            cached = BASE_PATTERNS.get(basePath);
            if (cached != null) return cached;
            String prefix = basePath;
            while (prefix.endsWith("/")) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.endsWith("\\")) prefix = prefix.substring(0, prefix.length() - 1);
            }
            Pattern compiled = Pattern.compile("^(?:" + prefix + ")(?=/|$)");
            // Eviction order is deliberately unspecified; cache hits need not
            // update shared access-order bookkeeping.
            if (BASE_PATTERNS.size() >= 64) {
                BASE_PATTERNS.remove(BASE_PATTERNS.keySet().iterator().next());
            }
            BASE_PATTERNS.put(basePath, compiled);
            return compiled;
        }
    }
}
