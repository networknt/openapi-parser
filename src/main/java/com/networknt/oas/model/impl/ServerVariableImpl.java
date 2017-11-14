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
import com.networknt.oas.jsonoverlay.PrimitiveOverlay;
import com.networknt.oas.jsonoverlay.ReferenceRegistry;
import com.networknt.oas.jsonoverlay.StringOverlay;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.ServerVariable;
import com.networknt.oas.model.impl.OpenApiObjectImpl;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public class ServerVariableImpl extends OpenApiObjectImpl<OpenApi3, ServerVariable> implements ServerVariable {


    public ServerVariableImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    public ServerVariableImpl(ServerVariable serverVariable, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(serverVariable, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    private ChildListOverlay<Object, PrimitiveOverlay> enumValues = null;


    private ChildOverlay<Object, PrimitiveOverlay> defaultValue = null;


    private ChildOverlay<String, StringOverlay> description = null;


    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

    // EnumValue
    @Override

    public Collection<Object> getEnumValues() {
        return enumValues.get();
    }

    @Override

    public Collection<Object> getEnumValues(boolean elaborate) {
        return enumValues.get(elaborate);
    }

    @Override

    public boolean hasEnumValues() {
        return enumValues.isPresent();
    }

    @Override

    public Object getEnumValue(int index) {
        return enumValues.get(index);
    }

    @Override

    public void setEnumValues(Collection<Object> enumValues) {
        this.enumValues.set((Collection<Object>) enumValues);
    }

    @Override

    public void setEnumValue(int index, Object enumValue) {
        enumValues.set(index, enumValue);
    }

    @Override

    public void addEnumValue(Object enumValue) {
        enumValues.add(enumValue);
    }

    @Override

    public void insertEnumValue(int index, Object enumValue) {
        enumValues.insert(index, enumValue);
    }

    @Override

    public void removeEnumValue(int index) {
        enumValues.remove(index);
    }

    // Default
    @Override

    public Object getDefault() {
        return defaultValue.get();
    }

    @Override

    public Object getDefault(boolean elaborate) {
        return defaultValue.get(elaborate);
    }

    @Override

    public void setDefault(Object defaultValue) {
        this.defaultValue.set(defaultValue);
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
        enumValues = createChildList("enum", this, PrimitiveOverlay.factory);
            defaultValue = createChild("default", this, PrimitiveOverlay.factory);
            description = createChild("description", this, StringOverlay.factory);
            extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<ServerVariable, ServerVariableImpl> factory = new OverlayFactory<ServerVariable, ServerVariableImpl>() {
    @Override
    protected Class<? super ServerVariableImpl> getOverlayClass() {
         return ServerVariableImpl.class;
    }

    @Override
    public ServerVariableImpl _create(ServerVariable serverVariable, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new ServerVariableImpl(serverVariable, parent, refReg);
    }

    @Override
    public ServerVariableImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new ServerVariableImpl(json, parent, refReg);
    }
};

}
