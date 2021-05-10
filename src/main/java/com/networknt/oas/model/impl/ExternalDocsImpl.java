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
import com.networknt.oas.model.ExternalDocs;
import com.networknt.oas.model.OpenApi3;
import java.util.Map;


public class ExternalDocsImpl extends PropertiesOverlay<ExternalDocs> implements ExternalDocs {

	public ExternalDocsImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public ExternalDocsImpl(ExternalDocs externalDocs, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(externalDocs, parent, factory, refMgr);
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

	public static final String F_description = "description";

	public static final String F_url = "url";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("description", "description", StringOverlay.factory);
		_createScalar("url", "url", StringOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<ExternalDocs> factory = new OverlayFactory<ExternalDocs>() {

		@Override
		protected Class<? extends JsonOverlay<? super ExternalDocs>> getOverlayClass() {
			return ExternalDocsImpl.class;
		}

		@Override
		public JsonOverlay<ExternalDocs> _create(ExternalDocs externalDocs, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ExternalDocsImpl(externalDocs, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<ExternalDocs> castOverlay = (JsonOverlay<ExternalDocs>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<ExternalDocs> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ExternalDocsImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<ExternalDocs> castOverlay = (JsonOverlay<ExternalDocs>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends ExternalDocs> getSubtypeOf(ExternalDocs externalDocs) {
		return ExternalDocs.class;
	}

	private static Class<? extends ExternalDocs> getSubtypeOf(JsonNode json) {
		return ExternalDocs.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<ExternalDocs> builder(OV modelMember) {
		return new Builder<ExternalDocs>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> ExternalDocs create(OV modelMember) {
		return (ExternalDocs) builder(modelMember).build();
	}
}
