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
import com.networknt.oas.validator.ValidationResults;

public class OAuthFlowValidator extends ObjectValidatorBase<OAuthFlow> {

    @Override
    public void validateObject(OAuthFlow oauthFlow, ValidationResults results) {
        validateUrl(oauthFlow.getAuthorizationUrl(false), results, true, "authorizationUrl");
        validateUrl(oauthFlow.getTokenUrl(false), results, true, "tokenUrl");
        validateUrl(oauthFlow.getRefreshUrl(false), results, true, "refreshUrl");
        validateMap(oauthFlow.getScopes(false), results, true, "scopes", Regexes.NOEXT_REGEX, null);
        validateExtensions(oauthFlow.getExtensions(false), results);
    }

}
