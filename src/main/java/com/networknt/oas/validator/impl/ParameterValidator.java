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

import com.networknt.jsonoverlay.Overlay;
import com.networknt.jsonoverlay.PropertiesOverlay;
import com.networknt.oas.model.*;
import com.networknt.oas.validator.ObjectValidatorBase;

import java.util.Map;

import static com.networknt.oas.model.impl.ParameterImpl.*;
import static com.networknt.oas.validator.impl.OpenApi3Messages.NoPath;
import static com.networknt.oas.validator.impl.OpenApi3Messages.PathParamReq;
import static com.networknt.oas.validator.msg.Messages.msg;

public class ParameterValidator extends ObjectValidatorBase<Parameter> {

	@Override
	public void runObjectValidations() {
		Parameter parameter = (Parameter) value.getOverlay();
		validateStringField(F_description, false);
		validateBooleanField(F_deprecated, false);
		validateBooleanField(F_allowEmptyValue, false);
		validateBooleanField(F_explode, false);
		Overlay<Object> example = validateField(F_example, false, Object.class, null);
		Overlay<Map<String, Example>> examples = validateMapField(F_examples, false, false, Example.class,
				new ExampleValidator());
		checkExampleExclusion(examples, example);
		validateStringField(F_name, true);
		validateStringField(F_in, true, Regexes.PARAM_IN_REGEX);
		checkPathParam(parameter);
		checkRequired(parameter);
		validateStringField(F_style, false, Regexes.STYLE_REGEX);
		checkAllowReserved(parameter);
		// TODO Q: Should schema be required in parameter object?
		validateField(F_schema, false, Schema.class, new SchemaValidator());
		validateMapField(F_contentMediaTypes, false, false, MediaType.class, new MediaTypeValidator());
		validateExtensions(parameter.getExtensions());
	}

	private void checkPathParam(Parameter parameter) {
		if (parameter.getIn() != null && parameter.getIn().equals("path") && parameter.getName() != null) {
			String path = getPathString(parameter);
			if (path != null) {
				if (!path.matches(".*/\\{" + parameter.getName() + "\\}(/.*)?")) {
					results.addError(msg(OpenApi3Messages.MissingPathTplt, parameter.getName(), path), value);
				}
			} else {
				results.addWarning(msg(NoPath, parameter.getName(), parameter.getIn()), value);
			}
		}
	}

	private void checkRequired(Parameter parameter) {
		if ("path".equals(parameter.getIn())) {
			if (parameter.getRequired() != Boolean.TRUE) {
				results.addError(msg(PathParamReq, parameter.getName()), value);
			}
		}
	}

	private void checkAllowReserved(Parameter parameter) {
		if (parameter.isAllowReserved() && !"query".equals(parameter.getIn())) {
			results.addWarning(msg(OpenApi3Messages.NonQryAllowRsvd, parameter.getName(), parameter.getIn()), value);
		}
	}

	private String getPathString(Parameter parameter) {
		PropertiesOverlay<?> parent = Overlay.of(parameter).getParentPropertiesOverlay();
		while (parent != null && !(parent instanceof Path)) {
			parent = Overlay.of(parent).getParentPropertiesOverlay();
		}
		return parent != null && parent instanceof Path ? Overlay.getPathInParent(parent) : null;
	}

	void checkExampleExclusion(Overlay<Map<String, Example>> examples, Overlay<Object> example) {
		boolean examplesPresent = examples != null && examples.isPresent()
				&& Overlay.getMapOverlay(examples).size() > 0;
		boolean examplePresent = example != null && example.isPresent();
		if (examplesPresent && examplePresent) {
			results.addError("ExmplExclusion|The 'example' and 'exmaples' properties may not both appear", value);
		}
	}
}
