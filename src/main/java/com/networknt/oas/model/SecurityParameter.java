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

import java.util.List;

import javax.annotation.Generated;

import com.networknt.jsonoverlay.IJsonOverlay;
import com.networknt.jsonoverlay.IModelPart;

public interface SecurityParameter extends IJsonOverlay<SecurityParameter>, IModelPart<OpenApi3, SecurityParameter> {

	// Parameter
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	List<String> getParameters();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	List<String> getParameters(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasParameters();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getParameter(int index);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setParameters(List<String> parameters);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setParameter(int index, String parameter);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void addParameter(String parameter);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void insertParameter(int index, String parameter);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeParameter(int index);
}
