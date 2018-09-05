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

import com.networknt.oas.model.Server;
import com.networknt.oas.model.ServerVariable;
import com.networknt.oas.validator.ObjectValidatorBase;

import static com.networknt.oas.model.impl.ServerImpl.F_description;
import static com.networknt.oas.model.impl.ServerImpl.F_serverVariables;
import static com.networknt.oas.model.impl.ServerImpl.F_url;

public class ServerValidator extends ObjectValidatorBase<Server> {

	@Override
	public void runObjectValidations() {
		Server server = (Server) value.getOverlay();
		validateStringField(F_description, false);
		validateUrlField(F_url, true, true, true);
		validateMapField(F_serverVariables, false, false, ServerVariable.class, new ServerVariableValidator());
		validateExtensions(server.getExtensions());
	}
}
