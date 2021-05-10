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
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.networknt.jsonoverlay.*;
import com.networknt.oas.model.*;
import com.networknt.oas.validator.ValidationContext;
import com.networknt.oas.validator.ValidationResults;
import com.networknt.oas.validator.ValidationResults.Severity;
import com.networknt.oas.validator.impl.OpenApi3Validator;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class OpenApi3Impl extends PropertiesOverlay<OpenApi3> implements OpenApi3 {

	private ValidationResults validationResults = null;

	@Override
	protected JsonNode _fixJson(JsonNode json) {
		if (json.isMissingNode()) {
			json = _jsonObject();
		}
		if (!json.has("paths")) {
			((ObjectNode) json).putObject("paths");
		}
		return json;
	}

	@Override
	public void validate() {
		try (ValidationContext context = ValidationContext.open()) {
			validationResults = ValidationContext.getValidationResults();
			new OpenApi3Validator().validate(Overlay.of(this));
		}
	}

	@Override
	public boolean isValid() {
		if (validationResults == null) {
			validate();
		}
		return validationResults.getSeverity().lt(Severity.ERROR);
	}

	@Override
	public ValidationResults getValidationResults() {
		if (validationResults == null) {
			validate();
		}
		return validationResults;
	}

	@Override
	public Collection<ValidationResults.ValidationItem> getValidationItems() {
		return getValidationResults().getItems();
	}

	public OpenApi3Impl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public OpenApi3Impl(OpenApi3 openApi3, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(openApi3, parent, factory, refMgr);
	}

	// OpenApi
	@Override
	public String getOpenApi() {
		return _get("openApi", String.class);
	}

	@Override
	public void setOpenApi(String openApi) {
		_setScalar("openApi", openApi, String.class);
	}

	// Info
	@Override
	public Info getInfo() {
		return _get("info", Info.class);
	}

	@Override
	public Info getInfo(boolean elaborate) {
		return _get("info", elaborate, Info.class);
	}

	@Override
	public void setInfo(Info info) {
		_setScalar("info", info, Info.class);
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

	// Path
	@Override
	public Map<String, Path> getPaths() {
		return _getMap("paths", Path.class);
	}

	@Override
	public Map<String, Path> getPaths(boolean elaborate) {
		return _getMap("paths", elaborate, Path.class);
	}

	@Override
	public boolean hasPaths() {
		return _isPresent("paths");
	}

	@Override
	public boolean hasPath(String name) {
		return _getMap("paths", Path.class).containsKey(name);
	}

	@Override
	public Path getPath(String name) {
		return _get("paths", name, Path.class);
	}

	@Override
	public void setPaths(Map<String, Path> paths) {
		_setMap("paths", paths, Path.class);
	}

	@Override
	public void setPath(String name, Path path) {
		_set("paths", name, path, Path.class);
	}

	@Override
	public void removePath(String name) {
		_remove("paths", name, Path.class);
	}

	// PathsExtension
	@Override
	public Map<String, Object> getPathsExtensions() {
		return _getMap("pathsExtensions", Object.class);
	}

	@Override
	public Map<String, Object> getPathsExtensions(boolean elaborate) {
		return _getMap("pathsExtensions", elaborate, Object.class);
	}

	@Override
	public boolean hasPathsExtensions() {
		return _isPresent("pathsExtensions");
	}

	@Override
	public boolean hasPathsExtension(String name) {
		return _getMap("pathsExtensions", Object.class).containsKey(name);
	}

	@Override
	public Object getPathsExtension(String name) {
		return _get("pathsExtensions", name, Object.class);
	}

	@Override
	public void setPathsExtensions(Map<String, Object> pathsExtensions) {
		_setMap("pathsExtensions", pathsExtensions, Object.class);
	}

	@Override
	public void setPathsExtension(String name, Object pathsExtension) {
		_set("pathsExtensions", name, pathsExtension, Object.class);
	}

	@Override
	public void removePathsExtension(String name) {
		_remove("pathsExtensions", name, Object.class);
	}

	// Schema
	@Override
	public Map<String, Schema> getSchemas() {
		return _getMap("schemas", Schema.class);
	}

	@Override
	public Map<String, Schema> getSchemas(boolean elaborate) {
		return _getMap("schemas", elaborate, Schema.class);
	}

	@Override
	public boolean hasSchemas() {
		return _isPresent("schemas");
	}

	@Override
	public boolean hasSchema(String name) {
		return _getMap("schemas", Schema.class).containsKey(name);
	}

	@Override
	public Schema getSchema(String name) {
		return _get("schemas", name, Schema.class);
	}

	@Override
	public void setSchemas(Map<String, Schema> schemas) {
		_setMap("schemas", schemas, Schema.class);
	}

	@Override
	public void setSchema(String name, Schema schema) {
		_set("schemas", name, schema, Schema.class);
	}

	@Override
	public void removeSchema(String name) {
		_remove("schemas", name, Schema.class);
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

	// Parameter
	@Override
	public Map<String, Parameter> getParameters() {
		return _getMap("parameters", Parameter.class);
	}

	@Override
	public Map<String, Parameter> getParameters(boolean elaborate) {
		return _getMap("parameters", elaborate, Parameter.class);
	}

	@Override
	public boolean hasParameters() {
		return _isPresent("parameters");
	}

	@Override
	public boolean hasParameter(String name) {
		return _getMap("parameters", Parameter.class).containsKey(name);
	}

	@Override
	public Parameter getParameter(String name) {
		return _get("parameters", name, Parameter.class);
	}

	@Override
	public void setParameters(Map<String, Parameter> parameters) {
		_setMap("parameters", parameters, Parameter.class);
	}

	@Override
	public void setParameter(String name, Parameter parameter) {
		_set("parameters", name, parameter, Parameter.class);
	}

	@Override
	public void removeParameter(String name) {
		_remove("parameters", name, Parameter.class);
	}

	// Example
	@Override
	public Map<String, Example> getExamples() {
		return _getMap("examples", Example.class);
	}

	@Override
	public Map<String, Example> getExamples(boolean elaborate) {
		return _getMap("examples", elaborate, Example.class);
	}

	@Override
	public boolean hasExamples() {
		return _isPresent("examples");
	}

	@Override
	public boolean hasExample(String name) {
		return _getMap("examples", Example.class).containsKey(name);
	}

	@Override
	public Example getExample(String name) {
		return _get("examples", name, Example.class);
	}

	@Override
	public void setExamples(Map<String, Example> examples) {
		_setMap("examples", examples, Example.class);
	}

	@Override
	public void setExample(String name, Example example) {
		_set("examples", name, example, Example.class);
	}

	@Override
	public void removeExample(String name) {
		_remove("examples", name, Example.class);
	}

	// RequestBody
	@Override
	public Map<String, RequestBody> getRequestBodies() {
		return _getMap("requestBodies", RequestBody.class);
	}

	@Override
	public Map<String, RequestBody> getRequestBodies(boolean elaborate) {
		return _getMap("requestBodies", elaborate, RequestBody.class);
	}

	@Override
	public boolean hasRequestBodies() {
		return _isPresent("requestBodies");
	}

	@Override
	public boolean hasRequestBody(String name) {
		return _getMap("requestBodies", RequestBody.class).containsKey(name);
	}

	@Override
	public RequestBody getRequestBody(String name) {
		return _get("requestBodies", name, RequestBody.class);
	}

	@Override
	public void setRequestBodies(Map<String, RequestBody> requestBodies) {
		_setMap("requestBodies", requestBodies, RequestBody.class);
	}

	@Override
	public void setRequestBody(String name, RequestBody requestBody) {
		_set("requestBodies", name, requestBody, RequestBody.class);
	}

	@Override
	public void removeRequestBody(String name) {
		_remove("requestBodies", name, RequestBody.class);
	}

	// Header
	@Override
	public Map<String, Header> getHeaders() {
		return _getMap("headers", Header.class);
	}

	@Override
	public Map<String, Header> getHeaders(boolean elaborate) {
		return _getMap("headers", elaborate, Header.class);
	}

	@Override
	public boolean hasHeaders() {
		return _isPresent("headers");
	}

	@Override
	public boolean hasHeader(String name) {
		return _getMap("headers", Header.class).containsKey(name);
	}

	@Override
	public Header getHeader(String name) {
		return _get("headers", name, Header.class);
	}

	@Override
	public void setHeaders(Map<String, Header> headers) {
		_setMap("headers", headers, Header.class);
	}

	@Override
	public void setHeader(String name, Header header) {
		_set("headers", name, header, Header.class);
	}

	@Override
	public void removeHeader(String name) {
		_remove("headers", name, Header.class);
	}

	// SecurityScheme
	@Override
	public Map<String, SecurityScheme> getSecuritySchemes() {
		return _getMap("securitySchemes", SecurityScheme.class);
	}

	@Override
	public Map<String, SecurityScheme> getSecuritySchemes(boolean elaborate) {
		return _getMap("securitySchemes", elaborate, SecurityScheme.class);
	}

	@Override
	public boolean hasSecuritySchemes() {
		return _isPresent("securitySchemes");
	}

	@Override
	public boolean hasSecurityScheme(String name) {
		return _getMap("securitySchemes", SecurityScheme.class).containsKey(name);
	}

	@Override
	public SecurityScheme getSecurityScheme(String name) {
		return _get("securitySchemes", name, SecurityScheme.class);
	}

	@Override
	public void setSecuritySchemes(Map<String, SecurityScheme> securitySchemes) {
		_setMap("securitySchemes", securitySchemes, SecurityScheme.class);
	}

	@Override
	public void setSecurityScheme(String name, SecurityScheme securityScheme) {
		_set("securitySchemes", name, securityScheme, SecurityScheme.class);
	}

	@Override
	public void removeSecurityScheme(String name) {
		_remove("securitySchemes", name, SecurityScheme.class);
	}

	// Link
	@Override
	public Map<String, Link> getLinks() {
		return _getMap("links", Link.class);
	}

	@Override
	public Map<String, Link> getLinks(boolean elaborate) {
		return _getMap("links", elaborate, Link.class);
	}

	@Override
	public boolean hasLinks() {
		return _isPresent("links");
	}

	@Override
	public boolean hasLink(String name) {
		return _getMap("links", Link.class).containsKey(name);
	}

	@Override
	public Link getLink(String name) {
		return _get("links", name, Link.class);
	}

	@Override
	public void setLinks(Map<String, Link> links) {
		_setMap("links", links, Link.class);
	}

	@Override
	public void setLink(String name, Link link) {
		_set("links", name, link, Link.class);
	}

	@Override
	public void removeLink(String name) {
		_remove("links", name, Link.class);
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

	// ComponentsExtension
	@Override
	public Map<String, Object> getComponentsExtensions() {
		return _getMap("componentsExtensions", Object.class);
	}

	@Override
	public Map<String, Object> getComponentsExtensions(boolean elaborate) {
		return _getMap("componentsExtensions", elaborate, Object.class);
	}

	@Override
	public boolean hasComponentsExtensions() {
		return _isPresent("componentsExtensions");
	}

	@Override
	public boolean hasComponentsExtension(String name) {
		return _getMap("componentsExtensions", Object.class).containsKey(name);
	}

	@Override
	public Object getComponentsExtension(String name) {
		return _get("componentsExtensions", name, Object.class);
	}

	@Override
	public void setComponentsExtensions(Map<String, Object> componentsExtensions) {
		_setMap("componentsExtensions", componentsExtensions, Object.class);
	}

	@Override
	public void setComponentsExtension(String name, Object componentsExtension) {
		_set("componentsExtensions", name, componentsExtension, Object.class);
	}

	@Override
	public void removeComponentsExtension(String name) {
		_remove("componentsExtensions", name, Object.class);
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

	// Tag
	@Override
	public List<Tag> getTags() {
		return _getList("tags", Tag.class);
	}

	@Override
	public List<Tag> getTags(boolean elaborate) {
		return _getList("tags", elaborate, Tag.class);
	}

	@Override
	public boolean hasTags() {
		return _isPresent("tags");
	}

	@Override
	public Tag getTag(int index) {
		return _get("tags", index, Tag.class);
	}

	@Override
	public void setTags(List<Tag> tags) {
		_setList("tags", tags, Tag.class);
	}

	@Override
	public void setTag(int index, Tag tag) {
		_set("tags", index, tag, Tag.class);
	}

	@Override
	public void addTag(Tag tag) {
		_add("tags", tag, Tag.class);
	}

	@Override
	public void insertTag(int index, Tag tag) {
		_insert("tags", index, tag, Tag.class);
	}

	@Override
	public void removeTag(int index) {
		_remove("tags", index, Tag.class);
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

	public static final String F_openApi = "openApi";

	public static final String F_info = "info";

	public static final String F_servers = "servers";

	public static final String F_paths = "paths";

	public static final String F_pathsExtensions = "pathsExtensions";

	public static final String F_schemas = "schemas";

	public static final String F_responses = "responses";

	public static final String F_parameters = "parameters";

	public static final String F_examples = "examples";

	public static final String F_requestBodies = "requestBodies";

	public static final String F_headers = "headers";

	public static final String F_securitySchemes = "securitySchemes";

	public static final String F_links = "links";

	public static final String F_callbacks = "callbacks";

	public static final String F_componentsExtensions = "componentsExtensions";

	public static final String F_securityRequirements = "securityRequirements";

	public static final String F_tags = "tags";

	public static final String F_externalDocs = "externalDocs";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("openApi", "openapi", StringOverlay.factory);
		_createScalar("info", "info", InfoImpl.factory);
		_createList("servers", "servers", ServerImpl.factory);
		_createMap("paths", "paths", PathImpl.factory, "/.*");
		_createMap("pathsExtensions", "paths", ObjectOverlay.factory, "x-.+");
		_createMap("schemas", "components/schemas", SchemaImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createMap("responses", "components/responses", ResponseImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createMap("parameters", "components/parameters", ParameterImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createMap("examples", "components/examples", ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createMap("requestBodies", "components/requestBodies", RequestBodyImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createMap("headers", "components/headers", HeaderImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createMap("securitySchemes", "components/securitySchemes", SecuritySchemeImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createMap("links", "components/links", LinkImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createMap("callbacks", "components/callbacks", CallbackImpl.factory, "(?!x-)[a-zA-Z0-9\\._-]+");
		_createMap("componentsExtensions", "components", ObjectOverlay.factory, "x-.+");
		_createList("securityRequirements", "security", SecurityRequirementImpl.factory);
		_createList("tags", "tags", TagImpl.factory);
		_createScalar("externalDocs", "externalDocs", ExternalDocsImpl.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<OpenApi3> factory = new OverlayFactory<OpenApi3>() {

		@Override
		protected Class<? extends JsonOverlay<? super OpenApi3>> getOverlayClass() {
			return OpenApi3Impl.class;
		}

		@Override
		public JsonOverlay<OpenApi3> _create(OpenApi3 openApi3, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new OpenApi3Impl(openApi3, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<OpenApi3> castOverlay = (JsonOverlay<OpenApi3>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<OpenApi3> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new OpenApi3Impl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<OpenApi3> castOverlay = (JsonOverlay<OpenApi3>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends OpenApi3> getSubtypeOf(OpenApi3 openApi3) {
		return OpenApi3.class;
	}

	private static Class<? extends OpenApi3> getSubtypeOf(JsonNode json) {
		return OpenApi3.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<OpenApi3> builder(OV modelMember) {
		return new Builder<OpenApi3>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> OpenApi3 create(OV modelMember) {
		return (OpenApi3) builder(modelMember).build();
	}
}
