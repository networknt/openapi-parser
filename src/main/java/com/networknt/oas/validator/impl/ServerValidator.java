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
import com.networknt.oas.validator.ValidationResults;
import com.networknt.oas.validator.Validator;
import com.networknt.service.SingletonServiceFactory;

import static com.networknt.oas.validator.impl.Regexes.NAME_REGEX;

public class ServerValidator extends ObjectValidatorBase<Server> {

    private static Validator<ServerVariable> serverVariableValidator = SingletonServiceFactory.getBean(Validator.class, ServerVariable.class);

    @Override
    public void validateObject(Server server, ValidationResults results) {
        // no validation for: description
        validateUrl(server.getUrl(false), results, false, "url", true);
        validateMap(server.getServerVariables(false), results, false, "variables", NAME_REGEX, serverVariableValidator);
        validateExtensions(server.getExtensions(false), results);
    }
}
