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

import static com.networknt.oas.model.impl.HeaderImpl.*;
import static com.networknt.oas.validator.impl.OpenApi3Messages.IgnContType;
import static com.networknt.oas.validator.impl.OpenApi3Messages.NonQryAllowRsvd;
import static com.networknt.oas.validator.msg.Messages.msg;


public class HeaderValidator extends ObjectValidatorBase<Header> {

	@Override
	public void runObjectValidations() {
		Header header = (Header) value.getOverlay();
		validateStringField(F_description, false);
		validateBooleanField(F_deprecated, false);
		validateBooleanField(F_allowEmptyValue, false);
		validateBooleanField(F_explode, false);
		validateField(F_example, false, Object.class, null);
		validateMapField(F_examples, false, false, Example.class, new ExampleValidator());
		validateStringField(F_style, false, Regexes.STYLE_REGEX);
		checkAllowReserved(header);
		// TODO Q: Should schema be required in header object?
		validateField(F_schema, false, Schema.class, new SchemaValidator());
		validateMapField(F_contentMediaTypes, false, false, MediaType.class, new MediaTypeValidator());
		validateExtensions(header.getExtensions());
		checkContentType();
		// TODO validate that location-related values (like style) are consistent with
		// header location
		// TODO warn if this appears on a request body whose media type is not multipart
	}

	private void checkAllowReserved(Header header) {
		// TODO Q: Shouldn't "allowReserved" be disallowed for headers, as are "name"
		// and "in"?
		if (header.isAllowReserved()) {
			results.addWarning(msg(NonQryAllowRsvd, value.getPathInParent(), "header"), value);
		}
	}

	private void checkContentType() {
		if (value.getPathInParent().equalsIgnoreCase("Content-Type")) {
			results.addWarning(msg(IgnContType), value);
		}
	}
}
