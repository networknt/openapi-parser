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

import com.networknt.oas.model.EncodingProperty;
import com.networknt.oas.model.Header;
import com.networknt.oas.validator.ObjectValidatorBase;

import static com.networknt.oas.model.impl.EncodingPropertyImpl.*;
import static com.networknt.oas.model.impl.ParameterImpl.F_allowReserved;

public class EncodingPropertyValidator extends ObjectValidatorBase<EncodingProperty> {

	@Override
	public void runObjectValidations() {
		EncodingProperty encodingProperty = (EncodingProperty) value.getOverlay();

		// TODO ought to have a pattern for acceptable values "a/b", "a/*", comma-lists
		// of those.
		validateStringField(F_contentType, false);

		// TODO Q: spec says "Headers" (capitalized) for property name -assuming it's a
		// typo
		validateMapField(F_headers, false, false, Header.class, null);
		validateStringField(F_style, false, Regexes.STYLE_REGEX);
		validateBooleanField(F_explode, false);
		validateBooleanField(F_allowReserved, false);
		validateExtensions(encodingProperty.getExtensions());
	}

}
