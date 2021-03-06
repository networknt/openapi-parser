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


public class HeaderImpl extends PropertiesOverlay<Header> implements Header {

	private Overlay<Header> overlay = Overlay.of(this);

	@Override
	public String getKey() {
		return overlay.getParent() instanceof MapOverlay<?> ? overlay.getPathInParent() : null;
	}

	public HeaderImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public HeaderImpl(Header header, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(header, parent, factory, refMgr);
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

	// Deprecated
	@Override
	public Boolean getDeprecated() {
		return _get("deprecated", Boolean.class);
	}

	@Override
	public boolean isDeprecated() {
		Boolean bool = _get("deprecated", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	public void setDeprecated(Boolean deprecated) {
		_setScalar("deprecated", deprecated, Boolean.class);
	}

	// AllowEmptyValue
	@Override
	public Boolean getAllowEmptyValue() {
		return _get("allowEmptyValue", Boolean.class);
	}

	@Override
	public boolean isAllowEmptyValue() {
		Boolean bool = _get("allowEmptyValue", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	public void setAllowEmptyValue(Boolean allowEmptyValue) {
		_setScalar("allowEmptyValue", allowEmptyValue, Boolean.class);
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

	// Schema
	@Override
	public Schema getSchema() {
		return _get("schema", Schema.class);
	}

	@Override
	public Schema getSchema(boolean elaborate) {
		return _get("schema", elaborate, Schema.class);
	}

	@Override
	public void setSchema(Schema schema) {
		_setScalar("schema", schema, Schema.class);
	}

	// Example
	@Override
	public Object getExample() {
		return _get("example", Object.class);
	}

	@Override
	public void setExample(Object example) {
		_setScalar("example", example, Object.class);
	}

	// Example
	@Override
	public Map<String, Example> getExamples() {
		return _getMap("examples", Example.class);
	}

	@Override
	public Map<String, Example> getExamples(boolean elaborate) {
		return _getMap("examples", elaborate, Example.class);
	}

	@Override
	public boolean hasExamples() {
		return _isPresent("examples");
	}

	@Override
	public boolean hasExample(String name) {
		return _getMap("examples", Example.class).containsKey(name);
	}

	@Override
	public Example getExample(String name) {
		return _get("examples", name, Example.class);
	}

	@Override
	public void setExamples(Map<String, Example> examples) {
		_setMap("examples", examples, Example.class);
	}

	@Override
	public void setExample(String name, Example example) {
		_set("examples", name, example, Example.class);
	}

	@Override
	public void removeExample(String name) {
		_remove("examples", name, Example.class);
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

	public static final String F_required = "required";

	public static final String F_deprecated = "deprecated";

	public static final String F_allowEmptyValue = "allowEmptyValue";

	public static final String F_style = "style";

	public static final String F_explode = "explode";

	public static final String F_allowReserved = "allowReserved";

	public static final String F_schema = "schema";

	public static final String F_example = "example";

	public static final String F_examples = "examples";

	public static final String F_contentMediaTypes = "contentMediaTypes";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("description", "description", StringOverlay.factory);
		_createScalar("required", "required", BooleanOverlay.factory);
		_createScalar("deprecated", "deprecated", BooleanOverlay.factory);
		_createScalar("allowEmptyValue", "allowEmptyValue", BooleanOverlay.factory);
		_createScalar("style", "style", StringOverlay.factory);
		_createScalar("explode", "explode", BooleanOverlay.factory);
		_createScalar("allowReserved", "allowReserved", BooleanOverlay.factory);
		_createScalar("schema", "schema", SchemaImpl.factory);
		_createScalar("example", "example", ObjectOverlay.factory);
		_createMap("examples", "examples", ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createMap("contentMediaTypes", "content", MediaTypeImpl.factory, null);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<Header> factory = new OverlayFactory<Header>() {

		@Override
		protected Class<? extends JsonOverlay<? super Header>> getOverlayClass() {
			return HeaderImpl.class;
		}

		@Override
		public JsonOverlay<Header> _create(Header header, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new HeaderImpl(header, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Header> castOverlay = (JsonOverlay<Header>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Header> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new HeaderImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Header> castOverlay = (JsonOverlay<Header>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends Header> getSubtypeOf(Header header) {
		return Header.class;
	}

	private static Class<? extends Header> getSubtypeOf(JsonNode json) {
		return Header.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<Header> builder(OV modelMember) {
		return new Builder<Header>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> Header create(OV modelMember) {
		return (Header) builder(modelMember).build();
	}
}
