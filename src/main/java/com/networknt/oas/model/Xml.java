package com.networknt.oas.model;

import java.util.Map;

public interface Xml extends OpenApiObject<OpenApi3, Xml> {

    // Name

    String getName();


    String getName(boolean elaborate);


    void setName(String name);

    // Namespace

    String getNamespace();


    String getNamespace(boolean elaborate);


    void setNamespace(String namespace);

    // Prefix

    String getPrefix();


    String getPrefix(boolean elaborate);


    void setPrefix(String prefix);

    // Attribute

    Boolean getAttribute();


    Boolean getAttribute(boolean elaborate);


    boolean isAttribute();


    void setAttribute(Boolean attribute);

    // Wrapped

    Boolean getWrapped();


    Boolean getWrapped(boolean elaborate);


    boolean isWrapped();


    void setWrapped(Boolean wrapped);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
