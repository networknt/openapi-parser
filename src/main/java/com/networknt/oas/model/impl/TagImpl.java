package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.jsonoverlay.*;
import com.networknt.oas.model.ExternalDocs;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.Tag;

import java.util.Map;

public class TagImpl extends OpenApiObjectImpl<OpenApi3, Tag> implements Tag {


    public TagImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    public TagImpl(Tag tag, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(tag, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> name = null;


    private ChildOverlay<String, StringOverlay> description = null;


    private ChildOverlay<ExternalDocs, ExternalDocsImpl> externalDocs = null;


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

    // ExternalDocs
    @Override
    public ExternalDocs getExternalDocs() {
        return externalDocs.get();
    }

    @Override
    public ExternalDocs getExternalDocs(boolean elaborate) {
        return externalDocs.get(elaborate);
    }

    @Override
    public void setExternalDocs(ExternalDocs externalDocs) {
        this.externalDocs.set(externalDocs);
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
        description = createChild("description", this, StringOverlay.factory);
        externalDocs = createChild("externalDocs", this, ExternalDocsImpl.factory);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<Tag, TagImpl> factory = new OverlayFactory<Tag, TagImpl>() {
        @Override
        protected Class<? super TagImpl> getOverlayClass() {
            return TagImpl.class;
        }

        @Override
        public TagImpl _create(Tag tag, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new TagImpl(tag, parent, refReg);
        }

        @Override
        public TagImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new TagImpl(json, parent, refReg);
        }
    };

}
