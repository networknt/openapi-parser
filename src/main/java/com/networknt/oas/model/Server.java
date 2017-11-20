package com.networknt.oas.model;

import java.util.Map;

public interface Server extends OpenApiObject<OpenApi3, Server> {

    // Url

    String getUrl();


    String getUrl(boolean elaborate);


    void setUrl(String url);

    // Description

    String getDescription();


    String getDescription(boolean elaborate);


    void setDescription(String description);

    // ServerVariable

    Map<String, ServerVariable> getServerVariables();


    Map<String, ServerVariable> getServerVariables(boolean elaborate);


    boolean hasServerVariable(String name);


    ServerVariable getServerVariable(String name);


    void setServerVariables(Map<String, ServerVariable> serverVariables);


    void setServerVariable(String name, ServerVariable serverVariable);


    void removeServerVariable(String name);

    // VariablesExtension

    Map<String, Object> getVariablesExtensions();


    Map<String, Object> getVariablesExtensions(boolean elaborate);


    boolean hasVariablesExtension(String name);


    Object getVariablesExtension(String name);


    void setVariablesExtensions(Map<String, Object> variablesExtensions);


    void setVariablesExtension(String name, Object variablesExtension);


    void removeVariablesExtension(String name);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
