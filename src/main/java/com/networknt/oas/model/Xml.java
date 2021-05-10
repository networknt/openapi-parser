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

public interface Xml extends IJsonOverlay<Xml>, IModelPart<OpenApi3, Xml> {

	// Name
	String getName();

	void setName(String name);

	// Namespace
	String getNamespace();

	void setNamespace(String namespace);

	// Prefix
	String getPrefix();

	void setPrefix(String prefix);

	// Attribute
	Boolean getAttribute();

	boolean isAttribute();

	void setAttribute(Boolean attribute);

	// Wrapped
	Boolean getWrapped();

	boolean isWrapped();

	void setWrapped(Boolean wrapped);

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
