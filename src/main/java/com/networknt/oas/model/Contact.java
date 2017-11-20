package com.networknt.oas.model;

import java.util.Map;

public interface Contact extends OpenApiObject<OpenApi3, Contact> {

    // Name

    String getName();


    String getName(boolean elaborate);


    void setName(String name);

    // Url

    String getUrl();


    String getUrl(boolean elaborate);


    void setUrl(String url);

    // Email

    String getEmail();


    String getEmail(boolean elaborate);


    void setEmail(String email);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
