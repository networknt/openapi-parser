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

import com.networknt.oas.model.Info;
import com.networknt.oas.model.impl.InfoImpl;
import com.networknt.oas.validator.ImplValidator;
import com.networknt.oas.validator.ObjectValidator;
import com.networknt.oas.validator.ValidationResults;

public class InfoOverlayValidator extends ObjectValidator<InfoImpl> implements ImplValidator<Info> {

    @Override
    public void validateImpl(Info info, ValidationResults results) {
        super.validate((InfoImpl) info, results);
    }

}
