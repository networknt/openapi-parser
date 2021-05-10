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

public interface MediaType extends IJsonOverlay<MediaType>, IModelPart<OpenApi3, MediaType> {

	// Schema
	Schema getSchema();

	Schema getSchema(boolean elaborate);

	void setSchema(Schema schema);

	// Example
	Map<String, Example> getExamples();

	Map<String, Example> getExamples(boolean elaborate);

	boolean hasExamples();

	boolean hasExample(String name);

	Example getExample(String name);

	void setExamples(Map<String, Example> examples);

	void setExample(String name, Example example);

	void removeExample(String name);

	// Example
	Object getExample();

	void setExample(Object example);

	// EncodingProperty
	Map<String, EncodingProperty> getEncodingProperties();

	Map<String, EncodingProperty> getEncodingProperties(boolean elaborate);

	boolean hasEncodingProperties();

	boolean hasEncodingProperty(String name);

	EncodingProperty getEncodingProperty(String name);

	void setEncodingProperties(Map<String, EncodingProperty> encodingProperties);

	void setEncodingProperty(String name, EncodingProperty encodingProperty);

	void removeEncodingProperty(String name);

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
