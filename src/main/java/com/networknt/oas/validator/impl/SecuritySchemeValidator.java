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
import com.networknt.oas.model.SecurityScheme;
import com.networknt.oas.validator.ObjectValidatorBase;
import com.networknt.oas.validator.ValidationResults;
import com.networknt.oas.validator.Validator;
import com.networknt.service.SingletonServiceFactory;

public class SecuritySchemeValidator extends ObjectValidatorBase<SecurityScheme> {

    private static Validator<OAuthFlow> oauthFlowValidator = SingletonServiceFactory.getBean(Validator.class, OAuthFlow.class);

    @Override
    public void validateObject(SecurityScheme securityScheme, ValidationResults results) {
        // no validation for: description, bearerFormat
        validateString(securityScheme.getType(false), results, true, "apiKey|http|oauth2|openIdConnect", "type");
        switch (securityScheme.getType(false)) {
            case "http":
            	validateString(securityScheme.getScheme(false), results, true, "scheme");
                // If bearer validate bearerFormat
                break;
            case "apiKey":
                validateString(securityScheme.getName(false), results, true, "name");
                validateString(securityScheme.getIn(false), results, true, "query|header|cookie", "in");
                break;
            case "oauth2":
                validateField(securityScheme.getImplicitOAuthFlow(false), results, false, "flow.implicit", oauthFlowValidator);
                validateField(securityScheme.getImplicitOAuthFlow(false), results, false, "flow.password", oauthFlowValidator);
                validateField(securityScheme.getImplicitOAuthFlow(false), results, false, "flow.clientCredentials", oauthFlowValidator);
                validateField(securityScheme.getImplicitOAuthFlow(false), results, false, "authorizationCode", oauthFlowValidator);
                validateExtensions(securityScheme.getOAuthFlowsExtensions(false), results, "flow");
                break;
            case "openIdConnect":
                validateUrl(securityScheme.getOpenIdConnectUrl(false), results, true, "openIdConnectUrl");
                break;
        }
        validateExtensions(securityScheme.getExtensions(false), results);
    }

}
