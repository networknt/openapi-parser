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


public class MediaTypeImpl extends PropertiesOverlay<MediaType> implements MediaType {

	public MediaTypeImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public MediaTypeImpl(MediaType mediaType, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(mediaType, parent, factory, refMgr);
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

	// EncodingProperty
	@Override
	public Map<String, EncodingProperty> getEncodingProperties() {
		return _getMap("encodingProperties", EncodingProperty.class);
	}

	@Override
	public Map<String, EncodingProperty> getEncodingProperties(boolean elaborate) {
		return _getMap("encodingProperties", elaborate, EncodingProperty.class);
	}

	@Override
	public boolean hasEncodingProperties() {
		return _isPresent("encodingProperties");
	}

	@Override
	public boolean hasEncodingProperty(String name) {
		return _getMap("encodingProperties", EncodingProperty.class).containsKey(name);
	}

	@Override
	public EncodingProperty getEncodingProperty(String name) {
		return _get("encodingProperties", name, EncodingProperty.class);
	}

	@Override
	public void setEncodingProperties(Map<String, EncodingProperty> encodingProperties) {
		_setMap("encodingProperties", encodingProperties, EncodingProperty.class);
	}

	@Override
	public void setEncodingProperty(String name, EncodingProperty encodingProperty) {
		_set("encodingProperties", name, encodingProperty, EncodingProperty.class);
	}

	@Override
	public void removeEncodingProperty(String name) {
		_remove("encodingProperties", name, EncodingProperty.class);
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

	public static final String F_schema = "schema";

	public static final String F_examples = "examples";

	public static final String F_example = "example";

	public static final String F_encodingProperties = "encodingProperties";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("schema", "schema", SchemaImpl.factory);
		_createMap("examples", "examples", ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createScalar("example", "example", ObjectOverlay.factory);
		_createMap("encodingProperties", "encoding", EncodingPropertyImpl.factory, null);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<MediaType> factory = new OverlayFactory<MediaType>() {

		@Override
		protected Class<? extends JsonOverlay<? super MediaType>> getOverlayClass() {
			return MediaTypeImpl.class;
		}

		@Override
		public JsonOverlay<MediaType> _create(MediaType mediaType, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new MediaTypeImpl(mediaType, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<MediaType> castOverlay = (JsonOverlay<MediaType>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<MediaType> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new MediaTypeImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<MediaType> castOverlay = (JsonOverlay<MediaType>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends MediaType> getSubtypeOf(MediaType mediaType) {
		return MediaType.class;
	}

	private static Class<? extends MediaType> getSubtypeOf(JsonNode json) {
		return MediaType.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<MediaType> builder(OV modelMember) {
		return new Builder<MediaType>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> MediaType create(OV modelMember) {
		return (MediaType) builder(modelMember).build();
	}
}
