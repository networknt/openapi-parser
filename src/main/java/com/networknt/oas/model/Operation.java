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

public interface Operation extends IJsonOverlay<Operation>, IModelPart<OpenApi3, Operation> {

	// Tag
	List<String> getTags();

	List<String> getTags(boolean elaborate);

	boolean hasTags();

	String getTag(int index);

	void setTags(List<String> tags);

	void setTag(int index, String tag);

	void addTag(String tag);

	void insertTag(int index, String tag);

	void removeTag(int index);

	// Summary
	String getSummary();

	void setSummary(String summary);

	// Description
	String getDescription();

	void setDescription(String description);

	// ExternalDocs
	ExternalDocs getExternalDocs();

	ExternalDocs getExternalDocs(boolean elaborate);

	void setExternalDocs(ExternalDocs externalDocs);

	// OperationId
	String getOperationId();

	void setOperationId(String operationId);

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

	// RequestBody
	RequestBody getRequestBody();

	RequestBody getRequestBody(boolean elaborate);

	void setRequestBody(RequestBody requestBody);

	// Response
	Map<String, Response> getResponses();

	Map<String, Response> getResponses(boolean elaborate);

	boolean hasResponses();

	boolean hasResponse(String name);

	Response getResponse(String name);

	void setResponses(Map<String, Response> responses);

	void setResponse(String name, Response response);

	void removeResponse(String name);

	// ResponsesExtension
	Map<String, Object> getResponsesExtensions();

	Map<String, Object> getResponsesExtensions(boolean elaborate);

	boolean hasResponsesExtensions();

	boolean hasResponsesExtension(String name);

	Object getResponsesExtension(String name);

	void setResponsesExtensions(Map<String, Object> responsesExtensions);

	void setResponsesExtension(String name, Object responsesExtension);

	void removeResponsesExtension(String name);

	// Callback
	Map<String, Callback> getCallbacks();

	Map<String, Callback> getCallbacks(boolean elaborate);

	boolean hasCallbacks();

	boolean hasCallback(String name);

	Callback getCallback(String name);

	void setCallbacks(Map<String, Callback> callbacks);

	void setCallback(String name, Callback callback);

	void removeCallback(String name);

	// CallbacksExtension
	Map<String, Object> getCallbacksExtensions();

	Map<String, Object> getCallbacksExtensions(boolean elaborate);

	boolean hasCallbacksExtensions();

	boolean hasCallbacksExtension(String name);

	Object getCallbacksExtension(String name);

	void setCallbacksExtensions(Map<String, Object> callbacksExtensions);

	void setCallbacksExtension(String name, Object callbacksExtension);

	void removeCallbacksExtension(String name);

	// Deprecated
	Boolean getDeprecated();

	boolean isDeprecated();

	void setDeprecated(Boolean deprecated);

	// SecurityRequirement
	List<SecurityRequirement> getSecurityRequirements();

	List<SecurityRequirement> getSecurityRequirements(boolean elaborate);

	boolean hasSecurityRequirements();

	SecurityRequirement getSecurityRequirement(int index);

	void setSecurityRequirements(List<SecurityRequirement> securityRequirements);

	void setSecurityRequirement(int index, SecurityRequirement securityRequirement);

	void addSecurityRequirement(SecurityRequirement securityRequirement);

	void insertSecurityRequirement(int index, SecurityRequirement securityRequirement);

	void removeSecurityRequirement(int index);

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
