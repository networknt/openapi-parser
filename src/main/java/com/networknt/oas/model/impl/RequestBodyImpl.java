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
import com.networknt.oas.model.MediaType;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.RequestBody;
import java.util.Map;


public class RequestBodyImpl extends PropertiesOverlay<RequestBody> implements RequestBody {

	private Overlay<RequestBody> overlay = Overlay.of(this);

	@Override
	public String getName() {
		return overlay.getParent() instanceof MapOverlay<?> ? overlay.getPathInParent() : null;
	}

	public RequestBodyImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public RequestBodyImpl(RequestBody requestBody, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(requestBody, parent, factory, refMgr);
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

	// Required
	@Override
	public Boolean getRequired() {
		return _get("required", Boolean.class);
	}

	@Override
	public boolean isRequired() {
		Boolean bool = _get("required", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	public void setRequired(Boolean required) {
		_setScalar("required", required, Boolean.class);
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

	public static final String F_contentMediaTypes = "contentMediaTypes";

	public static final String F_required = "required";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("description", "description", StringOverlay.factory);
		_createMap("contentMediaTypes", "content", MediaTypeImpl.factory, null);
		_createScalar("required", "required", BooleanOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<RequestBody> factory = new OverlayFactory<RequestBody>() {

		@Override
		protected Class<? extends JsonOverlay<? super RequestBody>> getOverlayClass() {
			return RequestBodyImpl.class;
		}

		@Override
		public JsonOverlay<RequestBody> _create(RequestBody requestBody, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new RequestBodyImpl(requestBody, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<RequestBody> castOverlay = (JsonOverlay<RequestBody>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<RequestBody> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new RequestBodyImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<RequestBody> castOverlay = (JsonOverlay<RequestBody>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends RequestBody> getSubtypeOf(RequestBody requestBody) {
		return RequestBody.class;
	}

	private static Class<? extends RequestBody> getSubtypeOf(JsonNode json) {
		return RequestBody.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<RequestBody> builder(OV modelMember) {
		return new Builder<RequestBody>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> RequestBody create(OV modelMember) {
		return (RequestBody) builder(modelMember).build();
	}
}
