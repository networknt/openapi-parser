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

import com.networknt.jsonoverlay.IJsonOverlay;
import com.networknt.jsonoverlay.IModelPart;

public interface SecurityScheme extends IJsonOverlay<SecurityScheme>, IModelPart<OpenApi3, SecurityScheme> {

	String getKey();

	// Type
	String getType();

	void setType(String type);

	// Description
	String getDescription();

	void setDescription(String description);

	// Name
	String getName();

	void setName(String name);

	// In
	String getIn();

	void setIn(String in);

	// Scheme
	String getScheme();

	void setScheme(String scheme);

	// BearerFormat
	String getBearerFormat();

	void setBearerFormat(String bearerFormat);

	// ImplicitOAuthFlow
	OAuthFlow getImplicitOAuthFlow();

	OAuthFlow getImplicitOAuthFlow(boolean elaborate);

	void setImplicitOAuthFlow(OAuthFlow implicitOAuthFlow);

	// PasswordOAuthFlow
	OAuthFlow getPasswordOAuthFlow();

	OAuthFlow getPasswordOAuthFlow(boolean elaborate);

	void setPasswordOAuthFlow(OAuthFlow passwordOAuthFlow);

	// ClientCredentialsOAuthFlow
	OAuthFlow getClientCredentialsOAuthFlow();

	OAuthFlow getClientCredentialsOAuthFlow(boolean elaborate);

	void setClientCredentialsOAuthFlow(OAuthFlow clientCredentialsOAuthFlow);

	// AuthorizationCodeOAuthFlow
	OAuthFlow getAuthorizationCodeOAuthFlow();

	OAuthFlow getAuthorizationCodeOAuthFlow(boolean elaborate);

	void setAuthorizationCodeOAuthFlow(OAuthFlow authorizationCodeOAuthFlow);

	// OAuthFlowsExtension
	Map<String, Object> getOAuthFlowsExtensions();

	Map<String, Object> getOAuthFlowsExtensions(boolean elaborate);

	boolean hasOAuthFlowsExtensions();

	boolean hasOAuthFlowsExtension(String name);

	Object getOAuthFlowsExtension(String name);

	void setOAuthFlowsExtensions(Map<String, Object> oAuthFlowsExtensions);

	void setOAuthFlowsExtension(String name, Object oAuthFlowsExtension);

	void removeOAuthFlowsExtension(String name);

	// OpenIdConnectUrl
	String getOpenIdConnectUrl();

	void setOpenIdConnectUrl(String openIdConnectUrl);

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
