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

public interface Info extends IJsonOverlay<Info>, IModelPart<OpenApi3, Info> {

	// Title
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getTitle();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setTitle(String title);

	// Description
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getDescription();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setDescription(String description);

	// TermsOfService
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getTermsOfService();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setTermsOfService(String termsOfService);

	// Contact
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Contact getContact();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Contact getContact(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setContact(Contact contact);

	// License
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	License getLicense();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	License getLicense(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setLicense(License license);

	// Version
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getVersion();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setVersion(String version);

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
