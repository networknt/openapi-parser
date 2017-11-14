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

import com.networknt.oas.model.EncodingProperty;
import com.networknt.oas.validator.ObjectValidatorBase;
import com.networknt.oas.validator.ValidationResults;

public class EncodingPropertyValidator extends ObjectValidatorBase<EncodingProperty> {

    @Override
    public void validateObject(EncodingProperty encodingProperty, ValidationResults results) {
        // no validation for: contentType, explode
        // TODO Q: spec says "Headers" (capitalized) for peroperty name -assuming it's a typo
        validateMap(encodingProperty.getHeaders(false), results, false, "headers", Regexes.NOEXT_REGEX, null);
        validateString(encodingProperty.getStyle(false), results, false, Regexes.STYLE_REGEX, "style");
        validateExtensions(encodingProperty.getExtensions(false), results);
    }

}
