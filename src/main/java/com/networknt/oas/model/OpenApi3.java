package com.networknt.oas.model;

import com.networknt.oas.OpenApi;
import com.networknt.oas.jsonoverlay.Reference;
import com.networknt.oas.validator.ValidationResults;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public interface OpenApi3 extends OpenApiObject<OpenApi3, OpenApi3>, OpenApi<OpenApi3> {

    public void validate();

    public boolean isValid();

    public ValidationResults getValidationResults();

    public Collection<ValidationResults.ValidationItem> getValidationItems();

    // OpenApi

    String getOpenApi();


    String getOpenApi(boolean elaborate);


    void setOpenApi(String openApi);

    // Info

    Info getInfo();


    Info getInfo(boolean elaborate);


    void setInfo(Info info);

    // Server

    Collection<Server> getServers();


    Collection<Server> getServers(boolean elaborate);


    boolean hasServers();


    Server getServer(int index);


    void setServers(Collection<Server> servers);


    void setServer(int index, Server server);


    void addServer(Server server);


    void insertServer(int index, Server server);


    void removeServer(int index);

    // Path

    Map<String, Path> getPaths();


    Map<String, Path> getPaths(boolean elaborate);


    boolean hasPath(String name);


    Path getPath(String name);


    void setPaths(Map<String, Path> paths);


    void setPath(String name, Path path);


    void removePath(String name);


    boolean isPathReference(String key);


    Reference getPathReference(String key);

    // PathsExtension

    Map<String, Object> getPathsExtensions();


    Map<String, Object> getPathsExtensions(boolean elaborate);


    boolean hasPathsExtension(String name);


    Object getPathsExtension(String name);


    void setPathsExtensions(Map<String, Object> pathsExtensions);


    void setPathsExtension(String name, Object pathsExtension);


    void removePathsExtension(String name);

    // Schema

    Map<String, Schema> getSchemas();


    Map<String, Schema> getSchemas(boolean elaborate);


    boolean hasSchema(String name);


    Schema getSchema(String name);


    void setSchemas(Map<String, Schema> schemas);


    void setSchema(String name, Schema schema);


    void removeSchema(String name);


    boolean isSchemaReference(String key);


    Reference getSchemaReference(String key);

    // Response

    Map<String, Response> getResponses();


    Map<String, Response> getResponses(boolean elaborate);


    boolean hasResponse(String name);


    Response getResponse(String name);


    void setResponses(Map<String, Response> responses);


    void setResponse(String name, Response response);


    void removeResponse(String name);


    boolean isResponseReference(String key);


    Reference getResponseReference(String key);

    // Parameter

    Map<String, Parameter> getParameters();


    Map<String, Parameter> getParameters(boolean elaborate);


    boolean hasParameter(String name);


    Parameter getParameter(String name);


    void setParameters(Map<String, Parameter> parameters);


    void setParameter(String name, Parameter parameter);


    void removeParameter(String name);


    boolean isParameterReference(String key);


    Reference getParameterReference(String key);

    // Example

    Map<String, Example> getExamples();


    Map<String, Example> getExamples(boolean elaborate);


    boolean hasExample(String name);


    Example getExample(String name);


    void setExamples(Map<String, Example> examples);


    void setExample(String name, Example example);


    void removeExample(String name);


    boolean isExampleReference(String key);


    Reference getExampleReference(String key);

    // RequestBody

    Map<String, RequestBody> getRequestBodies();


    Map<String, RequestBody> getRequestBodies(boolean elaborate);


    boolean hasRequestBody(String name);


    RequestBody getRequestBody(String name);


    void setRequestBodies(Map<String, RequestBody> requestBodies);


    void setRequestBody(String name, RequestBody requestBody);


    void removeRequestBody(String name);


    boolean isRequestBodyReference(String key);


    Reference getRequestBodyReference(String key);

    // Header

    Map<String, Header> getHeaders();


    Map<String, Header> getHeaders(boolean elaborate);


    boolean hasHeader(String name);


    Header getHeader(String name);


    void setHeaders(Map<String, Header> headers);


    void setHeader(String name, Header header);


    void removeHeader(String name);


    boolean isHeaderReference(String key);


    Reference getHeaderReference(String key);

    // SecurityScheme

    Map<String, SecurityScheme> getSecuritySchemes();


    Map<String, SecurityScheme> getSecuritySchemes(boolean elaborate);


    boolean hasSecurityScheme(String name);


    SecurityScheme getSecurityScheme(String name);


    void setSecuritySchemes(Map<String, SecurityScheme> securitySchemes);


    void setSecurityScheme(String name, SecurityScheme securityScheme);


    void removeSecurityScheme(String name);


    boolean isSecuritySchemeReference(String key);


    Reference getSecuritySchemeReference(String key);

    // Link

    Map<String, Link> getLinks();


    Map<String, Link> getLinks(boolean elaborate);


    boolean hasLink(String name);


    Link getLink(String name);


    void setLinks(Map<String, Link> links);


    void setLink(String name, Link link);


    void removeLink(String name);


    boolean isLinkReference(String key);


    Reference getLinkReference(String key);

    // Callback

    Map<String, Callback> getCallbacks();


    Map<String, Callback> getCallbacks(boolean elaborate);


    boolean hasCallback(String name);


    Callback getCallback(String name);


    void setCallbacks(Map<String, Callback> callbacks);


    void setCallback(String name, Callback callback);


    void removeCallback(String name);


    boolean isCallbackReference(String key);


    Reference getCallbackReference(String key);

    // ComponentsExtension

    Map<String, Object> getComponentsExtensions();


    Map<String, Object> getComponentsExtensions(boolean elaborate);


    boolean hasComponentsExtension(String name);


    Object getComponentsExtension(String name);


    void setComponentsExtensions(Map<String, Object> componentsExtensions);


    void setComponentsExtension(String name, Object componentsExtension);


    void removeComponentsExtension(String name);

    // SecurityRequirement

    Collection<SecurityRequirement> getSecurityRequirements();


    Collection<SecurityRequirement> getSecurityRequirements(boolean elaborate);


    boolean hasSecurityRequirements();


    SecurityRequirement getSecurityRequirement(int index);


    void setSecurityRequirements(Collection<SecurityRequirement> securityRequirements);


    void setSecurityRequirement(int index, SecurityRequirement securityRequirement);


    void addSecurityRequirement(SecurityRequirement securityRequirement);


    void insertSecurityRequirement(int index, SecurityRequirement securityRequirement);


    void removeSecurityRequirement(int index);

    // Tag

    Collection<Tag> getTags();


    Collection<Tag> getTags(boolean elaborate);


    boolean hasTags();


    Tag getTag(int index);


    void setTags(Collection<Tag> tags);


    void setTag(int index, Tag tag);


    void addTag(Tag tag);


    void insertTag(int index, Tag tag);


    void removeTag(int index);

    // ExternalDocs

    ExternalDocs getExternalDocs();


    ExternalDocs getExternalDocs(boolean elaborate);


    void setExternalDocs(ExternalDocs externalDocs);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
