package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.jsonoverlay.*;
import com.networknt.oas.model.OAuthFlow;
import com.networknt.oas.model.OpenApi3;

import java.util.Map;

public class OAuthFlowImpl extends OpenApiObjectImpl<OpenApi3, OAuthFlow> implements OAuthFlow {


    public OAuthFlowImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    public OAuthFlowImpl(OAuthFlow oAuthFlow, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(oAuthFlow, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> authorizationUrl = null;


    private ChildOverlay<String, StringOverlay> tokenUrl = null;


    private ChildOverlay<String, StringOverlay> refreshUrl = null;


    private ChildMapOverlay<String, StringOverlay> scopes = null;


    private ChildMapOverlay<Object, ObjectOverlay> scopesExtensions = null;


    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

    // AuthorizationUrl
    @Override
    public String getAuthorizationUrl() {
        return authorizationUrl.get();
    }

    @Override
    public String getAuthorizationUrl(boolean elaborate) {
        return authorizationUrl.get(elaborate);
    }

    @Override
    public void setAuthorizationUrl(String authorizationUrl) {
        this.authorizationUrl.set(authorizationUrl);
    }

    // TokenUrl
    @Override
    public String getTokenUrl() {
        return tokenUrl.get();
    }

    @Override
    public String getTokenUrl(boolean elaborate) {
        return tokenUrl.get(elaborate);
    }

    @Override
    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl.set(tokenUrl);
    }

    // RefreshUrl
    @Override
    public String getRefreshUrl() {
        return refreshUrl.get();
    }

    @Override
    public String getRefreshUrl(boolean elaborate) {
        return refreshUrl.get(elaborate);
    }

    @Override
    public void setRefreshUrl(String refreshUrl) {
        this.refreshUrl.set(refreshUrl);
    }

    // Scope
    @Override
    public Map<String, String> getScopes() {
        return scopes.get();
    }

    @Override
    public Map<String, String> getScopes(boolean elaborate) {
        return scopes.get(elaborate);
    }

    @Override
    public boolean hasScope(String name) {
        return scopes.containsKey(name);
    }

    @Override
    public String getScope(String name) {
        return scopes.get(name);
    }

    @Override
    public void setScopes(Map<String, String> scopes) {
        this.scopes.set(scopes);
    }

    @Override
    public void setScope(String name, String scope) {
        scopes.set(name, scope);
    }

    @Override
    public void removeScope(String name) {
        scopes.remove(name);
    }

    // ScopesExtension
    @Override
    public Map<String, Object> getScopesExtensions() {
        return scopesExtensions.get();
    }

    @Override
    public Map<String, Object> getScopesExtensions(boolean elaborate) {
        return scopesExtensions.get(elaborate);
    }

    @Override
    public boolean hasScopesExtension(String name) {
        return scopesExtensions.containsKey(name);
    }

    @Override
    public Object getScopesExtension(String name) {
        return scopesExtensions.get(name);
    }

    @Override
    public void setScopesExtensions(Map<String, Object> scopesExtensions) {
        this.scopesExtensions.set(scopesExtensions);
    }

    @Override
    public void setScopesExtension(String name, Object scopesExtension) {
        scopesExtensions.set(name, scopesExtension);
    }

    @Override
    public void removeScopesExtension(String name) {
        scopesExtensions.remove(name);
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
        authorizationUrl = createChild("authorizationUrl", this, StringOverlay.factory);
        tokenUrl = createChild("tokenUrl", this, StringOverlay.factory);
        refreshUrl = createChild("refreshUrl", this, StringOverlay.factory);
        scopes = createChildMap("scopes", this, StringOverlay.factory, "(?!x-).*");
        scopesExtensions = createChildMap("scopes", this, ObjectOverlay.factory, "x-.+");
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<OAuthFlow, OAuthFlowImpl> factory = new OverlayFactory<OAuthFlow, OAuthFlowImpl>() {
        @Override
        protected Class<? super OAuthFlowImpl> getOverlayClass() {
            return OAuthFlowImpl.class;
        }

        @Override
        public OAuthFlowImpl _create(OAuthFlow oAuthFlow, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new OAuthFlowImpl(oAuthFlow, parent, refReg);
        }

        @Override
        public OAuthFlowImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new OAuthFlowImpl(json, parent, refReg);
        }
    };

}
