package com.networknt.oas.model;

import java.util.Map;

public interface Example extends OpenApiObject<OpenApi3, Example> {

    // Summary

    String getSummary();


    String getSummary(boolean elaborate);


    void setSummary(String summary);

    // Description

    String getDescription();


    String getDescription(boolean elaborate);


    void setDescription(String description);

    // Value

    Object getValue();


    Object getValue(boolean elaborate);


    void setValue(Object value);

    // ExternalValue

    String getExternalValue();


    String getExternalValue(boolean elaborate);


    void setExternalValue(String externalValue);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
