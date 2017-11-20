package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.networknt.oas.jsonoverlay.*;
import com.networknt.oas.model.*;
import com.networknt.oas.validator.ValidationResults;
import com.networknt.oas.validator.ValidationResults.Severity;
import com.networknt.oas.validator.Validator;
import com.networknt.oas.validator.impl.OpenApi3Validator;

import java.util.Collection;
import java.util.Map;

public class OpenApi3Impl extends OpenApiObjectImpl<OpenApi3, OpenApi3> implements OpenApi3 {

    private ValidationResults validationResults = null;

    @Override
    protected JsonNode fixJson(JsonNode json) {
        if (json.isMissingNode()) {
            json = jsonObject();
        }
        if (!json.has("paths")) {
            ((ObjectNode) json).putObject("paths");
        }
        return json;
    }

    private Validator<OpenApi3> validator = new OpenApi3Validator();

    @Override
    public void validate() {
        validationResults = validator.validate(this);
    }

    @Override
    public boolean isValid() {
        if (validationResults == null) {
            validate();
        }
        return validationResults.getSeverity().lt(Severity.ERROR);
    }

    @Override
    public ValidationResults getValidationResults() {
        if (validationResults == null) {
            validate();
        }
        return validationResults;
    }

    @Override
    public Collection<ValidationResults.ValidationItem> getValidationItems() {
        return getValidationResults().getItems();
    }


