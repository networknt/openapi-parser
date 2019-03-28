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

public interface Link extends IJsonOverlay<Link>, IModelPart<OpenApi3, Link> {

	String getName();

	// OperationId
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getOperationId();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setOperationId(String operationId);

	// OperationRef
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getOperationRef();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setOperationRef(String operationRef);

	// Parameter
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, String> getParameters();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, String> getParameters(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasParameters();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasParameter(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getParameter(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setParameters(Map<String, String> parameters);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setParameter(String name, String parameter);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeParameter(String name);

	// Description
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getDescription();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setDescription(String description);

	// Server
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Server getServer();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Server getServer(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setServer(Server server);

	// RequestBody
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Object getRequestBody();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setRequestBody(Object requestBody);

	// Extension
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, Object> getExtensions();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, Object> getExtensions(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasExtensions();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasExtension(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Object getExtension(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setExtensions(Map<String, Object> extensions);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setExtension(String name, Object extension);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeExtension(String name);
}
