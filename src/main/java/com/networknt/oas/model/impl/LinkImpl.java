package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.jsonoverlay.*;
import com.networknt.oas.model.Header;
import com.networknt.oas.model.Link;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.Server;

import java.util.Map;

public class LinkImpl extends OpenApiObjectImpl<OpenApi3, Link> implements Link {


    public LinkImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    public LinkImpl(Link link, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(link, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> operationId = null;


    private ChildOverlay<String, StringOverlay> operationRef = null;


    private ChildMapOverlay<String, StringOverlay> parameters = null;


    private ChildMapOverlay<Header, HeaderImpl> headers = null;


    private ChildOverlay<String, StringOverlay> description = null;


    private ChildOverlay<Server, ServerImpl> server = null;


    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

    // OperationId
    @Override
    public String getOperationId() {
        return operationId.get();
    }

    @Override
    public String getOperationId(boolean elaborate) {
        return operationId.get(elaborate);
    }

    @Override
    public void setOperationId(String operationId) {
        this.operationId.set(operationId);
    }

    // OperationRef
    @Override
    public String getOperationRef() {
        return operationRef.get();
    }

    @Override
    public String getOperationRef(boolean elaborate) {
        return operationRef.get(elaborate);
    }

    @Override
    public void setOperationRef(String operationRef) {
        this.operationRef.set(operationRef);
    }

    // Parameter
    @Override
    public Map<String, String> getParameters() {
        return parameters.get();
    }

    @Override
    public Map<String, String> getParameters(boolean elaborate) {
        return parameters.get(elaborate);
    }

    @Override
    public boolean hasParameter(String name) {
        return parameters.containsKey(name);
    }

    @Override
    public String getParameter(String name) {
        return parameters.get(name);
    }

    @Override
    public void setParameters(Map<String, String> parameters) {
        this.parameters.set(parameters);
    }

    @Override
    public void setParameter(String name, String parameter) {
        parameters.set(name, parameter);
    }

    @Override
    public void removeParameter(String name) {
        parameters.remove(name);
    }

    // Header
    @Override
    public Map<String, Header> getHeaders() {
        return headers.get();
    }

    @Override
    public Map<String, Header> getHeaders(boolean elaborate) {
        return headers.get(elaborate);
    }

    @Override
    public boolean hasHeader(String name) {
        return headers.containsKey(name);
    }

    @Override
    public Header getHeader(String name) {
        return headers.get(name);
    }

    @Override
    public void setHeaders(Map<String, Header> headers) {
        this.headers.set(headers);
    }

    @Override
    public void setHeader(String name, Header header) {
        headers.set(name, header);
    }

    @Override
    public void removeHeader(String name) {
        headers.remove(name);
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

    // Server
    @Override
    public Server getServer() {
        return server.get();
    }

    @Override
    public Server getServer(boolean elaborate) {
        return server.get(elaborate);
    }

    @Override
    public void setServer(Server server) {
        this.server.set(server);
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
        operationId = createChild("operationId", this, StringOverlay.factory);
        operationRef = createChild("operationRef", this, StringOverlay.factory);
        parameters = createChildMap("parameters", this, StringOverlay.factory, null);
        headers = createChildMap("headers", this, HeaderImpl.factory, null);
        description = createChild("description", this, StringOverlay.factory);
        server = createChild("server", this, ServerImpl.factory);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<Link, LinkImpl> factory = new OverlayFactory<Link, LinkImpl>() {
        @Override
        protected Class<? super LinkImpl> getOverlayClass() {
            return LinkImpl.class;
        }

        @Override
        public LinkImpl _create(Link link, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new LinkImpl(link, parent, refReg);
        }

        @Override
        public LinkImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new LinkImpl(json, parent, refReg);
        }
    };

}
