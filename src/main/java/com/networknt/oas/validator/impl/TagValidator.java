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

import com.networknt.oas.model.ExternalDocs;
import com.networknt.oas.model.Tag;
import com.networknt.oas.validator.ObjectValidatorBase;
import com.networknt.oas.validator.ValidationResults;
import com.networknt.oas.validator.Validator;
import com.networknt.service.SingletonServiceFactory;

public class TagValidator extends ObjectValidatorBase<Tag> {

    private static Validator<ExternalDocs> externalDocsValidator = SingletonServiceFactory.getBean(Validator.class, ExternalDocs.class);

    @Override
    public void validateObject(Tag tag, ValidationResults results) {
        validateString(tag.getName(false), results, true, "name");
        validateField(tag.getExternalDocs(false), results, false, "externalDocs", externalDocsValidator);
        validateExtensions(tag.getExtensions(false), results);
    }

}
