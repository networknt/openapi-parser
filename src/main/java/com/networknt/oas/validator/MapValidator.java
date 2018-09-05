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

import com.networknt.jsonoverlay.MapOverlay;
import com.networknt.jsonoverlay.Overlay;

import java.util.Map;

public class MapValidator<T> extends ValidatorBase<Map<String, T>> {

	private Validator<T> valueValidator;

	public MapValidator(Validator<T> valueValidator) {
		this.valueValidator = valueValidator;
	}

	@Override
	public void runValidations() {
		MapOverlay<T> mapOverlay = Overlay.getMapOverlay(value);
		if (valueValidator != null) {
			for (String key : mapOverlay.keySet()) {
				valueValidator.validate(Overlay.of(mapOverlay, key));
			}
		}
	}
}
