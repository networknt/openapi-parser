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
package com.networknt.oas.model;

import java.util.List;
import java.util.Map;

import com.networknt.jsonoverlay.IJsonOverlay;
import com.networknt.jsonoverlay.IModelPart;

public interface Schema extends IJsonOverlay<Schema>, IModelPart<OpenApi3, Schema> {

	String getName();

	// Title
	String getTitle();

	void setTitle(String title);

	// MultipleOf
	Number getMultipleOf();

	void setMultipleOf(Number multipleOf);

	// Maximum
	Number getMaximum();

	void setMaximum(Number maximum);

	// ExclusiveMaximum
	Boolean getExclusiveMaximum();

	boolean isExclusiveMaximum();

	void setExclusiveMaximum(Boolean exclusiveMaximum);

	// Minimum
	Number getMinimum();

	void setMinimum(Number minimum);

	// ExclusiveMinimum
	Boolean getExclusiveMinimum();

	boolean isExclusiveMinimum();

	void setExclusiveMinimum(Boolean exclusiveMinimum);

	// MaxLength
	Integer getMaxLength();

	void setMaxLength(Integer maxLength);

	// MinLength
	Integer getMinLength();

	void setMinLength(Integer minLength);

	// Pattern
	String getPattern();

	void setPattern(String pattern);

	// MaxItems
	Integer getMaxItems();

	void setMaxItems(Integer maxItems);

	// MinItems
	Integer getMinItems();

	void setMinItems(Integer minItems);

	// UniqueItems
	Boolean getUniqueItems();

	boolean isUniqueItems();

	void setUniqueItems(Boolean uniqueItems);

	// MaxProperties
	Integer getMaxProperties();

	void setMaxProperties(Integer maxProperties);

	// MinProperties
	Integer getMinProperties();

	void setMinProperties(Integer minProperties);

	// RequiredField
	List<String> getRequiredFields();

	List<String> getRequiredFields(boolean elaborate);

	boolean hasRequiredFields();

	String getRequiredField(int index);

	void setRequiredFields(List<String> requiredFields);

	void setRequiredField(int index, String requiredField);

	void addRequiredField(String requiredField);

	void insertRequiredField(int index, String requiredField);

	void removeRequiredField(int index);

	// Enum
	List<Object> getEnums();

	List<Object> getEnums(boolean elaborate);

	boolean hasEnums();

	Object getEnum(int index);

	void setEnums(List<Object> enums);

	void setEnum(int index, Object enumValue);

	void addEnum(Object enumValue);

	void insertEnum(int index, Object enumValue);

	void removeEnum(int index);

	// Type
	String getType();

	void setType(String type);

	// AllOfSchema
	List<Schema> getAllOfSchemas();

	List<Schema> getAllOfSchemas(boolean elaborate);

	boolean hasAllOfSchemas();

	Schema getAllOfSchema(int index);

	void setAllOfSchemas(List<Schema> allOfSchemas);

	void setAllOfSchema(int index, Schema allOfSchema);

	void addAllOfSchema(Schema allOfSchema);

	void insertAllOfSchema(int index, Schema allOfSchema);

	void removeAllOfSchema(int index);

	// OneOfSchema
	List<Schema> getOneOfSchemas();

	List<Schema> getOneOfSchemas(boolean elaborate);

	boolean hasOneOfSchemas();

	Schema getOneOfSchema(int index);

	void setOneOfSchemas(List<Schema> oneOfSchemas);

	void setOneOfSchema(int index, Schema oneOfSchema);

	void addOneOfSchema(Schema oneOfSchema);

	void insertOneOfSchema(int index, Schema oneOfSchema);

	void removeOneOfSchema(int index);

	// AnyOfSchema
	List<Schema> getAnyOfSchemas();

	List<Schema> getAnyOfSchemas(boolean elaborate);

	boolean hasAnyOfSchemas();

	Schema getAnyOfSchema(int index);

	void setAnyOfSchemas(List<Schema> anyOfSchemas);

	void setAnyOfSchema(int index, Schema anyOfSchema);

	void addAnyOfSchema(Schema anyOfSchema);

	void insertAnyOfSchema(int index, Schema anyOfSchema);

	void removeAnyOfSchema(int index);

	// NotSchema
	Schema getNotSchema();

	Schema getNotSchema(boolean elaborate);

	void setNotSchema(Schema notSchema);

	// ItemsSchema
	Schema getItemsSchema();

	Schema getItemsSchema(boolean elaborate);

	void setItemsSchema(Schema itemsSchema);

	// Property
	Map<String, Schema> getProperties();

	Map<String, Schema> getProperties(boolean elaborate);

	boolean hasProperties();

	boolean hasProperty(String name);

	Schema getProperty(String name);

	void setProperties(Map<String, Schema> properties);

	void setProperty(String name, Schema property);

	void removeProperty(String name);

	// AdditionalPropertiesSchema
	Schema getAdditionalPropertiesSchema();

	Schema getAdditionalPropertiesSchema(boolean elaborate);

	void setAdditionalPropertiesSchema(Schema additionalPropertiesSchema);

	// AdditionalProperties
	Boolean getAdditionalProperties();

	boolean isAdditionalProperties();

	void setAdditionalProperties(Boolean additionalProperties);

	// UnevaluatedProperties
	Boolean getUnevaluatedProperties();

	boolean isUnevaluatedProperties();

	void setUnevaluatedProperties(Boolean additionalProperties);

	// Description
	String getDescription();

	void setDescription(String description);

	// Format
	String getFormat();

	void setFormat(String format);

	// Default
	Object getDefault();

	void setDefault(Object defaultValue);

	// Nullable
	Boolean getNullable();

	boolean isNullable();

	void setNullable(Boolean nullable);

	// Discriminator
	Discriminator getDiscriminator();

	Discriminator getDiscriminator(boolean elaborate);

	void setDiscriminator(Discriminator discriminator);

	// ReadOnly
	Boolean getReadOnly();

	boolean isReadOnly();

	void setReadOnly(Boolean readOnly);

	// WriteOnly
	Boolean getWriteOnly();

	boolean isWriteOnly();

	void setWriteOnly(Boolean writeOnly);

	// Xml
	Xml getXml();

	Xml getXml(boolean elaborate);

	void setXml(Xml xml);

	// ExternalDocs
	ExternalDocs getExternalDocs();

	ExternalDocs getExternalDocs(boolean elaborate);

	void setExternalDocs(ExternalDocs externalDocs);

	// Example
	Object getExample();

	void setExample(Object example);

	// Deprecated
	Boolean getDeprecated();

	boolean isDeprecated();

	void setDeprecated(Boolean deprecated);

	// Extension
	Map<String, Object> getExtensions();

	Map<String, Object> getExtensions(boolean elaborate);

	boolean hasExtensions();

	boolean hasExtension(String name);

	Object getExtension(String name);

	void setExtensions(Map<String, Object> extensions);

	void setExtension(String name, Object extension);

	void removeExtension(String name);
}
