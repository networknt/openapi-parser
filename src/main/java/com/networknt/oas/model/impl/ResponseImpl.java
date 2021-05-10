/*******************************************************************************
 *  Copyright (c) 2017 ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.jsonoverlay.*;
import com.networknt.oas.model.*;
import java.util.Map;


public class ResponseImpl extends PropertiesOverlay<Response> implements Response {

	private Overlay<Response> overlay = Overlay.of(this);

	@Override
	public String getName() {
		return overlay.getParent() instanceof MapOverlay<?> ? overlay.getPathInParent() : null;
	}

	public ResponseImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public ResponseImpl(Response response, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(response, parent, factory, refMgr);
	}

	// Description
	@Override
	public String getDescription() {
		return _get("description", String.class);
	}

	@Override
	public void setDescription(String description) {
		_setScalar("description", description, String.class);
	}

	// Header
	@Override
	public Map<String, Header> getHeaders() {
		return _getMap("headers", Header.class);
	}

	@Override
	public Map<String, Header> getHeaders(boolean elaborate) {
		return _getMap("headers", elaborate, Header.class);
	}

	@Override
	public boolean hasHeaders() {
		return _isPresent("headers");
	}

	@Override
	public boolean hasHeader(String name) {
		return _getMap("headers", Header.class).containsKey(name);
	}

	@Override
	public Header getHeader(String name) {
		return _get("headers", name, Header.class);
	}

	@Override
	public void setHeaders(Map<String, Header> headers) {
		_setMap("headers", headers, Header.class);
	}

	@Override
	public void setHeader(String name, Header header) {
		_set("headers", name, header, Header.class);
	}

	@Override
	public void removeHeader(String name) {
		_remove("headers", name, Header.class);
	}

	// ContentMediaType
	@Override
	public Map<String, MediaType> getContentMediaTypes() {
		return _getMap("contentMediaTypes", MediaType.class);
	}

	@Override
	public Map<String, MediaType> getContentMediaTypes(boolean elaborate) {
		return _getMap("contentMediaTypes", elaborate, MediaType.class);
	}

	@Override
	public boolean hasContentMediaTypes() {
		return _isPresent("contentMediaTypes");
	}

	@Override
	public boolean hasContentMediaType(String name) {
		return _getMap("contentMediaTypes", MediaType.class).containsKey(name);
	}

	@Override
	public MediaType getContentMediaType(String name) {
		return _get("contentMediaTypes", name, MediaType.class);
	}

	@Override
	public void setContentMediaTypes(Map<String, MediaType> contentMediaTypes) {
		_setMap("contentMediaTypes", contentMediaTypes, MediaType.class);
	}

	@Override
	public void setContentMediaType(String name, MediaType contentMediaType) {
		_set("contentMediaTypes", name, contentMediaType, MediaType.class);
	}

	@Override
	public void removeContentMediaType(String name) {
		_remove("contentMediaTypes", name, MediaType.class);
	}

	// Link
	@Override
	public Map<String, Link> getLinks() {
		return _getMap("links", Link.class);
	}

	@Override
	public Map<String, Link> getLinks(boolean elaborate) {
		return _getMap("links", elaborate, Link.class);
	}

	@Override
	public boolean hasLinks() {
		return _isPresent("links");
	}

	@Override
	public boolean hasLink(String name) {
		return _getMap("links", Link.class).containsKey(name);
	}

	@Override
	public Link getLink(String name) {
		return _get("links", name, Link.class);
	}

	@Override
	public void setLinks(Map<String, Link> links) {
		_setMap("links", links, Link.class);
	}

	@Override
	public void setLink(String name, Link link) {
		_set("links", name, link, Link.class);
	}

	@Override
	public void removeLink(String name) {
		_remove("links", name, Link.class);
	}

	// Extension
	@Override
	public Map<String, Object> getExtensions() {
		return _getMap("extensions", Object.class);
	}

	@Override
	public Map<String, Object> getExtensions(boolean elaborate) {
		return _getMap("extensions", elaborate, Object.class);
	}

	@Override
	public boolean hasExtensions() {
		return _isPresent("extensions");
	}

	@Override
	public boolean hasExtension(String name) {
		return _getMap("extensions", Object.class).containsKey(name);
	}

	@Override
	public Object getExtension(String name) {
		return _get("extensions", name, Object.class);
	}

	@Override
	public void setExtensions(Map<String, Object> extensions) {
		_setMap("extensions", extensions, Object.class);
	}

	@Override
	public void setExtension(String name, Object extension) {
		_set("extensions", name, extension, Object.class);
	}

	@Override
	public void removeExtension(String name) {
		_remove("extensions", name, Object.class);
	}

	public static final String F_description = "description";

	public static final String F_headers = "headers";

	public static final String F_contentMediaTypes = "contentMediaTypes";

	public static final String F_links = "links";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("description", "description", StringOverlay.factory);
		_createMap("headers", "headers", HeaderImpl.factory, null);
		_createMap("contentMediaTypes", "content", MediaTypeImpl.factory, null);
		_createMap("links", "links", LinkImpl.factory, null);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<Response> factory = new OverlayFactory<Response>() {

		@Override
		protected Class<? extends JsonOverlay<? super Response>> getOverlayClass() {
			return ResponseImpl.class;
		}

		@Override
		public JsonOverlay<Response> _create(Response response, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ResponseImpl(response, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Response> castOverlay = (JsonOverlay<Response>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Response> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ResponseImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Response> castOverlay = (JsonOverlay<Response>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends Response> getSubtypeOf(Response response) {
		return Response.class;
	}

	private static Class<? extends Response> getSubtypeOf(JsonNode json) {
		return Response.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<Response> builder(OV modelMember) {
		return new Builder<Response>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> Response create(OV modelMember) {
		return (Response) builder(modelMember).build();
	}
}
