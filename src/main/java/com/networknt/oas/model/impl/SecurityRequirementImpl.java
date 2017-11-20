package com.networknt.oas.model.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.oas.jsonoverlay.ChildMapOverlay;
import com.networknt.oas.jsonoverlay.JsonOverlay;
import com.networknt.oas.jsonoverlay.OverlayFactory;
import com.networknt.oas.jsonoverlay.ReferenceRegistry;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.SecurityParameter;
import com.networknt.oas.model.SecurityRequirement;

import java.util.Map;

public class SecurityRequirementImpl extends OpenApiObjectImpl<OpenApi3, SecurityRequirement> implements SecurityRequirement {


    public SecurityRequirementImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    public SecurityRequirementImpl(SecurityRequirement securityRequirement, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(securityRequirement, parent, refReg);
        super.maybeElaborateChildrenAtCreation();
    }


    private ChildMapOverlay<SecurityParameter, SecurityParameterImpl> requirements = null;

    // Requirement
    @Override
    public Map<String, SecurityParameter> getRequirements() {
        return requirements.get();
    }

    @Override
    public Map<String, SecurityParameter> getRequirements(boolean elaborate) {
        return requirements.get(elaborate);
    }

    @Override
    public boolean hasRequirement(String name) {
        return requirements.containsKey(name);
    }

    @Override
    public SecurityParameter getRequirement(String name) {
        return requirements.get(name);
    }

    @Override
    public void setRequirements(Map<String, SecurityParameter> requirements) {
        this.requirements.set(requirements);
    }

    @Override
    public void setRequirement(String name, SecurityParameter requirement) {
        requirements.set(name, requirement);
    }

    @Override
    public void removeRequirement(String name) {
        requirements.remove(name);
    }

    @Override
    protected void elaborateChildren() {
        requirements = createChildMap("", this, SecurityParameterImpl.factory, "[a-zA-Z0-9\\._-]+");
    }


    public static OverlayFactory<SecurityRequirement, SecurityRequirementImpl> factory = new OverlayFactory<SecurityRequirement, SecurityRequirementImpl>() {
        @Override
        protected Class<? super SecurityRequirementImpl> getOverlayClass() {
            return SecurityRequirementImpl.class;
        }

        @Override
        public SecurityRequirementImpl _create(SecurityRequirement securityRequirement, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new SecurityRequirementImpl(securityRequirement, parent, refReg);
        }

        @Override
        public SecurityRequirementImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            return new SecurityRequirementImpl(json, parent, refReg);
        }
    };

}
