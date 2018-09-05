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

import static com.networknt.oas.model.impl.ContactImpl.F_email;
import static com.networknt.oas.model.impl.ContactImpl.F_name;
import static com.networknt.oas.model.impl.ContactImpl.F_url;

public class ContactValidator extends ObjectValidatorBase<Contact> {

	@Override
	public void runObjectValidations() {
		Contact contact = (Contact) value.getOverlay();
		validateStringField(F_name, false);
		validateUrlField(F_url, false, true, false);
		validateEmailField(F_email, false);
		validateExtensions(contact.getExtensions());
	}
}
