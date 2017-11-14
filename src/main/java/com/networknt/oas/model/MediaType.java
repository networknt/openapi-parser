package com.networknt.oas.model;

import com.networknt.oas.jsonoverlay.Reference;
import java.util.Map;
import javax.annotation.Generated;

public interface MediaType extends OpenApiObject<OpenApi3, MediaType> {

    // Schema

    Schema getSchema();


    Schema getSchema(boolean elaborate);


    void setSchema(Schema schema);


    boolean isSchemaReference();


    Reference getSchemaReference();

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

    // Example

    Object getExample();


    Object getExample(boolean elaborate);


    void setExample(Object example);

    // EncodingProperty

    Map<String, EncodingProperty> getEncodingProperties();


    Map<String, EncodingProperty> getEncodingProperties(boolean elaborate);


    boolean hasEncodingProperty(String name);


    EncodingProperty getEncodingProperty(String name);


    void setEncodingProperties(Map<String, EncodingProperty> encodingProperties);


    void setEncodingProperty(String name, EncodingProperty encodingProperty);


    void removeEncodingProperty(String name);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
