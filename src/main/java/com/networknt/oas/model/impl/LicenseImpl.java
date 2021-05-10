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
import com.networknt.oas.model.License;
import com.networknt.oas.model.OpenApi3;
import java.util.Map;


public class LicenseImpl extends PropertiesOverlay<License> implements License {

	JsonNode initJson = _jsonMissing();

	public LicenseImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public LicenseImpl(License license, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(license, parent, factory, refMgr);
	}

	// Name
	@Override
	public String getName() {
		return _get("name", String.class);
	}

	@Override
	public void setName(String name) {
		_setScalar("name", name, String.class);
	}

	// Url
	@Override
	public String getUrl() {
		return _get("url", String.class);
	}

	@Override
	public void setUrl(String url) {
		_setScalar("url", url, String.class);
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

	public static final String F_name = "name";

	public static final String F_url = "url";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("name", "name", StringOverlay.factory);
		_createScalar("url", "url", StringOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<License> factory = new OverlayFactory<License>() {

		@Override
		protected Class<? extends JsonOverlay<? super License>> getOverlayClass() {
			return LicenseImpl.class;
		}

		@Override
		public JsonOverlay<License> _create(License license, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new LicenseImpl(license, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<License> castOverlay = (JsonOverlay<License>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<License> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new LicenseImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<License> castOverlay = (JsonOverlay<License>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends License> getSubtypeOf(License license) {
		return License.class;
	}

	private static Class<? extends License> getSubtypeOf(JsonNode json) {
		return License.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<License> builder(OV modelMember) {
		return new Builder<License>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> License create(OV modelMember) {
		return (License) builder(modelMember).build();
	}
}
