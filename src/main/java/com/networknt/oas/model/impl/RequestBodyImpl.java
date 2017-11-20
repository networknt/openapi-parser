package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.jsonoverlay.*;
import com.networknt.oas.model.MediaType;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.RequestBody;

import java.util.Map;

public class RequestBodyImpl extends OpenApiObjectImpl<OpenApi3, RequestBody> implements RequestBody {


    public RequestBodyImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    public RequestBodyImpl(RequestBody requestBody, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(requestBody, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> description = null;


    private ChildMapOverlay<MediaType, MediaTypeImpl> contentMediaTypes = null;


    private ChildOverlay<Boolean, BooleanOverlay> required = null;


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
        contentMediaTypes = createChildMap("content", this, MediaTypeImpl.factory, null);
        required = createChild("required", this, BooleanOverlay.factory);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<RequestBody, RequestBodyImpl> factory = new OverlayFactory<RequestBody, RequestBodyImpl>() {
        @Override
        protected Class<? super RequestBodyImpl> getOverlayClass() {
            return RequestBodyImpl.class;
        }

        @Override
        public RequestBodyImpl _create(RequestBody requestBody, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new RequestBodyImpl(requestBody, parent, refReg);
        }

        @Override
        public RequestBodyImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new RequestBodyImpl(json, parent, refReg);
        }
    };

}
