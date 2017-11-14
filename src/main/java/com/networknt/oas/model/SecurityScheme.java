package com.networknt.oas.model;

import java.util.Map;
import javax.annotation.Generated;

public interface SecurityScheme extends OpenApiObject<OpenApi3, SecurityScheme> {

    // Type

    String getType();


    String getType(boolean elaborate);


    void setType(String type);

    // Description

    String getDescription();


    String getDescription(boolean elaborate);


    void setDescription(String description);

    // Name

    String getName();


    String getName(boolean elaborate);


    void setName(String name);

    // In

    String getIn();


    String getIn(boolean elaborate);


    void setIn(String in);

    // Scheme

    String getScheme();


    String getScheme(boolean elaborate);


    void setScheme(String scheme);

    // BearerFormat

    String getBearerFormat();


    String getBearerFormat(boolean elaborate);


    void setBearerFormat(String bearerFormat);

    // ImplicitOAuthFlow

    OAuthFlow getImplicitOAuthFlow();


    OAuthFlow getImplicitOAuthFlow(boolean elaborate);


    void setImplicitOAuthFlow(OAuthFlow implicitOAuthFlow);

    // PasswordOAuthFlow

    OAuthFlow getPasswordOAuthFlow();


    OAuthFlow getPasswordOAuthFlow(boolean elaborate);


    void setPasswordOAuthFlow(OAuthFlow passwordOAuthFlow);

    // ClientCredentialsOAuthFlow

    OAuthFlow getClientCredentialsOAuthFlow();


    OAuthFlow getClientCredentialsOAuthFlow(boolean elaborate);


    void setClientCredentialsOAuthFlow(OAuthFlow clientCredentialsOAuthFlow);

    // AuthorizationCodeOAuthFlow

    OAuthFlow getAuthorizationCodeOAuthFlow();


    OAuthFlow getAuthorizationCodeOAuthFlow(boolean elaborate);


    void setAuthorizationCodeOAuthFlow(OAuthFlow authorizationCodeOAuthFlow);

    // OAuthFlowsExtension

    Map<String, Object> getOAuthFlowsExtensions();


    Map<String, Object> getOAuthFlowsExtensions(boolean elaborate);


    boolean hasOAuthFlowsExtension(String name);


    Object getOAuthFlowsExtension(String name);


    void setOAuthFlowsExtensions(Map<String, Object> oAuthFlowsExtensions);


    void setOAuthFlowsExtension(String name, Object oAuthFlowsExtension);


    void removeOAuthFlowsExtension(String name);

    // OpenIdConnectUrl

    String getOpenIdConnectUrl();


    String getOpenIdConnectUrl(boolean elaborate);


    void setOpenIdConnectUrl(String openIdConnectUrl);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
