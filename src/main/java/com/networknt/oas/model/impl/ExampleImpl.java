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
import com.networknt.oas.model.Example;
import com.networknt.oas.model.OpenApi3;
import java.util.Map;


public class ExampleImpl extends PropertiesOverlay<Example> implements Example {

	private Overlay<Example> overlay = Overlay.of(this);

	@Override
	public String getName() {
		return overlay.getParent() instanceof MapOverlay<?> ? overlay.getPathInParent() : null;
	}

	public ExampleImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public ExampleImpl(Example example, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(example, parent, factory, refMgr);
	}

	// Summary
	@Override
	public String getSummary() {
		return _get("summary", String.class);
	}

	@Override
	public void setSummary(String summary) {
		_setScalar("summary", summary, String.class);
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

	// Value
	@Override
	public Object getValue() {
		return _get("value", Object.class);
	}

	@Override
	public void setValue(Object value) {
		_setScalar("value", value, Object.class);
	}

	// ExternalValue
	@Override
	public String getExternalValue() {
		return _get("externalValue", String.class);
	}

	@Override
	public void setExternalValue(String externalValue) {
		_setScalar("externalValue", externalValue, String.class);
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

	public static final String F_summary = "summary";

	public static final String F_description = "description";

	public static final String F_value = "value";

	public static final String F_externalValue = "externalValue";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("summary", "summary", StringOverlay.factory);
		_createScalar("description", "description", StringOverlay.factory);
		_createScalar("value", "value", ObjectOverlay.factory);
		_createScalar("externalValue", "externalValue", StringOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<Example> factory = new OverlayFactory<Example>() {

		@Override
		protected Class<? extends JsonOverlay<? super Example>> getOverlayClass() {
			return ExampleImpl.class;
		}

		@Override
		public JsonOverlay<Example> _create(Example example, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ExampleImpl(example, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Example> castOverlay = (JsonOverlay<Example>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Example> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ExampleImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Example> castOverlay = (JsonOverlay<Example>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends Example> getSubtypeOf(Example example) {
		return Example.class;
	}

	private static Class<? extends Example> getSubtypeOf(JsonNode json) {
		return Example.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<Example> builder(OV modelMember) {
		return new Builder<Example>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> Example create(OV modelMember) {
		return (Example) builder(modelMember).build();
	}
}
