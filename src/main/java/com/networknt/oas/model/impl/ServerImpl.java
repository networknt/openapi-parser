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
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.Server;
import com.networknt.oas.model.ServerVariable;
import java.util.Map;


public class ServerImpl extends PropertiesOverlay<Server> implements Server {

	public ServerImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public ServerImpl(Server server, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(server, parent, factory, refMgr);
	}

	// Url
	@Override
	public String getUrl() {
		return _get("url", String.class);
	}

	@Override
	public void setUrl(String url) {
		_setScalar("url", url, String.class);
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

	// ServerVariable
	@Override
	public Map<String, ServerVariable> getServerVariables() {
		return _getMap("serverVariables", ServerVariable.class);
	}

	@Override
	public Map<String, ServerVariable> getServerVariables(boolean elaborate) {
		return _getMap("serverVariables", elaborate, ServerVariable.class);
	}

	@Override
	public boolean hasServerVariables() {
		return _isPresent("serverVariables");
	}

	@Override
	public boolean hasServerVariable(String name) {
		return _getMap("serverVariables", ServerVariable.class).containsKey(name);
	}

	@Override
	public ServerVariable getServerVariable(String name) {
		return _get("serverVariables", name, ServerVariable.class);
	}

	@Override
	public void setServerVariables(Map<String, ServerVariable> serverVariables) {
		_setMap("serverVariables", serverVariables, ServerVariable.class);
	}

	@Override
	public void setServerVariable(String name, ServerVariable serverVariable) {
		_set("serverVariables", name, serverVariable, ServerVariable.class);
	}

	@Override
	public void removeServerVariable(String name) {
		_remove("serverVariables", name, ServerVariable.class);
	}

	// VariablesExtension
	@Override
	public Map<String, Object> getVariablesExtensions() {
		return _getMap("variablesExtensions", Object.class);
	}

	@Override
	public Map<String, Object> getVariablesExtensions(boolean elaborate) {
		return _getMap("variablesExtensions", elaborate, Object.class);
	}

	@Override
	public boolean hasVariablesExtensions() {
		return _isPresent("variablesExtensions");
	}

	@Override
	public boolean hasVariablesExtension(String name) {
		return _getMap("variablesExtensions", Object.class).containsKey(name);
	}

	@Override
	public Object getVariablesExtension(String name) {
		return _get("variablesExtensions", name, Object.class);
	}

	@Override
	public void setVariablesExtensions(Map<String, Object> variablesExtensions) {
		_setMap("variablesExtensions", variablesExtensions, Object.class);
	}

	@Override
	public void setVariablesExtension(String name, Object variablesExtension) {
		_set("variablesExtensions", name, variablesExtension, Object.class);
	}

	@Override
	public void removeVariablesExtension(String name) {
		_remove("variablesExtensions", name, Object.class);
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

	public static final String F_url = "url";

	public static final String F_description = "description";

	public static final String F_serverVariables = "serverVariables";

	public static final String F_variablesExtensions = "variablesExtensions";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("url", "url", StringOverlay.factory);
		_createScalar("description", "description", StringOverlay.factory);
		_createMap("serverVariables", "variables", ServerVariableImpl.factory, "(?!x-)[a-zA-Z0-9\\._-]+");
		_createMap("variablesExtensions", "variables", ObjectOverlay.factory, "x-.+");
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<Server> factory = new OverlayFactory<Server>() {

		@Override
		protected Class<? extends JsonOverlay<? super Server>> getOverlayClass() {
			return ServerImpl.class;
		}

		@Override
		public JsonOverlay<Server> _create(Server server, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ServerImpl(server, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Server> castOverlay = (JsonOverlay<Server>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Server> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ServerImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Server> castOverlay = (JsonOverlay<Server>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends Server> getSubtypeOf(Server server) {
		return Server.class;
	}

	private static Class<? extends Server> getSubtypeOf(JsonNode json) {
		return Server.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<Server> builder(OV modelMember) {
		return new Builder<Server>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> Server create(OV modelMember) {
		return (Server) builder(modelMember).build();
	}
}
