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

import com.networknt.oas.model.License;
import com.networknt.oas.validator.ObjectValidatorBase;

import static com.networknt.oas.model.impl.LicenseImpl.F_name;
import static com.networknt.oas.model.impl.LicenseImpl.F_url;

public class LicenseValidator extends ObjectValidatorBase<License> {

	@Override
	public void runObjectValidations() {
		License license = (License) value.getOverlay();
		validateStringField(F_name, true);
		validateUrlField(F_url, false, true, false);
		validateExtensions(license.getExtensions());
	}

}
