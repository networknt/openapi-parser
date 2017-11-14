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

import com.networknt.oas.model.Callback;
import com.networknt.oas.model.Path;
import com.networknt.oas.validator.ObjectValidatorBase;
import com.networknt.oas.validator.ValidationResults;
import com.networknt.oas.validator.Validator;
import com.networknt.service.SingletonServiceFactory;

public class CallbackValidator extends ObjectValidatorBase<Callback> {

    private static Validator<Path> pathValidator = SingletonServiceFactory.getBean(Validator.class, Path.class);

    @Override
    public void validateObject(Callback callback, ValidationResults results) {
        validateMap(callback.getCallbackPaths(false), results, false, null, Regexes.NOEXT_REGEX, pathValidator);
        validateExtensions(callback.getExtensions(false), results);
    }

}
