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

import com.networknt.oas.model.ExternalDocs;
import com.networknt.oas.validator.ObjectValidatorBase;
import com.networknt.oas.validator.ValidationResults;

public class ExternalDocsValidator extends ObjectValidatorBase<ExternalDocs> {

    @Override
    public void validateObject(ExternalDocs externalDocs, ValidationResults results) {
        // no validation for: description
        validateUrl(externalDocs.getUrl(false), results, true, "externalDocs");
        validateExtensions(externalDocs.getExtensions(false), results);
    }

}
