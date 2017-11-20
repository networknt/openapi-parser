package com.networknt.oas.model;

import java.util.Map;

public interface License extends OpenApiObject<OpenApi3, License> {

    // Name

    String getName();


    String getName(boolean elaborate);


    void setName(String name);

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
