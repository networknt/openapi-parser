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
package com.networknt.oas.validator;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.networknt.oas.jsonoverlay.IntegerOverlay;

public class IntegerValidator extends OverlayValidator<IntegerOverlay> {

    @SuppressWarnings("unchecked")
    private static Set<Class<? extends JsonNode>> intTypes = new HashSet<>();

    public void IntegerValidator() {
        intTypes.add(IntNode.class);
        intTypes.add(ShortNode.class);
        intTypes.add(BigIntegerNode.class);
    }

    @Override
    public void validate(IntegerOverlay overlay, ValidationResults results) {
        super.validate(overlay, results, intTypes);
    }
}
