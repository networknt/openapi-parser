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

import com.networknt.oas.model.*;
import com.networknt.oas.validator.ObjectValidatorBase;
import com.networknt.oas.validator.ValidationResults;
import com.networknt.oas.validator.Validator;
import com.networknt.service.SingletonServiceFactory;

import static com.networknt.oas.validator.Messages.m;

public class ParameterValidator extends ObjectValidatorBase<Parameter> {

	private static Validator<Schema> schemaValidator = SingletonServiceFactory.getBean(Validator.class, Schema.class);
	private static Validator<MediaType> mediaTypeValidator = SingletonServiceFactory.getBean(Validator.class, MediaType.class);

	@Override
	public void validateObject(Parameter parameter, ValidationResults results) {
		// no validations for: description, deprecated, allowEmptyValue, explode,
		// example, examples
		validateString(parameter.getName(false), results, true, "name");
		validateString(parameter.getIn(false), results, true, Regexes.PARAM_IN_REGEX, "in");
		checkPathParam(parameter, results);
		checkRequired(parameter, results);
		validateString(parameter.getStyle(false), results, false, Regexes.STYLE_REGEX, "style");
		checkAllowReserved(parameter, results);
		// TODO Q: Should schema be required in parameter object?
		validateField(parameter.getSchema(false), results, false, "schema", schemaValidator);
		validateMap(parameter.getContentMediaTypes(false), results, false, "content", Regexes.NOEXT_REGEX,
				mediaTypeValidator);
		validateExtensions(parameter.getExtensions(false), results);
	}

	private void checkPathParam(Parameter parameter, ValidationResults results) {
		if (parameter.getIn(false) != null && parameter.getIn(false).equals("path")
				&& parameter.getName(false) != null) {
			String path = getPathString(parameter);
			if (path != null) {
				if (!path.matches(".*/\\{" + parameter.getName(false) + "\\}(/.*)?")) {
					results.addError(m.msg("MissingPathTplt|No template for path parameter in path string",
							parameter.getName(false), path), "name");
				}
			} else {
				results.addWarning(m.msg("NoPath|Could not locate path for parameter", parameter.getName(false),
						parameter.getIn(false)));
			}
		}
	}

	private void checkRequired(Parameter parameter, ValidationResults results) {
		if ("path".equals(parameter.getIn(false))) {
			if (parameter.getRequired(false) != Boolean.TRUE) {
				results.addError(m.msg("PathParamReq|Path param must have 'required' property set true",
						parameter.getName(false)), "required");
			}
		}
	}

	private void checkAllowReserved(Parameter parameter, ValidationResults results) {
		if (parameter.isAllowReserved() && !"query".equals(parameter.getIn(false))) {
			results.addWarning(m.msg("NonQryAllowRsvd|AllowReserved is ignored for non-query parameter",
					parameter.getName(false), parameter.getIn(false)), "allowReserved");
		}
	}

	private String getPathString(Parameter parameter) {
		OpenApiObject<OpenApi3, ?> parent = (OpenApiObject<OpenApi3, ?>) parameter.getParentObject();
		while (parent != null && !(parent instanceof Path)) {
			parent = (OpenApiObject<OpenApi3, ?>) parent.getParentObject();
		}
		return parent instanceof Path ? parent.getPathInParent() : null;
	}
}
