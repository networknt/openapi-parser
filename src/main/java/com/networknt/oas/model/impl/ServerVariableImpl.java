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
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.ServerVariable;
import java.util.List;
import java.util.Map;


public class ServerVariableImpl extends PropertiesOverlay<ServerVariable> implements ServerVariable {

	public ServerVariableImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public ServerVariableImpl(ServerVariable serverVariable, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(serverVariable, parent, factory, refMgr);
	}

	// EnumValue
	@Override
	public List<String> getEnumValues() {
		return _getList("enumValues", String.class);
	}

	@Override
	public List<String> getEnumValues(boolean elaborate) {
		return _getList("enumValues", elaborate, String.class);
	}

	@Override
	public boolean hasEnumValues() {
		return _isPresent("enumValues");
	}

	@Override
	public String getEnumValue(int index) {
		return _get("enumValues", index, String.class);
	}

	@Override
	public void setEnumValues(List<String> enumValues) {
		_setList("enumValues", enumValues, String.class);
	}

	@Override
	public void setEnumValue(int index, String enumValue) {
		_set("enumValues", index, enumValue, String.class);
	}

	@Override
	public void addEnumValue(String enumValue) {
		_add("enumValues", enumValue, String.class);
	}

	@Override
	public void insertEnumValue(int index, String enumValue) {
		_insert("enumValues", index, enumValue, String.class);
	}

	@Override
	public void removeEnumValue(int index) {
		_remove("enumValues", index, String.class);
	}

	// Default
	@Override
	public String getDefault() {
		return _get("defaultValue", String.class);
	}

	@Override
	public void setDefault(String defaultValue) {
		_setScalar("defaultValue", defaultValue, String.class);
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

	public static final String F_enumValues = "enumValues";

	public static final String F_defaultValue = "defaultValue";

	public static final String F_description = "description";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createList("enumValues", "enum", StringOverlay.factory);
		_createScalar("defaultValue", "default", StringOverlay.factory);
		_createScalar("description", "description", StringOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<ServerVariable> factory = new OverlayFactory<ServerVariable>() {

		@Override
		protected Class<? extends JsonOverlay<? super ServerVariable>> getOverlayClass() {
			return ServerVariableImpl.class;
		}

		@Override
		public JsonOverlay<ServerVariable> _create(ServerVariable serverVariable, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ServerVariableImpl(serverVariable, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<ServerVariable> castOverlay = (JsonOverlay<ServerVariable>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<ServerVariable> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ServerVariableImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<ServerVariable> castOverlay = (JsonOverlay<ServerVariable>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends ServerVariable> getSubtypeOf(ServerVariable serverVariable) {
		return ServerVariable.class;
	}

	private static Class<? extends ServerVariable> getSubtypeOf(JsonNode json) {
		return ServerVariable.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<ServerVariable> builder(OV modelMember) {
		return new Builder<ServerVariable>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> ServerVariable create(OV modelMember) {
		return (ServerVariable) builder(modelMember).build();
	}
}
