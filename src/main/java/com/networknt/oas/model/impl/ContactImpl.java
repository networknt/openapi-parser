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
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.impl.OpenApiObjectImpl;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public class ContactImpl extends OpenApiObjectImpl<OpenApi3, Contact> implements Contact {


    public ContactImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    public ContactImpl(Contact contact, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(contact, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> name = null;


    private ChildOverlay<String, StringOverlay> url = null;


    private ChildOverlay<String, StringOverlay> email = null;


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

    // Email
    @Override

    public String getEmail() {
        return email.get();
    }

    @Override

    public String getEmail(boolean elaborate) {
        return email.get(elaborate);
    }

    @Override

    public void setEmail(String email) {
        this.email.set(email);
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
            email = createChild("email", this, StringOverlay.factory);
            extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<Contact, ContactImpl> factory = new OverlayFactory<Contact, ContactImpl>() {
    @Override
    protected Class<? super ContactImpl> getOverlayClass() {
         return ContactImpl.class;
    }

    @Override
    public ContactImpl _create(Contact contact, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new ContactImpl(contact, parent, refReg);
    }

    @Override
    public ContactImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new ContactImpl(json, parent, refReg);
    }
};

}
