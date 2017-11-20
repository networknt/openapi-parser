package com.networknt.oas.model;

import java.util.Map;

public interface SecurityRequirement extends OpenApiObject<OpenApi3, SecurityRequirement> {

    // Requirement

    Map<String, SecurityParameter> getRequirements();


    Map<String, SecurityParameter> getRequirements(boolean elaborate);


    boolean hasRequirement(String name);


    SecurityParameter getRequirement(String name);


    void setRequirements(Map<String, SecurityParameter> requirements);


    void setRequirement(String name, SecurityParameter requirement);


    void removeRequirement(String name);

}
