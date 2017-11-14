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
import com.networknt.oas.validator.ValidationResults;
import com.networknt.oas.validator.Validator;
import com.networknt.service.SingletonServiceFactory;

public class PathValidator extends ObjectValidatorBase<Path> {

    private static Validator<Operation> operationValidator = SingletonServiceFactory.getBean(Validator.class, Operation.class);
    private static Validator<Server> serverValidator = SingletonServiceFactory.getBean(Validator.class, Server.class);
    private static Validator<Parameter> parameterValidator = SingletonServiceFactory.getBean(Validator.class, Parameter.class);

    @Override
    public void validateObject(Path path, ValidationResults results) {
        // no validation for: summary, description
        validateMap(path.getOperations(false), results, false, null, Regexes.METHOD_REGEX, operationValidator);
        validateList(path.getServers(false), path.hasServers(), results, false, "servers", serverValidator);
        validateList(path.getParameters(false), path.hasParameters(), results, false, "parameters", parameterValidator);
        validateExtensions(path.getExtensions(false), results);
    }
}
