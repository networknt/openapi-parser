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

public interface Discriminator extends IJsonOverlay<Discriminator>, IModelPart<OpenApi3, Discriminator> {

	// PropertyName
	String getPropertyName();

	void setPropertyName(String propertyName);

	// Mapping
	Map<String, String> getMappings();

	Map<String, String> getMappings(boolean elaborate);

	boolean hasMappings();

	boolean hasMapping(String name);

	String getMapping(String name);

	void setMappings(Map<String, String> mappings);

	void setMapping(String name, String mapping);

	void removeMapping(String name);
}
