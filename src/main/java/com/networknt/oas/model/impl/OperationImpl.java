package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.jsonoverlay.BooleanOverlay;
import com.networknt.oas.jsonoverlay.ChildListOverlay;
import com.networknt.oas.jsonoverlay.ChildMapOverlay;
import com.networknt.oas.jsonoverlay.ChildOverlay;
import com.networknt.oas.jsonoverlay.JsonOverlay;
import com.networknt.oas.jsonoverlay.ListOverlay;
import com.networknt.oas.jsonoverlay.MapOverlay;
import com.networknt.oas.jsonoverlay.ObjectOverlay;
import com.networknt.oas.jsonoverlay.OverlayFactory;
import com.networknt.oas.jsonoverlay.Reference;
import com.networknt.oas.jsonoverlay.ReferenceRegistry;
import com.networknt.oas.jsonoverlay.StringOverlay;
import com.networknt.oas.model.Callback;
import com.networknt.oas.model.ExternalDocs;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.Operation;
import com.networknt.oas.model.Parameter;
import com.networknt.oas.model.RequestBody;
import com.networknt.oas.model.Response;
import com.networknt.oas.model.SecurityRequirement;
import com.networknt.oas.model.Server;
import com.networknt.oas.model.impl.CallbackImpl;
import com.networknt.oas.model.impl.ExternalDocsImpl;
import com.networknt.oas.model.impl.OpenApiObjectImpl;
import com.networknt.oas.model.impl.ParameterImpl;
import com.networknt.oas.model.impl.RequestBodyImpl;
import com.networknt.oas.model.impl.ResponseImpl;
import com.networknt.oas.model.impl.SecurityRequirementImpl;
import com.networknt.oas.model.impl.ServerImpl;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public class OperationImpl extends OpenApiObjectImpl<OpenApi3, Operation> implements Operation {


    public OperationImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    public OperationImpl(Operation operation, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(operation, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    private ChildListOverlay<String, StringOverlay> tags = null;


    private ChildOverlay<String, StringOverlay> summary = null;


    private ChildOverlay<String, StringOverlay> description = null;


    private ChildOverlay<ExternalDocs, ExternalDocsImpl> externalDocs = null;


    private ChildOverlay<String, StringOverlay> operationId = null;


    private ChildListOverlay<Parameter, ParameterImpl> parameters = null;


    private ChildOverlay<RequestBody, RequestBodyImpl> requestBody = null;


    private ChildMapOverlay<Response, ResponseImpl> responses = null;


    private ChildMapOverlay<Object, ObjectOverlay> responsesExtensions = null;


    private ChildMapOverlay<Callback, CallbackImpl> callbacks = null;


    private ChildMapOverlay<Object, ObjectOverlay> callbacksExtensions = null;


    private ChildOverlay<Boolean, BooleanOverlay> deprecated = null;


    private ChildListOverlay<SecurityRequirement, SecurityRequirementImpl> securityRequirements = null;


    private ChildListOverlay<Server, ServerImpl> servers = null;


    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

    // Tag
    @Override

    public Collection<String> getTags() {
        return tags.get();
    }

    @Override

    public Collection<String> getTags(boolean elaborate) {
        return tags.get(elaborate);
    }

    @Override

    public boolean hasTags() {
        return tags.isPresent();
    }

    @Override

    public String getTag(int index) {
        return tags.get(index);
    }

    @Override

    public void setTags(Collection<String> tags) {
        this.tags.set((Collection<String>) tags);
    }

    @Override

    public void setTag(int index, String tag) {
        tags.set(index, tag);
    }

    @Override

    public void addTag(String tag) {
        tags.add(tag);
    }

    @Override

    public void insertTag(int index, String tag) {
        tags.insert(index, tag);
    }

    @Override

    public void removeTag(int index) {
        tags.remove(index);
    }

    // Summary
    @Override

    public String getSummary() {
        return summary.get();
    }

    @Override

    public String getSummary(boolean elaborate) {
        return summary.get(elaborate);
    }

    @Override

    public void setSummary(String summary) {
        this.summary.set(summary);
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

    // ExternalDocs
    @Override

    public ExternalDocs getExternalDocs() {
        return externalDocs.get();
    }

    @Override

    public ExternalDocs getExternalDocs(boolean elaborate) {
        return externalDocs.get(elaborate);
    }

    @Override

    public void setExternalDocs(ExternalDocs externalDocs) {
        this.externalDocs.set(externalDocs);
    }

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

    // Parameter
    @Override

    public Collection<Parameter> getParameters() {
        return parameters.get();
    }

    @Override

    public Collection<Parameter> getParameters(boolean elaborate) {
        return parameters.get(elaborate);
    }

    @Override

    public boolean hasParameters() {
        return parameters.isPresent();
    }

    @Override

    public Parameter getParameter(int index) {
        return parameters.get(index);
    }

    @Override

    public void setParameters(Collection<Parameter> parameters) {
        this.parameters.set((Collection<Parameter>) parameters);
    }

    @Override

    public void setParameter(int index, Parameter parameter) {
        parameters.set(index, parameter);
    }

    @Override

    public void addParameter(Parameter parameter) {
        parameters.add(parameter);
    }

    @Override

    public void insertParameter(int index, Parameter parameter) {
        parameters.insert(index, parameter);
    }

    @Override

    public void removeParameter(int index) {
        parameters.remove(index);
    }

    @Override

    public boolean isParameterReference(int index) {
        return parameters.getChild(index).isReference();
    }

    @Override

    public Reference getParameterReference(int index) {
        return parameters.getChild(index).getReference();
    }

    // RequestBody
    @Override

    public RequestBody getRequestBody() {
        return requestBody.get();
    }

    @Override

    public RequestBody getRequestBody(boolean elaborate) {
        return requestBody.get(elaborate);
    }

    @Override

    public void setRequestBody(RequestBody requestBody) {
        this.requestBody.set(requestBody);
    }

    @Override

    public boolean isRequestBodyReference() {
        return requestBody != null ? requestBody.isReference() : false;
    }

    @Override

    public Reference getRequestBodyReference() {
        return requestBody != null ? requestBody.getReference() : null;
    }

    // Response
    @Override

    public Map<String, Response> getResponses() {
        return responses.get();
    }

    @Override

    public Map<String, Response> getResponses(boolean elaborate) {
        return responses.get(elaborate);
    }

    @Override

    public boolean hasResponse(String name) {
        return responses.containsKey(name);
    }

    @Override

    public Response getResponse(String name) {
        return responses.get(name);
    }

    @Override

    public void setResponses(Map<String, Response> responses) {
        this.responses.set(responses);
    }

    @Override

    public void setResponse(String name, Response response) {
        responses.set(name, response);
    }

    @Override

    public void removeResponse(String name) {
        responses.remove(name);
    }

    @Override

    public boolean isResponseReference(String key) {
        ChildOverlay<Response, ResponseImpl> child = responses.getChild(key);
            return child != null ? child.isReference() : false;
    }

    @Override

    public Reference getResponseReference(String key) {
        ChildOverlay<Response, ResponseImpl> child = responses.getChild(key);
            return child != null ? child.getReference() : null;
    }

    // ResponsesExtension
    @Override

    public Map<String, Object> getResponsesExtensions() {
        return responsesExtensions.get();
    }

    @Override

    public Map<String, Object> getResponsesExtensions(boolean elaborate) {
        return responsesExtensions.get(elaborate);
    }

    @Override

    public boolean hasResponsesExtension(String name) {
        return responsesExtensions.containsKey(name);
    }

    @Override

    public Object getResponsesExtension(String name) {
        return responsesExtensions.get(name);
    }

    @Override

    public void setResponsesExtensions(Map<String, Object> responsesExtensions) {
        this.responsesExtensions.set(responsesExtensions);
    }

    @Override

    public void setResponsesExtension(String name, Object responsesExtension) {
        responsesExtensions.set(name, responsesExtension);
    }

    @Override

    public void removeResponsesExtension(String name) {
        responsesExtensions.remove(name);
    }

    // Callback
    @Override

    public Map<String, Callback> getCallbacks() {
        return callbacks.get();
    }

    @Override

    public Map<String, Callback> getCallbacks(boolean elaborate) {
        return callbacks.get(elaborate);
    }

    @Override

    public boolean hasCallback(String name) {
        return callbacks.containsKey(name);
    }

    @Override

    public Callback getCallback(String name) {
        return callbacks.get(name);
    }

    @Override

    public void setCallbacks(Map<String, Callback> callbacks) {
        this.callbacks.set(callbacks);
    }

    @Override

    public void setCallback(String name, Callback callback) {
        callbacks.set(name, callback);
    }

    @Override

    public void removeCallback(String name) {
        callbacks.remove(name);
    }

    @Override

    public boolean isCallbackReference(String key) {
        ChildOverlay<Callback, CallbackImpl> child = callbacks.getChild(key);
            return child != null ? child.isReference() : false;
    }

    @Override

    public Reference getCallbackReference(String key) {
        ChildOverlay<Callback, CallbackImpl> child = callbacks.getChild(key);
            return child != null ? child.getReference() : null;
    }

    // CallbacksExtension
    @Override

    public Map<String, Object> getCallbacksExtensions() {
        return callbacksExtensions.get();
    }

    @Override

    public Map<String, Object> getCallbacksExtensions(boolean elaborate) {
        return callbacksExtensions.get(elaborate);
    }

    @Override

    public boolean hasCallbacksExtension(String name) {
        return callbacksExtensions.containsKey(name);
    }

    @Override

    public Object getCallbacksExtension(String name) {
        return callbacksExtensions.get(name);
    }

    @Override

    public void setCallbacksExtensions(Map<String, Object> callbacksExtensions) {
        this.callbacksExtensions.set(callbacksExtensions);
    }

    @Override

    public void setCallbacksExtension(String name, Object callbacksExtension) {
        callbacksExtensions.set(name, callbacksExtension);
    }

    @Override

    public void removeCallbacksExtension(String name) {
        callbacksExtensions.remove(name);
    }

    // Deprecated
    @Override

    public Boolean getDeprecated() {
        return deprecated.get();
    }

    @Override

    public Boolean getDeprecated(boolean elaborate) {
        return deprecated.get(elaborate);
    }

    @Override

    public boolean isDeprecated() {
        return deprecated.get() != null ? deprecated.get() : false;
    }

    @Override

    public void setDeprecated(Boolean deprecated) {
        this.deprecated.set(deprecated);
    }

    // SecurityRequirement
    @Override

    public Collection<SecurityRequirement> getSecurityRequirements() {
        return securityRequirements.get();
    }

    @Override

    public Collection<SecurityRequirement> getSecurityRequirements(boolean elaborate) {
        return securityRequirements.get(elaborate);
    }

    @Override

    public boolean hasSecurityRequirements() {
        return securityRequirements.isPresent();
    }

    @Override

    public SecurityRequirement getSecurityRequirement(int index) {
        return securityRequirements.get(index);
    }

    @Override

    public void setSecurityRequirements(Collection<SecurityRequirement> securityRequirements) {
        this.securityRequirements.set((Collection<SecurityRequirement>) securityRequirements);
    }

    @Override

    public void setSecurityRequirement(int index, SecurityRequirement securityRequirement) {
        securityRequirements.set(index, securityRequirement);
    }

    @Override

    public void addSecurityRequirement(SecurityRequirement securityRequirement) {
        securityRequirements.add(securityRequirement);
    }

    @Override

    public void insertSecurityRequirement(int index, SecurityRequirement securityRequirement) {
        securityRequirements.insert(index, securityRequirement);
    }

    @Override

    public void removeSecurityRequirement(int index) {
        securityRequirements.remove(index);
    }

    // Server
    @Override

    public Collection<Server> getServers() {
        return servers.get();
    }

    @Override

    public Collection<Server> getServers(boolean elaborate) {
        return servers.get(elaborate);
    }

    @Override

    public boolean hasServers() {
        return servers.isPresent();
    }

    @Override

    public Server getServer(int index) {
        return servers.get(index);
    }

    @Override

    public void setServers(Collection<Server> servers) {
        this.servers.set((Collection<Server>) servers);
    }

    @Override

    public void setServer(int index, Server server) {
        servers.set(index, server);
    }

    @Override

    public void addServer(Server server) {
        servers.add(server);
    }

    @Override

    public void insertServer(int index, Server server) {
        servers.insert(index, server);
    }

    @Override

    public void removeServer(int index) {
        servers.remove(index);
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
        tags = createChildList("tags", this, StringOverlay.factory);
            summary = createChild("summary", this, StringOverlay.factory);
            description = createChild("description", this, StringOverlay.factory);
            externalDocs = createChild("externalDocs", this, ExternalDocsImpl.factory);
            operationId = createChild("operationId", this, StringOverlay.factory);
            parameters = createChildList("parameters", this, ParameterImpl.factory);
            refables.put("parameters", parameters);
            requestBody = createChild("requestBody", this, RequestBodyImpl.factory);
            refables.put("requestBody", requestBody);
            responses = createChildMap("responses", this, ResponseImpl.factory, "default|(\\d\\d\\d)");
            refables.put("responses", responses);
            responsesExtensions = createChildMap("responses", this, ObjectOverlay.factory, "x-.+");
            callbacks = createChildMap("callbacks", this, CallbackImpl.factory, "(?!x-)[a-zA-Z0-9\\._-]+");
            refables.put("callbacks", callbacks);
            callbacksExtensions = createChildMap("callbacks", this, ObjectOverlay.factory, "x-.+");
            deprecated = createChild("deprecated", this, BooleanOverlay.factory);
            securityRequirements = createChildList("security", this, SecurityRequirementImpl.factory);
            servers = createChildList("servers", this, ServerImpl.factory);
            extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<Operation, OperationImpl> factory = new OverlayFactory<Operation, OperationImpl>() {
    @Override
    protected Class<? super OperationImpl> getOverlayClass() {
         return OperationImpl.class;
    }

    @Override
    public OperationImpl _create(Operation operation, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new OperationImpl(operation, parent, refReg);
    }

    @Override
    public OperationImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new OperationImpl(json, parent, refReg);
    }
};

}
