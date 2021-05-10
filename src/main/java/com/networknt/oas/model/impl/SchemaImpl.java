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

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.jsonoverlay.*;
import com.networknt.oas.model.*;
import java.util.List;
import java.util.Map;


public class SchemaImpl extends PropertiesOverlay<Schema> implements Schema {

	private Overlay<Schema> overlay = Overlay.of(this);

	@Override
	public String getName() {
		return overlay.getParent() instanceof MapOverlay<?> ? overlay.getPathInParent() : null;
	}

	@Override
	public JsonOverlay<?> _findInternal(JsonPointer path) {
		if (path.matchesProperty("additionalProperties")) {
			return path.tail().matches() ? _getOverlay("additionalProperties", BooleanOverlay.class)
					: _get("additionalPropertiesSchema", SchemaImpl.class)._findInternal(path.tail());
		} else {
			return super._findInternal(path);
		}
	}

	public SchemaImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public SchemaImpl(Schema schema, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(schema, parent, factory, refMgr);
	}

	// Title
	@Override
	public String getTitle() {
		return _get("title", String.class);
	}

	@Override
	public void setTitle(String title) {
		_setScalar("title", title, String.class);
	}

	// MultipleOf
	@Override
	public Number getMultipleOf() {
		return _get("multipleOf", Number.class);
	}

	@Override
	public void setMultipleOf(Number multipleOf) {
		_setScalar("multipleOf", multipleOf, Number.class);
	}

	// Maximum
	@Override
	public Number getMaximum() {
		return _get("maximum", Number.class);
	}

	@Override
	public void setMaximum(Number maximum) {
		_setScalar("maximum", maximum, Number.class);
	}

	// ExclusiveMaximum
	@Override
	public Boolean getExclusiveMaximum() {
		return _get("exclusiveMaximum", Boolean.class);
	}

