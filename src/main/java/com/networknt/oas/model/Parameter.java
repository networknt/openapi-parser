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

public interface Parameter extends IJsonOverlay<Parameter>, IModelPart<OpenApi3, Parameter> {

	String getKey();

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

	// Example
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, Example> getExamples();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, Example> getExamples(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasExamples();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasExample(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Example getExample(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setExamples(Map<String, Example> examples);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setExample(String name, Example example);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeExample(String name);

	// Example
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Object getExample();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setExample(Object example);

	// Schema
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Schema getSchema();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Schema getSchema(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setSchema(Schema schema);

	// AllowReserved
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Boolean getAllowReserved();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean isAllowReserved();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setAllowReserved(Boolean allowReserved);

	// Explode
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Boolean getExplode();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean isExplode();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setExplode(Boolean explode);

	// Style
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getStyle();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setStyle(String style);

	// AllowEmptyValue
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Boolean getAllowEmptyValue();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean isAllowEmptyValue();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setAllowEmptyValue(Boolean allowEmptyValue);

	// Deprecated
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Boolean getDeprecated();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean isDeprecated();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setDeprecated(Boolean deprecated);

	// Required
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Boolean getRequired();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean isRequired();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setRequired(Boolean required);

	// Description
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getDescription();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setDescription(String description);

	// Name
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getName();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setName(String name);

	// In
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getIn();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setIn(String in);
}
