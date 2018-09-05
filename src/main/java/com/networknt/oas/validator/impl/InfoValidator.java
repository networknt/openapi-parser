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

import static com.networknt.oas.model.impl.InfoImpl.*;

public class InfoValidator extends ObjectValidatorBase<Info> {

	@Override
	public void runObjectValidations() {
		Info info = (Info) value.getOverlay();
		validateStringField(F_title, true);
		validateStringField(F_description, false);
		validateUrlField(F_termsOfService, false, true, false);
		validateField(F_contact, false, Contact.class, new ContactValidator());
		validateField(F_license, false, License.class, new LicenseValidator());
		validateStringField(F_version, true);
		validateExtensions(info.getExtensions());
	}
}
