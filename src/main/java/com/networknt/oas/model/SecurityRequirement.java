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
package com.networknt.oas.model;

import java.util.Map;

import com.networknt.jsonoverlay.IJsonOverlay;
import com.networknt.jsonoverlay.IModelPart;

public interface SecurityRequirement
		extends IJsonOverlay<SecurityRequirement>, IModelPart<OpenApi3, SecurityRequirement> {

	// Requirement
	Map<String, SecurityParameter> getRequirements();

	Map<String, SecurityParameter> getRequirements(boolean elaborate);

	boolean hasRequirements();

	boolean hasRequirement(String name);

	SecurityParameter getRequirement(String name);

	void setRequirements(Map<String, SecurityParameter> requirements);

	void setRequirement(String name, SecurityParameter requirement);

	void removeRequirement(String name);
}
