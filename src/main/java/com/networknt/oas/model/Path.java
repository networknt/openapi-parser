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

public interface Path extends IJsonOverlay<Path>, IModelPart<OpenApi3, Path> {

	String getPathString();

	// Summary
	String getSummary();

	void setSummary(String summary);

	// Description
	String getDescription();

	void setDescription(String description);

	// Operation
	Map<String, Operation> getOperations();

	Map<String, Operation> getOperations(boolean elaborate);

	boolean hasOperations();

	boolean hasOperation(String name);

	Operation getOperation(String name);

	void setOperations(Map<String, Operation> operations);

	void setOperation(String name, Operation operation);

	void removeOperation(String name);

	// Get
	Operation getGet();

	Operation getGet(boolean elaborate);

	void setGet(Operation get);

	// Put
	Operation getPut();

	Operation getPut(boolean elaborate);

	void setPut(Operation put);

	// Post
	Operation getPost();

	Operation getPost(boolean elaborate);

	void setPost(Operation post);

	// Delete
	Operation getDelete();

	Operation getDelete(boolean elaborate);

	void setDelete(Operation delete);

	// Options
	Operation getOptions();

	Operation getOptions(boolean elaborate);

	void setOptions(Operation options);

	// Head
	Operation getHead();

	Operation getHead(boolean elaborate);

	void setHead(Operation head);

	// Patch
	Operation getPatch();

	Operation getPatch(boolean elaborate);

	void setPatch(Operation patch);

	// Trace
	Operation getTrace();

	Operation getTrace(boolean elaborate);

	void setTrace(Operation trace);

	// Server
	List<Server> getServers();

	List<Server> getServers(boolean elaborate);

	boolean hasServers();

	Server getServer(int index);

	void setServers(List<Server> servers);

	void setServer(int index, Server server);

	void addServer(Server server);

	void insertServer(int index, Server server);

	void removeServer(int index);

	// Parameter
	List<Parameter> getParameters();

	List<Parameter> getParameters(boolean elaborate);

	boolean hasParameters();

	Parameter getParameter(int index);

	void setParameters(List<Parameter> parameters);

	void setParameter(int index, Parameter parameter);

	void addParameter(Parameter parameter);

	void insertParameter(int index, Parameter parameter);

	void removeParameter(int index);

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
