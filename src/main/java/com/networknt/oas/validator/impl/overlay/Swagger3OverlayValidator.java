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
package com.networknt.oas.validator.impl.overlay;

import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.impl.OpenApi3Impl;
import com.networknt.oas.validator.ImplValidator;
import com.networknt.oas.validator.ObjectValidator;
import com.networknt.oas.validator.ValidationResults;

public class Swagger3OverlayValidator extends ObjectValidator<OpenApi3Impl> implements ImplValidator<OpenApi3> {

    @Override
    public void validate(OpenApi3Impl overlay, ValidationResults results) {
        super.validate(overlay, results);
    }

    @Override
    public void validateImpl(OpenApi3 swagger3, ValidationResults results) {
        validate((OpenApi3Impl) swagger3, results);
    }

}
