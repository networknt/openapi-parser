package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.jsonoverlay.*;
import com.networknt.oas.model.*;

import java.util.Map;

public class ParameterImpl extends OpenApiObjectImpl<OpenApi3, Parameter> implements Parameter {


    public ParameterImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    public ParameterImpl(Parameter parameter, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(parameter, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> name = null;


    private ChildOverlay<String, StringOverlay> in = null;


    private ChildOverlay<String, StringOverlay> description = null;


    private ChildOverlay<Boolean, BooleanOverlay> required = null;


    private ChildOverlay<Boolean, BooleanOverlay> deprecated = null;


    private ChildOverlay<Boolean, BooleanOverlay> allowEmptyValue = null;


    private ChildOverlay<String, StringOverlay> style = null;


    private ChildOverlay<Boolean, BooleanOverlay> explode = null;


    private ChildOverlay<Boolean, BooleanOverlay> allowReserved = null;


    private ChildOverlay<Schema, SchemaImpl> schema = null;


    private ChildOverlay<Object, ObjectOverlay> example = null;


    private ChildMapOverlay<Example, ExampleImpl> examples = null;


    private ChildMapOverlay<MediaType, MediaTypeImpl> contentMediaTypes = null;


    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

    // Name
    @Override
    public String getName() {
        return name.get();
    }

    @Override
    public String getName(boolean elaborate) {
        return name.get(elaborate);
    }

    @Override
    public void setName(String name) {
        this.name.set(name);
    }

    // In
    @Override
    public String getIn() {
        return in.get();
    }

    @Override
    public String getIn(boolean elaborate) {
        return in.get(elaborate);
    }

    @Override
    public void setIn(String in) {
        this.in.set(in);
    }

    // Description
    @Override
    public String getDescription() {
        return description.get();
    }

    @Override
    public String getDescription(boolean elaborate) {
        return description.get(elaborate);
    }

    @Override
    public void setDescription(String description) {
        this.description.set(description);
    }

    // Required
    @Override
    public Boolean getRequired() {
        return required.get();
    }

    @Override
    public Boolean getRequired(boolean elaborate) {
        return required.get(elaborate);
    }

    @Override
    public boolean isRequired() {
        return required.get() != null ? required.get() : false;
    }

    @Override
    public void setRequired(Boolean required) {
        this.required.set(required);
    }

    // Deprecated
    @Override
    public Boolean getDeprecated() {
        return deprecated.get();
    }

    @Override
    public Boolean getDeprecated(boolean elaborate) {
        return deprecated.get(elaborate);
    }

    @Override
    public boolean isDeprecated() {
        return deprecated.get() != null ? deprecated.get() : false;
    }

    @Override
    public void setDeprecated(Boolean deprecated) {
        this.deprecated.set(deprecated);
    }

    // AllowEmptyValue
    @Override
    public Boolean getAllowEmptyValue() {
        return allowEmptyValue.get();
    }

    @Override
    public Boolean getAllowEmptyValue(boolean elaborate) {
        return allowEmptyValue.get(elaborate);
    }

    @Override
    public boolean isAllowEmptyValue() {
        return allowEmptyValue.get() != null ? allowEmptyValue.get() : false;
    }

    @Override
    public void setAllowEmptyValue(Boolean allowEmptyValue) {
        this.allowEmptyValue.set(allowEmptyValue);
    }

    // Style
    @Override
    public String getStyle() {
        return style.get();
    }

    @Override
    public String getStyle(boolean elaborate) {
        return style.get(elaborate);
    }

    @Override
    public void setStyle(String style) {
        this.style.set(style);
    }

    // Explode
    @Override
    public Boolean getExplode() {
        return explode.get();
    }

    @Override
    public Boolean getExplode(boolean elaborate) {
        return explode.get(elaborate);
    }

    @Override
    public boolean isExplode() {
        return explode.get() != null ? explode.get() : false;
    }

    @Override
    public void setExplode(Boolean explode) {
        this.explode.set(explode);
    }

    // AllowReserved
    @Override
    public Boolean getAllowReserved() {
        return allowReserved.get();
    }

    @Override
    public Boolean getAllowReserved(boolean elaborate) {
        return allowReserved.get(elaborate);
    }

    @Override
    public boolean isAllowReserved() {
        return allowReserved.get() != null ? allowReserved.get() : false;
    }

    @Override
    public void setAllowReserved(Boolean allowReserved) {
        this.allowReserved.set(allowReserved);
    }

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

    // ContentMediaType
    @Override
    public Map<String, MediaType> getContentMediaTypes() {
        return contentMediaTypes.get();
    }

    @Override
    public Map<String, MediaType> getContentMediaTypes(boolean elaborate) {
        return contentMediaTypes.get(elaborate);
    }

    @Override
    public boolean hasContentMediaType(String name) {
        return contentMediaTypes.containsKey(name);
    }

    @Override
    public MediaType getContentMediaType(String name) {
        return contentMediaTypes.get(name);
    }

    @Override
    public void setContentMediaTypes(Map<String, MediaType> contentMediaTypes) {
        this.contentMediaTypes.set(contentMediaTypes);
    }

    @Override
    public void setContentMediaType(String name, MediaType contentMediaType) {
        contentMediaTypes.set(name, contentMediaType);
    }

    @Override
    public void removeContentMediaType(String name) {
        contentMediaTypes.remove(name);
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
        name = createChild("name", this, StringOverlay.factory);
        in = createChild("in", this, StringOverlay.factory);
        description = createChild("description", this, StringOverlay.factory);
        required = createChild("required", this, BooleanOverlay.factory);
        deprecated = createChild("deprecated", this, BooleanOverlay.factory);
        allowEmptyValue = createChild("allowEmptyValue", this, BooleanOverlay.factory);
        style = createChild("style", this, StringOverlay.factory);
        explode = createChild("explode", this, BooleanOverlay.factory);
        allowReserved = createChild("allowReserved", this, BooleanOverlay.factory);
        schema = createChild("schema", this, SchemaImpl.factory);
        refables.put("schema", schema);
        example = createChild("example", this, ObjectOverlay.factory);
        examples = createChildMap("examples", this, ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");
        refables.put("examples", examples);
        contentMediaTypes = createChildMap("content", this, MediaTypeImpl.factory, null);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<Parameter, ParameterImpl> factory = new OverlayFactory<Parameter, ParameterImpl>() {
        @Override
        protected Class<? super ParameterImpl> getOverlayClass() {
            return ParameterImpl.class;
        }

        @Override
        public ParameterImpl _create(Parameter parameter, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new ParameterImpl(parameter, parent, refReg);
        }

        @Override
        public ParameterImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new ParameterImpl(json, parent, refReg);
        }
    };

}
