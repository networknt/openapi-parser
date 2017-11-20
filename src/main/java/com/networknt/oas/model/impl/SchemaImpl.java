package com.networknt.oas.model.impl;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.jsonoverlay.*;
import com.networknt.oas.model.*;

import java.util.Collection;
import java.util.Map;

public class SchemaImpl extends OpenApiObjectImpl<OpenApi3, Schema> implements Schema {

    @Override
    public IJsonOverlay<?> find(JsonPointer path) {
        if (path.matchesProperty("additionalProperties")) {
            return path.tail().matches() ? additionalProperties : additionalPropertiesSchema.find(path.tail());
        } else {
            return super.find(path);
        }
    }


    public SchemaImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    public SchemaImpl(Schema schema, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(schema, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    private ChildOverlay<String, StringOverlay> title = null;


    private ChildOverlay<Number, NumberOverlay> multipleOf = null;


    private ChildOverlay<Number, NumberOverlay> maximum = null;


    private ChildOverlay<Boolean, BooleanOverlay> exclusiveMaximum = null;


    private ChildOverlay<Number, NumberOverlay> minimum = null;


    private ChildOverlay<Boolean, BooleanOverlay> exclusiveMinimum = null;


    private ChildOverlay<Integer, IntegerOverlay> maxLength = null;


    private ChildOverlay<Integer, IntegerOverlay> minLength = null;


    private ChildOverlay<String, StringOverlay> pattern = null;


    private ChildOverlay<Integer, IntegerOverlay> maxItems = null;


    private ChildOverlay<Integer, IntegerOverlay> minItems = null;


    private ChildOverlay<Boolean, BooleanOverlay> uniqueItems = null;


    private ChildOverlay<Integer, IntegerOverlay> maxProperties = null;


    private ChildOverlay<Integer, IntegerOverlay> minProperties = null;


    private ChildListOverlay<String, StringOverlay> requiredFields = null;


    private ChildListOverlay<Object, ObjectOverlay> enums = null;


    private ChildOverlay<String, StringOverlay> type = null;


    private ChildListOverlay<Schema, SchemaImpl> allOfSchemas = null;


    private ChildListOverlay<Schema, SchemaImpl> oneOfSchemas = null;


    private ChildListOverlay<Schema, SchemaImpl> anyOfSchemas = null;


    private ChildOverlay<Schema, SchemaImpl> notSchema = null;


    private ChildOverlay<Schema, SchemaImpl> itemsSchema = null;


    private ChildMapOverlay<Schema, SchemaImpl> properties = null;


    private ChildOverlay<Schema, SchemaImpl> additionalPropertiesSchema = null;


    private ChildOverlay<Boolean, BooleanOverlay> additionalProperties = null;


    private ChildOverlay<String, StringOverlay> description = null;


    private ChildOverlay<String, StringOverlay> format = null;


    private ChildOverlay<Object, ObjectOverlay> defaultValue = null;


    private ChildOverlay<Boolean, BooleanOverlay> nullable = null;


    private ChildOverlay<String, StringOverlay> discriminator = null;


    private ChildOverlay<Boolean, BooleanOverlay> readOnly = null;


    private ChildOverlay<Boolean, BooleanOverlay> writeOnly = null;


    private ChildOverlay<Xml, XmlImpl> xml = null;


    private ChildOverlay<ExternalDocs, ExternalDocsImpl> externalDocs = null;


    private ChildMapOverlay<Example, ExampleImpl> examples = null;


    private ChildOverlay<Object, ObjectOverlay> example = null;


    private ChildOverlay<Boolean, BooleanOverlay> deprecated = null;


    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

    // Title
    @Override
    public String getTitle() {
        return title.get();
    }

    @Override
    public String getTitle(boolean elaborate) {
        return title.get(elaborate);
    }

    @Override
    public void setTitle(String title) {
        this.title.set(title);
    }

    // MultipleOf
    @Override
    public Number getMultipleOf() {
        return multipleOf.get();
    }

    @Override
    public Number getMultipleOf(boolean elaborate) {
        return multipleOf.get(elaborate);
    }

    @Override
    public void setMultipleOf(Number multipleOf) {
        this.multipleOf.set(multipleOf);
    }

    // Maximum
    @Override
    public Number getMaximum() {
        return maximum.get();
    }

    @Override
    public Number getMaximum(boolean elaborate) {
        return maximum.get(elaborate);
    }

    @Override
    public void setMaximum(Number maximum) {
        this.maximum.set(maximum);
    }

    // ExclusiveMaximum
    @Override
    public Boolean getExclusiveMaximum() {
        return exclusiveMaximum.get();
    }

    @Override
    public Boolean getExclusiveMaximum(boolean elaborate) {
        return exclusiveMaximum.get(elaborate);
    }

    @Override
    public boolean isExclusiveMaximum() {
        return exclusiveMaximum.get() != null ? exclusiveMaximum.get() : false;
    }

    @Override
    public void setExclusiveMaximum(Boolean exclusiveMaximum) {
        this.exclusiveMaximum.set(exclusiveMaximum);
    }

    // Minimum
    @Override
    public Number getMinimum() {
        return minimum.get();
    }

    @Override
    public Number getMinimum(boolean elaborate) {
        return minimum.get(elaborate);
    }

    @Override
    public void setMinimum(Number minimum) {
        this.minimum.set(minimum);
    }

    // ExclusiveMinimum
    @Override
    public Boolean getExclusiveMinimum() {
        return exclusiveMinimum.get();
    }

    @Override
    public Boolean getExclusiveMinimum(boolean elaborate) {
        return exclusiveMinimum.get(elaborate);
    }

    @Override
    public boolean isExclusiveMinimum() {
        return exclusiveMinimum.get() != null ? exclusiveMinimum.get() : false;
    }

    @Override
    public void setExclusiveMinimum(Boolean exclusiveMinimum) {
        this.exclusiveMinimum.set(exclusiveMinimum);
    }

    // MaxLength
    @Override
    public Integer getMaxLength() {
        return maxLength.get();
    }

    @Override
    public Integer getMaxLength(boolean elaborate) {
        return maxLength.get(elaborate);
    }

    @Override
    public void setMaxLength(Integer maxLength) {
        this.maxLength.set(maxLength);
    }

    // MinLength
    @Override
    public Integer getMinLength() {
        return minLength.get();
    }

    @Override
    public Integer getMinLength(boolean elaborate) {
        return minLength.get(elaborate);
    }

    @Override
    public void setMinLength(Integer minLength) {
        this.minLength.set(minLength);
    }

    // Pattern
    @Override
    public String getPattern() {
        return pattern.get();
    }

    @Override
    public String getPattern(boolean elaborate) {
        return pattern.get(elaborate);
    }

    @Override
    public void setPattern(String pattern) {
        this.pattern.set(pattern);
    }

    // MaxItems
    @Override
    public Integer getMaxItems() {
        return maxItems.get();
    }

    @Override
    public Integer getMaxItems(boolean elaborate) {
        return maxItems.get(elaborate);
    }

    @Override
    public void setMaxItems(Integer maxItems) {
        this.maxItems.set(maxItems);
    }

    // MinItems
    @Override
    public Integer getMinItems() {
        return minItems.get();
    }

    @Override
    public Integer getMinItems(boolean elaborate) {
        return minItems.get(elaborate);
    }

    @Override
    public void setMinItems(Integer minItems) {
        this.minItems.set(minItems);
    }

    // UniqueItems
    @Override
    public Boolean getUniqueItems() {
        return uniqueItems.get();
    }

    @Override
    public Boolean getUniqueItems(boolean elaborate) {
        return uniqueItems.get(elaborate);
    }

    @Override
    public boolean isUniqueItems() {
        return uniqueItems.get() != null ? uniqueItems.get() : false;
    }

    @Override
    public void setUniqueItems(Boolean uniqueItems) {
        this.uniqueItems.set(uniqueItems);
    }

    // MaxProperties
    @Override
    public Integer getMaxProperties() {
        return maxProperties.get();
    }

    @Override
    public Integer getMaxProperties(boolean elaborate) {
        return maxProperties.get(elaborate);
    }

    @Override
    public void setMaxProperties(Integer maxProperties) {
        this.maxProperties.set(maxProperties);
    }

    // MinProperties
    @Override
    public Integer getMinProperties() {
        return minProperties.get();
    }

    @Override
    public Integer getMinProperties(boolean elaborate) {
        return minProperties.get(elaborate);
    }

    @Override
    public void setMinProperties(Integer minProperties) {
        this.minProperties.set(minProperties);
    }

    // RequiredField
    @Override
    public Collection<String> getRequiredFields() {
        return requiredFields.get();
    }

    @Override
    public Collection<String> getRequiredFields(boolean elaborate) {
        return requiredFields.get(elaborate);
    }

    @Override
    public boolean hasRequiredFields() {
        return requiredFields.isPresent();
    }

    @Override
    public String getRequiredField(int index) {
        return requiredFields.get(index);
    }

    @Override
    public void setRequiredFields(Collection<String> requiredFields) {
        this.requiredFields.set((Collection<String>) requiredFields);
    }

    @Override
    public void setRequiredField(int index, String requiredField) {
        requiredFields.set(index, requiredField);
    }

    @Override
    public void addRequiredField(String requiredField) {
        requiredFields.add(requiredField);
    }

    @Override
    public void insertRequiredField(int index, String requiredField) {
        requiredFields.insert(index, requiredField);
    }

    @Override
    public void removeRequiredField(int index) {
        requiredFields.remove(index);
    }

    // Enum
    @Override
    public Collection<Object> getEnums() {
        return enums.get();
    }

    @Override
    public Collection<Object> getEnums(boolean elaborate) {
        return enums.get(elaborate);
    }

    @Override
    public boolean hasEnums() {
        return enums.isPresent();
    }

    @Override
    public Object getEnum(int index) {
        return enums.get(index);
    }

    @Override
    public void setEnums(Collection<Object> enums) {
        this.enums.set((Collection<Object>) enums);
    }

    @Override
    public void setEnum(int index, Object enumValue) {
        enums.set(index, enumValue);
    }

    @Override
    public void addEnum(Object enumValue) {
        enums.add(enumValue);
    }

    @Override
    public void insertEnum(int index, Object enumValue) {
        enums.insert(index, enumValue);
    }

    @Override
    public void removeEnum(int index) {
        enums.remove(index);
    }

    // Type
    @Override
    public String getType() {
        return type.get();
    }

    @Override
    public String getType(boolean elaborate) {
        return type.get(elaborate);
    }

    @Override
    public void setType(String type) {
        this.type.set(type);
    }

    // AllOfSchema
    @Override
    public Collection<Schema> getAllOfSchemas() {
        return allOfSchemas.get();
    }

    @Override
    public Collection<Schema> getAllOfSchemas(boolean elaborate) {
        return allOfSchemas.get(elaborate);
    }

    @Override
    public boolean hasAllOfSchemas() {
        return allOfSchemas.isPresent();
    }

    @Override
    public Schema getAllOfSchema(int index) {
        return allOfSchemas.get(index);
    }

    @Override
    public void setAllOfSchemas(Collection<Schema> allOfSchemas) {
        this.allOfSchemas.set((Collection<Schema>) allOfSchemas);
    }

    @Override
    public void setAllOfSchema(int index, Schema allOfSchema) {
        allOfSchemas.set(index, allOfSchema);
    }

    @Override
    public void addAllOfSchema(Schema allOfSchema) {
        allOfSchemas.add(allOfSchema);
    }

    @Override
    public void insertAllOfSchema(int index, Schema allOfSchema) {
        allOfSchemas.insert(index, allOfSchema);
    }

    @Override
    public void removeAllOfSchema(int index) {
        allOfSchemas.remove(index);
    }

    @Override
    public boolean isAllOfSchemaReference(int index) {
        return allOfSchemas.getChild(index).isReference();
    }

    @Override
    public Reference getAllOfSchemaReference(int index) {
        return allOfSchemas.getChild(index).getReference();
    }

    // OneOfSchema
    @Override
    public Collection<Schema> getOneOfSchemas() {
        return oneOfSchemas.get();
    }

    @Override
    public Collection<Schema> getOneOfSchemas(boolean elaborate) {
        return oneOfSchemas.get(elaborate);
    }

    @Override
    public boolean hasOneOfSchemas() {
        return oneOfSchemas.isPresent();
    }

    @Override
    public Schema getOneOfSchema(int index) {
        return oneOfSchemas.get(index);
    }

    @Override
    public void setOneOfSchemas(Collection<Schema> oneOfSchemas) {
        this.oneOfSchemas.set((Collection<Schema>) oneOfSchemas);
    }

    @Override
    public void setOneOfSchema(int index, Schema oneOfSchema) {
        oneOfSchemas.set(index, oneOfSchema);
    }

    @Override
    public void addOneOfSchema(Schema oneOfSchema) {
        oneOfSchemas.add(oneOfSchema);
    }

    @Override
    public void insertOneOfSchema(int index, Schema oneOfSchema) {
        oneOfSchemas.insert(index, oneOfSchema);
    }

    @Override
    public void removeOneOfSchema(int index) {
        oneOfSchemas.remove(index);
    }

    @Override
    public boolean isOneOfSchemaReference(int index) {
        return oneOfSchemas.getChild(index).isReference();
    }

    @Override
    public Reference getOneOfSchemaReference(int index) {
        return oneOfSchemas.getChild(index).getReference();
    }

    // AnyOfSchema
    @Override
    public Collection<Schema> getAnyOfSchemas() {
        return anyOfSchemas.get();
    }

    @Override
    public Collection<Schema> getAnyOfSchemas(boolean elaborate) {
        return anyOfSchemas.get(elaborate);
    }

    @Override
    public boolean hasAnyOfSchemas() {
        return anyOfSchemas.isPresent();
    }

    @Override
    public Schema getAnyOfSchema(int index) {
        return anyOfSchemas.get(index);
    }

    @Override
    public void setAnyOfSchemas(Collection<Schema> anyOfSchemas) {
        this.anyOfSchemas.set((Collection<Schema>) anyOfSchemas);
    }

    @Override
    public void setAnyOfSchema(int index, Schema anyOfSchema) {
        anyOfSchemas.set(index, anyOfSchema);
    }

    @Override
    public void addAnyOfSchema(Schema anyOfSchema) {
        anyOfSchemas.add(anyOfSchema);
    }

    @Override
    public void insertAnyOfSchema(int index, Schema anyOfSchema) {
        anyOfSchemas.insert(index, anyOfSchema);
    }

    @Override
    public void removeAnyOfSchema(int index) {
        anyOfSchemas.remove(index);
    }

    @Override
    public boolean isAnyOfSchemaReference(int index) {
        return anyOfSchemas.getChild(index).isReference();
    }

    @Override
    public Reference getAnyOfSchemaReference(int index) {
        return anyOfSchemas.getChild(index).getReference();
    }

    // NotSchema
    @Override
    public Schema getNotSchema() {
        return notSchema.get();
    }

    @Override
    public Schema getNotSchema(boolean elaborate) {
        return notSchema.get(elaborate);
    }

    @Override
    public void setNotSchema(Schema notSchema) {
        this.notSchema.set(notSchema);
    }

    @Override
    public boolean isNotSchemaReference() {
        return notSchema != null ? notSchema.isReference() : false;
    }

    @Override
    public Reference getNotSchemaReference() {
        return notSchema != null ? notSchema.getReference() : null;
    }

    // ItemsSchema
    @Override
    public Schema getItemsSchema() {
        return itemsSchema.get();
    }

    @Override
    public Schema getItemsSchema(boolean elaborate) {
        return itemsSchema.get(elaborate);
    }

    @Override
    public void setItemsSchema(Schema itemsSchema) {
        this.itemsSchema.set(itemsSchema);
    }

    @Override
    public boolean isItemsSchemaReference() {
        return itemsSchema != null ? itemsSchema.isReference() : false;
    }

    @Override
    public Reference getItemsSchemaReference() {
        return itemsSchema != null ? itemsSchema.getReference() : null;
    }

    // Property
    @Override
    public Map<String, Schema> getProperties() {
        return properties.get();
    }

    @Override
    public Map<String, Schema> getProperties(boolean elaborate) {
        return properties.get(elaborate);
    }

    @Override
    public boolean hasProperty(String name) {
        return properties.containsKey(name);
    }

    @Override
    public Schema getProperty(String name) {
        return properties.get(name);
    }

    @Override
    public void setProperties(Map<String, Schema> properties) {
        this.properties.set(properties);
    }

    @Override
    public void setProperty(String name, Schema property) {
        properties.set(name, property);
    }

    @Override
    public void removeProperty(String name) {
        properties.remove(name);
    }

    @Override
    public boolean isPropertyReference(String key) {
        ChildOverlay<Schema, SchemaImpl> child = properties.getChild(key);
        return child != null ? child.isReference() : false;
    }

    @Override
    public Reference getPropertyReference(String key) {
        ChildOverlay<Schema, SchemaImpl> child = properties.getChild(key);
        return child != null ? child.getReference() : null;
    }

    // AdditionalPropertiesSchema
    @Override
    public Schema getAdditionalPropertiesSchema() {
        return additionalPropertiesSchema.get();
    }

    @Override
    public Schema getAdditionalPropertiesSchema(boolean elaborate) {
        return additionalPropertiesSchema.get(elaborate);
    }

    @Override
    public void setAdditionalPropertiesSchema(Schema additionalPropertiesSchema) {
        this.additionalPropertiesSchema.set(additionalPropertiesSchema);
    }

    @Override
    public boolean isAdditionalPropertiesSchemaReference() {
        return additionalPropertiesSchema != null ? additionalPropertiesSchema.isReference() : false;
    }

    @Override
    public Reference getAdditionalPropertiesSchemaReference() {
        return additionalPropertiesSchema != null ? additionalPropertiesSchema.getReference() : null;
    }

    // AdditionalProperties
    @Override
    public Boolean getAdditionalProperties() {
        return additionalProperties.get();
    }

    @Override
    public Boolean getAdditionalProperties(boolean elaborate) {
        return additionalProperties.get(elaborate);
    }

    @Override
    public boolean isAdditionalProperties() {
        return additionalProperties.get() != null ? additionalProperties.get() : false;
    }

    @Override
    public void setAdditionalProperties(Boolean additionalProperties) {
        this.additionalProperties.set(additionalProperties);
    }

    // Description
    @Override
    public String getDescription() {
        return description.get();
    }

    @Override
    public String getDescription(boolean elaborate) {
        return description.get(elaborate);
    }

    @Override
    public void setDescription(String description) {
        this.description.set(description);
    }

    // Format
    @Override
    public String getFormat() {
        return format.get();
    }

    @Override
    public String getFormat(boolean elaborate) {
        return format.get(elaborate);
    }

    @Override
    public void setFormat(String format) {
        this.format.set(format);
    }

    // Default
    @Override
    public Object getDefault() {
        return defaultValue.get();
    }

    @Override
    public Object getDefault(boolean elaborate) {
        return defaultValue.get(elaborate);
    }

    @Override
    public void setDefault(Object defaultValue) {
        this.defaultValue.set(defaultValue);
    }

    // Nullable
    @Override
    public Boolean getNullable() {
        return nullable.get();
    }

    @Override
    public Boolean getNullable(boolean elaborate) {
        return nullable.get(elaborate);
    }

    @Override
    public boolean isNullable() {
        return nullable.get() != null ? nullable.get() : false;
    }

    @Override
    public void setNullable(Boolean nullable) {
        this.nullable.set(nullable);
    }

    // Discriminator
    @Override
    public String getDiscriminator() {
        return discriminator.get();
    }

    @Override
    public String getDiscriminator(boolean elaborate) {
        return discriminator.get(elaborate);
    }

    @Override
    public void setDiscriminator(String discriminator) {
        this.discriminator.set(discriminator);
    }

    // ReadOnly
    @Override
    public Boolean getReadOnly() {
        return readOnly.get();
    }

    @Override
    public Boolean getReadOnly(boolean elaborate) {
        return readOnly.get(elaborate);
    }

    @Override
    public boolean isReadOnly() {
        return readOnly.get() != null ? readOnly.get() : false;
    }

    @Override
    public void setReadOnly(Boolean readOnly) {
        this.readOnly.set(readOnly);
    }

    // WriteOnly
    @Override
    public Boolean getWriteOnly() {
        return writeOnly.get();
    }

    @Override
    public Boolean getWriteOnly(boolean elaborate) {
        return writeOnly.get(elaborate);
    }

    @Override
    public boolean isWriteOnly() {
        return writeOnly.get() != null ? writeOnly.get() : false;
    }

    @Override
    public void setWriteOnly(Boolean writeOnly) {
        this.writeOnly.set(writeOnly);
    }

    // Xml
    @Override
    public Xml getXml() {
        return xml.get();
    }

    @Override
    public Xml getXml(boolean elaborate) {
        return xml.get(elaborate);
    }

    @Override
    public void setXml(Xml xml) {
        this.xml.set(xml);
    }

    // ExternalDocs
    @Override
    public ExternalDocs getExternalDocs() {
        return externalDocs.get();
    }

    @Override
    public ExternalDocs getExternalDocs(boolean elaborate) {
        return externalDocs.get(elaborate);
    }

    @Override
    public void setExternalDocs(ExternalDocs externalDocs) {
        this.externalDocs.set(externalDocs);
    }

    // Example
    @Override
    public Map<String, Example> getExamples() {
        return examples.get();
    }

    @Override
    public Map<String, Example> getExamples(boolean elaborate) {
        return examples.get(elaborate);
    }

    @Override
    public boolean hasExample(String name) {
        return examples.containsKey(name);
    }

    @Override
    public Example getExample(String name) {
        return examples.get(name);
    }

    @Override
    public void setExamples(Map<String, Example> examples) {
        this.examples.set(examples);
    }

    @Override
    public void setExample(String name, Example example) {
        examples.set(name, example);
    }

    @Override
    public void removeExample(String name) {
        examples.remove(name);
    }

    // Example
    @Override
    public Object getExample() {
        return example.get();
    }

    @Override
    public Object getExample(boolean elaborate) {
        return example.get(elaborate);
    }

    @Override
    public void setExample(Object example) {
        this.example.set(example);
    }

    // Deprecated
    @Override
    public Boolean getDeprecated() {
        return deprecated.get();
    }

    @Override
    public Boolean getDeprecated(boolean elaborate) {
        return deprecated.get(elaborate);
    }

    @Override
    public boolean isDeprecated() {
        return deprecated.get() != null ? deprecated.get() : false;
    }

    @Override
    public void setDeprecated(Boolean deprecated) {
        this.deprecated.set(deprecated);
    }

    // Extension
    @Override
    public Map<String, Object> getExtensions() {
        return extensions.get();
    }

    @Override
    public Map<String, Object> getExtensions(boolean elaborate) {
        return extensions.get(elaborate);
    }

    @Override
    public boolean hasExtension(String name) {
        return extensions.containsKey(name);
    }

    @Override
    public Object getExtension(String name) {
        return extensions.get(name);
    }

    @Override
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions.set(extensions);
    }

    @Override
    public void setExtension(String name, Object extension) {
        extensions.set(name, extension);
    }

    @Override
    public void removeExtension(String name) {
        extensions.remove(name);
    }

    @Override
    protected void elaborateChildren() {
        title = createChild("title", this, StringOverlay.factory);
        multipleOf = createChild("multipleOf", this, NumberOverlay.factory);
        maximum = createChild("maximum", this, NumberOverlay.factory);
        exclusiveMaximum = createChild("exclusiveMaximum", this, BooleanOverlay.factory);
        minimum = createChild("minimum", this, NumberOverlay.factory);
        exclusiveMinimum = createChild("exclusiveMinimum", this, BooleanOverlay.factory);
        maxLength = createChild("maxLength", this, IntegerOverlay.factory);
        minLength = createChild("minLength", this, IntegerOverlay.factory);
        pattern = createChild("pattern", this, StringOverlay.factory);
        maxItems = createChild("maxItems", this, IntegerOverlay.factory);
        minItems = createChild("minItems", this, IntegerOverlay.factory);
        uniqueItems = createChild("uniqueItems", this, BooleanOverlay.factory);
        maxProperties = createChild("maxProperties", this, IntegerOverlay.factory);
        minProperties = createChild("minProperties", this, IntegerOverlay.factory);
        requiredFields = createChildList("required", this, StringOverlay.factory);
        enums = createChildList("enum", this, ObjectOverlay.factory);
        type = createChild("type", this, StringOverlay.factory);
        allOfSchemas = createChildList("allOf", this, SchemaImpl.factory);
        refables.put("allOf", allOfSchemas);
        oneOfSchemas = createChildList("oneOf", this, SchemaImpl.factory);
        refables.put("oneOf", oneOfSchemas);
        anyOfSchemas = createChildList("anyOf", this, SchemaImpl.factory);
        refables.put("anyOf", anyOfSchemas);
        notSchema = createChild("not", this, SchemaImpl.factory);
        refables.put("not", notSchema);
        itemsSchema = createChild("items", this, SchemaImpl.factory);
        refables.put("items", itemsSchema);
        properties = createChildMap("properties", this, SchemaImpl.factory, null);
        refables.put("properties", properties);
        additionalPropertiesSchema = createChild(json.at("/additionalProperties").isObject(), "additionalProperties", this, SchemaImpl.factory);
        refables.put("additionalProperties", additionalPropertiesSchema);
        additionalProperties = createChild(json.at("/additionalProperties").isBoolean(), "additionalProperties", this, BooleanOverlay.factory);
        description = createChild("description", this, StringOverlay.factory);
        format = createChild("format", this, StringOverlay.factory);
        defaultValue = createChild("default", this, ObjectOverlay.factory);
        nullable = createChild("nullable", this, BooleanOverlay.factory);
        discriminator = createChild("discriminator", this, StringOverlay.factory);
        readOnly = createChild("readOnly", this, BooleanOverlay.factory);
        writeOnly = createChild("writeOnly", this, BooleanOverlay.factory);
        xml = createChild("xml", this, XmlImpl.factory);
        externalDocs = createChild("externalDocs", this, ExternalDocsImpl.factory);
        examples = createChildMap("examples", this, ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");
        example = createChild("example", this, ObjectOverlay.factory);
        deprecated = createChild("deprecated", this, BooleanOverlay.factory);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<Schema, SchemaImpl> factory = new OverlayFactory<Schema, SchemaImpl>() {
        @Override
        protected Class<? super SchemaImpl> getOverlayClass() {
            return SchemaImpl.class;
        }

        @Override
        public SchemaImpl _create(Schema schema, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new SchemaImpl(schema, parent, refReg);
        }

        @Override
        public SchemaImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new SchemaImpl(json, parent, refReg);
        }
    };

}
