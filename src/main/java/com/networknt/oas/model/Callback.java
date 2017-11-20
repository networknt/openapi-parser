package com.networknt.oas.model;

import java.util.Map;

public interface Callback extends OpenApiObject<OpenApi3, Callback> {

    // CallbackPath

    Map<String, Path> getCallbackPaths();


    Map<String, Path> getCallbackPaths(boolean elaborate);


    boolean hasCallbackPath(String expression);


    Path getCallbackPath(String expression);


    void setCallbackPaths(Map<String, Path> callbackPaths);


    void setCallbackPath(String expression, Path callbackPath);


    void removeCallbackPath(String expression);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
