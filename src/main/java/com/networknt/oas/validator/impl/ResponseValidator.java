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
import com.networknt.oas.validator.ValidationResults;
import com.networknt.oas.validator.Validator;
import com.networknt.service.SingletonServiceFactory;

public class ResponseValidator extends ObjectValidatorBase<Response> {

    private static Validator<Header> headerValidator = SingletonServiceFactory.getBean(Validator.class, Header.class);
    private static Validator<MediaType> mediaTypeValidator = SingletonServiceFactory.getBean(Validator.class, MediaType.class);
    private static Validator<Link> linkValidator = SingletonServiceFactory.getBean(Validator.class, Link.class);

    @Override
    public void validateObject(Response response, ValidationResults results) {
        validateMap(response.getHeaders(false), results, false, "headers", null, headerValidator);
        validateMap(response.getContentMediaTypes(false), results, false, "content", Regexes.NOEXT_REGEX,
                mediaTypeValidator);
        validateMap(response.getLinks(false), results, false, "links", Regexes.NOEXT_NAME_REGEX, linkValidator);
        validateExtensions(response.getExtensions(false), results);
    }
}
