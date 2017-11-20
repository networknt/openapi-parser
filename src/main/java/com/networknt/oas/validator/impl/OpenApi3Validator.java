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

import com.networknt.oas.model.*;
import com.networknt.oas.validator.ObjectValidatorBase;
import com.networknt.oas.validator.ValidationResults;
import com.networknt.oas.validator.Validator;
import com.networknt.service.SingletonServiceFactory;

import static com.networknt.oas.validator.impl.Regexes.*;

public class OpenApi3Validator extends ObjectValidatorBase<OpenApi3> {

    private static Validator<Info> infoValidator = SingletonServiceFactory.getBean(Validator.class, Info.class);
    private static Validator<Server> serverValidator = SingletonServiceFactory.getBean(Validator.class, Server.class);
    private static Validator<Path> pathValidator = SingletonServiceFactory.getBean(Validator.class, Path.class);
    private static Validator<Schema> schemaValidator = SingletonServiceFactory.getBean(Validator.class, Schema.class);
    private static Validator<Response> responseValidator = SingletonServiceFactory.getBean(Validator.class, Response.class);
    private static Validator<Parameter> parameterValidator = SingletonServiceFactory.getBean(Validator.class, Parameter.class);
    private static Validator<RequestBody> requestBodyValidator = SingletonServiceFactory.getBean(Validator.class, RequestBody.class);
    private static Validator<Header> headerValidator = SingletonServiceFactory.getBean(Validator.class, Header.class);
    private static Validator<SecurityScheme> securitySchemeValidator = SingletonServiceFactory.getBean(Validator.class, SecurityScheme.class);
    private static Validator<Link> linkValidator = SingletonServiceFactory.getBean(Validator.class, Link.class);
    private static Validator<Callback> callbackValidator = SingletonServiceFactory.getBean(Validator.class, Callback.class);
    private static Validator<SecurityRequirement> securityRequirementValidator = SingletonServiceFactory.getBean(Validator.class, SecurityRequirement.class);
    private static Validator<Tag> tagValidator = SingletonServiceFactory.getBean(Validator.class, Tag.class);
    private static Validator<ExternalDocs> externalDocsValidator = SingletonServiceFactory.getBean(Validator.class, ExternalDocs.class);

    @Override
    public void validateObject(final OpenApi3 swagger, final ValidationResults results) {
        results.withCrumb("model", new Runnable() {
            @Override
            public void run() {
                validateString(swagger.getOpenApi(false), results, true, "3\\.\\d+(\\.\\d+.*)?", "openapi");
                validateField(swagger.getInfo(false), results, true, "info", infoValidator);
                validateList(swagger.getServers(false), swagger.hasServers(), results, false, "servers", serverValidator);
                validateMap(swagger.getPaths(false), results, true, "paths", PATH_REGEX, pathValidator);
                validateMap(swagger.getPathsExtensions(false), results, false, "paths", EXT_REGEX, null);
                validateMap(swagger.getSchemas(false), results, false, "collections/schemas", NAME_REGEX, schemaValidator);
                validateMap(swagger.getResponses(false), results, false, "collections/responses", NAME_REGEX,
                        responseValidator);
                validateMap(swagger.getParameters(false), results, false, "collections/parameters", NAME_REGEX,
                        parameterValidator);
                validateMap(swagger.getExamples(false), results, false, "collections/examples", NAME_REGEX, null);
                validateMap(swagger.getRequestBodies(false), results, false, "collection/requestBodies", NAME_REGEX,
                        requestBodyValidator);
                validateMap(swagger.getHeaders(false), results, false, "collections/headers", NAME_REGEX, headerValidator);
                validateMap(swagger.getSecuritySchemes(false), results, false, "collections/securitySchemes", NAME_REGEX,
                        securitySchemeValidator);
                validateMap(swagger.getLinks(false), results, false, "collections/links", NAME_REGEX, linkValidator);
                validateMap(swagger.getCallbacks(false), results, false, "collections/callbacks", NAME_REGEX,
                        callbackValidator);
                validateMap(swagger.getComponentsExtensions(false), results, false, "collections", EXT_REGEX, null);
                validateList(swagger.getSecurityRequirements(false), swagger.hasSecurityRequirements(), results, false,
                        "security", securityRequirementValidator);
                validateList(swagger.getTags(false), swagger.hasTags(), results, false, "tags", tagValidator);
                validateField(swagger.getExternalDocs(false), results, false, "externalDocs", externalDocsValidator);
                validateExtensions(swagger.getExtensions(false), results);
            }
        });
    }
}
