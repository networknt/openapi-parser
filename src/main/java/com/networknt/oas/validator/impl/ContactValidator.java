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
import com.networknt.oas.validator.ObjectValidatorBase;
import com.networknt.oas.validator.ValidationResults;

public class ContactValidator extends ObjectValidatorBase<Contact> {

    @Override
    public void validateObject(Contact contact, ValidationResults results) {
        validateUrl(contact.getUrl(false), results, false, "url");
        validateEmail(contact.getEmail(false), results, false, "email");
        validateExtensions(contact.getExtensions(false), results);
    }

}
