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
import com.networknt.oas.model.Example;
import com.networknt.oas.validator.ObjectValidatorBase;

import static com.networknt.oas.model.impl.ExampleImpl.*;
import static com.networknt.oas.validator.impl.OpenApi3Messages.ExampleNoValue;
import static com.networknt.oas.validator.impl.OpenApi3Messages.ExmplTwoValues;
import static com.networknt.oas.validator.msg.Messages.msg;

public class ExampleValidator extends ObjectValidatorBase<Example> {

	@Override
	public void runObjectValidations() {
		Example example = (Example) value.getOverlay();
		validateStringField(F_summary, false);
		validateStringField(F_description, false);
		Overlay<Object> valueField = validateField(F_value, false, Object.class, null);
		Overlay<String> externalField = validateUrlField(F_externalValue, false, true, false);
		validateExtensions(example.getExtensions());
		checkExactlyOneValue(valueField, externalField);
		// TODO check that a direct value is compatible with the containng parameter or
		// media type (not entirely clear how to approach this)
	}

	private void checkExactlyOneValue(Overlay<Object> valueField, Overlay<String> externalField) {
		boolean valuePresent = valueField != null & valueField.isPresent();
		boolean externalPresent = externalField != null && externalField.isPresent();
		if (valuePresent && externalPresent) {
			results.addError(msg(ExmplTwoValues), value);
		} else if (!valuePresent && !externalPresent) {
			// the specification doesn't actually state that a value is required, but the
			// object seems pointless without one, so we'll go with a warning
			results.addWarning(msg(ExampleNoValue), value);
		}
	}
}
