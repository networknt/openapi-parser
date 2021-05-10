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

public interface Callback extends IJsonOverlay<Callback>, IModelPart<OpenApi3, Callback> {

	String getName();

	// CallbackPath
	Map<String, Path> getCallbackPaths();

	Map<String, Path> getCallbackPaths(boolean elaborate);

	boolean hasCallbackPaths();

	boolean hasCallbackPath(String expression);

	Path getCallbackPath(String expression);

	void setCallbackPaths(Map<String, Path> callbackPaths);

	void setCallbackPath(String expression, Path callbackPath);

	void removeCallbackPath(String expression);

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
