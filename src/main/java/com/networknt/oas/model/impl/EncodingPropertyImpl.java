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
import com.networknt.oas.jsonoverlay.Reference;
import com.networknt.oas.jsonoverlay.ReferenceRegistry;
import com.networknt.oas.jsonoverlay.StringOverlay;
import com.networknt.oas.model.EncodingProperty;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.impl.OpenApiObjectImpl;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public class EncodingPropertyImpl extends OpenApiObjectImpl<OpenApi3, EncodingProperty> implements EncodingProperty {


    public EncodingPropertyImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    public EncodingPropertyImpl(EncodingProperty encodingProperty, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(encodingProperty, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> contentType = null;


    private ChildMapOverlay<String, StringOverlay> headers = null;


    private ChildOverlay<String, StringOverlay> style = null;


    private ChildOverlay<Boolean, BooleanOverlay> explode = null;


    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

    // ContentType
    @Override

    public String getContentType() {
        return contentType.get();
    }

    @Override

    public String getContentType(boolean elaborate) {
        return contentType.get(elaborate);
    }

    @Override

    public void setContentType(String contentType) {
        this.contentType.set(contentType);
    }

    // Header
    @Override

    public Map<String, String> getHeaders() {
        return headers.get();
    }

    @Override

    public Map<String, String> getHeaders(boolean elaborate) {
        return headers.get(elaborate);
    }

    @Override

    public boolean hasHeader(String name) {
        return headers.containsKey(name);
    }

    @Override

    public String getHeader(String name) {
        return headers.get(name);
    }

    @Override

    public void setHeaders(Map<String, String> headers) {
        this.headers.set(headers);
    }

    @Override

    public void setHeader(String name, String header) {
        headers.set(name, header);
    }

    @Override

    public void removeHeader(String name) {
        headers.remove(name);
    }

    @Override

    public boolean isHeaderReference(String key) {
        ChildOverlay<String, StringOverlay> child = headers.getChild(key);
            return child != null ? child.isReference() : false;
    }

    @Override

    public Reference getHeaderReference(String key) {
        ChildOverlay<String, StringOverlay> child = headers.getChild(key);
            return child != null ? child.getReference() : null;
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
        contentType = createChild("contentType", this, StringOverlay.factory);
            headers = createChildMap("headers", this, StringOverlay.factory, null);
            refables.put("headers", headers);
            style = createChild("style", this, StringOverlay.factory);
            explode = createChild("explode", this, BooleanOverlay.factory);
            extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<EncodingProperty, EncodingPropertyImpl> factory = new OverlayFactory<EncodingProperty, EncodingPropertyImpl>() {
    @Override
    protected Class<? super EncodingPropertyImpl> getOverlayClass() {
         return EncodingPropertyImpl.class;
    }

    @Override
    public EncodingPropertyImpl _create(EncodingProperty encodingProperty, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new EncodingPropertyImpl(encodingProperty, parent, refReg);
    }

    @Override
    public EncodingPropertyImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new EncodingPropertyImpl(json, parent, refReg);
    }
};

}
