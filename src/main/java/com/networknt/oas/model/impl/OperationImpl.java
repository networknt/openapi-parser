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
package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.jsonoverlay.*;
import com.networknt.oas.model.*;
import java.util.List;
import java.util.Map;


public class OperationImpl extends PropertiesOverlay<Operation> implements Operation {

	public OperationImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public OperationImpl(Operation operation, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(operation, parent, factory, refMgr);
	}

	// Tag
	@Override
	public List<String> getTags() {
		return _getList("tags", String.class);
	}

	@Override
	public List<String> getTags(boolean elaborate) {
		return _getList("tags", elaborate, String.class);
	}

	@Override
	public boolean hasTags() {
		return _isPresent("tags");
	}

	@Override
	public String getTag(int index) {
		return _get("tags", index, String.class);
	}

	@Override
	public void setTags(List<String> tags) {
		_setList("tags", tags, String.class);
	}

	@Override
	public void setTag(int index, String tag) {
		_set("tags", index, tag, String.class);
	}

	@Override
	public void addTag(String tag) {
		_add("tags", tag, String.class);
	}

	@Override
	public void insertTag(int index, String tag) {
		_insert("tags", index, tag, String.class);
	}

	@Override
	public void removeTag(int index) {
		_remove("tags", index, String.class);
	}

	// Summary
	@Override
	public String getSummary() {
		return _get("summary", String.class);
	}

	@Override
	public void setSummary(String summary) {
		_setScalar("summary", summary, String.class);
	}

	// Description
	@Override
	public String getDescription() {
		return _get("description", String.class);
	}

	@Override
	public void setDescription(String description) {
		_setScalar("description", description, String.class);
	}

	// ExternalDocs
	@Override
	public ExternalDocs getExternalDocs() {
		return _get("externalDocs", ExternalDocs.class);
	}

	@Override
	public ExternalDocs getExternalDocs(boolean elaborate) {
		return _get("externalDocs", elaborate, ExternalDocs.class);
	}

	@Override
	public void setExternalDocs(ExternalDocs externalDocs) {
		_setScalar("externalDocs", externalDocs, ExternalDocs.class);
	}

	// OperationId
	@Override
	public String getOperationId() {
		return _get("operationId", String.class);
	}

	@Override
	public void setOperationId(String operationId) {
		_setScalar("operationId", operationId, String.class);
	}

	// Parameter
	@Override
	public List<Parameter> getParameters() {
		return _getList("parameters", Parameter.class);
	}

	@Override
	public List<Parameter> getParameters(boolean elaborate) {
		return _getList("parameters", elaborate, Parameter.class);
	}

	@Override
	public boolean hasParameters() {
		return _isPresent("parameters");
	}

	@Override
	public Parameter getParameter(int index) {
		return _get("parameters", index, Parameter.class);
	}

	@Override
	public void setParameters(List<Parameter> parameters) {
		_setList("parameters", parameters, Parameter.class);
	}

	@Override
	public void setParameter(int index, Parameter parameter) {
		_set("parameters", index, parameter, Parameter.class);
	}

	@Override
	public void addParameter(Parameter parameter) {
		_add("parameters", parameter, Parameter.class);
	}

	@Override
	public void insertParameter(int index, Parameter parameter) {
		_insert("parameters", index, parameter, Parameter.class);
	}

	@Override
	public void removeParameter(int index) {
		_remove("parameters", index, Parameter.class);
	}

	// RequestBody
	@Override
	public RequestBody getRequestBody() {
		return _get("requestBody", RequestBody.class);
	}

	@Override
	public RequestBody getRequestBody(boolean elaborate) {
		return _get("requestBody", elaborate, RequestBody.class);
	}

	@Override
	public void setRequestBody(RequestBody requestBody) {
		_setScalar("requestBody", requestBody, RequestBody.class);
	}

	// Response
	@Override
	public Map<String, Response> getResponses() {
		return _getMap("responses", Response.class);
	}

	@Override
	public Map<String, Response> getResponses(boolean elaborate) {
		return _getMap("responses", elaborate, Response.class);
	}

	@Override
	public boolean hasResponses() {
		return _isPresent("responses");
	}

	@Override
	public boolean hasResponse(String name) {
		return _getMap("responses", Response.class).containsKey(name);
	}

	@Override
	public Response getResponse(String name) {
		return _get("responses", name, Response.class);
	}

	@Override
	public void setResponses(Map<String, Response> responses) {
		_setMap("responses", responses, Response.class);
	}

	@Override
	public void setResponse(String name, Response response) {
		_set("responses", name, response, Response.class);
	}

	@Override
	public void removeResponse(String name) {
		_remove("responses", name, Response.class);
	}

