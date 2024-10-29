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

import com.networknt.oas.model.OAuthFlow;
import com.networknt.oas.validator.ObjectValidatorBase;

import static com.networknt.oas.model.impl.OAuthFlowImpl.*;

public class OAuthFlowValidator extends ObjectValidatorBase<OAuthFlow> {

	@Override
	public void runObjectValidations() {
		OAuthFlow oauthFlow = (OAuthFlow) value.getOverlay();
		validateUrlField(F_authorizationUrl, true, true, false);
		validateUrlField(F_tokenUrl, true, true, false);
		validateUrlField(F_refreshUrl, false, true, false);
		validateMapField(F_scopes, true, false, String.class, null);
		validateExtensions(oauthFlow.getExtensions());
	}
}