	@Override
	public boolean isExclusiveMaximum() {
		Boolean bool = _get("exclusiveMaximum", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	public void setExclusiveMaximum(Boolean exclusiveMaximum) {
		_setScalar("exclusiveMaximum", exclusiveMaximum, Boolean.class);
	}

	// Minimum
	@Override
	public Number getMinimum() {
		return _get("minimum", Number.class);
	}

	@Override
	public void setMinimum(Number minimum) {
		_setScalar("minimum", minimum, Number.class);
	}

	// ExclusiveMinimum
	@Override
	public Boolean getExclusiveMinimum() {
		return _get("exclusiveMinimum", Boolean.class);
	}

	@Override
	public boolean isExclusiveMinimum() {
		Boolean bool = _get("exclusiveMinimum", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	public void setExclusiveMinimum(Boolean exclusiveMinimum) {
		_setScalar("exclusiveMinimum", exclusiveMinimum, Boolean.class);
	}

	// MaxLength
	@Override
	public Integer getMaxLength() {
		return _get("maxLength", Integer.class);
	}

	@Override
	public void setMaxLength(Integer maxLength) {
		_setScalar("maxLength", maxLength, Integer.class);
	}

	// MinLength
	@Override
	public Integer getMinLength() {
		return _get("minLength", Integer.class);
	}

	@Override
	public void setMinLength(Integer minLength) {
		_setScalar("minLength", minLength, Integer.class);
	}

	// Pattern
	@Override
	public String getPattern() {
		return _get("pattern", String.class);
	}

	@Override
	public void setPattern(String pattern) {
		_setScalar("pattern", pattern, String.class);
	}

	// MaxItems
	@Override
	public Integer getMaxItems() {
		return _get("maxItems", Integer.class);
	}

	@Override
	public void setMaxItems(Integer maxItems) {
		_setScalar("maxItems", maxItems, Integer.class);
	}

	// MinItems
	@Override
	public Integer getMinItems() {
		return _get("minItems", Integer.class);
	}

	@Override
	public void setMinItems(Integer minItems) {
		_setScalar("minItems", minItems, Integer.class);
	}

	// UniqueItems
	@Override
	public Boolean getUniqueItems() {
		return _get("uniqueItems", Boolean.class);
	}

	@Override
	public boolean isUniqueItems() {
		Boolean bool = _get("uniqueItems", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	public void setUniqueItems(Boolean uniqueItems) {
		_setScalar("uniqueItems", uniqueItems, Boolean.class);
	}

	// MaxProperties
	@Override
	public Integer getMaxProperties() {
		return _get("maxProperties", Integer.class);
	}

	@Override
	public void setMaxProperties(Integer maxProperties) {
		_setScalar("maxProperties", maxProperties, Integer.class);
	}

	// MinProperties
	@Override
	public Integer getMinProperties() {
		return _get("minProperties", Integer.class);
	}

	@Override
	public void setMinProperties(Integer minProperties) {
		_setScalar("minProperties", minProperties, Integer.class);
	}

	// RequiredField
	@Override
	public List<String> getRequiredFields() {
		return _getList("requiredFields", String.class);
	}

	@Override
	public List<String> getRequiredFields(boolean elaborate) {
		return _getList("requiredFields", elaborate, String.class);
	}

	@Override
	public boolean hasRequiredFields() {
		return _isPresent("requiredFields");
	}

	@Override
	public String getRequiredField(int index) {
		return _get("requiredFields", index, String.class);
	}

	@Override
	public void setRequiredFields(List<String> requiredFields) {
		_setList("requiredFields", requiredFields, String.class);
	}

	@Override
	public void setRequiredField(int index, String requiredField) {
		_set("requiredFields", index, requiredField, String.class);
	}

	@Override
	public void addRequiredField(String requiredField) {
		_add("requiredFields", requiredField, String.class);
	}

	@Override
	public void insertRequiredField(int index, String requiredField) {
		_insert("requiredFields", index, requiredField, String.class);
	}

	@Override
	public void removeRequiredField(int index) {
		_remove("requiredFields", index, String.class);
	}

	// Enum
	@Override
	public List<Object> getEnums() {
		return _getList("enums", Object.class);
	}

	@Override
	public List<Object> getEnums(boolean elaborate) {
		return _getList("enums", elaborate, Object.class);
	}

	@Override
	public boolean hasEnums() {
		return _isPresent("enums");
	}

	@Override
	public Object getEnum(int index) {
		return _get("enums", index, Object.class);
	}

	@Override
	public void setEnums(List<Object> enums) {
		_setList("enums", enums, Object.class);
	}

	@Override
	public void setEnum(int index, Object enumValue) {
		_set("enums", index, enumValue, Object.class);
	}

	@Override
	public void addEnum(Object enumValue) {
		_add("enums", enumValue, Object.class);
	}

	@Override
	public void insertEnum(int index, Object enumValue) {
		_insert("enums", index, enumValue, Object.class);
	}

	@Override
	public void removeEnum(int index) {
		_remove("enums", index, Object.class);
	}

	// Type
	@Override
	public String getType() {
		return _get("type", String.class);
	}

	@Override
	public void setType(String type) {
		_setScalar("type", type, String.class);
	}

	// AllOfSchema
	@Override
	public List<Schema> getAllOfSchemas() {
		return _getList("allOfSchemas", Schema.class);
	}

	@Override
	public List<Schema> getAllOfSchemas(boolean elaborate) {
		return _getList("allOfSchemas", elaborate, Schema.class);
	}

	@Override
	public boolean hasAllOfSchemas() {
		return _isPresent("allOfSchemas");
	}

	@Override
	public Schema getAllOfSchema(int index) {
		return _get("allOfSchemas", index, Schema.class);
	}

	@Override
	public void setAllOfSchemas(List<Schema> allOfSchemas) {
		_setList("allOfSchemas", allOfSchemas, Schema.class);
	}

	@Override
	public void setAllOfSchema(int index, Schema allOfSchema) {
		_set("allOfSchemas", index, allOfSchema, Schema.class);
	}

	@Override
	public void addAllOfSchema(Schema allOfSchema) {
		_add("allOfSchemas", allOfSchema, Schema.class);
	}

	@Override
	public void insertAllOfSchema(int index, Schema allOfSchema) {
		_insert("allOfSchemas", index, allOfSchema, Schema.class);
	}

	@Override
	public void removeAllOfSchema(int index) {
		_remove("allOfSchemas", index, Schema.class);
	}

	// OneOfSchema
	@Override
	public List<Schema> getOneOfSchemas() {
		return _getList("oneOfSchemas", Schema.class);
	}

	@Override
	public List<Schema> getOneOfSchemas(boolean elaborate) {
		return _getList("oneOfSchemas", elaborate, Schema.class);
	}

	@Override
	public boolean hasOneOfSchemas() {
		return _isPresent("oneOfSchemas");
	}

	@Override
	public Schema getOneOfSchema(int index) {
		return _get("oneOfSchemas", index, Schema.class);
	}

	@Override
	public void setOneOfSchemas(List<Schema> oneOfSchemas) {
		_setList("oneOfSchemas", oneOfSchemas, Schema.class);
	}

	@Override
	public void setOneOfSchema(int index, Schema oneOfSchema) {
		_set("oneOfSchemas", index, oneOfSchema, Schema.class);
	}

	@Override
	public void addOneOfSchema(Schema oneOfSchema) {
		_add("oneOfSchemas", oneOfSchema, Schema.class);
	}

	@Override
	public void insertOneOfSchema(int index, Schema oneOfSchema) {
		_insert("oneOfSchemas", index, oneOfSchema, Schema.class);
	}

	@Override
	public void removeOneOfSchema(int index) {
		_remove("oneOfSchemas", index, Schema.class);
	}

	// AnyOfSchema
	@Override
	public List<Schema> getAnyOfSchemas() {
		return _getList("anyOfSchemas", Schema.class);
	}

	@Override
	public List<Schema> getAnyOfSchemas(boolean elaborate) {
		return _getList("anyOfSchemas", elaborate, Schema.class);
	}

	@Override
	public boolean hasAnyOfSchemas() {
		return _isPresent("anyOfSchemas");
	}

	@Override
	public Schema getAnyOfSchema(int index) {
		return _get("anyOfSchemas", index, Schema.class);
	}

	@Override
	public void setAnyOfSchemas(List<Schema> anyOfSchemas) {
		_setList("anyOfSchemas", anyOfSchemas, Schema.class);
	}

	@Override
	public void setAnyOfSchema(int index, Schema anyOfSchema) {
		_set("anyOfSchemas", index, anyOfSchema, Schema.class);
	}

	@Override
	public void addAnyOfSchema(Schema anyOfSchema) {
		_add("anyOfSchemas", anyOfSchema, Schema.class);
	}

	@Override
	public void insertAnyOfSchema(int index, Schema anyOfSchema) {
		_insert("anyOfSchemas", index, anyOfSchema, Schema.class);
	}

	@Override
	public void removeAnyOfSchema(int index) {
		_remove("anyOfSchemas", index, Schema.class);
	}

	// NotSchema
	@Override
	public Schema getNotSchema() {
		return _get("notSchema", Schema.class);
	}

	@Override
	public Schema getNotSchema(boolean elaborate) {
		return _get("notSchema", elaborate, Schema.class);
	}

	@Override
	public void setNotSchema(Schema notSchema) {
		_setScalar("notSchema", notSchema, Schema.class);
	}

	// ItemsSchema
	@Override
	public Schema getItemsSchema() {
		return _get("itemsSchema", Schema.class);
	}

	@Override
	public Schema getItemsSchema(boolean elaborate) {
		return _get("itemsSchema", elaborate, Schema.class);
	}

	@Override
	public void setItemsSchema(Schema itemsSchema) {
		_setScalar("itemsSchema", itemsSchema, Schema.class);
	}

	// Property
	@Override
	public Map<String, Schema> getProperties() {
		return _getMap("properties", Schema.class);
	}

	@Override
	public Map<String, Schema> getProperties(boolean elaborate) {
		return _getMap("properties", elaborate, Schema.class);
	}

	@Override
	public boolean hasProperties() {
		return _isPresent("properties");
	}

	@Override
	public boolean hasProperty(String name) {
		return _getMap("properties", Schema.class).containsKey(name);
	}

	@Override
	public Schema getProperty(String name) {
		return _get("properties", name, Schema.class);
	}

	@Override
	public void setProperties(Map<String, Schema> properties) {
		_setMap("properties", properties, Schema.class);
	}

	@Override
	public void setProperty(String name, Schema property) {
		_set("properties", name, property, Schema.class);
	}

	@Override
	public void removeProperty(String name) {
		_remove("properties", name, Schema.class);
	}

	// AdditionalPropertiesSchema
	@Override
	public Schema getAdditionalPropertiesSchema() {
		return _get("additionalPropertiesSchema", Schema.class);
	}

	@Override
	public Schema getAdditionalPropertiesSchema(boolean elaborate) {
		return _get("additionalPropertiesSchema", elaborate, Schema.class);
	}

	@Override
	public void setAdditionalPropertiesSchema(Schema additionalPropertiesSchema) {
		_setScalar("additionalPropertiesSchema", additionalPropertiesSchema, Schema.class);
	}

	// AdditionalProperties
	@Override
	public Boolean getAdditionalProperties() {
		return _get("additionalProperties", Boolean.class);
	}

	@Override
	public boolean isAdditionalProperties() {
		Boolean bool = _get("additionalProperties", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	public void setAdditionalProperties(Boolean additionalProperties) {
		_setScalar("additionalProperties", additionalProperties, Boolean.class);
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

	// Format
	@Override
	public String getFormat() {
		return _get("format", String.class);
	}

	@Override
	public void setFormat(String format) {
		_setScalar("format", format, String.class);
	}

	// Default
	@Override
	public Object getDefault() {
		return _get("defaultValue", Object.class);
	}

	@Override
	public void setDefault(Object defaultValue) {
		_setScalar("defaultValue", defaultValue, Object.class);
	}

	// Nullable
	@Override
	public Boolean getNullable() {
		return _get("nullable", Boolean.class);
	}

	@Override
	public boolean isNullable() {
		Boolean bool = _get("nullable", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	public void setNullable(Boolean nullable) {
		_setScalar("nullable", nullable, Boolean.class);
	}

	// Discriminator
	@Override
	public Discriminator getDiscriminator() {
		return _get("discriminator", Discriminator.class);
	}

	@Override
	public Discriminator getDiscriminator(boolean elaborate) {
		return _get("discriminator", elaborate, Discriminator.class);
	}

	@Override
	public void setDiscriminator(Discriminator discriminator) {
		_setScalar("discriminator", discriminator, Discriminator.class);
	}

	// ReadOnly
	@Override
	public Boolean getReadOnly() {
		return _get("readOnly", Boolean.class);
	}

	@Override
	public boolean isReadOnly() {
		Boolean bool = _get("readOnly", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	public void setReadOnly(Boolean readOnly) {
		_setScalar("readOnly", readOnly, Boolean.class);
	}

	// WriteOnly
	@Override
	public Boolean getWriteOnly() {
		return _get("writeOnly", Boolean.class);
	}

	@Override
	public boolean isWriteOnly() {
		Boolean bool = _get("writeOnly", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	public void setWriteOnly(Boolean writeOnly) {
		_setScalar("writeOnly", writeOnly, Boolean.class);
	}

	// Xml
	@Override
	public Xml getXml() {
		return _get("xml", Xml.class);
	}

	@Override
	public Xml getXml(boolean elaborate) {
		return _get("xml", elaborate, Xml.class);
	}

	@Override
	public void setXml(Xml xml) {
		_setScalar("xml", xml, Xml.class);
	}

	// ExternalDocs
	@Override
	public ExternalDocs getExternalDocs() {
		return _get("externalDocs", ExternalDocs.class);
	}

	@Override
	public ExternalDocs getExternalDocs(boolean elaborate) {
		return _get("externalDocs", elaborate, ExternalDocs.class);
	}

	@Override
	public void setExternalDocs(ExternalDocs externalDocs) {
		_setScalar("externalDocs", externalDocs, ExternalDocs.class);
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

	public static final String F_title = "title";

	public static final String F_multipleOf = "multipleOf";

	public static final String F_maximum = "maximum";

	public static final String F_exclusiveMaximum = "exclusiveMaximum";

	public static final String F_minimum = "minimum";

	public static final String F_exclusiveMinimum = "exclusiveMinimum";

	public static final String F_maxLength = "maxLength";

	public static final String F_minLength = "minLength";

	public static final String F_pattern = "pattern";

	public static final String F_maxItems = "maxItems";

	public static final String F_minItems = "minItems";

	public static final String F_uniqueItems = "uniqueItems";

	public static final String F_maxProperties = "maxProperties";

	public static final String F_minProperties = "minProperties";

	public static final String F_requiredFields = "requiredFields";

	public static final String F_enums = "enums";

	public static final String F_type = "type";

	public static final String F_allOfSchemas = "allOfSchemas";

	public static final String F_oneOfSchemas = "oneOfSchemas";

	public static final String F_anyOfSchemas = "anyOfSchemas";

	public static final String F_notSchema = "notSchema";

	public static final String F_itemsSchema = "itemsSchema";

	public static final String F_properties = "properties";

	public static final String F_additionalPropertiesSchema = "additionalPropertiesSchema";

	public static final String F_additionalProperties = "additionalProperties";

	public static final String F_description = "description";

	public static final String F_format = "format";

	public static final String F_defaultValue = "defaultValue";

	public static final String F_nullable = "nullable";

	public static final String F_discriminator = "discriminator";

	public static final String F_readOnly = "readOnly";

	public static final String F_writeOnly = "writeOnly";

	public static final String F_xml = "xml";

	public static final String F_externalDocs = "externalDocs";

	public static final String F_example = "example";

	public static final String F_deprecated = "deprecated";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("title", "title", StringOverlay.factory);
		_createScalar("multipleOf", "multipleOf", NumberOverlay.factory);
		_createScalar("maximum", "maximum", NumberOverlay.factory);
		_createScalar("exclusiveMaximum", "exclusiveMaximum", BooleanOverlay.factory);
		_createScalar("minimum", "minimum", NumberOverlay.factory);
		_createScalar("exclusiveMinimum", "exclusiveMinimum", BooleanOverlay.factory);
		_createScalar("maxLength", "maxLength", IntegerOverlay.factory);
		_createScalar("minLength", "minLength", IntegerOverlay.factory);
		_createScalar("pattern", "pattern", StringOverlay.factory);
		_createScalar("maxItems", "maxItems", IntegerOverlay.factory);
		_createScalar("minItems", "minItems", IntegerOverlay.factory);
		_createScalar("uniqueItems", "uniqueItems", BooleanOverlay.factory);
		_createScalar("maxProperties", "maxProperties", IntegerOverlay.factory);
		_createScalar("minProperties", "minProperties", IntegerOverlay.factory);
		_createList("requiredFields", "required", StringOverlay.factory);
		_createList("enums", "enum", ObjectOverlay.factory);
		_createScalar("type", "type", StringOverlay.factory);
		_createList("allOfSchemas", "allOf", SchemaImpl.factory);
		_createList("oneOfSchemas", "oneOf", SchemaImpl.factory);
		_createList("anyOfSchemas", "anyOf", SchemaImpl.factory);
		_createScalar("notSchema", "not", SchemaImpl.factory);
		_createScalar("itemsSchema", "items", SchemaImpl.factory);
		_createMap("properties", "properties", SchemaImpl.factory, null);
		_createScalar("additionalPropertiesSchema", "additionalProperties", SchemaImpl.factory);
		_createScalar("additionalProperties", "additionalProperties", BooleanOverlay.factory);
		_createScalar("description", "description", StringOverlay.factory);
		_createScalar("format", "format", StringOverlay.factory);
		_createScalar("defaultValue", "default", ObjectOverlay.factory);
		_createScalar("nullable", "nullable", BooleanOverlay.factory);
		_createScalar("discriminator", "discriminator", DiscriminatorImpl.factory);
		_createScalar("readOnly", "readOnly", BooleanOverlay.factory);
		_createScalar("writeOnly", "writeOnly", BooleanOverlay.factory);
		_createScalar("xml", "xml", XmlImpl.factory);
		_createScalar("externalDocs", "externalDocs", ExternalDocsImpl.factory);
		_createScalar("example", "example", ObjectOverlay.factory);
		_createScalar("deprecated", "deprecated", BooleanOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<Schema> factory = new OverlayFactory<Schema>() {

		@Override
		protected Class<? extends JsonOverlay<? super Schema>> getOverlayClass() {
			return SchemaImpl.class;
		}

		@Override
		public JsonOverlay<Schema> _create(Schema schema, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new SchemaImpl(schema, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Schema> castOverlay = (JsonOverlay<Schema>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Schema> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new SchemaImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Schema> castOverlay = (JsonOverlay<Schema>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends Schema> getSubtypeOf(Schema schema) {
		return Schema.class;
	}

	private static Class<? extends Schema> getSubtypeOf(JsonNode json) {
		return Schema.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<Schema> builder(OV modelMember) {
		return new Builder<Schema>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> Schema create(OV modelMember) {
		return (Schema) builder(modelMember).build();
	}
}
