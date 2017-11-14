package com.networknt.oas.model;

import java.util.Map;
import javax.annotation.Generated;

public interface RequestBody extends OpenApiObject<OpenApi3, RequestBody> {

    // Description

    String getDescription();


    String getDescription(boolean elaborate);


    void setDescription(String description);

    // ContentMediaType

    Map<String, MediaType> getContentMediaTypes();


    Map<String, MediaType> getContentMediaTypes(boolean elaborate);


    boolean hasContentMediaType(String name);


    MediaType getContentMediaType(String name);


    void setContentMediaTypes(Map<String, MediaType> contentMediaTypes);


    void setContentMediaType(String name, MediaType contentMediaType);


    void removeContentMediaType(String name);

    // Required

    Boolean getRequired();


    Boolean getRequired(boolean elaborate);


    boolean isRequired();


    void setRequired(Boolean required);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
