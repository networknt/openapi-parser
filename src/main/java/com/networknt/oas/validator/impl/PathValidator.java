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

import com.networknt.oas.model.Operation;
import com.networknt.oas.model.Parameter;
import com.networknt.oas.model.Path;
import com.networknt.oas.model.Server;
import com.networknt.oas.validator.ObjectValidatorBase;

import static com.networknt.oas.model.impl.PathImpl.*;

public class PathValidator extends ObjectValidatorBase<Path> {

	@Override
	public void runObjectValidations() {
		Path path = (Path) value.getOverlay();
		validateStringField(F_summary, false);
		validateStringField(F_description, false);
		validateMapField(F_operations, false, false, Operation.class, new OperationValidator());
		validateListField(F_servers, false, false, Server.class, new ServerValidator());
		validateListField(F_parameters, false, false, Parameter.class, new ParameterValidator());
		validateExtensions(path.getExtensions());
	}
}
