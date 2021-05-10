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

public interface OAuthFlow extends IJsonOverlay<OAuthFlow>, IModelPart<OpenApi3, OAuthFlow> {

	// AuthorizationUrl
	String getAuthorizationUrl();

	void setAuthorizationUrl(String authorizationUrl);

	// TokenUrl
	String getTokenUrl();

	void setTokenUrl(String tokenUrl);

	// RefreshUrl
	String getRefreshUrl();

	void setRefreshUrl(String refreshUrl);

	// Scope
	Map<String, String> getScopes();

	Map<String, String> getScopes(boolean elaborate);

	boolean hasScopes();

	boolean hasScope(String name);

	String getScope(String name);

	void setScopes(Map<String, String> scopes);

	void setScope(String name, String scope);

	void removeScope(String name);

	// ScopesExtension
	Map<String, Object> getScopesExtensions();

	Map<String, Object> getScopesExtensions(boolean elaborate);

	boolean hasScopesExtensions();

	boolean hasScopesExtension(String name);

	Object getScopesExtension(String name);

	void setScopesExtensions(Map<String, Object> scopesExtensions);

	void setScopesExtension(String name, Object scopesExtension);

	void removeScopesExtension(String name);

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
