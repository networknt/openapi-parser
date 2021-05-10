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
import com.networknt.oas.model.Link;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.Server;
import java.util.Map;


public class LinkImpl extends PropertiesOverlay<Link> implements Link {

	private Overlay<Link> overlay = Overlay.of(this);

	@Override
	public String getName() {
		return overlay.getParent() instanceof MapOverlay<?> ? overlay.getPathInParent() : null;
	}

	public LinkImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public LinkImpl(Link link, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(link, parent, factory, refMgr);
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

	// OperationRef
	@Override
	public String getOperationRef() {
		return _get("operationRef", String.class);
	}

	@Override
	public void setOperationRef(String operationRef) {
		_setScalar("operationRef", operationRef, String.class);
	}

	// Parameter
	@Override
	public Map<String, String> getParameters() {
		return _getMap("parameters", String.class);
	}

	@Override
	public Map<String, String> getParameters(boolean elaborate) {
		return _getMap("parameters", elaborate, String.class);
	}

	@Override
	public boolean hasParameters() {
		return _isPresent("parameters");
	}

	@Override
	public boolean hasParameter(String name) {
		return _getMap("parameters", String.class).containsKey(name);
	}

	@Override
	public String getParameter(String name) {
		return _get("parameters", name, String.class);
	}

	@Override
	public void setParameters(Map<String, String> parameters) {
		_setMap("parameters", parameters, String.class);
	}

	@Override
	public void setParameter(String name, String parameter) {
		_set("parameters", name, parameter, String.class);
	}

	@Override
	public void removeParameter(String name) {
		_remove("parameters", name, String.class);
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

	// Server
	@Override
	public Server getServer() {
		return _get("server", Server.class);
	}

	@Override
	public Server getServer(boolean elaborate) {
		return _get("server", elaborate, Server.class);
	}

	@Override
	public void setServer(Server server) {
		_setScalar("server", server, Server.class);
	}

	// RequestBody
	@Override
	public Object getRequestBody() {
		return _get("requestBody", Object.class);
	}

	@Override
	public void setRequestBody(Object requestBody) {
		_setScalar("requestBody", requestBody, Object.class);
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

	public static final String F_operationId = "operationId";

	public static final String F_operationRef = "operationRef";

	public static final String F_parameters = "parameters";

	public static final String F_description = "description";

	public static final String F_server = "server";

	public static final String F_requestBody = "requestBody";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("operationId", "operationId", StringOverlay.factory);
		_createScalar("operationRef", "operationRef", StringOverlay.factory);
		_createMap("parameters", "parameters", StringOverlay.factory, null);
		_createScalar("description", "description", StringOverlay.factory);
		_createScalar("server", "server", ServerImpl.factory);
		_createScalar("requestBody", "requestBody", ObjectOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<Link> factory = new OverlayFactory<Link>() {

		@Override
		protected Class<? extends JsonOverlay<? super Link>> getOverlayClass() {
			return LinkImpl.class;
		}

		@Override
		public JsonOverlay<Link> _create(Link link, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new LinkImpl(link, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Link> castOverlay = (JsonOverlay<Link>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Link> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new LinkImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Link> castOverlay = (JsonOverlay<Link>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends Link> getSubtypeOf(Link link) {
		return Link.class;
	}

	private static Class<? extends Link> getSubtypeOf(JsonNode json) {
		return Link.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<Link> builder(OV modelMember) {
		return new Builder<Link>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> Link create(OV modelMember) {
		return (Link) builder(modelMember).build();
	}
}
