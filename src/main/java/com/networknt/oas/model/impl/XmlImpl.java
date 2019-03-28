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
import com.networknt.oas.model.Xml;

import javax.annotation.Generated;
import java.util.Map;


public class XmlImpl extends PropertiesOverlay<Xml> implements Xml {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public XmlImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public XmlImpl(Xml xml, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(xml, parent, factory, refMgr);
	}

	// Name
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getName() {
		return _get("name", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setName(String name) {
		_setScalar("name", name, String.class);
	}

	// Namespace
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getNamespace() {
		return _get("namespace", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setNamespace(String namespace) {
		_setScalar("namespace", namespace, String.class);
	}

	// Prefix
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getPrefix() {
		return _get("prefix", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setPrefix(String prefix) {
		_setScalar("prefix", prefix, String.class);
	}

	// Attribute
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getAttribute() {
		return _get("attribute", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isAttribute() {
		Boolean bool = _get("attribute", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setAttribute(Boolean attribute) {
		_setScalar("attribute", attribute, Boolean.class);
	}

	// Wrapped
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getWrapped() {
		return _get("wrapped", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isWrapped() {
		Boolean bool = _get("wrapped", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setWrapped(Boolean wrapped) {
		_setScalar("wrapped", wrapped, Boolean.class);
	}

	// Extension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions() {
		return _getMap("extensions", Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions(boolean elaborate) {
		return _getMap("extensions", elaborate, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtensions() {
		return _isPresent("extensions");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtension(String name) {
		return _getMap("extensions", Object.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getExtension(String name) {
		return _get("extensions", name, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtensions(Map<String, Object> extensions) {
		_setMap("extensions", extensions, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtension(String name, Object extension) {
		_set("extensions", name, extension, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeExtension(String name) {
		_remove("extensions", name, Object.class);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_name = "name";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_namespace = "namespace";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_prefix = "prefix";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_attribute = "attribute";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_wrapped = "wrapped";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_extensions = "extensions";

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("name", "name", StringOverlay.factory);
		_createScalar("namespace", "namespace", StringOverlay.factory);
		_createScalar("prefix", "prefix", StringOverlay.factory);
		_createScalar("attribute", "attribute", BooleanOverlay.factory);
		_createScalar("wrapped", "wrapped", BooleanOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<Xml> factory = new OverlayFactory<Xml>() {

		@Override
		protected Class<? extends JsonOverlay<? super Xml>> getOverlayClass() {
			return XmlImpl.class;
		}

		@Override
		public JsonOverlay<Xml> _create(Xml xml, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new XmlImpl(xml, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Xml> castOverlay = (JsonOverlay<Xml>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Xml> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new XmlImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Xml> castOverlay = (JsonOverlay<Xml>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Xml> getSubtypeOf(Xml xml) {
		return Xml.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Xml> getSubtypeOf(JsonNode json) {
		return Xml.class;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> Builder<Xml> builder(OV modelMember) {
		return new Builder<Xml>(factory, modelMember);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> Xml create(OV modelMember) {
		return (Xml) builder(modelMember).build();
	}
}
