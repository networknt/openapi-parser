package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.jsonoverlay.*;
import com.networknt.oas.model.ExternalDocs;
import com.networknt.oas.model.OpenApi3;

import java.util.Map;

public class ExternalDocsImpl extends OpenApiObjectImpl<OpenApi3, ExternalDocs> implements ExternalDocs {


    public ExternalDocsImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    public ExternalDocsImpl(ExternalDocs externalDocs, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(externalDocs, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> description = null;


    private ChildOverlay<String, StringOverlay> url = null;


    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

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

    // Url
    @Override
    public String getUrl() {
        return url.get();
    }

    @Override
    public String getUrl(boolean elaborate) {
        return url.get(elaborate);
    }

    @Override
    public void setUrl(String url) {
        this.url.set(url);
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
        description = createChild("description", this, StringOverlay.factory);
        url = createChild("url", this, StringOverlay.factory);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<ExternalDocs, ExternalDocsImpl> factory = new OverlayFactory<ExternalDocs, ExternalDocsImpl>() {
        @Override
        protected Class<? super ExternalDocsImpl> getOverlayClass() {
            return ExternalDocsImpl.class;
        }

        @Override
        public ExternalDocsImpl _create(ExternalDocs externalDocs, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new ExternalDocsImpl(externalDocs, parent, refReg);
        }

        @Override
        public ExternalDocsImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new ExternalDocsImpl(json, parent, refReg);
        }
    };

}
