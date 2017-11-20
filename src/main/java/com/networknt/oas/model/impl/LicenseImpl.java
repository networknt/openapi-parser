package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.jsonoverlay.*;
import com.networknt.oas.model.License;
import com.networknt.oas.model.OpenApi3;

import java.util.Map;

public class LicenseImpl extends OpenApiObjectImpl<OpenApi3, License> implements License {

    JsonNode initJson = jsonMissing();


    public LicenseImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    public LicenseImpl(License license, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(license, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> name = null;


    private ChildOverlay<String, StringOverlay> url = null;


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
        name = createChild("name", this, StringOverlay.factory);
        url = createChild("url", this, StringOverlay.factory);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<License, LicenseImpl> factory = new OverlayFactory<License, LicenseImpl>() {
        @Override
        protected Class<? super LicenseImpl> getOverlayClass() {
            return LicenseImpl.class;
        }

        @Override
        public LicenseImpl _create(License license, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new LicenseImpl(license, parent, refReg);
        }

        @Override
        public LicenseImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new LicenseImpl(json, parent, refReg);
        }
    };

}
