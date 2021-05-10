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
import com.networknt.oas.model.EncodingProperty;
import com.networknt.oas.model.OpenApi3;
import java.util.Map;


public class EncodingPropertyImpl extends PropertiesOverlay<EncodingProperty> implements EncodingProperty {

	public EncodingPropertyImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public EncodingPropertyImpl(EncodingProperty encodingProperty, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(encodingProperty, parent, factory, refMgr);
	}

	// ContentType
	@Override
	public String getContentType() {
		return _get("contentType", String.class);
	}

	@Override
	public void setContentType(String contentType) {
		_setScalar("contentType", contentType, String.class);
	}

	// Header
	@Override
	public Map<String, String> getHeaders() {
		return _getMap("headers", String.class);
	}

	@Override
	public Map<String, String> getHeaders(boolean elaborate) {
		return _getMap("headers", elaborate, String.class);
	}

	@Override
	public boolean hasHeaders() {
		return _isPresent("headers");
	}

	@Override
	public boolean hasHeader(String name) {
		return _getMap("headers", String.class).containsKey(name);
	}

	@Override
	public String getHeader(String name) {
		return _get("headers", name, String.class);
	}

	@Override
	public void setHeaders(Map<String, String> headers) {
		_setMap("headers", headers, String.class);
	}

	@Override
	public void setHeader(String name, String header) {
		_set("headers", name, header, String.class);
	}

	@Override
	public void removeHeader(String name) {
		_remove("headers", name, String.class);
	}

	// Style
	@Override
	public String getStyle() {
		return _get("style", String.class);
	}

	@Override
	public void setStyle(String style) {
		_setScalar("style", style, String.class);
	}

	// Explode
	@Override
	public Boolean getExplode() {
		return _get("explode", Boolean.class);
	}

	@Override
	public boolean isExplode() {
		Boolean bool = _get("explode", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	public void setExplode(Boolean explode) {
		_setScalar("explode", explode, Boolean.class);
	}

	// AllowReserved
	@Override
	public Boolean getAllowReserved() {
		return _get("allowReserved", Boolean.class);
	}

	@Override
	public boolean isAllowReserved() {
		Boolean bool = _get("allowReserved", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	public void setAllowReserved(Boolean allowReserved) {
		_setScalar("allowReserved", allowReserved, Boolean.class);
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

	public static final String F_contentType = "contentType";

	public static final String F_headers = "headers";

	public static final String F_style = "style";

	public static final String F_explode = "explode";

	public static final String F_allowReserved = "allowReserved";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("contentType", "contentType", StringOverlay.factory);
		_createMap("headers", "headers", StringOverlay.factory, null);
		_createScalar("style", "style", StringOverlay.factory);
		_createScalar("explode", "explode", BooleanOverlay.factory);
		_createScalar("allowReserved", "allowReserved", BooleanOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<EncodingProperty> factory = new OverlayFactory<EncodingProperty>() {

		@Override
		protected Class<? extends JsonOverlay<? super EncodingProperty>> getOverlayClass() {
			return EncodingPropertyImpl.class;
		}

		@Override
		public JsonOverlay<EncodingProperty> _create(EncodingProperty encodingProperty, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new EncodingPropertyImpl(encodingProperty, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<EncodingProperty> castOverlay = (JsonOverlay<EncodingProperty>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<EncodingProperty> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new EncodingPropertyImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<EncodingProperty> castOverlay = (JsonOverlay<EncodingProperty>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends EncodingProperty> getSubtypeOf(EncodingProperty encodingProperty) {
		return EncodingProperty.class;
	}

	private static Class<? extends EncodingProperty> getSubtypeOf(JsonNode json) {
		return EncodingProperty.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<EncodingProperty> builder(OV modelMember) {
		return new Builder<EncodingProperty>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> EncodingProperty create(OV modelMember) {
		return (EncodingProperty) builder(modelMember).build();
	}
}
