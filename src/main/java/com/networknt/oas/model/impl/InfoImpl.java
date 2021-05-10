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
package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.jsonoverlay.*;
import com.networknt.oas.model.Contact;
import com.networknt.oas.model.Info;
import com.networknt.oas.model.License;
import com.networknt.oas.model.OpenApi3;
import java.util.Map;

public class InfoImpl extends PropertiesOverlay<Info> implements Info {

	public InfoImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public InfoImpl(Info info, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(info, parent, factory, refMgr);
	}

	// Title
	@Override
	public String getTitle() {
		return _get("title", String.class);
	}

	@Override
	public void setTitle(String title) {
		_setScalar("title", title, String.class);
	}

	// Description
	@Override
	public String getDescription() {
		return _get("description", String.class);
	}

	@Override
	public void setDescription(String description) {
		_setScalar("description", description, String.class);
	}

	// TermsOfService
	@Override
	public String getTermsOfService() {
		return _get("termsOfService", String.class);
	}

	@Override
	public void setTermsOfService(String termsOfService) {
		_setScalar("termsOfService", termsOfService, String.class);
	}

	// Contact
	@Override
	public Contact getContact() {
		return _get("contact", Contact.class);
	}

	@Override
	public Contact getContact(boolean elaborate) {
		return _get("contact", elaborate, Contact.class);
	}

	@Override
	public void setContact(Contact contact) {
		_setScalar("contact", contact, Contact.class);
	}

	// License
	@Override
	public License getLicense() {
		return _get("license", License.class);
	}

	@Override
	public License getLicense(boolean elaborate) {
		return _get("license", elaborate, License.class);
	}

	@Override
	public void setLicense(License license) {
		_setScalar("license", license, License.class);
	}

	// Version
	@Override
	public String getVersion() {
		return _get("version", String.class);
	}

	@Override
	public void setVersion(String version) {
		_setScalar("version", version, String.class);
	}

	// Extension
	@Override
	public Map<String, Object> getExtensions() {
		return _getMap("extensions", Object.class);
	}

	@Override
	public Map<String, Object> getExtensions(boolean elaborate) {
		return _getMap("extensions", elaborate, Object.class);
	}

	@Override
	public boolean hasExtensions() {
		return _isPresent("extensions");
	}

	@Override
	public boolean hasExtension(String name) {
		return _getMap("extensions", Object.class).containsKey(name);
	}

	@Override
	public Object getExtension(String name) {
		return _get("extensions", name, Object.class);
	}

	@Override
	public void setExtensions(Map<String, Object> extensions) {
		_setMap("extensions", extensions, Object.class);
	}

	@Override
	public void setExtension(String name, Object extension) {
		_set("extensions", name, extension, Object.class);
	}

	@Override
	public void removeExtension(String name) {
		_remove("extensions", name, Object.class);
	}

	public static final String F_title = "title";

	public static final String F_description = "description";

	public static final String F_termsOfService = "termsOfService";

	public static final String F_contact = "contact";

	public static final String F_license = "license";

	public static final String F_version = "version";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("title", "title", StringOverlay.factory);
		_createScalar("description", "description", StringOverlay.factory);
		_createScalar("termsOfService", "termsOfService", StringOverlay.factory);
		_createScalar("contact", "contact", ContactImpl.factory);
		_createScalar("license", "license", LicenseImpl.factory);
		_createScalar("version", "version", StringOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<Info> factory = new OverlayFactory<Info>() {

		@Override
		protected Class<? extends JsonOverlay<? super Info>> getOverlayClass() {
			return InfoImpl.class;
		}

		@Override
		public JsonOverlay<Info> _create(Info info, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new InfoImpl(info, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Info> castOverlay = (JsonOverlay<Info>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Info> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new InfoImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Info> castOverlay = (JsonOverlay<Info>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends Info> getSubtypeOf(Info info) {
		return Info.class;
	}

	private static Class<? extends Info> getSubtypeOf(JsonNode json) {
		return Info.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<Info> builder(OV modelMember) {
		return new Builder<Info>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> Info create(OV modelMember) {
		return (Info) builder(modelMember).build();
	}
}
