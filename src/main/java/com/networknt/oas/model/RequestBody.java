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

public interface RequestBody extends IJsonOverlay<RequestBody>, IModelPart<OpenApi3, RequestBody> {

	String getName();

	// Description
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getDescription();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setDescription(String description);

	// ContentMediaType
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, MediaType> getContentMediaTypes();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, MediaType> getContentMediaTypes(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasContentMediaTypes();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasContentMediaType(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	MediaType getContentMediaType(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setContentMediaTypes(Map<String, MediaType> contentMediaTypes);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setContentMediaType(String name, MediaType contentMediaType);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeContentMediaType(String name);

	// Required
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Boolean getRequired();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean isRequired();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setRequired(Boolean required);

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
