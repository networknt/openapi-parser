package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.jsonoverlay.*;
import com.networknt.oas.model.Example;
import com.networknt.oas.model.OpenApi3;

import java.util.Map;

public class ExampleImpl extends OpenApiObjectImpl<OpenApi3, Example> implements Example {


    public ExampleImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    public ExampleImpl(Example example, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(example, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> summary = null;


    private ChildOverlay<String, StringOverlay> description = null;


    private ChildOverlay<Object, ObjectOverlay> value = null;


    private ChildOverlay<String, StringOverlay> externalValue = null;


    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

    // Summary
    @Override
    public String getSummary() {
        return summary.get();
    }

    @Override
    public String getSummary(boolean elaborate) {
        return summary.get(elaborate);
    }

    @Override
    public void setSummary(String summary) {
        this.summary.set(summary);
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

    // Value
    @Override
    public Object getValue() {
        return value.get();
    }

    @Override
    public Object getValue(boolean elaborate) {
        return value.get(elaborate);
    }

    @Override
    public void setValue(Object value) {
        this.value.set(value);
    }

    // ExternalValue
    @Override
    public String getExternalValue() {
        return externalValue.get();
    }

    @Override
    public String getExternalValue(boolean elaborate) {
        return externalValue.get(elaborate);
    }

    @Override
    public void setExternalValue(String externalValue) {
        this.externalValue.set(externalValue);
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
        summary = createChild("summary", this, StringOverlay.factory);
        description = createChild("description", this, StringOverlay.factory);
        value = createChild("value", this, ObjectOverlay.factory);
        externalValue = createChild("externalValue", this, StringOverlay.factory);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<Example, ExampleImpl> factory = new OverlayFactory<Example, ExampleImpl>() {
        @Override
        protected Class<? super ExampleImpl> getOverlayClass() {
            return ExampleImpl.class;
        }

        @Override
        public ExampleImpl _create(Example example, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new ExampleImpl(example, parent, refReg);
        }

        @Override
        public ExampleImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new ExampleImpl(json, parent, refReg);
        }
    };

}
