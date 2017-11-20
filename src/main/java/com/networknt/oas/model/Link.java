package com.networknt.oas.model;

import java.util.Map;

public interface Link extends OpenApiObject<OpenApi3, Link> {

    // OperationId

    String getOperationId();


    String getOperationId(boolean elaborate);


    void setOperationId(String operationId);

    // OperationRef

    String getOperationRef();


    String getOperationRef(boolean elaborate);


    void setOperationRef(String operationRef);

    // Parameter

    Map<String, String> getParameters();


    Map<String, String> getParameters(boolean elaborate);


    boolean hasParameter(String name);


    String getParameter(String name);


    void setParameters(Map<String, String> parameters);


    void setParameter(String name, String parameter);


    void removeParameter(String name);

    // Header

    Map<String, Header> getHeaders();


    Map<String, Header> getHeaders(boolean elaborate);


    boolean hasHeader(String name);


    Header getHeader(String name);


    void setHeaders(Map<String, Header> headers);


    void setHeader(String name, Header header);


    void removeHeader(String name);

    // Description

    String getDescription();


    String getDescription(boolean elaborate);


    void setDescription(String description);

    // Server

    Server getServer();


    Server getServer(boolean elaborate);


    void setServer(Server server);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
