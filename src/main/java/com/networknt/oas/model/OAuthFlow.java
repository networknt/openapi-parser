package com.networknt.oas.model;

import java.util.Map;

public interface OAuthFlow extends OpenApiObject<OpenApi3, OAuthFlow> {

    // AuthorizationUrl

    String getAuthorizationUrl();


    String getAuthorizationUrl(boolean elaborate);


    void setAuthorizationUrl(String authorizationUrl);

    // TokenUrl

    String getTokenUrl();


    String getTokenUrl(boolean elaborate);


    void setTokenUrl(String tokenUrl);

    // RefreshUrl

    String getRefreshUrl();


    String getRefreshUrl(boolean elaborate);


    void setRefreshUrl(String refreshUrl);

    // Scope

    Map<String, String> getScopes();


    Map<String, String> getScopes(boolean elaborate);


    boolean hasScope(String name);


    String getScope(String name);


    void setScopes(Map<String, String> scopes);


    void setScope(String name, String scope);


    void removeScope(String name);

    // ScopesExtension

    Map<String, Object> getScopesExtensions();


    Map<String, Object> getScopesExtensions(boolean elaborate);


    boolean hasScopesExtension(String name);


    Object getScopesExtension(String name);


    void setScopesExtensions(Map<String, Object> scopesExtensions);


    void setScopesExtension(String name, Object scopesExtension);


    void removeScopesExtension(String name);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
