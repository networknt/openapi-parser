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

import javax.annotation.Generated;
import java.util.Map;


public class EncodingPropertyImpl extends PropertiesOverlay<EncodingProperty> implements EncodingProperty {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public EncodingPropertyImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public EncodingPropertyImpl(EncodingProperty encodingProperty, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(encodingProperty, parent, factory, refMgr);
	}

	// ContentType
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getContentType() {
		return _get("contentType", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setContentType(String contentType) {
		_setScalar("contentType", contentType, String.class);
	}

	// Header
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, String> getHeaders() {
		return _getMap("headers", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, String> getHeaders(boolean elaborate) {
		return _getMap("headers", elaborate, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasHeaders() {
		return _isPresent("headers");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasHeader(String name) {
		return _getMap("headers", String.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getHeader(String name) {
		return _get("headers", name, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setHeaders(Map<String, String> headers) {
		_setMap("headers", headers, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setHeader(String name, String header) {
		_set("headers", name, header, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeHeader(String name) {
		_remove("headers", name, String.class);
	}

	// Style
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getStyle() {
		return _get("style", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setStyle(String style) {
		_setScalar("style", style, String.class);
	}

	// Explode
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getExplode() {
		return _get("explode", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isExplode() {
		Boolean bool = _get("explode", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExplode(Boolean explode) {
		_setScalar("explode", explode, Boolean.class);
	}

	// AllowReserved
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getAllowReserved() {
		return _get("allowReserved", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isAllowReserved() {
		Boolean bool = _get("allowReserved", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setAllowReserved(Boolean allowReserved) {
		_setScalar("allowReserved", allowReserved, Boolean.class);
	}

	// Extension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions() {
		return _getMap("extensions", Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions(boolean elaborate) {
		return _getMap("extensions", elaborate, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtensions() {
		return _isPresent("extensions");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtension(String name) {
		return _getMap("extensions", Object.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getExtension(String name) {
		return _get("extensions", name, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtensions(Map<String, Object> extensions) {
		_setMap("extensions", extensions, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtension(String name, Object extension) {
		_set("extensions", name, extension, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeExtension(String name) {
		_remove("extensions", name, Object.class);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_contentType = "contentType";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_headers = "headers";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_style = "style";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_explode = "explode";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_allowReserved = "allowReserved";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_extensions = "extensions";

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("contentType", "contentType", StringOverlay.factory);
		_createMap("headers", "headers", StringOverlay.factory, null);
		_createScalar("style", "style", StringOverlay.factory);
		_createScalar("explode", "explode", BooleanOverlay.factory);
		_createScalar("allowReserved", "allowReserved", BooleanOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
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

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends EncodingProperty> getSubtypeOf(EncodingProperty encodingProperty) {
		return EncodingProperty.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends EncodingProperty> getSubtypeOf(JsonNode json) {
		return EncodingProperty.class;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> Builder<EncodingProperty> builder(OV modelMember) {
		return new Builder<EncodingProperty>(factory, modelMember);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> EncodingProperty create(OV modelMember) {
		return (EncodingProperty) builder(modelMember).build();
	}
}
