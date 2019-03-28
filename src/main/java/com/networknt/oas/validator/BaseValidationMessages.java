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
package com.networknt.oas.validator;

import com.networknt.oas.validator.msg.Messages;

public enum BaseValidationMessages implements Messages {
	WrongTypeJson("Incorrect JSON value type: %1; allowed types: %2"), //
	BadRef("Reference '%1' could not be resolved: %2"), //
	PatternMatchFail("Value '%1' does not match required pattern '%2'"), //
	BadPattern("Pattern is not a valid Java Regular Expression but may be valid in ECMA 262: %1"), //
	BadUrl("Invalid URL '%1': %2"), //
	BadEmail("Invalid email address '%1': %2"), //
	NumberConstraint("Value %1 must be %2"), //
	EmptyList("List may not be empty"), //
	DuplicateValue("Value at '%2' appeared already: %1"), //
	MissingField("Required field '%1' is missing"), //
	WrongTypeFormat("OpenAPI-defined format '%1' requires type '%3' but appears with missing or invalid type %2"), //
	WrongTypeValue("Value is incompatible with schema type"), //
	NoRelUrl("URL must not be a relative URL: %1");

	private String formatString;

	BaseValidationMessages(String formatString) {
		this.formatString = formatString;
	}

	@Override
	public String getFormatString() {
		return formatString;
	}

}
