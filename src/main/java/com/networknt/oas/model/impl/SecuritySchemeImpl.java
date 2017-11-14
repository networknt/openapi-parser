package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.jsonoverlay.ChildListOverlay;
import com.networknt.oas.jsonoverlay.ChildMapOverlay;
import com.networknt.oas.jsonoverlay.ChildOverlay;
import com.networknt.oas.jsonoverlay.JsonOverlay;
import com.networknt.oas.jsonoverlay.ListOverlay;
import com.networknt.oas.jsonoverlay.MapOverlay;
import com.networknt.oas.jsonoverlay.ObjectOverlay;
import com.networknt.oas.jsonoverlay.OverlayFactory;
import com.networknt.oas.jsonoverlay.ReferenceRegistry;
import com.networknt.oas.jsonoverlay.StringOverlay;
import com.networknt.oas.model.OAuthFlow;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.SecurityScheme;
import com.networknt.oas.model.impl.OAuthFlowImpl;
import com.networknt.oas.model.impl.OpenApiObjectImpl;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public class SecuritySchemeImpl extends OpenApiObjectImpl<OpenApi3, SecurityScheme> implements SecurityScheme {


    public SecuritySchemeImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    public SecuritySchemeImpl(SecurityScheme securityScheme, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(securityScheme, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> type = null;


    private ChildOverlay<String, StringOverlay> description = null;


    private ChildOverlay<String, StringOverlay> name = null;


    private ChildOverlay<String, StringOverlay> in = null;


    private ChildOverlay<String, StringOverlay> scheme = null;


    private ChildOverlay<String, StringOverlay> bearerFormat = null;


    private ChildOverlay<OAuthFlow, OAuthFlowImpl> implicitOAuthFlow = null;


    private ChildOverlay<OAuthFlow, OAuthFlowImpl> passwordOAuthFlow = null;


    private ChildOverlay<OAuthFlow, OAuthFlowImpl> clientCredentialsOAuthFlow = null;


    private ChildOverlay<OAuthFlow, OAuthFlowImpl> authorizationCodeOAuthFlow = null;


    private ChildMapOverlay<Object, ObjectOverlay> oAuthFlowsExtensions = null;


    private ChildOverlay<String, StringOverlay> openIdConnectUrl = null;


    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

    // Type
    @Override

    public String getType() {
        return type.get();
    }

    @Override

    public String getType(boolean elaborate) {
        return type.get(elaborate);
    }

    @Override

    public void setType(String type) {
        this.type.set(type);
    }

    // Description
    @Override

    public String getDescription() {
        return description.get();
    }

    @Override

    public String getDescription(boolean elaborate) {
        return description.get(elaborate);
    }

    @Override

    public void setDescription(String description) {
        this.description.set(description);
    }

    // Name
    @Override

    public String getName() {
        return name.get();
    }

    @Override

    public String getName(boolean elaborate) {
        return name.get(elaborate);
    }

    @Override

    public void setName(String name) {
        this.name.set(name);
    }

    // In
    @Override

    public String getIn() {
        return in.get();
    }

    @Override

    public String getIn(boolean elaborate) {
        return in.get(elaborate);
    }

    @Override

    public void setIn(String in) {
        this.in.set(in);
    }

    // Scheme
    @Override

    public String getScheme() {
        return scheme.get();
    }

    @Override

    public String getScheme(boolean elaborate) {
        return scheme.get(elaborate);
    }

    @Override

    public void setScheme(String scheme) {
        this.scheme.set(scheme);
    }

    // BearerFormat
    @Override

    public String getBearerFormat() {
        return bearerFormat.get();
    }

    @Override

    public String getBearerFormat(boolean elaborate) {
        return bearerFormat.get(elaborate);
    }

    @Override

    public void setBearerFormat(String bearerFormat) {
        this.bearerFormat.set(bearerFormat);
    }

    // ImplicitOAuthFlow
    @Override

    public OAuthFlow getImplicitOAuthFlow() {
        return implicitOAuthFlow.get();
    }

    @Override

    public OAuthFlow getImplicitOAuthFlow(boolean elaborate) {
        return implicitOAuthFlow.get(elaborate);
    }

    @Override

    public void setImplicitOAuthFlow(OAuthFlow implicitOAuthFlow) {
        this.implicitOAuthFlow.set(implicitOAuthFlow);
    }

    // PasswordOAuthFlow
    @Override

    public OAuthFlow getPasswordOAuthFlow() {
        return passwordOAuthFlow.get();
    }

    @Override

    public OAuthFlow getPasswordOAuthFlow(boolean elaborate) {
        return passwordOAuthFlow.get(elaborate);
    }

    @Override

    public void setPasswordOAuthFlow(OAuthFlow passwordOAuthFlow) {
        this.passwordOAuthFlow.set(passwordOAuthFlow);
    }

    // ClientCredentialsOAuthFlow
    @Override

    public OAuthFlow getClientCredentialsOAuthFlow() {
        return clientCredentialsOAuthFlow.get();
    }

    @Override

    public OAuthFlow getClientCredentialsOAuthFlow(boolean elaborate) {
        return clientCredentialsOAuthFlow.get(elaborate);
    }

    @Override

    public void setClientCredentialsOAuthFlow(OAuthFlow clientCredentialsOAuthFlow) {
        this.clientCredentialsOAuthFlow.set(clientCredentialsOAuthFlow);
    }

    // AuthorizationCodeOAuthFlow
    @Override

    public OAuthFlow getAuthorizationCodeOAuthFlow() {
        return authorizationCodeOAuthFlow.get();
    }

    @Override

    public OAuthFlow getAuthorizationCodeOAuthFlow(boolean elaborate) {
        return authorizationCodeOAuthFlow.get(elaborate);
    }

    @Override

    public void setAuthorizationCodeOAuthFlow(OAuthFlow authorizationCodeOAuthFlow) {
        this.authorizationCodeOAuthFlow.set(authorizationCodeOAuthFlow);
    }

    // OAuthFlowsExtension
    @Override

    public Map<String, Object> getOAuthFlowsExtensions() {
        return oAuthFlowsExtensions.get();
    }

    @Override

    public Map<String, Object> getOAuthFlowsExtensions(boolean elaborate) {
        return oAuthFlowsExtensions.get(elaborate);
    }

    @Override

    public boolean hasOAuthFlowsExtension(String name) {
        return oAuthFlowsExtensions.containsKey(name);
    }

    @Override

    public Object getOAuthFlowsExtension(String name) {
        return oAuthFlowsExtensions.get(name);
    }

    @Override

    public void setOAuthFlowsExtensions(Map<String, Object> oAuthFlowsExtensions) {
        this.oAuthFlowsExtensions.set(oAuthFlowsExtensions);
    }

    @Override

    public void setOAuthFlowsExtension(String name, Object oAuthFlowsExtension) {
        oAuthFlowsExtensions.set(name, oAuthFlowsExtension);
    }

    @Override

    public void removeOAuthFlowsExtension(String name) {
        oAuthFlowsExtensions.remove(name);
    }

    // OpenIdConnectUrl
    @Override

    public String getOpenIdConnectUrl() {
        return openIdConnectUrl.get();
    }

    @Override

    public String getOpenIdConnectUrl(boolean elaborate) {
        return openIdConnectUrl.get(elaborate);
    }

    @Override

    public void setOpenIdConnectUrl(String openIdConnectUrl) {
        this.openIdConnectUrl.set(openIdConnectUrl);
    }

    // Extension
    @Override

    public Map<String, Object> getExtensions() {
        return extensions.get();
    }

    @Override

    public Map<String, Object> getExtensions(boolean elaborate) {
        return extensions.get(elaborate);
    }

    @Override

    public boolean hasExtension(String name) {
        return extensions.containsKey(name);
    }

    @Override

    public Object getExtension(String name) {
        return extensions.get(name);
    }

    @Override

    public void setExtensions(Map<String, Object> extensions) {
        this.extensions.set(extensions);
    }

    @Override

    public void setExtension(String name, Object extension) {
        extensions.set(name, extension);
    }

    @Override

    public void removeExtension(String name) {
        extensions.remove(name);
    }

    @Override

    protected void elaborateChildren() {
        type = createChild("type", this, StringOverlay.factory);
            description = createChild("description", this, StringOverlay.factory);
            name = createChild("name", this, StringOverlay.factory);
            in = createChild("in", this, StringOverlay.factory);
            scheme = createChild("scheme", this, StringOverlay.factory);
            bearerFormat = createChild("bearerFormat", this, StringOverlay.factory);
            implicitOAuthFlow = createChild("flow/implicit", this, OAuthFlowImpl.factory);
            passwordOAuthFlow = createChild("flow/password", this, OAuthFlowImpl.factory);
            clientCredentialsOAuthFlow = createChild("flow/clientCredentials", this, OAuthFlowImpl.factory);
            authorizationCodeOAuthFlow = createChild("flow/authorizationCode", this, OAuthFlowImpl.factory);
            oAuthFlowsExtensions = createChildMap("flow", this, ObjectOverlay.factory, "x-.+");
            openIdConnectUrl = createChild("openIdConnectUrl", this, StringOverlay.factory);
            extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<SecurityScheme, SecuritySchemeImpl> factory = new OverlayFactory<SecurityScheme, SecuritySchemeImpl>() {
    @Override
    protected Class<? super SecuritySchemeImpl> getOverlayClass() {
         return SecuritySchemeImpl.class;
    }

    @Override
    public SecuritySchemeImpl _create(SecurityScheme securityScheme, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new SecuritySchemeImpl(securityScheme, parent, refReg);
    }

    @Override
    public SecuritySchemeImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new SecuritySchemeImpl(json, parent, refReg);
    }
};

}
