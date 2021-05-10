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

public interface Header extends IJsonOverlay<Header>, IModelPart<OpenApi3, Header> {

	String getKey();

	// Description
	String getDescription();

	void setDescription(String description);

	// Required
	Boolean getRequired();

	boolean isRequired();

	void setRequired(Boolean required);

	// Deprecated
	Boolean getDeprecated();

	boolean isDeprecated();

	void setDeprecated(Boolean deprecated);

	// AllowEmptyValue
	Boolean getAllowEmptyValue();

	boolean isAllowEmptyValue();

	void setAllowEmptyValue(Boolean allowEmptyValue);

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

	// Schema
	Schema getSchema();

	Schema getSchema(boolean elaborate);

	void setSchema(Schema schema);

	// Example
	Object getExample();

	void setExample(Object example);

	// Example
	Map<String, Example> getExamples();

	Map<String, Example> getExamples(boolean elaborate);

	boolean hasExamples();

	boolean hasExample(String name);

	Example getExample(String name);

	void setExamples(Map<String, Example> examples);

	void setExample(String name, Example example);

	void removeExample(String name);

	// ContentMediaType
	Map<String, MediaType> getContentMediaTypes();

	Map<String, MediaType> getContentMediaTypes(boolean elaborate);

	boolean hasContentMediaTypes();

	boolean hasContentMediaType(String name);

	MediaType getContentMediaType(String name);

	void setContentMediaTypes(Map<String, MediaType> contentMediaTypes);

	void setContentMediaType(String name, MediaType contentMediaType);

	void removeContentMediaType(String name);

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
