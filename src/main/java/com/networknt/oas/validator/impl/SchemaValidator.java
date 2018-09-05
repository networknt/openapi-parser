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
package com.networknt.oas.validator.impl;

import com.networknt.oas.model.Discriminator;
import com.networknt.oas.model.ExternalDocs;
import com.networknt.oas.model.Schema;
import com.networknt.oas.model.Xml;
import com.networknt.oas.validator.ObjectValidatorBase;

import static com.networknt.oas.model.impl.SchemaImpl.*;
import static com.networknt.oas.validator.impl.OpenApi3Messages.ROnlyAndWOnly;
import static com.networknt.oas.validator.msg.Messages.msg;

public class SchemaValidator extends ObjectValidatorBase<Schema> {

	@Override
	public void runObjectValidations() {
		Schema schema = (Schema) value.getOverlay();
		validateStringField(F_title, false);
		validateStringField(F_description, false);
		validateNumericField(F_maximum, false, null, null);
		validateBooleanField(F_exclusiveMaximum, false);
		validateNumericField(F_minimum, false, null, null);
		validateBooleanField(F_exclusiveMinimum, false);
		validateBooleanField(F_uniqueItems, false);
		validateBooleanField(F_nullable, false);
		validateField(F_example, false, Object.class, null);
		validateBooleanField(F_deprecated, false);
		validatePositiveField(F_multipleOf, false);
		validateNonNegativeField(F_maxLength, false);
		validateNonNegativeField(F_minLength, false);
		validatePatternField(F_pattern, false);
		validateNonNegativeField(F_maxItems, false);
		validateNonNegativeField(F_minItems, false);
		validateNonNegativeField(F_maxProperties, false);
		validateNonNegativeField(F_minProperties, false);
		validateListField(F_requiredFields, false, true, String.class, null);
		validateListField(F_enums, false, true, Object.class, null);
		validateStringField(F_type, false, "boolean|object|array|number|integer|string");
		{
			SchemaValidator schemaValidator = new SchemaValidator();
			validateListField(F_allOfSchemas, false, false, Schema.class, schemaValidator);
			validateListField(F_oneOfSchemas, false, false, Schema.class, schemaValidator);
			validateListField(F_anyOfSchemas, false, false, Schema.class, schemaValidator);
			validateField(F_notSchema, false, Schema.class, schemaValidator);
			validateField(F_itemsSchema, false, Schema.class, schemaValidator);
			validateMapField(F_properties, false, false, Schema.class, schemaValidator);
		}
		validateFormatField(F_format, false, schema.getType());
		validateField(F_defaultValue, false, Object.class, null, field -> checkDefault(field, schema.getType()));
		validateField(F_discriminator, false, Discriminator.class, new DiscriminatorValidator());
		checkReadWrite(schema);
		validateField(F_xml, false, Xml.class, new XmlValidator());
		validateField(F_externalDocs, false, ExternalDocs.class, new ExternalDocsValidator());
		validateExtensions(schema.getExtensions());
	}

	private void checkReadWrite(Schema schema) {
		if (schema.isReadOnly() && schema.isWriteOnly()) {
			results.addError(msg(ROnlyAndWOnly), value);
		}
	}
}
