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
import com.networknt.oas.validator.ValidationResults;
import com.networknt.oas.validator.Validator;
import com.networknt.service.SingletonServiceFactory;

public class RequestBodyValidator extends ObjectValidatorBase<RequestBody> {

    private static Validator<MediaType> mediaTypeValidator = SingletonServiceFactory.getBean(Validator.class, MediaType.class);

    @Override
    public void validateObject(RequestBody requestBody, ValidationResults results) {
        // no validation for: description, required
        validateMap(requestBody.getContentMediaTypes(false), results, false, "content", Regexes.NOEXT_REGEX,
                mediaTypeValidator);
        validateExtensions(requestBody.getExtensions(false), results);
    }

}
