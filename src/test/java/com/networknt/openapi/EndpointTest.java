package com.networknt.openapi;

import com.google.common.io.Resources;
import com.networknt.oas.model.*;
import org.junit.Test;

import java.net.URL;
import java.util.*;


public class EndpointTest {

    @Test
    public void testJson() throws Exception {
        URL url = Resources.getResource("models/petstore.json");
        String spec = new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next();
        OpenApiHelper.init(spec);

        String basePath = OpenApiHelper.basePath;
        Map<String, Object> endpoints = new HashMap<>();
        Map<String, Path> paths = OpenApiHelper.openApi3.getPaths();
        for (Map.Entry<String, Path> pathPair : paths.entrySet()) {
            String path = pathPair.getKey();
            for (Map.Entry<String, Operation> entries : pathPair.getValue().getOperations().entrySet()) {
                String key = entries.getKey();
                Operation operation = entries.getValue();
                String endpoint = basePath + path + "@" + key;
                Collection<SecurityRequirement> securityRequirements = operation.getSecurityRequirements();
                List<String> scopes = null;
                if(securityRequirements != null) {
                    for(SecurityRequirement requirement: securityRequirements) {
                        SecurityParameter securityParameter = null;
                        for(String oauth2Name: OpenApiHelper.oauth2Names) {
                            securityParameter = requirement.getRequirement(oauth2Name);
                            if(securityParameter != null) break;
                        }
                        if(securityParameter != null) scopes = securityParameter.getParameters();
                        if(scopes != null) break;
                    }
                }
                System.out.println(endpoint);
                Map<String, List<String>> scopeMap = new HashMap<>();
                scopeMap.put("scopes", scopes);
                // scopes, access and filter
                endpoints.put(endpoint, scopeMap);
            }
        }
        System.out.println("endpoints");
    }

    @Test
    public void testYaml() throws Exception {
        URL url = Resources.getResource("models/petstore.yaml");
        String spec = new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next();
        OpenApiHelper.init(spec);

        String basePath = OpenApiHelper.basePath;
        Map<String, Object> endpoints = new HashMap<>();
        Map<String, Path> paths = OpenApiHelper.openApi3.getPaths();
        for (Map.Entry<String, Path> pathPair : paths.entrySet()) {
            String path = pathPair.getKey();
            for (Map.Entry<String, Operation> entries : pathPair.getValue().getOperations().entrySet()) {
                String key = entries.getKey();
                Operation operation = entries.getValue();
                String endpoint = basePath + path + "@" + key;
                Collection<SecurityRequirement> securityRequirements = operation.getSecurityRequirements();
                List<String> scopes = null;
                if(securityRequirements != null) {
                    for(SecurityRequirement requirement: securityRequirements) {
                        SecurityParameter securityParameter = null;
                        for(String oauth2Name: OpenApiHelper.oauth2Names) {
                            securityParameter = requirement.getRequirement(oauth2Name);
                            if(securityParameter != null) break;
                        }
                        if(securityParameter != null) scopes = securityParameter.getParameters();
                        if(scopes != null) break;
                    }
                }
                System.out.println(endpoint);
                Map<String, List<String>> scopeMap = new HashMap<>();
                scopeMap.put("scopes", scopes);
                // scopes, access and filter
                endpoints.put(endpoint, scopeMap);
            }
        }
        System.out.println("endpoints");

    }

}
