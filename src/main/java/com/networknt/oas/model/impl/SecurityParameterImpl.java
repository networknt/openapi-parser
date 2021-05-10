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
import com.networknt.oas.model.SecurityParameter;
import java.util.List;


public class SecurityParameterImpl extends PropertiesOverlay<SecurityParameter> implements SecurityParameter {

	@Override
	protected JsonNode _fixJson(JsonNode json) {
		return json.isMissingNode() ? _jsonArray() : json;
	}

	public SecurityParameterImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public SecurityParameterImpl(SecurityParameter securityParameter, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(securityParameter, parent, factory, refMgr);
	}

	// Parameter
	@Override
	public List<String> getParameters() {
		return _getList("parameters", String.class);
	}

	@Override
	public List<String> getParameters(boolean elaborate) {
		return _getList("parameters", elaborate, String.class);
	}

	@Override
	public boolean hasParameters() {
		return _isPresent("parameters");
	}

	@Override
	public String getParameter(int index) {
		return _get("parameters", index, String.class);
	}

	@Override
	public void setParameters(List<String> parameters) {
		_setList("parameters", parameters, String.class);
	}

	@Override
	public void setParameter(int index, String parameter) {
		_set("parameters", index, parameter, String.class);
	}

	@Override
	public void addParameter(String parameter) {
		_add("parameters", parameter, String.class);
	}

	@Override
	public void insertParameter(int index, String parameter) {
		_insert("parameters", index, parameter, String.class);
	}

	@Override
	public void removeParameter(int index) {
		_remove("parameters", index, String.class);
	}

	public static final String F_parameters = "parameters";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createList("parameters", "", StringOverlay.factory);
	}

	public static OverlayFactory<SecurityParameter> factory = new OverlayFactory<SecurityParameter>() {

		@Override
		protected Class<? extends JsonOverlay<? super SecurityParameter>> getOverlayClass() {
			return SecurityParameterImpl.class;
		}

		@Override
		public JsonOverlay<SecurityParameter> _create(SecurityParameter securityParameter, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new SecurityParameterImpl(securityParameter, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<SecurityParameter> castOverlay = (JsonOverlay<SecurityParameter>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<SecurityParameter> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new SecurityParameterImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<SecurityParameter> castOverlay = (JsonOverlay<SecurityParameter>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends SecurityParameter> getSubtypeOf(SecurityParameter securityParameter) {
		return SecurityParameter.class;
	}

	private static Class<? extends SecurityParameter> getSubtypeOf(JsonNode json) {
		return SecurityParameter.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<SecurityParameter> builder(OV modelMember) {
		return new Builder<SecurityParameter>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> SecurityParameter create(OV modelMember) {
		return (SecurityParameter) builder(modelMember).build();
	}
}
