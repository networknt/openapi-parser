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

import com.networknt.jsonoverlay.MapOverlay;
import com.networknt.jsonoverlay.Overlay;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.SecurityParameter;
import com.networknt.oas.model.SecurityRequirement;
import com.networknt.oas.validator.ObjectValidatorBase;

import java.util.Map;
import java.util.Set;

import static com.networknt.oas.model.impl.SecurityRequirementImpl.F_requirements;
import static com.networknt.oas.validator.impl.OpenApi3Messages.UnkSecScheme;
import static com.networknt.oas.validator.msg.Messages.msg;

public class SecurityRequirementValidator extends ObjectValidatorBase<SecurityRequirement> {

	@Override
	public void runObjectValidations() {
		Overlay<Map<String, SecurityParameter>> requirements = validateMapField(F_requirements, false, false,
				SecurityParameter.class, new SecurityParameterValidator());
		checkAllSchemesDefined(requirements);
	}

	public void checkAllSchemesDefined(Overlay<Map<String, SecurityParameter>> requirements) {
		OpenApi3 model = value.getModel();
		Set<String> definedSchemes = model.getSecuritySchemes().keySet();
		MapOverlay<SecurityParameter> mapOverlay = Overlay.getMapOverlay(requirements);
		for (String name : mapOverlay.keySet()) {
			if (!definedSchemes.contains(name)) {
				results.addError(msg(UnkSecScheme, name), Overlay.of(mapOverlay, name));
			}
		}

	}
}