	// ResponsesExtension
	@Override
	public Map<String, Object> getResponsesExtensions() {
		return _getMap("responsesExtensions", Object.class);
	}

	@Override
	public Map<String, Object> getResponsesExtensions(boolean elaborate) {
		return _getMap("responsesExtensions", elaborate, Object.class);
	}

	@Override
	public boolean hasResponsesExtensions() {
		return _isPresent("responsesExtensions");
	}

	@Override
	public boolean hasResponsesExtension(String name) {
		return _getMap("responsesExtensions", Object.class).containsKey(name);
	}

	@Override
	public Object getResponsesExtension(String name) {
		return _get("responsesExtensions", name, Object.class);
	}

	@Override
	public void setResponsesExtensions(Map<String, Object> responsesExtensions) {
		_setMap("responsesExtensions", responsesExtensions, Object.class);
	}

	@Override
	public void setResponsesExtension(String name, Object responsesExtension) {
		_set("responsesExtensions", name, responsesExtension, Object.class);
	}

	@Override
	public void removeResponsesExtension(String name) {
		_remove("responsesExtensions", name, Object.class);
	}

	// Callback
	@Override
	public Map<String, Callback> getCallbacks() {
		return _getMap("callbacks", Callback.class);
	}

	@Override
	public Map<String, Callback> getCallbacks(boolean elaborate) {
		return _getMap("callbacks", elaborate, Callback.class);
	}

	@Override
	public boolean hasCallbacks() {
		return _isPresent("callbacks");
	}

	@Override
	public boolean hasCallback(String name) {
		return _getMap("callbacks", Callback.class).containsKey(name);
	}

	@Override
	public Callback getCallback(String name) {
		return _get("callbacks", name, Callback.class);
	}

	@Override
	public void setCallbacks(Map<String, Callback> callbacks) {
		_setMap("callbacks", callbacks, Callback.class);
	}

	@Override
	public void setCallback(String name, Callback callback) {
		_set("callbacks", name, callback, Callback.class);
	}

	@Override
	public void removeCallback(String name) {
		_remove("callbacks", name, Callback.class);
	}

	// CallbacksExtension
	@Override
	public Map<String, Object> getCallbacksExtensions() {
		return _getMap("callbacksExtensions", Object.class);
	}

	@Override
	public Map<String, Object> getCallbacksExtensions(boolean elaborate) {
		return _getMap("callbacksExtensions", elaborate, Object.class);
	}

	@Override
	public boolean hasCallbacksExtensions() {
		return _isPresent("callbacksExtensions");
	}

	@Override
	public boolean hasCallbacksExtension(String name) {
		return _getMap("callbacksExtensions", Object.class).containsKey(name);
	}

	@Override
	public Object getCallbacksExtension(String name) {
		return _get("callbacksExtensions", name, Object.class);
	}

	@Override
	public void setCallbacksExtensions(Map<String, Object> callbacksExtensions) {
		_setMap("callbacksExtensions", callbacksExtensions, Object.class);
	}

	@Override
	public void setCallbacksExtension(String name, Object callbacksExtension) {
		_set("callbacksExtensions", name, callbacksExtension, Object.class);
	}

	@Override
	public void removeCallbacksExtension(String name) {
		_remove("callbacksExtensions", name, Object.class);
	}

	// Deprecated
	@Override
	public Boolean getDeprecated() {
		return _get("deprecated", Boolean.class);
	}

