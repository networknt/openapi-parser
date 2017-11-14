package com.networknt.oas.model;

import com.networknt.oas.jsonoverlay.Reference;
import java.util.Map;
import javax.annotation.Generated;

public interface EncodingProperty extends OpenApiObject<OpenApi3, EncodingProperty> {

    // ContentType

    String getContentType();


    String getContentType(boolean elaborate);


    void setContentType(String contentType);

    // Header

    Map<String, String> getHeaders();


    Map<String, String> getHeaders(boolean elaborate);


    boolean hasHeader(String name);


    String getHeader(String name);


    void setHeaders(Map<String, String> headers);


    void setHeader(String name, String header);


    void removeHeader(String name);


    boolean isHeaderReference(String key);


    Reference getHeaderReference(String key);

    // Style

    String getStyle();


    String getStyle(boolean elaborate);


    void setStyle(String style);

    // Explode

    Boolean getExplode();


    Boolean getExplode(boolean elaborate);


    boolean isExplode();


    void setExplode(Boolean explode);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
