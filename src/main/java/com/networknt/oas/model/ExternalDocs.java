package com.networknt.oas.model;

import java.util.Map;
import javax.annotation.Generated;

public interface ExternalDocs extends OpenApiObject<OpenApi3, ExternalDocs> {

    // Description

    String getDescription();


    String getDescription(boolean elaborate);


    void setDescription(String description);

    // Url

    String getUrl();


    String getUrl(boolean elaborate);


    void setUrl(String url);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