	@Override
	public boolean isDeprecated() {
		Boolean bool = _get("deprecated", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	public void setDeprecated(Boolean deprecated) {
		_setScalar("deprecated", deprecated, Boolean.class);
	}

	// SecurityRequirement
	@Override
	public List<SecurityRequirement> getSecurityRequirements() {
		return _getList("securityRequirements", SecurityRequirement.class);
	}

	@Override
	public List<SecurityRequirement> getSecurityRequirements(boolean elaborate) {
		return _getList("securityRequirements", elaborate, SecurityRequirement.class);
	}

	@Override
	public boolean hasSecurityRequirements() {
		return _isPresent("securityRequirements");
	}

	@Override
	public SecurityRequirement getSecurityRequirement(int index) {
		return _get("securityRequirements", index, SecurityRequirement.class);
	}

	@Override
	public void setSecurityRequirements(List<SecurityRequirement> securityRequirements) {
		_setList("securityRequirements", securityRequirements, SecurityRequirement.class);
	}

	@Override
	public void setSecurityRequirement(int index, SecurityRequirement securityRequirement) {
		_set("securityRequirements", index, securityRequirement, SecurityRequirement.class);
	}

	@Override
	public void addSecurityRequirement(SecurityRequirement securityRequirement) {
		_add("securityRequirements", securityRequirement, SecurityRequirement.class);
	}

	@Override
	public void insertSecurityRequirement(int index, SecurityRequirement securityRequirement) {
		_insert("securityRequirements", index, securityRequirement, SecurityRequirement.class);
	}

	@Override
	public void removeSecurityRequirement(int index) {
		_remove("securityRequirements", index, SecurityRequirement.class);
	}

	// Server
	@Override
	public List<Server> getServers() {
		return _getList("servers", Server.class);
	}

	@Override
	public List<Server> getServers(boolean elaborate) {
		return _getList("servers", elaborate, Server.class);
	}

	@Override
	public boolean hasServers() {
		return _isPresent("servers");
	}

	@Override
	public Server getServer(int index) {
		return _get("servers", index, Server.class);
	}

	@Override
	public void setServers(List<Server> servers) {
		_setList("servers", servers, Server.class);
	}

	@Override
	public void setServer(int index, Server server) {
		_set("servers", index, server, Server.class);
	}

	@Override
	public void addServer(Server server) {
		_add("servers", server, Server.class);
	}

	@Override
	public void insertServer(int index, Server server) {
		_insert("servers", index, server, Server.class);
	}

	@Override
	public void removeServer(int index) {
		_remove("servers", index, Server.class);
	}

	// Extension
	@Override
	public Map<String, Object> getExtensions() {
		return _getMap("extensions", Object.class);
	}

	@Override
	public Map<String, Object> getExtensions(boolean elaborate) {
		return _getMap("extensions", elaborate, Object.class);
	}

	@Override
	public boolean hasExtensions() {
		return _isPresent("extensions");
	}

	@Override
	public boolean hasExtension(String name) {
		return _getMap("extensions", Object.class).containsKey(name);
	}

	@Override
	public Object getExtension(String name) {
		return _get("extensions", name, Object.class);
	}

	@Override
	public void setExtensions(Map<String, Object> extensions) {
		_setMap("extensions", extensions, Object.class);
	}

	@Override
	public void setExtension(String name, Object extension) {
		_set("extensions", name, extension, Object.class);
	}

	@Override
	public void removeExtension(String name) {
		_remove("extensions", name, Object.class);
	}

	public static final String F_tags = "tags";

	public static final String F_summary = "summary";

	public static final String F_description = "description";

	public static final String F_externalDocs = "externalDocs";

	public static final String F_operationId = "operationId";

	public static final String F_parameters = "parameters";

	public static final String F_requestBody = "requestBody";

	public static final String F_responses = "responses";

	public static final String F_responsesExtensions = "responsesExtensions";

	public static final String F_callbacks = "callbacks";

	public static final String F_callbacksExtensions = "callbacksExtensions";

	public static final String F_deprecated = "deprecated";

	public static final String F_securityRequirements = "securityRequirements";

	public static final String F_servers = "servers";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createList("tags", "tags", StringOverlay.factory);
		_createScalar("summary", "summary", StringOverlay.factory);
		_createScalar("description", "description", StringOverlay.factory);
		_createScalar("externalDocs", "externalDocs", ExternalDocsImpl.factory);
		_createScalar("operationId", "operationId", StringOverlay.factory);
		_createList("parameters", "parameters", ParameterImpl.factory);
		_createScalar("requestBody", "requestBody", RequestBodyImpl.factory);
		_createMap("responses", "responses", ResponseImpl.factory, "default|(\\d[0-9X]{2})");
		_createMap("responsesExtensions", "responses", ObjectOverlay.factory, "x-.+");
		_createMap("callbacks", "callbacks", CallbackImpl.factory, "(?!x-)[a-zA-Z0-9\\._-]+");
		_createMap("callbacksExtensions", "callbacks", ObjectOverlay.factory, "x-.+");
		_createScalar("deprecated", "deprecated", BooleanOverlay.factory);
		_createList("securityRequirements", "security", SecurityRequirementImpl.factory);
		_createList("servers", "servers", ServerImpl.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<Operation> factory = new OverlayFactory<Operation>() {

		@Override
		protected Class<? extends JsonOverlay<? super Operation>> getOverlayClass() {
			return OperationImpl.class;
		}

		@Override
		public JsonOverlay<Operation> _create(Operation operation, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new OperationImpl(operation, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Operation> castOverlay = (JsonOverlay<Operation>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Operation> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new OperationImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Operation> castOverlay = (JsonOverlay<Operation>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends Operation> getSubtypeOf(Operation operation) {
		return Operation.class;
	}

	private static Class<? extends Operation> getSubtypeOf(JsonNode json) {
		return Operation.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<Operation> builder(OV modelMember) {
		return new Builder<Operation>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> Operation create(OV modelMember) {
		return (Operation) builder(modelMember).build();
	}
}
