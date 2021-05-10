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

public interface Server extends IJsonOverlay<Server>, IModelPart<OpenApi3, Server> {

	// Url
	String getUrl();

	void setUrl(String url);

	// Description
	String getDescription();

	void setDescription(String description);

	// ServerVariable
	Map<String, ServerVariable> getServerVariables();

	Map<String, ServerVariable> getServerVariables(boolean elaborate);

	boolean hasServerVariables();

	boolean hasServerVariable(String name);

	ServerVariable getServerVariable(String name);

	void setServerVariables(Map<String, ServerVariable> serverVariables);

	void setServerVariable(String name, ServerVariable serverVariable);

	void removeServerVariable(String name);

	// VariablesExtension
	Map<String, Object> getVariablesExtensions();

	Map<String, Object> getVariablesExtensions(boolean elaborate);

	boolean hasVariablesExtensions();

	boolean hasVariablesExtension(String name);

	Object getVariablesExtension(String name);

	void setVariablesExtensions(Map<String, Object> variablesExtensions);

	void setVariablesExtension(String name, Object variablesExtension);

	void removeVariablesExtension(String name);

	// Extension
	Map<String, Object> getExtensions();

	Map<String, Object> getExtensions(boolean elaborate);

	boolean hasExtensions();

	boolean hasExtension(String name);

	Object getExtension(String name);

	void setExtensions(Map<String, Object> extensions);

	void setExtension(String name, Object extension);

	void removeExtension(String name);
}
