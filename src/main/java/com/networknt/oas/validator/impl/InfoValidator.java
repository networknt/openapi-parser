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

import com.networknt.oas.model.Contact;
import com.networknt.oas.model.Info;
import com.networknt.oas.model.License;
import com.networknt.oas.validator.ObjectValidatorBase;
import com.networknt.oas.validator.ValidationResults;
import com.networknt.oas.validator.Validator;
import com.networknt.service.SingletonServiceFactory;

public class InfoValidator extends ObjectValidatorBase<Info> {

    private static Validator<Contact> contactValidator = SingletonServiceFactory.getBean(Validator.class, Contact.class);
    private static Validator<License> licenseValidator = SingletonServiceFactory.getBean(Validator.class, License.class);

    @Override
    public void validateObject(Info info, ValidationResults results) {
        validateString(info.getTitle(false), results, true, "title");
        validateField(info.getContact(false), results, false, "contact", contactValidator);
        validateField(info.getLicense(false), results, false, "license", licenseValidator);
        validateString(info.getVersion(false), results, true, "version");
        validateExtensions(info.getExtensions(false), results);
    }
}
