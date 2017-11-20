package com.networknt.oas.model;

import com.networknt.oas.jsonoverlay.Reference;

import java.util.Collection;
import java.util.Map;

public interface Operation extends OpenApiObject<OpenApi3, Operation> {

    // Tag

    Collection<String> getTags();


    Collection<String> getTags(boolean elaborate);


    boolean hasTags();


    String getTag(int index);


    void setTags(Collection<String> tags);


    void setTag(int index, String tag);


    void addTag(String tag);


    void insertTag(int index, String tag);


    void removeTag(int index);

    // Summary

    String getSummary();


    String getSummary(boolean elaborate);


    void setSummary(String summary);

    // Description

    String getDescription();


    String getDescription(boolean elaborate);


    void setDescription(String description);

    // ExternalDocs

    ExternalDocs getExternalDocs();


    ExternalDocs getExternalDocs(boolean elaborate);


    void setExternalDocs(ExternalDocs externalDocs);

    // OperationId

    String getOperationId();


    String getOperationId(boolean elaborate);


    void setOperationId(String operationId);

    // Parameter

    Collection<Parameter> getParameters();


    Collection<Parameter> getParameters(boolean elaborate);


    boolean hasParameters();


    Parameter getParameter(int index);


    void setParameters(Collection<Parameter> parameters);


    void setParameter(int index, Parameter parameter);


    void addParameter(Parameter parameter);


    void insertParameter(int index, Parameter parameter);


    void removeParameter(int index);


    boolean isParameterReference(int index);


    Reference getParameterReference(int index);

    // RequestBody

    RequestBody getRequestBody();


    RequestBody getRequestBody(boolean elaborate);


    void setRequestBody(RequestBody requestBody);


    boolean isRequestBodyReference();


    Reference getRequestBodyReference();

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

    // ResponsesExtension

    Map<String, Object> getResponsesExtensions();


    Map<String, Object> getResponsesExtensions(boolean elaborate);


    boolean hasResponsesExtension(String name);


    Object getResponsesExtension(String name);


    void setResponsesExtensions(Map<String, Object> responsesExtensions);


    void setResponsesExtension(String name, Object responsesExtension);


    void removeResponsesExtension(String name);

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

    // CallbacksExtension

    Map<String, Object> getCallbacksExtensions();


    Map<String, Object> getCallbacksExtensions(boolean elaborate);


    boolean hasCallbacksExtension(String name);


    Object getCallbacksExtension(String name);


    void setCallbacksExtensions(Map<String, Object> callbacksExtensions);


    void setCallbacksExtension(String name, Object callbacksExtension);


    void removeCallbacksExtension(String name);

    // Deprecated

    Boolean getDeprecated();


    Boolean getDeprecated(boolean elaborate);


    boolean isDeprecated();


    void setDeprecated(Boolean deprecated);

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

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
