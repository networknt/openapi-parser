package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.jsonoverlay.BooleanOverlay;
import com.networknt.oas.jsonoverlay.ChildListOverlay;
import com.networknt.oas.jsonoverlay.ChildMapOverlay;
import com.networknt.oas.jsonoverlay.ChildOverlay;
import com.networknt.oas.jsonoverlay.JsonOverlay;
import com.networknt.oas.jsonoverlay.ListOverlay;
import com.networknt.oas.jsonoverlay.MapOverlay;
import com.networknt.oas.jsonoverlay.ObjectOverlay;
import com.networknt.oas.jsonoverlay.OverlayFactory;
import com.networknt.oas.jsonoverlay.ReferenceRegistry;
import com.networknt.oas.jsonoverlay.StringOverlay;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.Xml;
import com.networknt.oas.model.impl.OpenApiObjectImpl;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public class XmlImpl extends OpenApiObjectImpl<OpenApi3, Xml> implements Xml {


    public XmlImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    public XmlImpl(Xml xml, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(xml, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> name = null;


    private ChildOverlay<String, StringOverlay> namespace = null;


    private ChildOverlay<String, StringOverlay> prefix = null;


    private ChildOverlay<Boolean, BooleanOverlay> attribute = null;


    private ChildOverlay<Boolean, BooleanOverlay> wrapped = null;


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

    // Namespace
    @Override

    public String getNamespace() {
        return namespace.get();
    }

    @Override

    public String getNamespace(boolean elaborate) {
        return namespace.get(elaborate);
    }

    @Override

    public void setNamespace(String namespace) {
        this.namespace.set(namespace);
    }

    // Prefix
    @Override

    public String getPrefix() {
        return prefix.get();
    }

    @Override

    public String getPrefix(boolean elaborate) {
        return prefix.get(elaborate);
    }

    @Override

    public void setPrefix(String prefix) {
        this.prefix.set(prefix);
    }

    // Attribute
    @Override

    public Boolean getAttribute() {
        return attribute.get();
    }

    @Override

    public Boolean getAttribute(boolean elaborate) {
        return attribute.get(elaborate);
    }

    @Override

    public boolean isAttribute() {
        return attribute.get() != null ? attribute.get() : false;
    }

    @Override

    public void setAttribute(Boolean attribute) {
        this.attribute.set(attribute);
    }

    // Wrapped
    @Override

    public Boolean getWrapped() {
        return wrapped.get();
    }

    @Override

    public Boolean getWrapped(boolean elaborate) {
        return wrapped.get(elaborate);
    }

    @Override

    public boolean isWrapped() {
        return wrapped.get() != null ? wrapped.get() : false;
    }

    @Override

    public void setWrapped(Boolean wrapped) {
        this.wrapped.set(wrapped);
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
            namespace = createChild("namespace", this, StringOverlay.factory);
            prefix = createChild("prefix", this, StringOverlay.factory);
            attribute = createChild("attribute", this, BooleanOverlay.factory);
            wrapped = createChild("wrapped", this, BooleanOverlay.factory);
            extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<Xml, XmlImpl> factory = new OverlayFactory<Xml, XmlImpl>() {
    @Override
    protected Class<? super XmlImpl> getOverlayClass() {
         return XmlImpl.class;
    }

    @Override
    public XmlImpl _create(Xml xml, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new XmlImpl(xml, parent, refReg);
    }

    @Override
    public XmlImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new XmlImpl(json, parent, refReg);
    }
};

}
