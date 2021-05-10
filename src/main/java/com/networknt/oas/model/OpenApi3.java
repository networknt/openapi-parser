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

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.networknt.jsonoverlay.IJsonOverlay;
import com.networknt.jsonoverlay.IModelPart;
import com.networknt.oas.OpenApi;
import com.networknt.oas.validator.ValidationResults;

public interface OpenApi3 extends IJsonOverlay<OpenApi3>, IModelPart<OpenApi3, OpenApi3>, OpenApi<OpenApi3> {

	public void validate();

	public boolean isValid();

	public ValidationResults getValidationResults();

	public Collection<ValidationResults.ValidationItem> getValidationItems();

	// OpenApi
	String getOpenApi();

	void setOpenApi(String openApi);

	// Info
	Info getInfo();

	Info getInfo(boolean elaborate);

	void setInfo(Info info);

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

	// Path
	Map<String, Path> getPaths();

	Map<String, Path> getPaths(boolean elaborate);

	boolean hasPaths();

	boolean hasPath(String name);

	Path getPath(String name);

	void setPaths(Map<String, Path> paths);

	void setPath(String name, Path path);

	void removePath(String name);

	// PathsExtension
	Map<String, Object> getPathsExtensions();

	Map<String, Object> getPathsExtensions(boolean elaborate);

	boolean hasPathsExtensions();

	boolean hasPathsExtension(String name);

	Object getPathsExtension(String name);

	void setPathsExtensions(Map<String, Object> pathsExtensions);

	void setPathsExtension(String name, Object pathsExtension);

	void removePathsExtension(String name);

	// Schema
	Map<String, Schema> getSchemas();

	Map<String, Schema> getSchemas(boolean elaborate);

	boolean hasSchemas();

	boolean hasSchema(String name);

	Schema getSchema(String name);

	void setSchemas(Map<String, Schema> schemas);

	void setSchema(String name, Schema schema);

	void removeSchema(String name);

	// Response
	Map<String, Response> getResponses();

	Map<String, Response> getResponses(boolean elaborate);

	boolean hasResponses();

	boolean hasResponse(String name);

	Response getResponse(String name);

	void setResponses(Map<String, Response> responses);

	void setResponse(String name, Response response);

	void removeResponse(String name);

	// Parameter
	Map<String, Parameter> getParameters();

	Map<String, Parameter> getParameters(boolean elaborate);

	boolean hasParameters();

	boolean hasParameter(String name);

	Parameter getParameter(String name);

	void setParameters(Map<String, Parameter> parameters);

	void setParameter(String name, Parameter parameter);

	void removeParameter(String name);

	// Example
	Map<String, Example> getExamples();

	Map<String, Example> getExamples(boolean elaborate);

	boolean hasExamples();

	boolean hasExample(String name);

	Example getExample(String name);

	void setExamples(Map<String, Example> examples);

	void setExample(String name, Example example);

	void removeExample(String name);

	// RequestBody
	Map<String, RequestBody> getRequestBodies();

	Map<String, RequestBody> getRequestBodies(boolean elaborate);

	boolean hasRequestBodies();

	boolean hasRequestBody(String name);

	RequestBody getRequestBody(String name);

	void setRequestBodies(Map<String, RequestBody> requestBodies);

	void setRequestBody(String name, RequestBody requestBody);

	void removeRequestBody(String name);

	// Header
	Map<String, Header> getHeaders();

	Map<String, Header> getHeaders(boolean elaborate);

	boolean hasHeaders();

	boolean hasHeader(String name);

	Header getHeader(String name);

	void setHeaders(Map<String, Header> headers);

	void setHeader(String name, Header header);

	void removeHeader(String name);

	// SecurityScheme
	Map<String, SecurityScheme> getSecuritySchemes();

	Map<String, SecurityScheme> getSecuritySchemes(boolean elaborate);

	boolean hasSecuritySchemes();

	boolean hasSecurityScheme(String name);

	SecurityScheme getSecurityScheme(String name);

	void setSecuritySchemes(Map<String, SecurityScheme> securitySchemes);

	void setSecurityScheme(String name, SecurityScheme securityScheme);

	void removeSecurityScheme(String name);

	// Link
	Map<String, Link> getLinks();

	Map<String, Link> getLinks(boolean elaborate);

	boolean hasLinks();

	boolean hasLink(String name);

	Link getLink(String name);

	void setLinks(Map<String, Link> links);

	void setLink(String name, Link link);

	void removeLink(String name);

	// Callback
	Map<String, Callback> getCallbacks();

	Map<String, Callback> getCallbacks(boolean elaborate);

	boolean hasCallbacks();

	boolean hasCallback(String name);

	Callback getCallback(String name);

	void setCallbacks(Map<String, Callback> callbacks);

	void setCallback(String name, Callback callback);

	void removeCallback(String name);

	// ComponentsExtension
	Map<String, Object> getComponentsExtensions();

	Map<String, Object> getComponentsExtensions(boolean elaborate);

	boolean hasComponentsExtensions();

	boolean hasComponentsExtension(String name);

	Object getComponentsExtension(String name);

	void setComponentsExtensions(Map<String, Object> componentsExtensions);

	void setComponentsExtension(String name, Object componentsExtension);

	void removeComponentsExtension(String name);

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

	// Tag
	List<Tag> getTags();

	List<Tag> getTags(boolean elaborate);

	boolean hasTags();

	Tag getTag(int index);

	void setTags(List<Tag> tags);

	void setTag(int index, Tag tag);

	void addTag(Tag tag);

	void insertTag(int index, Tag tag);

	void removeTag(int index);

	// ExternalDocs
	ExternalDocs getExternalDocs();

	ExternalDocs getExternalDocs(boolean elaborate);

	void setExternalDocs(ExternalDocs externalDocs);

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
