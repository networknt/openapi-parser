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

import static com.networknt.oas.validator.Messages.m;

import java.util.Set;

import com.networknt.oas.model.EncodingProperty;
import com.networknt.oas.model.Example;
import com.networknt.oas.model.MediaType;
import com.networknt.oas.model.Schema;
import com.networknt.oas.validator.ObjectValidatorBase;
import com.networknt.oas.validator.ValidationResults;
import com.networknt.oas.validator.Validator;
import com.networknt.service.SingletonServiceFactory;

public class MediaTypeValidator extends ObjectValidatorBase<MediaType> {

	private static Validator<Schema> schemaValidator = SingletonServiceFactory.getBean(Validator.class, Schema.class);
	private static Validator<EncodingProperty> encodingPropertyValidator = SingletonServiceFactory.getBean(Validator.class, EncodingProperty.class);
	private static Validator<Example> exampleValidator = SingletonServiceFactory.getBean(Validator.class, Example.class);

	@Override
	public void validateObject(MediaType mediaType, ValidationResults results) {
		// no validation for: example, examples
		// TODO Q: Should schema be required in media type?
		validateField(mediaType.getSchema(false), results, false, "schema", schemaValidator);
		validateMap(mediaType.getEncodingProperties(false), results, false, "encoding", Regexes.NOEXT_NAME_REGEX,
				encodingPropertyValidator);
		checkEncodingPropsAreProps(mediaType, results);
		validateExtensions(mediaType.getExtensions(false), results);
		validateMap(mediaType.getExamples(false), results, false, "examples", Regexes.NOEXT_NAME_REGEX,
				exampleValidator);
	}

	void checkEncodingPropsAreProps(MediaType mediaType, ValidationResults results) {
		// TODO Q: do allOf, anyOf, oneOf schemas participate? what about
		// additionalProperties?
		Schema schema = mediaType.getSchema(false);
		if (schema.isElaborated()) {
			Set<String> propNames = schema.getProperties(false).keySet();
			for (String encodingPropertyName : mediaType.getEncodingProperties(false).keySet()) {
				if (!propNames.contains(encodingPropertyName)) {
					results.addError(m.msg(
							"EncPropNotSchemaProp|Encoding property does not name a schema property for the media type",
							encodingPropertyName), encodingPropertyName);
				}
			}
		}
	}
}
