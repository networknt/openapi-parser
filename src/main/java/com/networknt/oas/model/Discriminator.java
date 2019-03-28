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

public interface Discriminator extends IJsonOverlay<Discriminator>, IModelPart<OpenApi3, Discriminator> {

	// PropertyName
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getPropertyName();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setPropertyName(String propertyName);

	// Mapping
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, String> getMappings();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, String> getMappings(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasMappings();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasMapping(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getMapping(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setMappings(Map<String, String> mappings);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setMapping(String name, String mapping);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeMapping(String name);
}
