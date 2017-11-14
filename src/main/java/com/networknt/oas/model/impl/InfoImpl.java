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
import com.networknt.oas.jsonoverlay.ReferenceRegistry;
import com.networknt.oas.jsonoverlay.StringOverlay;
import com.networknt.oas.model.Contact;
import com.networknt.oas.model.Info;
import com.networknt.oas.model.License;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.impl.ContactImpl;
import com.networknt.oas.model.impl.LicenseImpl;
import com.networknt.oas.model.impl.OpenApiObjectImpl;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public class InfoImpl extends OpenApiObjectImpl<OpenApi3, Info> implements Info {


    public InfoImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    public InfoImpl(Info info, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(info, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> title = null;


    private ChildOverlay<String, StringOverlay> description = null;


    private ChildOverlay<String, StringOverlay> termsOfService = null;


    private ChildOverlay<Contact, ContactImpl> contact = null;


    private ChildOverlay<License, LicenseImpl> license = null;


    private ChildOverlay<String, StringOverlay> version = null;


    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

    // Title
    @Override

    public String getTitle() {
        return title.get();
    }

    @Override

    public String getTitle(boolean elaborate) {
        return title.get(elaborate);
    }

    @Override

    public void setTitle(String title) {
        this.title.set(title);
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

    // TermsOfService
    @Override

    public String getTermsOfService() {
        return termsOfService.get();
    }

    @Override

    public String getTermsOfService(boolean elaborate) {
        return termsOfService.get(elaborate);
    }

    @Override

    public void setTermsOfService(String termsOfService) {
        this.termsOfService.set(termsOfService);
    }

    // Contact
    @Override

    public Contact getContact() {
        return contact.get();
    }

    @Override

    public Contact getContact(boolean elaborate) {
        return contact.get(elaborate);
    }

    @Override

    public void setContact(Contact contact) {
        this.contact.set(contact);
    }

    // License
    @Override

    public License getLicense() {
        return license.get();
    }

    @Override

    public License getLicense(boolean elaborate) {
        return license.get(elaborate);
    }

    @Override

    public void setLicense(License license) {
        this.license.set(license);
    }

    // Version
    @Override

    public String getVersion() {
        return version.get();
    }

    @Override

    public String getVersion(boolean elaborate) {
        return version.get(elaborate);
    }

    @Override

    public void setVersion(String version) {
        this.version.set(version);
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
        title = createChild("title", this, StringOverlay.factory);
            description = createChild("description", this, StringOverlay.factory);
            termsOfService = createChild("termsOfService", this, StringOverlay.factory);
            contact = createChild("contact", this, ContactImpl.factory);
            license = createChild("license", this, LicenseImpl.factory);
            version = createChild("version", this, StringOverlay.factory);
            extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<Info, InfoImpl> factory = new OverlayFactory<Info, InfoImpl>() {
    @Override
    protected Class<? super InfoImpl> getOverlayClass() {
         return InfoImpl.class;
    }

    @Override
    public InfoImpl _create(Info info, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new InfoImpl(info, parent, refReg);
    }

    @Override
    public InfoImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new InfoImpl(json, parent, refReg);
    }
};

}
