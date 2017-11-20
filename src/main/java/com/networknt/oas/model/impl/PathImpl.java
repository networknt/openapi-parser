package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.jsonoverlay.*;
import com.networknt.oas.model.*;

import java.util.Collection;
import java.util.Map;

public class PathImpl extends OpenApiObjectImpl<OpenApi3, Path> implements Path {

    @Override
    public Operation getGet() {
        return operations.get("get");
    }

    @Override
    public Operation getGet(boolean elaborate) {
        return operations.get("get").get(elaborate);
    }

    @Override
    public void setGet(Operation get) {
        operations.set("get", (OperationImpl) get);
    }

    @Override
    public Operation getPut() {
        return operations.get("put");
    }

    @Override
    public Operation getPut(boolean elaborate) {
        return operations.get("put").get(elaborate);
    }

    @Override
    public void setPut(Operation put) {
        operations.set("put", (OperationImpl) put);
    }

    @Override
    public Operation getPost() {
        return operations.get("post");
    }

    @Override
    public Operation getPost(boolean elaborate) {
        return operations.get("post").get(elaborate);
    }

    @Override
    public void setPost(Operation post) {
        operations.set("post", (OperationImpl) post);
    }

    @Override
    public Operation getDelete() {
        return operations.get("delete");
    }

    @Override
    public Operation getDelete(boolean elaborate) {
        return operations.get("delete").get(elaborate);
    }

    @Override
    public void setDelete(Operation delete) {
        operations.set("delete", (OperationImpl) delete);
    }

    @Override
    public Operation getOptions() {
        return operations.get("options");
    }

    @Override
    public Operation getOptions(boolean elaborate) {
        return operations.get("options").get(elaborate);
    }

    @Override
    public void setOptions(Operation options) {
        operations.set("options", (OperationImpl) options);
    }

    @Override
    public Operation getHead() {
        return operations.get("head");
    }

    @Override
    public Operation getHead(boolean elaborate) {
        return operations.get("head").get(elaborate);
    }

    @Override
    public void setHead(Operation head) {
        operations.set("head", (OperationImpl) head);
    }

    @Override
    public Operation getPatch() {
        return operations.get("patch");
    }

    @Override
    public Operation getPatch(boolean elaborate) {
        return operations.get("patch").get(elaborate);
    }

    @Override
    public void setPatch(Operation patch) {
        operations.set("patch", (OperationImpl) patch);
    }

    @Override
    public Operation getTrace() {
        return operations.get("trace");
    }

    @Override
    public Operation getTrace(boolean elaborate) {
        return operations.get("trace").get(elaborate);
    }

    @Override
    public void setTrace(Operation trace) {
        operations.set("trace", (OperationImpl) trace);
    }


    public PathImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    public PathImpl(Path path, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(path, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> summary = null;


    private ChildOverlay<String, StringOverlay> description = null;


    private ChildMapOverlay<Operation, OperationImpl> operations = null;


    private ChildListOverlay<Server, ServerImpl> servers = null;


    private ChildListOverlay<Parameter, ParameterImpl> parameters = null;


    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

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

    // Operation
    @Override
    public Map<String, Operation> getOperations() {
        return operations.get();
    }

    @Override
    public Map<String, Operation> getOperations(boolean elaborate) {
        return operations.get(elaborate);
    }

    @Override
    public boolean hasOperation(String name) {
        return operations.containsKey(name);
    }

    @Override
    public Operation getOperation(String name) {
        return operations.get(name);
    }

    @Override
    public void setOperations(Map<String, Operation> operations) {
        this.operations.set(operations);
    }

    @Override
    public void setOperation(String name, Operation operation) {
        operations.set(name, operation);
    }

    @Override
    public void removeOperation(String name) {
        operations.remove(name);
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
        summary = createChild("summary", this, StringOverlay.factory);
        description = createChild("description", this, StringOverlay.factory);
        operations = createChildMap("", this, OperationImpl.factory, "get|put|post|delete|options|head|patch|trace");
        servers = createChildList("servers", this, ServerImpl.factory);
        parameters = createChildList("parameters", this, ParameterImpl.factory);
        refables.put("parameters", parameters);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<Path, PathImpl> factory = new OverlayFactory<Path, PathImpl>() {
        @Override
        protected Class<? super PathImpl> getOverlayClass() {
            return PathImpl.class;
        }

        @Override
        public PathImpl _create(Path path, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new PathImpl(path, parent, refReg);
        }

        @Override
        public PathImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new PathImpl(json, parent, refReg);
        }
    };

}
