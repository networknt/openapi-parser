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

public interface Link extends IJsonOverlay<Link>, IModelPart<OpenApi3, Link> {

	String getName();

	// OperationId
	String getOperationId();

	void setOperationId(String operationId);

	// OperationRef
	String getOperationRef();

	void setOperationRef(String operationRef);

	// Parameter
	Map<String, String> getParameters();

	Map<String, String> getParameters(boolean elaborate);

	boolean hasParameters();

	boolean hasParameter(String name);

	String getParameter(String name);

	void setParameters(Map<String, String> parameters);

	void setParameter(String name, String parameter);

	void removeParameter(String name);

	// Description
	String getDescription();

	void setDescription(String description);

	// Server
	Server getServer();

	Server getServer(boolean elaborate);

	void setServer(Server server);

	// RequestBody
	Object getRequestBody();

	void setRequestBody(Object requestBody);

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
