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

import com.networknt.jsonoverlay.IJsonOverlay;
import com.networknt.jsonoverlay.IModelPart;

public interface SecurityParameter extends IJsonOverlay<SecurityParameter>, IModelPart<OpenApi3, SecurityParameter> {

	// Parameter
	List<String> getParameters();

	List<String> getParameters(boolean elaborate);

	boolean hasParameters();

	String getParameter(int index);

	void setParameters(List<String> parameters);

	void setParameter(int index, String parameter);

	void addParameter(String parameter);

	void insertParameter(int index, String parameter);

	void removeParameter(int index);
}
