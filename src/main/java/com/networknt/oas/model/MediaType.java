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

public interface MediaType extends IJsonOverlay<MediaType>, IModelPart<OpenApi3, MediaType> {

	// Schema
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Schema getSchema();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Schema getSchema(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setSchema(Schema schema);

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

	// EncodingProperty
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, EncodingProperty> getEncodingProperties();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, EncodingProperty> getEncodingProperties(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasEncodingProperties();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasEncodingProperty(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	EncodingProperty getEncodingProperty(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setEncodingProperties(Map<String, EncodingProperty> encodingProperties);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setEncodingProperty(String name, EncodingProperty encodingProperty);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeEncodingProperty(String name);

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
