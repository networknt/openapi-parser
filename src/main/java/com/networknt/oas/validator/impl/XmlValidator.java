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

import com.networknt.oas.model.Xml;
import com.networknt.oas.model.impl.XmlImpl;
import com.networknt.oas.validator.ObjectValidatorBase;

import static com.networknt.oas.model.impl.XmlImpl.*;

public class XmlValidator extends ObjectValidatorBase<Xml> {

	@Override
	public void runObjectValidations() {
		Xml xml = (Xml) value.getOverlay();
		validateStringField(F_name, false);
		validateStringField(F_prefix, false);
		validateBooleanField(F_attribute, false);
		validateBooleanField(XmlImpl.F_wrapped, false);
		validateUrlField(F_namespace, false, true, false);
		validateExtensions(xml.getExtensions());
	}
}
