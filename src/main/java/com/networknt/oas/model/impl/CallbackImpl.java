package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.jsonoverlay.ChildMapOverlay;
import com.networknt.oas.jsonoverlay.JsonOverlay;
import com.networknt.oas.jsonoverlay.MapOverlay;
import com.networknt.oas.jsonoverlay.ObjectOverlay;
import com.networknt.oas.jsonoverlay.OverlayFactory;
import com.networknt.oas.jsonoverlay.ReferenceRegistry;
import com.networknt.oas.model.Callback;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.Path;
import com.networknt.oas.model.impl.OpenApiObjectImpl;
import com.networknt.oas.model.impl.PathImpl;
import java.util.Map;
import javax.annotation.Generated;

public class CallbackImpl extends OpenApiObjectImpl<OpenApi3, Callback> implements Callback {


    public CallbackImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    public CallbackImpl(Callback callback, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(callback, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    private ChildMapOverlay<Path, PathImpl> callbackPaths = null;


    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

    // CallbackPath
    @Override

    public Map<String, Path> getCallbackPaths() {
        return callbackPaths.get();
    }

    @Override

    public Map<String, Path> getCallbackPaths(boolean elaborate) {
        return callbackPaths.get(elaborate);
    }

    @Override

    public boolean hasCallbackPath(String expression) {
        return callbackPaths.containsKey(expression);
    }

    @Override

    public Path getCallbackPath(String expression) {
        return callbackPaths.get(expression);
    }

    @Override

    public void setCallbackPaths(Map<String, Path> callbackPaths) {
        this.callbackPaths.set(callbackPaths);
    }

    @Override

    public void setCallbackPath(String expression, Path callbackPath) {
        callbackPaths.set(expression, callbackPath);
    }

    @Override

    public void removeCallbackPath(String expression) {
        callbackPaths.remove(expression);
    }

    // Extension
    @Override

    public Map<String, Object> getExtensions() {
        return extensions.get();
    }

    @Override

    public Map<String, Object> getExtensions(boolean elaborate) {
        return extensions.get(elaborate);
    }

    @Override

    public boolean hasExtension(String name) {
        return extensions.containsKey(name);
    }

    @Override

    public Object getExtension(String name) {
        return extensions.get(name);
    }

    @Override

    public void setExtensions(Map<String, Object> extensions) {
        this.extensions.set(extensions);
    }

    @Override

    public void setExtension(String name, Object extension) {
        extensions.set(name, extension);
    }

    @Override

    public void removeExtension(String name) {
        extensions.remove(name);
    }

    @Override

    protected void elaborateChildren() {
        callbackPaths = createChildMap("", this, PathImpl.factory, "(?!x-).*");
            extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }


    public static OverlayFactory<Callback, CallbackImpl> factory = new OverlayFactory<Callback, CallbackImpl>() {
    @Override
    protected Class<? super CallbackImpl> getOverlayClass() {
         return CallbackImpl.class;
    }

    @Override
    public CallbackImpl _create(Callback callback, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new CallbackImpl(callback, parent, refReg);
    }

    @Override
    public CallbackImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new CallbackImpl(json, parent, refReg);
    }
};

}
