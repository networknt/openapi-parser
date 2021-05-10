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
import com.networknt.oas.model.SecurityRequirement;
import java.util.Map;


public class SecurityRequirementImpl extends PropertiesOverlay<SecurityRequirement> implements SecurityRequirement {

	public SecurityRequirementImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public SecurityRequirementImpl(SecurityRequirement securityRequirement, JsonOverlay<?> parent,
			ReferenceManager refMgr) {
		super(securityRequirement, parent, factory, refMgr);
	}

	// Requirement
	@Override
	public Map<String, SecurityParameter> getRequirements() {
		return _getMap("requirements", SecurityParameter.class);
	}

	@Override
	public Map<String, SecurityParameter> getRequirements(boolean elaborate) {
		return _getMap("requirements", elaborate, SecurityParameter.class);
	}

	@Override
	public boolean hasRequirements() {
		return _isPresent("requirements");
	}

	@Override
	public boolean hasRequirement(String name) {
		return _getMap("requirements", SecurityParameter.class).containsKey(name);
	}

	@Override
	public SecurityParameter getRequirement(String name) {
		return _get("requirements", name, SecurityParameter.class);
	}

	@Override
	public void setRequirements(Map<String, SecurityParameter> requirements) {
		_setMap("requirements", requirements, SecurityParameter.class);
	}

	@Override
	public void setRequirement(String name, SecurityParameter requirement) {
		_set("requirements", name, requirement, SecurityParameter.class);
	}

	@Override
	public void removeRequirement(String name) {
		_remove("requirements", name, SecurityParameter.class);
	}

	public static final String F_requirements = "requirements";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createMap("requirements", "", SecurityParameterImpl.factory, "[a-zA-Z0-9\\._-]+");
	}

	public static OverlayFactory<SecurityRequirement> factory = new OverlayFactory<SecurityRequirement>() {

		@Override
		protected Class<? extends JsonOverlay<? super SecurityRequirement>> getOverlayClass() {
			return SecurityRequirementImpl.class;
		}

		@Override
		public JsonOverlay<SecurityRequirement> _create(SecurityRequirement securityRequirement, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new SecurityRequirementImpl(securityRequirement, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<SecurityRequirement> castOverlay = (JsonOverlay<SecurityRequirement>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<SecurityRequirement> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new SecurityRequirementImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<SecurityRequirement> castOverlay = (JsonOverlay<SecurityRequirement>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends SecurityRequirement> getSubtypeOf(SecurityRequirement securityRequirement) {
		return SecurityRequirement.class;
	}

	private static Class<? extends SecurityRequirement> getSubtypeOf(JsonNode json) {
		return SecurityRequirement.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<SecurityRequirement> builder(OV modelMember) {
		return new Builder<SecurityRequirement>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> SecurityRequirement create(OV modelMember) {
		return (SecurityRequirement) builder(modelMember).build();
	}
}
