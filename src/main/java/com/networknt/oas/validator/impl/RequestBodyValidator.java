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

import com.networknt.oas.model.MediaType;
import com.networknt.oas.model.RequestBody;
import com.networknt.oas.validator.ObjectValidatorBase;

import static com.networknt.oas.model.impl.RequestBodyImpl.F_contentMediaTypes;
import static com.networknt.oas.model.impl.RequestBodyImpl.F_description;
import static com.networknt.oas.model.impl.RequestBodyImpl.F_required;

public class RequestBodyValidator extends ObjectValidatorBase<RequestBody> {

	@Override
	public void runObjectValidations() {
		RequestBody requestBody = (RequestBody) value.getOverlay();
		validateStringField(F_description, false);
		validateBooleanField(F_required, false);
		validateMapField(F_contentMediaTypes, false, false, MediaType.class, new MediaTypeValidator());
		validateExtensions(requestBody.getExtensions());
	}
}
