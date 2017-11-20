package com.networknt.oas.model;

import com.networknt.oas.jsonoverlay.Reference;

import java.util.Map;

public interface Parameter extends OpenApiObject<OpenApi3, Parameter> {

    // Name

    String getName();


    String getName(boolean elaborate);


    void setName(String name);

    // In

    String getIn();


    String getIn(boolean elaborate);


    void setIn(String in);

    // Description

    String getDescription();


    String getDescription(boolean elaborate);


    void setDescription(String description);

    // Required

    Boolean getRequired();


    Boolean getRequired(boolean elaborate);


    boolean isRequired();


    void setRequired(Boolean required);

    // Deprecated

    Boolean getDeprecated();


    Boolean getDeprecated(boolean elaborate);


    boolean isDeprecated();


    void setDeprecated(Boolean deprecated);

    // AllowEmptyValue

    Boolean getAllowEmptyValue();


    Boolean getAllowEmptyValue(boolean elaborate);


    boolean isAllowEmptyValue();


    void setAllowEmptyValue(Boolean allowEmptyValue);

    // Style

    String getStyle();


    String getStyle(boolean elaborate);


    void setStyle(String style);

    // Explode

    Boolean getExplode();


    Boolean getExplode(boolean elaborate);


    boolean isExplode();


    void setExplode(Boolean explode);

    // AllowReserved

    Boolean getAllowReserved();


    Boolean getAllowReserved(boolean elaborate);


    boolean isAllowReserved();


    void setAllowReserved(Boolean allowReserved);

    // Schema

    Schema getSchema();


    Schema getSchema(boolean elaborate);


    void setSchema(Schema schema);


    boolean isSchemaReference();


    Reference getSchemaReference();

    // Example

    Object getExample();


    Object getExample(boolean elaborate);


    void setExample(Object example);

    // Example

    Map<String, Example> getExamples();


    Map<String, Example> getExamples(boolean elaborate);


    boolean hasExample(String name);


    Example getExample(String name);


    void setExamples(Map<String, Example> examples);


    void setExample(String name, Example example);


    void removeExample(String name);


    boolean isExampleReference(String key);


    Reference getExampleReference(String key);

    // ContentMediaType

    Map<String, MediaType> getContentMediaTypes();


    Map<String, MediaType> getContentMediaTypes(boolean elaborate);


    boolean hasContentMediaType(String name);


    MediaType getContentMediaType(String name);


    void setContentMediaTypes(Map<String, MediaType> contentMediaTypes);


    void setContentMediaType(String name, MediaType contentMediaType);


    void removeContentMediaType(String name);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
