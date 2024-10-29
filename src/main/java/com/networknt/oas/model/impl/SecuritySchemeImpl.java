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
import com.networknt.oas.model.SecurityScheme;
import java.util.Map;


public class SecuritySchemeImpl extends PropertiesOverlay<SecurityScheme> implements SecurityScheme {

	private Overlay<SecurityScheme> overlay = Overlay.of(this);

	@Override
	public String getKey() {
		return overlay.getParent() instanceof MapOverlay<?> ? overlay.getPathInParent() : null;
	}

	public SecuritySchemeImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public SecuritySchemeImpl(SecurityScheme securityScheme, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(securityScheme, parent, factory, refMgr);
	}

	// Type
	@Override
	public String getType() {
		return _get("type", String.class);
	}

	@Override
	public void setType(String type) {
		_setScalar("type", type, String.class);
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

	// Name
	@Override
	public String getName() {
		return _get("name", String.class);
	}

	@Override
	public void setName(String name) {
		_setScalar("name", name, String.class);
	}

	// In
	@Override
	public String getIn() {
		return _get("in", String.class);
	}

	@Override
	public void setIn(String in) {
		_setScalar("in", in, String.class);
	}

	// Scheme
	@Override
	public String getScheme() {
		return _get("scheme", String.class);
	}

	@Override
	public void setScheme(String scheme) {
		_setScalar("scheme", scheme, String.class);
	}

	// BearerFormat
	@Override
	public String getBearerFormat() {
		return _get("bearerFormat", String.class);
	}

	@Override
	public void setBearerFormat(String bearerFormat) {
		_setScalar("bearerFormat", bearerFormat, String.class);
	}

	// ImplicitOAuthFlow
	@Override
	public OAuthFlow getImplicitOAuthFlow() {
		return _get("implicitOAuthFlow", OAuthFlow.class);
	}

	@Override
	public OAuthFlow getImplicitOAuthFlow(boolean elaborate) {
		return _get("implicitOAuthFlow", elaborate, OAuthFlow.class);
	}

	@Override
	public void setImplicitOAuthFlow(OAuthFlow implicitOAuthFlow) {
		_setScalar("implicitOAuthFlow", implicitOAuthFlow, OAuthFlow.class);
	}

	// PasswordOAuthFlow
	@Override
	public OAuthFlow getPasswordOAuthFlow() {
		return _get("passwordOAuthFlow", OAuthFlow.class);
	}

	@Override
	public OAuthFlow getPasswordOAuthFlow(boolean elaborate) {
		return _get("passwordOAuthFlow", elaborate, OAuthFlow.class);
	}

	@Override
	public void setPasswordOAuthFlow(OAuthFlow passwordOAuthFlow) {
		_setScalar("passwordOAuthFlow", passwordOAuthFlow, OAuthFlow.class);
	}

	// ClientCredentialsOAuthFlow
	@Override
	public OAuthFlow getClientCredentialsOAuthFlow() {
		return _get("clientCredentialsOAuthFlow", OAuthFlow.class);
	}

	@Override
	public OAuthFlow getClientCredentialsOAuthFlow(boolean elaborate) {
		return _get("clientCredentialsOAuthFlow", elaborate, OAuthFlow.class);
	}

	@Override
	public void setClientCredentialsOAuthFlow(OAuthFlow clientCredentialsOAuthFlow) {
		_setScalar("clientCredentialsOAuthFlow", clientCredentialsOAuthFlow, OAuthFlow.class);
	}

	// AuthorizationCodeOAuthFlow
	@Override
	public OAuthFlow getAuthorizationCodeOAuthFlow() {
		return _get("authorizationCodeOAuthFlow", OAuthFlow.class);
	}

	@Override
	public OAuthFlow getAuthorizationCodeOAuthFlow(boolean elaborate) {
		return _get("authorizationCodeOAuthFlow", elaborate, OAuthFlow.class);
	}

	@Override
	public void setAuthorizationCodeOAuthFlow(OAuthFlow authorizationCodeOAuthFlow) {
		_setScalar("authorizationCodeOAuthFlow", authorizationCodeOAuthFlow, OAuthFlow.class);
	}

	// OAuthFlowsExtension
	@Override
	public Map<String, Object> getOAuthFlowsExtensions() {
		return _getMap("oAuthFlowsExtensions", Object.class);
	}

	@Override
	public Map<String, Object> getOAuthFlowsExtensions(boolean elaborate) {
		return _getMap("oAuthFlowsExtensions", elaborate, Object.class);
	}

	@Override
	public boolean hasOAuthFlowsExtensions() {
		return _isPresent("oAuthFlowsExtensions");
	}

	@Override
	public boolean hasOAuthFlowsExtension(String name) {
		return _getMap("oAuthFlowsExtensions", Object.class).containsKey(name);
	}

	@Override
	public Object getOAuthFlowsExtension(String name) {
		return _get("oAuthFlowsExtensions", name, Object.class);
	}

	@Override
	public void setOAuthFlowsExtensions(Map<String, Object> oAuthFlowsExtensions) {
		_setMap("oAuthFlowsExtensions", oAuthFlowsExtensions, Object.class);
	}

	@Override
	public void setOAuthFlowsExtension(String name, Object oAuthFlowsExtension) {
		_set("oAuthFlowsExtensions", name, oAuthFlowsExtension, Object.class);
	}

	@Override
	public void removeOAuthFlowsExtension(String name) {
		_remove("oAuthFlowsExtensions", name, Object.class);
	}

	// OpenIdConnectUrl
	@Override
	public String getOpenIdConnectUrl() {
		return _get("openIdConnectUrl", String.class);
	}

	@Override
	public void setOpenIdConnectUrl(String openIdConnectUrl) {
		_setScalar("openIdConnectUrl", openIdConnectUrl, String.class);
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

	public static final String F_type = "type";

	public static final String F_description = "description";

	public static final String F_name = "name";

	public static final String F_in = "in";

	public static final String F_scheme = "scheme";

	public static final String F_bearerFormat = "bearerFormat";

	public static final String F_implicitOAuthFlow = "implicitOAuthFlow";

	public static final String F_passwordOAuthFlow = "passwordOAuthFlow";

	public static final String F_clientCredentialsOAuthFlow = "clientCredentialsOAuthFlow";

	public static final String F_authorizationCodeOAuthFlow = "authorizationCodeOAuthFlow";

	public static final String F_oAuthFlowsExtensions = "oAuthFlowsExtensions";

	public static final String F_openIdConnectUrl = "openIdConnectUrl";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("type", "type", StringOverlay.factory);
		_createScalar("description", "description", StringOverlay.factory);
		_createScalar("name", "name", StringOverlay.factory);
		_createScalar("in", "in", StringOverlay.factory);
		_createScalar("scheme", "scheme", StringOverlay.factory);
		_createScalar("bearerFormat", "bearerFormat", StringOverlay.factory);
		_createScalar("implicitOAuthFlow", "flow/implicit", OAuthFlowImpl.factory);
		_createScalar("passwordOAuthFlow", "flow/password", OAuthFlowImpl.factory);
		_createScalar("clientCredentialsOAuthFlow", "flow/clientCredentials", OAuthFlowImpl.factory);
		_createScalar("authorizationCodeOAuthFlow", "flow/authorizationCode", OAuthFlowImpl.factory);
		_createMap("oAuthFlowsExtensions", "flow", ObjectOverlay.factory, "x-.+");
		_createScalar("openIdConnectUrl", "openIdConnectUrl", StringOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<SecurityScheme> factory = new OverlayFactory<SecurityScheme>() {

		@Override
		protected Class<? extends JsonOverlay<? super SecurityScheme>> getOverlayClass() {
			return SecuritySchemeImpl.class;
		}

		@Override
		public JsonOverlay<SecurityScheme> _create(SecurityScheme securityScheme, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new SecuritySchemeImpl(securityScheme, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<SecurityScheme> castOverlay = (JsonOverlay<SecurityScheme>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<SecurityScheme> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new SecuritySchemeImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<SecurityScheme> castOverlay = (JsonOverlay<SecurityScheme>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends SecurityScheme> getSubtypeOf(SecurityScheme securityScheme) {
		return SecurityScheme.class;
	}

	private static Class<? extends SecurityScheme> getSubtypeOf(JsonNode json) {
		return SecurityScheme.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<SecurityScheme> builder(OV modelMember) {
		return new Builder<SecurityScheme>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> SecurityScheme create(OV modelMember) {
		return (SecurityScheme) builder(modelMember).build();
	}
}
