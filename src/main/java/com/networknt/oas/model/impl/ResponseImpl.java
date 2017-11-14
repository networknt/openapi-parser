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
import com.networknt.oas.jsonoverlay.Reference;
import com.networknt.oas.jsonoverlay.ReferenceRegistry;
import com.networknt.oas.jsonoverlay.StringOverlay;
import com.networknt.oas.model.Header;
import com.networknt.oas.model.Link;
import com.networknt.oas.model.MediaType;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.Response;
import com.networknt.oas.model.impl.HeaderImpl;
import com.networknt.oas.model.impl.LinkImpl;
import com.networknt.oas.model.impl.MediaTypeImpl;
import com.networknt.oas.model.impl.OpenApiObjectImpl;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public class ResponseImpl extends OpenApiObjectImpl<OpenApi3, Response> implements Response {


    public ResponseImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    public ResponseImpl(Response response, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(response, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> description = null;


    private ChildMapOverlay<Header, HeaderImpl> headers = null;


    private ChildMapOverlay<MediaType, MediaTypeImpl> contentMediaTypes = null;


    private ChildMapOverlay<Link, LinkImpl> links = null;


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

    // Header
    @Override

    public Map<String, Header> getHeaders() {
        return headers.get();
    }

    @Override

    public Map<String, Header> getHeaders(boolean elaborate) {
        return headers.get(elaborate);
    }

    @Override

    public boolean hasHeader(String name) {
        return headers.containsKey(name);
    }

    @Override

    public Header getHeader(String name) {
        return headers.get(name);
    }

    @Override

    public void setHeaders(Map<String, Header> headers) {
        this.headers.set(headers);
    }

    @Override

    public void setHeader(String name, Header header) {
        headers.set(name, header);
    }

    @Override

    public void removeHeader(String name) {
        headers.remove(name);
    }

    @Override

    public boolean isHeaderReference(String key) {
        ChildOverlay<Header, HeaderImpl> child = headers.getChild(key);
            return child != null ? child.isReference() : false;
    }

    @Override

    public Reference getHeaderReference(String key) {
        ChildOverlay<Header, HeaderImpl> child = headers.getChild(key);
            return child != null ? child.getReference() : null;
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

    // Link
    @Override

    public Map<String, Link> getLinks() {
        return links.get();
    }

    @Override

    public Map<String, Link> getLinks(boolean elaborate) {
        return links.get(elaborate);
    }

    @Override

    public boolean hasLink(String name) {
        return links.containsKey(name);
    }

    @Override

    public Link getLink(String name) {
        return links.get(name);
    }

    @Override

    public void setLinks(Map<String, Link> links) {
        this.links.set(links);
    }

    @Override

    public void setLink(String name, Link link) {
        links.set(name, link);
    }

    @Override

    public void removeLink(String name) {
        links.remove(name);
    }

    @Override

    public boolean isLinkReference(String key) {
        ChildOverlay<Link, LinkImpl> child = links.getChild(key);
            return child != null ? child.isReference() : false;
    }

    @Override

    public Reference getLinkReference(String key) {
        ChildOverlay<Link, LinkImpl> child = links.getChild(key);
            return child != null ? child.getReference() : null;
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
            headers = createChildMap("headers", this, HeaderImpl.factory, null);
            refables.put("headers", headers);
            contentMediaTypes = createChildMap("content", this, MediaTypeImpl.factory, null);
            links = createChildMap("links", this, LinkImpl.factory, null);
            refables.put("links", links);
            extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<Response, ResponseImpl> factory = new OverlayFactory<Response, ResponseImpl>() {
    @Override
    protected Class<? super ResponseImpl> getOverlayClass() {
         return ResponseImpl.class;
    }

    @Override
    public ResponseImpl _create(Response response, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new ResponseImpl(response, parent, refReg);
    }

    @Override
    public ResponseImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new ResponseImpl(json, parent, refReg);
    }
};

}
