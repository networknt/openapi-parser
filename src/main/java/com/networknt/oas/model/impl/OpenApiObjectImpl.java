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
package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.OpenApi;
import com.networknt.oas.jsonoverlay.*;
import com.networknt.oas.model.OpenApiObject;
//import com.reprezen.swaggerparser.model.OpenApi3;

public abstract class OpenApiObjectImpl<OpenApi3, V extends IPropertiesOverlay<V>> extends PropertiesOverlay<V>
        implements OpenApiObject<OpenApi3, V> {

    protected OpenApiObjectImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
    }

    protected OpenApiObjectImpl(V value, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(value, parent, refReg);
    }

    @Override
    public OpenApi3 getModel() {
        IJsonOverlay<?> root = getRoot();
        return root instanceof OpenApi<?> ? (OpenApi3) root : null;
    }

    @Override
    public OpenApiObject<OpenApi3, ?> getParentObject() {
        IJsonOverlay<?> parent = super.getParent();
        while (parent != null && !(parent instanceof OpenApiObject)) {
            parent = parent.getParent();
        }
        return (OpenApiObject<OpenApi3, ?>) parent;
    }
}
