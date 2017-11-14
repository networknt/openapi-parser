package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.jsonoverlay.ChildListOverlay;
import com.networknt.oas.jsonoverlay.ChildMapOverlay;
import com.networknt.oas.jsonoverlay.ChildOverlay;
import com.networknt.oas.jsonoverlay.JsonOverlay;
import com.networknt.oas.jsonoverlay.ListOverlay;
import com.networknt.oas.jsonoverlay.MapOverlay;
import com.networknt.oas.jsonoverlay.ObjectOverlay;
import com.networknt.oas.jsonoverlay.OverlayFactory;
import com.networknt.oas.jsonoverlay.Reference;
import com.networknt.oas.jsonoverlay.ReferenceRegistry;
import com.networknt.oas.model.EncodingProperty;
import com.networknt.oas.model.Example;
import com.networknt.oas.model.MediaType;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.Schema;
import com.networknt.oas.model.impl.EncodingPropertyImpl;
import com.networknt.oas.model.impl.ExampleImpl;
import com.networknt.oas.model.impl.OpenApiObjectImpl;
import com.networknt.oas.model.impl.SchemaImpl;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public class MediaTypeImpl extends OpenApiObjectImpl<OpenApi3, MediaType> implements MediaType {


    public MediaTypeImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    public MediaTypeImpl(MediaType mediaType, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(mediaType, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<Schema, SchemaImpl> schema = null;


    private ChildMapOverlay<Example, ExampleImpl> examples = null;


    private ChildOverlay<Object, ObjectOverlay> example = null;


    private ChildMapOverlay<EncodingProperty, EncodingPropertyImpl> encodingProperties = null;


    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

    // Schema
    @Override

    public Schema getSchema() {
        return schema.get();
    }

    @Override

    public Schema getSchema(boolean elaborate) {
        return schema.get(elaborate);
    }

    @Override

    public void setSchema(Schema schema) {
        this.schema.set(schema);
    }

    @Override

    public boolean isSchemaReference() {
        return schema != null ? schema.isReference() : false;
    }

    @Override

    public Reference getSchemaReference() {
        return schema != null ? schema.getReference() : null;
    }

    // Example
    @Override

    public Map<String, Example> getExamples() {
        return examples.get();
    }

    @Override

    public Map<String, Example> getExamples(boolean elaborate) {
        return examples.get(elaborate);
    }

    @Override

    public boolean hasExample(String name) {
        return examples.containsKey(name);
    }

    @Override

    public Example getExample(String name) {
        return examples.get(name);
    }

    @Override

    public void setExamples(Map<String, Example> examples) {
        this.examples.set(examples);
    }

    @Override

    public void setExample(String name, Example example) {
        examples.set(name, example);
    }

    @Override

    public void removeExample(String name) {
        examples.remove(name);
    }

    @Override

    public boolean isExampleReference(String key) {
        ChildOverlay<Example, ExampleImpl> child = examples.getChild(key);
            return child != null ? child.isReference() : false;
    }

    @Override

    public Reference getExampleReference(String key) {
        ChildOverlay<Example, ExampleImpl> child = examples.getChild(key);
            return child != null ? child.getReference() : null;
    }

    // Example
    @Override

    public Object getExample() {
        return example.get();
    }

    @Override

    public Object getExample(boolean elaborate) {
        return example.get(elaborate);
    }

    @Override

    public void setExample(Object example) {
        this.example.set(example);
    }

    // EncodingProperty
    @Override

    public Map<String, EncodingProperty> getEncodingProperties() {
        return encodingProperties.get();
    }

    @Override

    public Map<String, EncodingProperty> getEncodingProperties(boolean elaborate) {
        return encodingProperties.get(elaborate);
    }

    @Override

    public boolean hasEncodingProperty(String name) {
        return encodingProperties.containsKey(name);
    }

    @Override

    public EncodingProperty getEncodingProperty(String name) {
        return encodingProperties.get(name);
    }

    @Override

    public void setEncodingProperties(Map<String, EncodingProperty> encodingProperties) {
        this.encodingProperties.set(encodingProperties);
    }

    @Override

    public void setEncodingProperty(String name, EncodingProperty encodingProperty) {
        encodingProperties.set(name, encodingProperty);
    }

    @Override

    public void removeEncodingProperty(String name) {
        encodingProperties.remove(name);
    }

    // Extension
    @Override

    public Map<String, Object> getExtensions() {
        return extensions.get();
    }

    @Override

    public Map<String, Object> getExtensions(boolean elaborate) {
        return extensions.get(elaborate);
    }

    @Override

    public boolean hasExtension(String name) {
        return extensions.containsKey(name);
    }

    @Override

    public Object getExtension(String name) {
        return extensions.get(name);
    }

    @Override

    public void setExtensions(Map<String, Object> extensions) {
        this.extensions.set(extensions);
    }

    @Override

    public void setExtension(String name, Object extension) {
        extensions.set(name, extension);
    }

    @Override

    public void removeExtension(String name) {
        extensions.remove(name);
    }

    @Override

    protected void elaborateChildren() {
        schema = createChild("schema", this, SchemaImpl.factory);
            refables.put("schema", schema);
            examples = createChildMap("examples", this, ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");
            refables.put("examples", examples);
            example = createChild("example", this, ObjectOverlay.factory);
            encodingProperties = createChildMap("encoding", this, EncodingPropertyImpl.factory, null);
            extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<MediaType, MediaTypeImpl> factory = new OverlayFactory<MediaType, MediaTypeImpl>() {
    @Override
    protected Class<? super MediaTypeImpl> getOverlayClass() {
         return MediaTypeImpl.class;
    }

    @Override
    public MediaTypeImpl _create(MediaType mediaType, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new MediaTypeImpl(mediaType, parent, refReg);
    }

    @Override
    public MediaTypeImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new MediaTypeImpl(json, parent, refReg);
    }
};

}