    public OpenApi3Impl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    public OpenApi3Impl(OpenApi3 openApi3, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(openApi3, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> openApi = null;


    private ChildOverlay<Info, InfoImpl> info = null;


    private ChildListOverlay<Server, ServerImpl> servers = null;


    private ChildMapOverlay<Path, PathImpl> paths = null;


    private ChildMapOverlay<Object, ObjectOverlay> pathsExtensions = null;


    private ChildMapOverlay<Schema, SchemaImpl> schemas = null;


    private ChildMapOverlay<Response, ResponseImpl> responses = null;


    private ChildMapOverlay<Parameter, ParameterImpl> parameters = null;


    private ChildMapOverlay<Example, ExampleImpl> examples = null;


    private ChildMapOverlay<RequestBody, RequestBodyImpl> requestBodies = null;


    private ChildMapOverlay<Header, HeaderImpl> headers = null;


    private ChildMapOverlay<SecurityScheme, SecuritySchemeImpl> securitySchemes = null;


    private ChildMapOverlay<Link, LinkImpl> links = null;


    private ChildMapOverlay<Callback, CallbackImpl> callbacks = null;


    private ChildMapOverlay<Object, ObjectOverlay> componentsExtensions = null;


    private ChildListOverlay<SecurityRequirement, SecurityRequirementImpl> securityRequirements = null;


    private ChildListOverlay<Tag, TagImpl> tags = null;


    private ChildOverlay<ExternalDocs, ExternalDocsImpl> externalDocs = null;


    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

    // OpenApi
    @Override
    public String getOpenApi() {
        return openApi.get();
    }

    @Override
    public String getOpenApi(boolean elaborate) {
        return openApi.get(elaborate);
    }

    @Override
    public void setOpenApi(String openApi) {
        this.openApi.set(openApi);
    }

    // Info
    @Override
    public Info getInfo() {
        return info.get();
    }

    @Override
    public Info getInfo(boolean elaborate) {
        return info.get(elaborate);
    }

    @Override
    public void setInfo(Info info) {
        this.info.set(info);
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

    // Path
    @Override
    public Map<String, Path> getPaths() {
        return paths.get();
    }

    @Override
    public Map<String, Path> getPaths(boolean elaborate) {
        return paths.get(elaborate);
    }

    @Override
    public boolean hasPath(String name) {
        return paths.containsKey(name);
    }

    @Override
    public Path getPath(String name) {
        return paths.get(name);
    }

    @Override
    public void setPaths(Map<String, Path> paths) {
        this.paths.set(paths);
    }

    @Override
    public void setPath(String name, Path path) {
        paths.set(name, path);
    }

    @Override
    public void removePath(String name) {
        paths.remove(name);
    }

    @Override
    public boolean isPathReference(String key) {
        ChildOverlay<Path, PathImpl> child = paths.getChild(key);
        return child != null ? child.isReference() : false;
    }

    @Override
    public Reference getPathReference(String key) {
        ChildOverlay<Path, PathImpl> child = paths.getChild(key);
        return child != null ? child.getReference() : null;
    }

    // PathsExtension
    @Override
    public Map<String, Object> getPathsExtensions() {
        return pathsExtensions.get();
    }

    @Override
    public Map<String, Object> getPathsExtensions(boolean elaborate) {
        return pathsExtensions.get(elaborate);
    }

    @Override
    public boolean hasPathsExtension(String name) {
        return pathsExtensions.containsKey(name);
    }

    @Override
    public Object getPathsExtension(String name) {
        return pathsExtensions.get(name);
    }

    @Override
    public void setPathsExtensions(Map<String, Object> pathsExtensions) {
        this.pathsExtensions.set(pathsExtensions);
    }

    @Override
    public void setPathsExtension(String name, Object pathsExtension) {
        pathsExtensions.set(name, pathsExtension);
    }

    @Override
    public void removePathsExtension(String name) {
        pathsExtensions.remove(name);
    }

    // Schema
    @Override
    public Map<String, Schema> getSchemas() {
        return schemas.get();
    }

    @Override
    public Map<String, Schema> getSchemas(boolean elaborate) {
        return schemas.get(elaborate);
    }

    @Override
    public boolean hasSchema(String name) {
        return schemas.containsKey(name);
    }

    @Override
    public Schema getSchema(String name) {
        return schemas.get(name);
    }

    @Override
    public void setSchemas(Map<String, Schema> schemas) {
        this.schemas.set(schemas);
    }

    @Override
    public void setSchema(String name, Schema schema) {
        schemas.set(name, schema);
    }

    @Override
    public void removeSchema(String name) {
        schemas.remove(name);
    }

    @Override
    public boolean isSchemaReference(String key) {
        ChildOverlay<Schema, SchemaImpl> child = schemas.getChild(key);
        return child != null ? child.isReference() : false;
    }

    @Override
    public Reference getSchemaReference(String key) {
        ChildOverlay<Schema, SchemaImpl> child = schemas.getChild(key);
        return child != null ? child.getReference() : null;
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

    // Parameter
    @Override
    public Map<String, Parameter> getParameters() {
        return parameters.get();
    }

    @Override
    public Map<String, Parameter> getParameters(boolean elaborate) {
        return parameters.get(elaborate);
    }

    @Override
    public boolean hasParameter(String name) {
        return parameters.containsKey(name);
    }

    @Override
    public Parameter getParameter(String name) {
        return parameters.get(name);
    }

    @Override
    public void setParameters(Map<String, Parameter> parameters) {
        this.parameters.set(parameters);
    }

    @Override
    public void setParameter(String name, Parameter parameter) {
        parameters.set(name, parameter);
    }

    @Override
    public void removeParameter(String name) {
        parameters.remove(name);
    }

    @Override
    public boolean isParameterReference(String key) {
        ChildOverlay<Parameter, ParameterImpl> child = parameters.getChild(key);
        return child != null ? child.isReference() : false;
    }

    @Override
    public Reference getParameterReference(String key) {
        ChildOverlay<Parameter, ParameterImpl> child = parameters.getChild(key);
        return child != null ? child.getReference() : null;
    }

    // Example
    @Override
    public Map<String, Example> getExamples() {
        return examples.get();
    }

    @Override
    public Map<String, Example> getExamples(boolean elaborate) {
        return examples.get(elaborate);
    }

    @Override
    public boolean hasExample(String name) {
        return examples.containsKey(name);
    }

    @Override
    public Example getExample(String name) {
        return examples.get(name);
    }

    @Override
    public void setExamples(Map<String, Example> examples) {
        this.examples.set(examples);
    }

    @Override
    public void setExample(String name, Example example) {
        examples.set(name, example);
    }

    @Override
    public void removeExample(String name) {
        examples.remove(name);
    }

    @Override
    public boolean isExampleReference(String key) {
        ChildOverlay<Example, ExampleImpl> child = examples.getChild(key);
        return child != null ? child.isReference() : false;
    }

    @Override
    public Reference getExampleReference(String key) {
        ChildOverlay<Example, ExampleImpl> child = examples.getChild(key);
        return child != null ? child.getReference() : null;
    }

    // RequestBody
    @Override
    public Map<String, RequestBody> getRequestBodies() {
        return requestBodies.get();
    }

    @Override
    public Map<String, RequestBody> getRequestBodies(boolean elaborate) {
        return requestBodies.get(elaborate);
    }

    @Override
    public boolean hasRequestBody(String name) {
        return requestBodies.containsKey(name);
    }

    @Override
    public RequestBody getRequestBody(String name) {
        return requestBodies.get(name);
    }

    @Override
    public void setRequestBodies(Map<String, RequestBody> requestBodies) {
        this.requestBodies.set(requestBodies);
    }

    @Override
    public void setRequestBody(String name, RequestBody requestBody) {
        requestBodies.set(name, requestBody);
    }

    @Override
    public void removeRequestBody(String name) {
        requestBodies.remove(name);
    }

    @Override
    public boolean isRequestBodyReference(String key) {
        ChildOverlay<RequestBody, RequestBodyImpl> child = requestBodies.getChild(key);
        return child != null ? child.isReference() : false;
    }

    @Override
    public Reference getRequestBodyReference(String key) {
        ChildOverlay<RequestBody, RequestBodyImpl> child = requestBodies.getChild(key);
        return child != null ? child.getReference() : null;
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

    @Override
    public boolean isHeaderReference(String key) {
        ChildOverlay<Header, HeaderImpl> child = headers.getChild(key);
        return child != null ? child.isReference() : false;
    }

    @Override
    public Reference getHeaderReference(String key) {
        ChildOverlay<Header, HeaderImpl> child = headers.getChild(key);
        return child != null ? child.getReference() : null;
    }

    // SecurityScheme
    @Override
    public Map<String, SecurityScheme> getSecuritySchemes() {
        return securitySchemes.get();
    }

    @Override
    public Map<String, SecurityScheme> getSecuritySchemes(boolean elaborate) {
        return securitySchemes.get(elaborate);
    }

    @Override
    public boolean hasSecurityScheme(String name) {
        return securitySchemes.containsKey(name);
    }

    @Override
    public SecurityScheme getSecurityScheme(String name) {
        return securitySchemes.get(name);
    }

    @Override
    public void setSecuritySchemes(Map<String, SecurityScheme> securitySchemes) {
        this.securitySchemes.set(securitySchemes);
    }

    @Override
    public void setSecurityScheme(String name, SecurityScheme securityScheme) {
        securitySchemes.set(name, securityScheme);
    }

    @Override
    public void removeSecurityScheme(String name) {
        securitySchemes.remove(name);
    }

    @Override
    public boolean isSecuritySchemeReference(String key) {
        ChildOverlay<SecurityScheme, SecuritySchemeImpl> child = securitySchemes.getChild(key);
        return child != null ? child.isReference() : false;
    }

    @Override
    public Reference getSecuritySchemeReference(String key) {
        ChildOverlay<SecurityScheme, SecuritySchemeImpl> child = securitySchemes.getChild(key);
        return child != null ? child.getReference() : null;
    }

    // Link
    @Override
    public Map<String, Link> getLinks() {
        return links.get();
    }

    @Override
    public Map<String, Link> getLinks(boolean elaborate) {
        return links.get(elaborate);
    }

    @Override
    public boolean hasLink(String name) {
        return links.containsKey(name);
    }

    @Override
    public Link getLink(String name) {
        return links.get(name);
    }

    @Override
    public void setLinks(Map<String, Link> links) {
        this.links.set(links);
    }

    @Override
    public void setLink(String name, Link link) {
        links.set(name, link);
    }

    @Override
    public void removeLink(String name) {
        links.remove(name);
    }

    @Override
    public boolean isLinkReference(String key) {
        ChildOverlay<Link, LinkImpl> child = links.getChild(key);
        return child != null ? child.isReference() : false;
    }

    @Override
    public Reference getLinkReference(String key) {
        ChildOverlay<Link, LinkImpl> child = links.getChild(key);
        return child != null ? child.getReference() : null;
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

    // ComponentsExtension
    @Override

    public Map<String, Object> getComponentsExtensions() {
        return componentsExtensions.get();
    }
    @Override

    public Map<String, Object> getComponentsExtensions(boolean elaborate) {
        return componentsExtensions.get(elaborate);
    }

    @Override
    public boolean hasComponentsExtension(String name) {
        return componentsExtensions.containsKey(name);
    }

    @Override
    public Object getComponentsExtension(String name) {
        return componentsExtensions.get(name);
    }

    @Override
    public void setComponentsExtensions(Map<String, Object> componentsExtensions) {
        this.componentsExtensions.set(componentsExtensions);
    }

    @Override
    public void setComponentsExtension(String name, Object componentsExtension) {
        componentsExtensions.set(name, componentsExtension);
    }

    @Override
    public void removeComponentsExtension(String name) {
        componentsExtensions.remove(name);
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

    // Tag
    @Override
    public Collection<Tag> getTags() {
        return tags.get();
    }

    @Override
    public Collection<Tag> getTags(boolean elaborate) {
        return tags.get(elaborate);
    }

    @Override
    public boolean hasTags() {
        return tags.isPresent();
    }

    @Override
    public Tag getTag(int index) {
        return tags.get(index);
    }

    @Override
    public void setTags(Collection<Tag> tags) {
        this.tags.set((Collection<Tag>) tags);
    }

    @Override
    public void setTag(int index, Tag tag) {
        tags.set(index, tag);
    }

    @Override
    public void addTag(Tag tag) {
        tags.add(tag);
    }

    @Override
    public void insertTag(int index, Tag tag) {
        tags.insert(index, tag);
    }

    @Override
    public void removeTag(int index) {
        tags.remove(index);
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
        openApi = createChild("openapi", this, StringOverlay.factory);
        info = createChild("info", this, InfoImpl.factory);
        servers = createChildList("servers", this, ServerImpl.factory);
        paths = createChildMap("paths", this, PathImpl.factory, "/.*");
        refables.put("paths", paths);
        pathsExtensions = createChildMap("paths", this, ObjectOverlay.factory, "x-.+");
        schemas = createChildMap("components/schemas", this, SchemaImpl.factory, "[a-zA-Z0-9\\._-]+");
        refables.put("components/schemas", schemas);
        responses = createChildMap("components/responses", this, ResponseImpl.factory, "[a-zA-Z0-9\\._-]+");
        refables.put("components/responses", responses);
        parameters = createChildMap("components/parameters", this, ParameterImpl.factory, "[a-zA-Z0-9\\._-]+");
        refables.put("components/parameters", parameters);
        examples = createChildMap("components/examples", this, ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");
        refables.put("components/examples", examples);
        requestBodies = createChildMap("components/requestBodies", this, RequestBodyImpl.factory, "[a-zA-Z0-9\\._-]+");
        refables.put("components/requestBodies", requestBodies);
        headers = createChildMap("components/headers", this, HeaderImpl.factory, "[a-zA-Z0-9\\._-]+");
        refables.put("components/headers", headers);
        securitySchemes = createChildMap("components/securitySchemes", this, SecuritySchemeImpl.factory, "[a-zA-Z0-9\\._-]+");
        refables.put("components/securitySchemes", securitySchemes);
        links = createChildMap("components/links", this, LinkImpl.factory, "[a-zA-Z0-9\\._-]+");
        refables.put("components/links", links);
        callbacks = createChildMap("components/callbacks", this, CallbackImpl.factory, "(?!x-)[a-zA-Z0-9\\._-]+");
        refables.put("components/callbacks", callbacks);
        componentsExtensions = createChildMap("components", this, ObjectOverlay.factory, "x-.+");
        securityRequirements = createChildList("security", this, SecurityRequirementImpl.factory);
        tags = createChildList("tags", this, TagImpl.factory);
        externalDocs = createChild("externalDocs", this, ExternalDocsImpl.factory);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<OpenApi3, OpenApi3Impl> factory = new OverlayFactory<OpenApi3, OpenApi3Impl>() {
        @Override
        protected Class<? super OpenApi3Impl> getOverlayClass() {
            return OpenApi3Impl.class;
        }

        @Override
        public OpenApi3Impl _create(OpenApi3 openApi3, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new OpenApi3Impl(openApi3, parent, refReg);
        }

        @Override
        public OpenApi3Impl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new OpenApi3Impl(json, parent, refReg);
        }
    };

}
