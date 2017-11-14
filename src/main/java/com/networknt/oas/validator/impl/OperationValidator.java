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

import static com.networknt.oas.validator.Messages.m;

import com.networknt.oas.model.*;
import com.networknt.oas.validator.ObjectValidatorBase;
import com.networknt.oas.validator.ValidationResults;
import com.networknt.oas.validator.Validator;
import com.networknt.service.SingletonServiceFactory;

public class OperationValidator extends ObjectValidatorBase<Operation> {

    private static Validator<ExternalDocs> externalDocsValidator = SingletonServiceFactory.getBean(Validator.class, ExternalDocs.class);
    private static Validator<Parameter> parameterValidator = SingletonServiceFactory.getBean(Validator.class, Parameter.class);
    private static Validator<RequestBody> requestBodyValidator = SingletonServiceFactory.getBean(Validator.class, RequestBody.class);
    private static Validator<Response> responseValidator = SingletonServiceFactory.getBean(Validator.class, Response.class);
    private static Validator<Callback> callbackValidator = SingletonServiceFactory.getBean(Validator.class, Callback.class);
    private static Validator<SecurityRequirement> securityRequirementValidator = SingletonServiceFactory.getBean(Validator.class, SecurityRequirement.class);
    private static Validator<Server> serverValidator = SingletonServiceFactory.getBean(Validator.class, Server.class);

    @Override
    public void validateObject(Operation operation, ValidationResults results) {
        // no validation for: tags, description, deprecated
        checkSummaryLength(operation, results);
        validateField(operation.getExternalDocs(false), results, false, "externalDocs", externalDocsValidator);
        // TODO Q: Not marked as required in spec, but spec says they all must be unique within the API. Seems like it
        // should be required.
        validateString(operation.getOperationId(false), results, false, "operationId");
        validateList(operation.getParameters(false), operation.hasParameters(), results, false, "parameters",
                parameterValidator);
        validateField(operation.getRequestBody(false), results, false, "requestBody", requestBodyValidator);
        validateMap(operation.getResponses(false), results, true, "responses", Regexes.RESPONSE_REGEX, responseValidator);
        validateMap(operation.getCallbacks(false), results, false, "callbacks", Regexes.NOEXT_REGEX, callbackValidator);
        validateList(operation.getSecurityRequirements(false), operation.hasSecurityRequirements(), results, false,
                "security", securityRequirementValidator);
        validateList(operation.getServers(false), operation.hasServers(), results, false, "servers", serverValidator);
    }

    private void checkSummaryLength(Operation operation, ValidationResults results) {
        String summary = operation.getSummary(false);
        if (summary != null && summary.length() > 120) {
            results.addWarning(m.msg("LongSummary|Sumamry exceeds recommended limit of 120 chars"), "summary");
        }
    }
}
