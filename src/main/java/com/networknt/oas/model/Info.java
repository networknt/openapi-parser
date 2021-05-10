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

public interface Info extends IJsonOverlay<Info>, IModelPart<OpenApi3, Info> {

	// Title
	String getTitle();

	void setTitle(String title);

	// Description
	String getDescription();

	void setDescription(String description);

	// TermsOfService
	String getTermsOfService();

	void setTermsOfService(String termsOfService);

	// Contact
	Contact getContact();

	Contact getContact(boolean elaborate);

	void setContact(Contact contact);

	// License
	License getLicense();

	License getLicense(boolean elaborate);

	void setLicense(License license);

	// Version
	String getVersion();

	void setVersion(String version);

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
