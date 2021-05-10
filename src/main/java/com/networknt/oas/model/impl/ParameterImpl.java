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


public class ParameterImpl extends PropertiesOverlay<Parameter> implements Parameter {

	private Overlay<Parameter> overlay = Overlay.of(this);

	@Override
	public String getKey() {
		return overlay.getParent() instanceof MapOverlay<?> ? overlay.getPathInParent() : null;
	}

	public ParameterImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public ParameterImpl(Parameter parameter, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(parameter, parent, factory, refMgr);
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

	// Example
	@Override
	public Object getExample() {
		return _get("example", Object.class);
	}

	@Override
	public void setExample(Object example) {
		_setScalar("example", example, Object.class);
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

	// Style
	@Override
	public String getStyle() {
		return _get("style", String.class);
	}

	@Override
	public void setStyle(String style) {
		_setScalar("style", style, String.class);
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

	// Description
	@Override
	public String getDescription() {
		return _get("description", String.class);
	}

	@Override
	public void setDescription(String description) {
		_setScalar("description", description, String.class);
	}

	// Name
	@Override
	public String getName() {
		return _get("name", String.class);
	}

	@Override
	public void setName(String name) {
		_setScalar("name", name, String.class);
	}

	// In
	@Override
	public String getIn() {
		return _get("in", String.class);
	}

	@Override
	public void setIn(String in) {
		_setScalar("in", in, String.class);
	}

	public static final String F_extensions = "extensions";

	public static final String F_contentMediaTypes = "contentMediaTypes";

	public static final String F_examples = "examples";

	public static final String F_example = "example";

	public static final String F_schema = "schema";

	public static final String F_allowReserved = "allowReserved";

	public static final String F_explode = "explode";

	public static final String F_style = "style";

	public static final String F_allowEmptyValue = "allowEmptyValue";

	public static final String F_deprecated = "deprecated";

	public static final String F_required = "required";

	public static final String F_description = "description";

	public static final String F_name = "name";

	public static final String F_in = "in";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
		_createMap("contentMediaTypes", "content", MediaTypeImpl.factory, null);
		_createMap("examples", "examples", ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createScalar("example", "example", ObjectOverlay.factory);
		_createScalar("schema", "schema", SchemaImpl.factory);
		_createScalar("allowReserved", "allowReserved", BooleanOverlay.factory);
		_createScalar("explode", "explode", BooleanOverlay.factory);
		_createScalar("style", "style", StringOverlay.factory);
		_createScalar("allowEmptyValue", "allowEmptyValue", BooleanOverlay.factory);
		_createScalar("deprecated", "deprecated", BooleanOverlay.factory);
		_createScalar("required", "required", BooleanOverlay.factory);
		_createScalar("description", "description", StringOverlay.factory);
		_createScalar("name", "name", StringOverlay.factory);
		_createScalar("in", "in", StringOverlay.factory);
	}

	public static OverlayFactory<Parameter> factory = new OverlayFactory<Parameter>() {

		@Override
		protected Class<? extends JsonOverlay<? super Parameter>> getOverlayClass() {
			return ParameterImpl.class;
		}

		@Override
		public JsonOverlay<Parameter> _create(Parameter parameter, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ParameterImpl(parameter, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Parameter> castOverlay = (JsonOverlay<Parameter>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Parameter> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ParameterImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Parameter> castOverlay = (JsonOverlay<Parameter>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends Parameter> getSubtypeOf(Parameter parameter) {
		return Parameter.class;
	}

	private static Class<? extends Parameter> getSubtypeOf(JsonNode json) {
		return Parameter.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<Parameter> builder(OV modelMember) {
		return new Builder<Parameter>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> Parameter create(OV modelMember) {
		return (Parameter) builder(modelMember).build();
	}
}
