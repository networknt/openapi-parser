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
import com.networknt.oas.model.Callback;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.Path;
import java.util.Map;


public class CallbackImpl extends PropertiesOverlay<Callback> implements Callback {

	private Overlay<Callback> overlay = Overlay.of(this);

	@Override
	public String getName() {
		return overlay.getParent() instanceof MapOverlay<?> ? overlay.getPathInParent() : null;
	}

	public CallbackImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	public CallbackImpl(Callback callback, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(callback, parent, factory, refMgr);
	}

	// CallbackPath
	@Override
	public Map<String, Path> getCallbackPaths() {
		return _getMap("callbackPaths", Path.class);
	}

	@Override
	public Map<String, Path> getCallbackPaths(boolean elaborate) {
		return _getMap("callbackPaths", elaborate, Path.class);
	}

	@Override
	public boolean hasCallbackPaths() {
		return _isPresent("callbackPaths");
	}

	@Override
	public boolean hasCallbackPath(String expression) {
		return _getMap("callbackPaths", Path.class).containsKey(expression);
	}

	@Override
	public Path getCallbackPath(String expression) {
		return _get("callbackPaths", expression, Path.class);
	}

	@Override
	public void setCallbackPaths(Map<String, Path> callbackPaths) {
		_setMap("callbackPaths", callbackPaths, Path.class);
	}

	@Override
	public void setCallbackPath(String expression, Path callbackPath) {
		_set("callbackPaths", expression, callbackPath, Path.class);
	}

	@Override
	public void removeCallbackPath(String expression) {
		_remove("callbackPaths", expression, Path.class);
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

	public static final String F_callbackPaths = "callbackPaths";

	public static final String F_extensions = "extensions";

	@Override
	protected void _elaborateJson() {
		super._elaborateJson();
		_createMap("callbackPaths", "", PathImpl.factory, "(?!x-).*");
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	public static OverlayFactory<Callback> factory = new OverlayFactory<Callback>() {

		@Override
		protected Class<? extends JsonOverlay<? super Callback>> getOverlayClass() {
			return CallbackImpl.class;
		}

		@Override
		public JsonOverlay<Callback> _create(Callback callback, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new CallbackImpl(callback, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Callback> castOverlay = (JsonOverlay<Callback>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Callback> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new CallbackImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Callback> castOverlay = (JsonOverlay<Callback>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	private static Class<? extends Callback> getSubtypeOf(Callback callback) {
		return Callback.class;
	}

	private static Class<? extends Callback> getSubtypeOf(JsonNode json) {
		return Callback.class;
	}

	@Override
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	public static <OV extends IJsonOverlay<?>> Builder<Callback> builder(OV modelMember) {
		return new Builder<Callback>(factory, modelMember);
	}

	public static <OV extends IJsonOverlay<?>> Callback create(OV modelMember) {
		return (Callback) builder(modelMember).build();
	}
}
