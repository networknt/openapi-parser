package com.networknt.oas.model;

import com.networknt.oas.jsonoverlay.Reference;

import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public interface Schema extends OpenApiObject<OpenApi3, Schema> {

    // Title

    String getTitle();


    String getTitle(boolean elaborate);


    void setTitle(String title);

    // MultipleOf

    Number getMultipleOf();


    Number getMultipleOf(boolean elaborate);


    void setMultipleOf(Number multipleOf);

    // Maximum

    Number getMaximum();


    Number getMaximum(boolean elaborate);


    void setMaximum(Number maximum);

    // ExclusiveMaximum

    Boolean getExclusiveMaximum();


    Boolean getExclusiveMaximum(boolean elaborate);


    boolean isExclusiveMaximum();


    void setExclusiveMaximum(Boolean exclusiveMaximum);

    // Minimum

    Number getMinimum();


    Number getMinimum(boolean elaborate);


    void setMinimum(Number minimum);

    // ExclusiveMinimum

    Boolean getExclusiveMinimum();


    Boolean getExclusiveMinimum(boolean elaborate);


    boolean isExclusiveMinimum();


    void setExclusiveMinimum(Boolean exclusiveMinimum);

    // MaxLength

    Integer getMaxLength();


    Integer getMaxLength(boolean elaborate);


    void setMaxLength(Integer maxLength);

    // MinLength

    Integer getMinLength();


    Integer getMinLength(boolean elaborate);


    void setMinLength(Integer minLength);

    // Pattern

    String getPattern();


    String getPattern(boolean elaborate);


    void setPattern(String pattern);

    // MaxItems

    Integer getMaxItems();


    Integer getMaxItems(boolean elaborate);


    void setMaxItems(Integer maxItems);

    // MinItems

    Integer getMinItems();


    Integer getMinItems(boolean elaborate);


    void setMinItems(Integer minItems);

    // UniqueItems

    Boolean getUniqueItems();


    Boolean getUniqueItems(boolean elaborate);


    boolean isUniqueItems();


    void setUniqueItems(Boolean uniqueItems);

    // MaxProperties

    Integer getMaxProperties();


    Integer getMaxProperties(boolean elaborate);


    void setMaxProperties(Integer maxProperties);

    // MinProperties

    Integer getMinProperties();


    Integer getMinProperties(boolean elaborate);


    void setMinProperties(Integer minProperties);

    // RequiredField

    Collection<String> getRequiredFields();


    Collection<String> getRequiredFields(boolean elaborate);


    boolean hasRequiredFields();


    String getRequiredField(int index);


    void setRequiredFields(Collection<String> requiredFields);


    void setRequiredField(int index, String requiredField);


    void addRequiredField(String requiredField);


    void insertRequiredField(int index, String requiredField);


    void removeRequiredField(int index);

    // Enum

    Collection<Object> getEnums();


    Collection<Object> getEnums(boolean elaborate);


    boolean hasEnums();


    Object getEnum(int index);


    void setEnums(Collection<Object> enums);


    void setEnum(int index, Object enumValue);


    void addEnum(Object enumValue);


    void insertEnum(int index, Object enumValue);


    void removeEnum(int index);

    // Type

    String getType();


    String getType(boolean elaborate);


    void setType(String type);

    // AllOfSchema

    Collection<Schema> getAllOfSchemas();


    Collection<Schema> getAllOfSchemas(boolean elaborate);


    boolean hasAllOfSchemas();


    Schema getAllOfSchema(int index);


    void setAllOfSchemas(Collection<Schema> allOfSchemas);


    void setAllOfSchema(int index, Schema allOfSchema);


    void addAllOfSchema(Schema allOfSchema);


    void insertAllOfSchema(int index, Schema allOfSchema);


    void removeAllOfSchema(int index);


    boolean isAllOfSchemaReference(int index);


    Reference getAllOfSchemaReference(int index);

    // OneOfSchema

    Collection<Schema> getOneOfSchemas();


    Collection<Schema> getOneOfSchemas(boolean elaborate);


    boolean hasOneOfSchemas();


    Schema getOneOfSchema(int index);


    void setOneOfSchemas(Collection<Schema> oneOfSchemas);


    void setOneOfSchema(int index, Schema oneOfSchema);


    void addOneOfSchema(Schema oneOfSchema);


    void insertOneOfSchema(int index, Schema oneOfSchema);


    void removeOneOfSchema(int index);


    boolean isOneOfSchemaReference(int index);


    Reference getOneOfSchemaReference(int index);

    // AnyOfSchema

    Collection<Schema> getAnyOfSchemas();


    Collection<Schema> getAnyOfSchemas(boolean elaborate);


    boolean hasAnyOfSchemas();


    Schema getAnyOfSchema(int index);


    void setAnyOfSchemas(Collection<Schema> anyOfSchemas);


    void setAnyOfSchema(int index, Schema anyOfSchema);


    void addAnyOfSchema(Schema anyOfSchema);


    void insertAnyOfSchema(int index, Schema anyOfSchema);


    void removeAnyOfSchema(int index);


    boolean isAnyOfSchemaReference(int index);


    Reference getAnyOfSchemaReference(int index);

    // NotSchema

    Schema getNotSchema();


    Schema getNotSchema(boolean elaborate);


    void setNotSchema(Schema notSchema);


    boolean isNotSchemaReference();


    Reference getNotSchemaReference();

    // ItemsSchema

    Schema getItemsSchema();


    Schema getItemsSchema(boolean elaborate);


    void setItemsSchema(Schema itemsSchema);


    boolean isItemsSchemaReference();


    Reference getItemsSchemaReference();

    // Property

    Map<String, Schema> getProperties();


    Map<String, Schema> getProperties(boolean elaborate);


    boolean hasProperty(String name);


    Schema getProperty(String name);


    void setProperties(Map<String, Schema> properties);


    void setProperty(String name, Schema property);


    void removeProperty(String name);


    boolean isPropertyReference(String key);


    Reference getPropertyReference(String key);

    // AdditionalPropertiesSchema

    Schema getAdditionalPropertiesSchema();


    Schema getAdditionalPropertiesSchema(boolean elaborate);


    void setAdditionalPropertiesSchema(Schema additionalPropertiesSchema);


    boolean isAdditionalPropertiesSchemaReference();


    Reference getAdditionalPropertiesSchemaReference();

    // AdditionalProperties

    Boolean getAdditionalProperties();


    Boolean getAdditionalProperties(boolean elaborate);


    boolean isAdditionalProperties();


    void setAdditionalProperties(Boolean additionalProperties);

    // Description

    String getDescription();


    String getDescription(boolean elaborate);


    void setDescription(String description);

    // Format

    String getFormat();


    String getFormat(boolean elaborate);


    void setFormat(String format);

    // Default

    Object getDefault();


    Object getDefault(boolean elaborate);


    void setDefault(Object defaultValue);

    // Nullable

    Boolean getNullable();


    Boolean getNullable(boolean elaborate);


    boolean isNullable();


    void setNullable(Boolean nullable);

    // Discriminator

    String getDiscriminator();


    String getDiscriminator(boolean elaborate);


    void setDiscriminator(String discriminator);

    // ReadOnly

    Boolean getReadOnly();


    Boolean getReadOnly(boolean elaborate);


    boolean isReadOnly();


    void setReadOnly(Boolean readOnly);

    // WriteOnly

    Boolean getWriteOnly();


    Boolean getWriteOnly(boolean elaborate);


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

    Map<String, Example> getExamples();


    Map<String, Example> getExamples(boolean elaborate);


    boolean hasExample(String name);


    Example getExample(String name);


    void setExamples(Map<String, Example> examples);


    void setExample(String name, Example example);


    void removeExample(String name);

    // Example

    Object getExample();


    Object getExample(boolean elaborate);


    void setExample(Object example);

    // Deprecated

    Boolean getDeprecated();


    Boolean getDeprecated(boolean elaborate);


    boolean isDeprecated();


    void setDeprecated(Boolean deprecated);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
