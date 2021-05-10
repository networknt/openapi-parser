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
import java.util.Map;

import com.networknt.jsonoverlay.IJsonOverlay;
import com.networknt.jsonoverlay.IModelPart;

public interface ServerVariable extends IJsonOverlay<ServerVariable>, IModelPart<OpenApi3, ServerVariable> {

	// EnumValue
	List<String> getEnumValues();

	List<String> getEnumValues(boolean elaborate);

	boolean hasEnumValues();

	String getEnumValue(int index);

	void setEnumValues(List<String> enumValues);

	void setEnumValue(int index, String enumValue);

	void addEnumValue(String enumValue);

	void insertEnumValue(int index, String enumValue);

	void removeEnumValue(int index);

	// Default
	String getDefault();

	void setDefault(String defaultValue);

	// Description
	String getDescription();

	void setDescription(String description);

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
