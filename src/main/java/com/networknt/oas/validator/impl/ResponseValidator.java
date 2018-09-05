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

import com.networknt.oas.model.Header;
import com.networknt.oas.model.Link;
import com.networknt.oas.model.MediaType;
import com.networknt.oas.model.Response;
import com.networknt.oas.validator.ObjectValidatorBase;

import static com.networknt.oas.model.impl.ResponseImpl.*;

public class ResponseValidator extends ObjectValidatorBase<Response> {

	@Override
	public void runObjectValidations() {
		Response response = (Response) value.getOverlay();
		validateStringField(F_description, false);
		validateMapField(F_headers, false, false, Header.class, new HeaderValidator());
		validateMapField(F_contentMediaTypes, false, false, MediaType.class, new MediaTypeValidator());
		validateMapField(F_links, false, false, Link.class, new LinkValidator());
		validateExtensions(response.getExtensions());
	}
}
