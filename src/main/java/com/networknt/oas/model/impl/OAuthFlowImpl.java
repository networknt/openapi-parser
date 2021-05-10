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
import com.networknt.oas.model.OAuthFlow;
import com.networknt.oas.model.OpenApi3;
import java.util.Map;


public class OAuthFlowImpl extends PropertiesOverlay<OAuthFlow> implements OAuthFlow {

	public OAuthFlowImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public OAuthFlowImpl(OAuthFlow oAuthFlow, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(oAuthFlow, parent, factory, refMgr);
	}

	// AuthorizationUrl
	@Override
	public String getAuthorizationUrl() {
		return _get("authorizationUrl", String.class);
	}

	@Override
	public void setAuthorizationUrl(String authorizationUrl) {
		_setScalar("authorizationUrl", authorizationUrl, String.class);
	}

	// TokenUrl
	@Override
	public String getTokenUrl() {
		return _get("tokenUrl", String.class);
	}

	@Override
	public void setTokenUrl(String tokenUrl) {
		_setScalar("tokenUrl", tokenUrl, String.class);
	}

	// RefreshUrl
	@Override
	public String getRefreshUrl() {
		return _get("refreshUrl", String.class);
	}

	@Override
	public void setRefreshUrl(String refreshUrl) {
		_setScalar("refreshUrl", refreshUrl, String.class);
	}

	// Scope
	@Override
	public Map<String, String> getScopes() {
		return _getMap("scopes", String.class);
	}

	@Override
	public Map<String, String> getScopes(boolean elaborate) {
		return _getMap("scopes", elaborate, String.class);
	}

	@Override
	public boolean hasScopes() {
		return _isPresent("scopes");
	}

	@Override
	public boolean hasScope(String name) {
		return _getMap("scopes", String.class).containsKey(name);
	}

	@Override
	public String getScope(String name) {
		return _get("scopes", name, String.class);
	}

	@Override
	public void setScopes(Map<String, String> scopes) {
		_setMap("scopes", scopes, String.class);
	}

	@Override
	public void setScope(String name, String scope) {
		_set("scopes", name, scope, String.class);
	}

	@Override
	public void removeScope(String name) {
		_remove("scopes", name, String.class);
	}

	// ScopesExtension
	@Override
	public Map<String, Object> getScopesExtensions() {
		return _getMap("scopesExtensions", Object.class);
	}

	@Override
	public Map<String, Object> getScopesExtensions(boolean elaborate) {
		return _getMap("scopesExtensions", elaborate, Object.class);
	}

	@Override
	public boolean hasScopesExtensions() {
		return _isPresent("scopesExtensions");
	}

	@Override
	public boolean hasScopesExtension(String name) {
		return _getMap("scopesExtensions", Object.class).containsKey(name);
	}

	@Override
	public Object getScopesExtension(String name) {
		return _get("scopesExtensions", name, Object.class);
	}

	@Override
	public void setScopesExtensions(Map<String, Object> scopesExtensions) {
		_setMap("scopesExtensions", scopesExtensions, Object.class);
	}

	@Override
	public void setScopesExtension(String name, Object scopesExtension) {
		_set("scopesExtensions", name, scopesExtension, Object.class);
	}

	@Override
	public void removeScopesExtension(String name) {
		_remove("scopesExtensions", name, Object.class);
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

	public static final String F_authorizationUrl = "authorizationUrl";

	public static final String F_tokenUrl = "tokenUrl";

	public static final String F_refreshUrl = "refreshUrl";

	public static final String F_scopes = "scopes";

	public static final String F_scopesExtensions = "scopesExtensions";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("authorizationUrl", "authorizationUrl", StringOverlay.factory);
		_createScalar("tokenUrl", "tokenUrl", StringOverlay.factory);
		_createScalar("refreshUrl", "refreshUrl", StringOverlay.factory);
		_createMap("scopes", "scopes", StringOverlay.factory, "(?!x-).*");
		_createMap("scopesExtensions", "scopes", ObjectOverlay.factory, "x-.+");
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<OAuthFlow> factory = new OverlayFactory<OAuthFlow>() {

		@Override
		protected Class<? extends JsonOverlay<? super OAuthFlow>> getOverlayClass() {
			return OAuthFlowImpl.class;
		}

		@Override
		public JsonOverlay<OAuthFlow> _create(OAuthFlow oAuthFlow, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new OAuthFlowImpl(oAuthFlow, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<OAuthFlow> castOverlay = (JsonOverlay<OAuthFlow>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<OAuthFlow> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new OAuthFlowImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<OAuthFlow> castOverlay = (JsonOverlay<OAuthFlow>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends OAuthFlow> getSubtypeOf(OAuthFlow oAuthFlow) {
		return OAuthFlow.class;
	}

	private static Class<? extends OAuthFlow> getSubtypeOf(JsonNode json) {
		return OAuthFlow.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<OAuthFlow> builder(OV modelMember) {
		return new Builder<OAuthFlow>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> OAuthFlow create(OV modelMember) {
		return (OAuthFlow) builder(modelMember).build();
	}
}
