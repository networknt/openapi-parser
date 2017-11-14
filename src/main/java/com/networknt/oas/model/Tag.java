package com.networknt.oas.model;

import java.util.Map;
import javax.annotation.Generated;

public interface Tag extends OpenApiObject<OpenApi3, Tag> {

    // Name

    String getName();


    String getName(boolean elaborate);


    void setName(String name);

    // Description

    String getDescription();


    String getDescription(boolean elaborate);


    void setDescription(String description);

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
