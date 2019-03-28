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

import com.networknt.oas.model.Discriminator;
import com.networknt.oas.model.impl.DiscriminatorImpl;
import com.networknt.oas.validator.ValidatorBase;

public class DiscriminatorValidator extends ValidatorBase<Discriminator> {

	@Override
	public void runValidations() {
		validateStringField(DiscriminatorImpl.F_propertyName, true);
		validateMapField("mappings", false, false, String.class, null);
	}
}
