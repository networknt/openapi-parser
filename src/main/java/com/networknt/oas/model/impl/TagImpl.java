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
import com.networknt.oas.model.Tag;
import java.util.Map;


public class TagImpl extends PropertiesOverlay<Tag> implements Tag {

	public TagImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public TagImpl(Tag tag, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(tag, parent, factory, refMgr);
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

	// Description
	@Override
	public String getDescription() {
		return _get("description", String.class);
	}

	@Override
	public void setDescription(String description) {
		_setScalar("description", description, String.class);
	}

	// ExternalDocs
	@Override
	public ExternalDocs getExternalDocs() {
		return _get("externalDocs", ExternalDocs.class);
	}

	@Override
	public ExternalDocs getExternalDocs(boolean elaborate) {
		return _get("externalDocs", elaborate, ExternalDocs.class);
	}

	@Override
	public void setExternalDocs(ExternalDocs externalDocs) {
		_setScalar("externalDocs", externalDocs, ExternalDocs.class);
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

	public static final String F_description = "description";

	public static final String F_externalDocs = "externalDocs";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("name", "name", StringOverlay.factory);
		_createScalar("description", "description", StringOverlay.factory);
		_createScalar("externalDocs", "externalDocs", ExternalDocsImpl.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<Tag> factory = new OverlayFactory<Tag>() {

		@Override
		protected Class<? extends JsonOverlay<? super Tag>> getOverlayClass() {
			return TagImpl.class;
		}

		@Override
		public JsonOverlay<Tag> _create(Tag tag, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new TagImpl(tag, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Tag> castOverlay = (JsonOverlay<Tag>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Tag> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new TagImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Tag> castOverlay = (JsonOverlay<Tag>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends Tag> getSubtypeOf(Tag tag) {
		return Tag.class;
	}

	private static Class<? extends Tag> getSubtypeOf(JsonNode json) {
		return Tag.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<Tag> builder(OV modelMember) {
		return new Builder<Tag>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> Tag create(OV modelMember) {
		return (Tag) builder(modelMember).build();
	}
}
