package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.networknt.oas.jsonoverlay.ChildListOverlay;
import com.networknt.oas.jsonoverlay.JsonOverlay;
import com.networknt.oas.jsonoverlay.ListOverlay;
import com.networknt.oas.jsonoverlay.OverlayFactory;
import com.networknt.oas.jsonoverlay.ReferenceRegistry;
import com.networknt.oas.jsonoverlay.StringOverlay;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.SecurityParameter;
import com.networknt.oas.model.impl.OpenApiObjectImpl;
import java.util.Collection;
import javax.annotation.Generated;

public class SecurityParameterImpl extends OpenApiObjectImpl<OpenApi3, SecurityParameter> implements SecurityParameter {

    @Override
    protected JsonNode fixJson(JsonNode json) {
        return json.isMissingNode() ? jsonArray() : json;
    }


    public SecurityParameterImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    public SecurityParameterImpl(SecurityParameter securityParameter, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(securityParameter, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }


    private ChildListOverlay<String, StringOverlay> parameters = null;

    // Parameter
    @Override

    public Collection<String> getParameters() {
        return parameters.get();
    }

    @Override

    public Collection<String> getParameters(boolean elaborate) {
        return parameters.get(elaborate);
    }

    @Override

    public boolean hasParameters() {
        return parameters.isPresent();
    }

    @Override

    public String getParameter(int index) {
        return parameters.get(index);
    }

    @Override

    public void setParameters(Collection<String> parameters) {
        this.parameters.set((Collection<String>) parameters);
    }

    @Override

    public void setParameter(int index, String parameter) {
        parameters.set(index, parameter);
    }

    @Override

    public void addParameter(String parameter) {
        parameters.add(parameter);
    }

    @Override

    public void insertParameter(int index, String parameter) {
        parameters.insert(index, parameter);
    }

    @Override

    public void removeParameter(int index) {
        parameters.remove(index);
    }

    @Override

    protected void elaborateChildren() {
        parameters = createChildList("", this, StringOverlay.factory);
    }


    public static OverlayFactory<SecurityParameter, SecurityParameterImpl> factory = new OverlayFactory<SecurityParameter, SecurityParameterImpl>() {
    @Override
    protected Class<? super SecurityParameterImpl> getOverlayClass() {
         return SecurityParameterImpl.class;
    }

    @Override
    public SecurityParameterImpl _create(SecurityParameter securityParameter, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new SecurityParameterImpl(securityParameter, parent, refReg);
    }

    @Override
    public SecurityParameterImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new SecurityParameterImpl(json, parent, refReg);
    }
};

}
