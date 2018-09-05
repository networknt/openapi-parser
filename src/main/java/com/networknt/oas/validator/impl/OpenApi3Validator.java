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

import static com.networknt.oas.model.impl.OpenApi3Impl.*;

public class OpenApi3Validator extends ObjectValidatorBase<OpenApi3> {

    @Override
    public void runObjectValidations() {
        OpenApi3 model = (OpenApi3) value.getOverlay();
        validateStringField(F_openApi, true, "3\\.\\d+(\\.\\d+.*)?");
        validateField(F_info, true, Info.class, new InfoValidator());
        validateListField(F_servers, false, false, Server.class, new ServerValidator());
        validateMapField(F_paths, true, false, Path.class, new PathValidator());
        validateExtensions(model.getPathsExtensions());
        validateMapField(F_schemas, false, false, Schema.class, new SchemaValidator());
        validateMapField(F_responses, false, false, Response.class, new ResponseValidator());
        validateMapField(F_parameters, false, false, Parameter.class, new ParameterValidator());
        validateMapField(F_examples, false, false, Example.class, new ExampleValidator());
        validateMapField(F_requestBodies, false, false, RequestBody.class, new RequestBodyValidator());
        validateMapField(F_headers, false, false, Header.class, new HeaderValidator());
        validateMapField(F_securitySchemes, false, false, SecurityScheme.class, new SecuritySchemeValidator());
        validateMapField(F_links, false, false, Link.class, new LinkValidator());
        validateMapField(F_callbacks, false, false, Callback.class, new CallbackValidator());
        validateExtensions(model.getComponentsExtensions());
        validateListField(F_securityRequirements, false, false, SecurityRequirement.class,
                new SecurityRequirementValidator());
        validateListField(F_tags, false, false, Tag.class, new TagValidator());
        validateField(F_externalDocs, false, ExternalDocs.class, new ExternalDocsValidator());
        validateExtensions(model.getExtensions());
    }
}
