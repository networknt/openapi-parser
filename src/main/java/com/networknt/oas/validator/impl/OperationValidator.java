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

import static com.networknt.oas.model.impl.OperationImpl.*;

public class OperationValidator extends ObjectValidatorBase<Operation> {

	@Override
	public void runObjectValidations() {
		Operation operation = (Operation) value.getOverlay();
		validateListField(F_tags, false, false, String.class, null);
		validateStringField(F_summary, false);
		validateStringField(F_description, false);
		validateField(F_externalDocs, false, ExternalDocs.class, new ExternalDocsValidator());
		// TODO Q: Not marked as required in spec, but spec says they all must be unique
		// within the API. Seems like it should be required.
		validateStringField(F_operationId, false);
		validateListField(F_parameters, false, false, Parameter.class, new ParameterValidator());
		validateField(F_requestBody, false, RequestBody.class, new RequestBodyValidator());
		validateMapField(F_responses, true, false, Response.class, new ResponseValidator());
		validateMapField(F_callbacks, false, false, Callback.class, new CallbackValidator());
		validateListField(F_securityRequirements, false, false, SecurityRequirement.class,
				new SecurityRequirementValidator());
		validateListField(F_servers, false, false, Server.class, new ServerValidator());
		validateExtensions(operation.getExtensions());
	}
}
