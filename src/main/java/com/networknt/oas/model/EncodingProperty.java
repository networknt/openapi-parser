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

public interface EncodingProperty extends IJsonOverlay<EncodingProperty>, IModelPart<OpenApi3, EncodingProperty> {

	// ContentType
	String getContentType();

	void setContentType(String contentType);

	// Header
	Map<String, String> getHeaders();

	Map<String, String> getHeaders(boolean elaborate);

	boolean hasHeaders();

	boolean hasHeader(String name);

	String getHeader(String name);

	void setHeaders(Map<String, String> headers);

	void setHeader(String name, String header);

	void removeHeader(String name);

	// Style
	String getStyle();

	void setStyle(String style);

	// Explode
	Boolean getExplode();

	boolean isExplode();

	void setExplode(Boolean explode);

	// AllowReserved
	Boolean getAllowReserved();

	boolean isAllowReserved();

	void setAllowReserved(Boolean allowReserved);

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
