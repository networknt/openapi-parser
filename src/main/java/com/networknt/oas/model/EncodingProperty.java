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

import javax.annotation.Generated;

import com.networknt.jsonoverlay.IJsonOverlay;
import com.networknt.jsonoverlay.IModelPart;

public interface EncodingProperty extends IJsonOverlay<EncodingProperty>, IModelPart<OpenApi3, EncodingProperty> {

	// ContentType
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getContentType();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setContentType(String contentType);

	// Header
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, String> getHeaders();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, String> getHeaders(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasHeaders();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasHeader(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getHeader(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setHeaders(Map<String, String> headers);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setHeader(String name, String header);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeHeader(String name);

	// Style
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getStyle();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setStyle(String style);

	// Explode
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Boolean getExplode();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean isExplode();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setExplode(Boolean explode);

	// AllowReserved
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Boolean getAllowReserved();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean isAllowReserved();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setAllowReserved(Boolean allowReserved);

	// Extension
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, Object> getExtensions();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, Object> getExtensions(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasExtensions();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasExtension(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Object getExtension(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setExtensions(Map<String, Object> extensions);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setExtension(String name, Object extension);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeExtension(String name);
}
