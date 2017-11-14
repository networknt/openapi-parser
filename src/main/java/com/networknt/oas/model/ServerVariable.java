package com.networknt.oas.model;

import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public interface ServerVariable extends OpenApiObject<OpenApi3, ServerVariable> {

    // EnumValue

    Collection<Object> getEnumValues();


    Collection<Object> getEnumValues(boolean elaborate);


    boolean hasEnumValues();


    Object getEnumValue(int index);


    void setEnumValues(Collection<Object> enumValues);


    void setEnumValue(int index, Object enumValue);


    void addEnumValue(Object enumValue);


    void insertEnumValue(int index, Object enumValue);


    void removeEnumValue(int index);

    // Default

    Object getDefault();


    Object getDefault(boolean elaborate);


    void setDefault(Object defaultValue);

    // Description

    String getDescription();


    String getDescription(boolean elaborate);


    void setDescription(String description);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
