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

import javax.annotation.Generated;

import com.networknt.jsonoverlay.IJsonOverlay;
import com.networknt.jsonoverlay.IModelPart;

public interface SecurityRequirement
		extends IJsonOverlay<SecurityRequirement>, IModelPart<OpenApi3, SecurityRequirement> {

	// Requirement
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, SecurityParameter> getRequirements();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, SecurityParameter> getRequirements(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasRequirements();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasRequirement(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	SecurityParameter getRequirement(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setRequirements(Map<String, SecurityParameter> requirements);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setRequirement(String name, SecurityParameter requirement);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeRequirement(String name);
}
