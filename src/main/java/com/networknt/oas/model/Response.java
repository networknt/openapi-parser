package com.networknt.oas.model;

import com.networknt.oas.jsonoverlay.Reference;

import java.util.Map;

public interface Response extends OpenApiObject<OpenApi3, Response> {

    // Description

    String getDescription();


    String getDescription(boolean elaborate);


    void setDescription(String description);

    // Header

    Map<String, Header> getHeaders();


    Map<String, Header> getHeaders(boolean elaborate);


    boolean hasHeader(String name);


    Header getHeader(String name);


    void setHeaders(Map<String, Header> headers);


    void setHeader(String name, Header header);


    void removeHeader(String name);


    boolean isHeaderReference(String key);


    Reference getHeaderReference(String key);

    // ContentMediaType

    Map<String, MediaType> getContentMediaTypes();


    Map<String, MediaType> getContentMediaTypes(boolean elaborate);


    boolean hasContentMediaType(String name);


    MediaType getContentMediaType(String name);


    void setContentMediaTypes(Map<String, MediaType> contentMediaTypes);


    void setContentMediaType(String name, MediaType contentMediaType);


    void removeContentMediaType(String name);

    // Link

    Map<String, Link> getLinks();


    Map<String, Link> getLinks(boolean elaborate);


    boolean hasLink(String name);


    Link getLink(String name);


    void setLinks(Map<String, Link> links);


    void setLink(String name, Link link);


    void removeLink(String name);


    boolean isLinkReference(String key);


    Reference getLinkReference(String key);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
