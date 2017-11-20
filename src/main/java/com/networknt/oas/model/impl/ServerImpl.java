package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.jsonoverlay.*;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.Server;
import com.networknt.oas.model.ServerVariable;

import java.util.Map;

public class ServerImpl extends OpenApiObjectImpl<OpenApi3, Server> implements Server {


    public ServerImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    public ServerImpl(Server server, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(server, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> url = null;


    private ChildOverlay<String, StringOverlay> description = null;


    private ChildMapOverlay<ServerVariable, ServerVariableImpl> serverVariables = null;


    private ChildMapOverlay<Object, ObjectOverlay> variablesExtensions = null;


    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

    // Url
    @Override
    public String getUrl() {
        return url.get();
    }

    @Override
    public String getUrl(boolean elaborate) {
        return url.get(elaborate);
    }

    @Override
    public void setUrl(String url) {
        this.url.set(url);
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

    // ServerVariable
    @Override
    public Map<String, ServerVariable> getServerVariables() {
        return serverVariables.get();
    }

    @Override
    public Map<String, ServerVariable> getServerVariables(boolean elaborate) {
        return serverVariables.get(elaborate);
    }

    @Override
    public boolean hasServerVariable(String name) {
        return serverVariables.containsKey(name);
    }

    @Override
    public ServerVariable getServerVariable(String name) {
        return serverVariables.get(name);
    }

    @Override
    public void setServerVariables(Map<String, ServerVariable> serverVariables) {
        this.serverVariables.set(serverVariables);
    }

    @Override
    public void setServerVariable(String name, ServerVariable serverVariable) {
        serverVariables.set(name, serverVariable);
    }

    @Override
    public void removeServerVariable(String name) {
        serverVariables.remove(name);
    }

    // VariablesExtension
    @Override
    public Map<String, Object> getVariablesExtensions() {
        return variablesExtensions.get();
    }

    @Override
    public Map<String, Object> getVariablesExtensions(boolean elaborate) {
        return variablesExtensions.get(elaborate);
    }

    @Override
    public boolean hasVariablesExtension(String name) {
        return variablesExtensions.containsKey(name);
    }

    @Override
    public Object getVariablesExtension(String name) {
        return variablesExtensions.get(name);
    }

    @Override
    public void setVariablesExtensions(Map<String, Object> variablesExtensions) {
        this.variablesExtensions.set(variablesExtensions);
    }

    @Override
    public void setVariablesExtension(String name, Object variablesExtension) {
        variablesExtensions.set(name, variablesExtension);
    }

    @Override
    public void removeVariablesExtension(String name) {
        variablesExtensions.remove(name);
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
        url = createChild("url", this, StringOverlay.factory);
        description = createChild("description", this, StringOverlay.factory);
        serverVariables = createChildMap("variables", this, ServerVariableImpl.factory, "(?!x-)[a-zA-Z0-9\\._-]+");
        variablesExtensions = createChildMap("variables", this, ObjectOverlay.factory, "x-.+");
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<Server, ServerImpl> factory = new OverlayFactory<Server, ServerImpl>() {
        @Override
        protected Class<? super ServerImpl> getOverlayClass() {
            return ServerImpl.class;
        }

        @Override
        public ServerImpl _create(Server server, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new ServerImpl(server, parent, refReg);
        }

        @Override
        public ServerImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new ServerImpl(json, parent, refReg);
        }
    };

}
