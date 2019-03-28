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

import java.util.Arrays;
import java.util.Collection;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.networknt.jsonoverlay.Overlay;
import com.networknt.oas.model.SecurityParameter;
import com.networknt.oas.validator.ObjectValidatorBase;

import static com.networknt.oas.model.impl.SecurityParameterImpl.F_parameters;

public class SecurityParameterValidator extends ObjectValidatorBase<SecurityParameter> {

	@Override
	public void runObjectValidations() {
		validateListField(F_parameters, false, false, String.class, null);
	}

	@Override
	protected Collection<Class<? extends JsonNode>> getAllowedJsonTypes(Overlay<?> value) {
		// SecurityParameter is the odd case of a ParametersOverlay that is not formed
		// from an object. It's the value type of the security requirement map, and that
		// value comes in the form of a JSON array. The SecurityParameter type exposes
		// that type as a list valued property named "parameters". There's no object
		// containing that property.Hence we need to specify the expected JsonNode type
		return Arrays.asList(ArrayNode.class);
	}

}
