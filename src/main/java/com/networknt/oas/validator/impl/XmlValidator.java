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

import com.networknt.oas.model.Xml;
import com.networknt.oas.validator.ObjectValidatorBase;
import com.networknt.oas.validator.ValidationResults;

import javax.print.attribute.standard.Severity;

public class XmlValidator extends ObjectValidatorBase<Xml> {

    @Override
    public void validateObject(Xml xml, ValidationResults results) {
        // no validation for: name, prefix, attribute, wrapped
        validateUrl(xml.getNamespace(false), results, false, "namespace", false, Severity.WARNING);
        validateExtensions(xml.getExtensions(false), results);
    }

}
