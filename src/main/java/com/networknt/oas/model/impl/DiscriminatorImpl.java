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

import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.jsonoverlay.Builder;
import com.networknt.jsonoverlay.IJsonOverlay;
import com.networknt.jsonoverlay.JsonOverlay;
import com.networknt.jsonoverlay.OverlayFactory;
import com.networknt.jsonoverlay.PropertiesOverlay;
import com.networknt.jsonoverlay.ReferenceManager;
import com.networknt.jsonoverlay.StringOverlay;
import com.networknt.oas.model.Discriminator;
import com.networknt.oas.model.OpenApi3;

public class DiscriminatorImpl extends PropertiesOverlay<Discriminator> implements Discriminator {

	public DiscriminatorImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public DiscriminatorImpl(Discriminator discriminator, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(discriminator, parent, factory, refMgr);
	}

	// PropertyName
	@Override
	public String getPropertyName() {
		return _get("propertyName", String.class);
	}

	@Override
	public void setPropertyName(String propertyName) {
		_setScalar("propertyName", propertyName, String.class);
	}

	// Mapping
	@Override
	public Map<String, String> getMappings() {
		return _getMap("mappings", String.class);
	}

	@Override
	public Map<String, String> getMappings(boolean elaborate) {
		return _getMap("mappings", elaborate, String.class);
	}

	@Override
	public boolean hasMappings() {
		return _isPresent("mappings");
	}

	@Override
	public boolean hasMapping(String name) {
		return _getMap("mappings", String.class).containsKey(name);
	}

	@Override
	public String getMapping(String name) {
		return _get("mappings", name, String.class);
	}

	@Override
	public void setMappings(Map<String, String> mappings) {
		_setMap("mappings", mappings, String.class);
	}

	@Override
	public void setMapping(String name, String mapping) {
		_set("mappings", name, mapping, String.class);
	}

	@Override
	public void removeMapping(String name) {
		_remove("mappings", name, String.class);
	}

	public static final String F_propertyName = "propertyName";

	public static final String F_mappings = "mappings";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("propertyName", "propertyName", StringOverlay.factory);
		_createMap("mappings", "mapping", StringOverlay.factory, null);
	}

	public static OverlayFactory<Discriminator> factory = new OverlayFactory<Discriminator>() {

		@Override
		protected Class<? extends JsonOverlay<? super Discriminator>> getOverlayClass() {
			return DiscriminatorImpl.class;
		}

		@Override
		public JsonOverlay<Discriminator> _create(Discriminator discriminator, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new DiscriminatorImpl(discriminator, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Discriminator> castOverlay = (JsonOverlay<Discriminator>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Discriminator> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new DiscriminatorImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Discriminator> castOverlay = (JsonOverlay<Discriminator>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends Discriminator> getSubtypeOf(Discriminator discriminator) {
		return Discriminator.class;
	}

	private static Class<? extends Discriminator> getSubtypeOf(JsonNode json) {
		return Discriminator.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<Discriminator> builder(OV modelMember) {
		return new Builder<Discriminator>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> Discriminator create(OV modelMember) {
		return (Discriminator) builder(modelMember).build();
	}
}
