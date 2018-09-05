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

import com.networknt.oas.model.Callback;
import com.networknt.oas.model.Path;
import com.networknt.oas.validator.ObjectValidatorBase;
import com.networknt.oas.validator.ValidationResults;
import com.networknt.oas.validator.Validator;
import com.networknt.service.SingletonServiceFactory;

import static com.networknt.oas.model.impl.CallbackImpl.F_callbackPaths;

public class CallbackValidator extends ObjectValidatorBase<Callback> {

	@Override
	public void runObjectValidations() {
		Callback callback = (Callback) value.getOverlay();
		validateMapField(F_callbackPaths, false, false, Path.class, new PathValidator());
		validateExtensions(callback.getExtensions());
	}

}
