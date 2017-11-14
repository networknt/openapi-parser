package com.networknt.oas.model;

import java.util.Collection;
import javax.annotation.Generated;

public interface SecurityParameter extends OpenApiObject<OpenApi3, SecurityParameter> {

    // Parameter

    Collection<String> getParameters();


    Collection<String> getParameters(boolean elaborate);


    boolean hasParameters();


    String getParameter(int index);


    void setParameters(Collection<String> parameters);


    void setParameter(int index, String parameter);


    void addParameter(String parameter);


    void insertParameter(int index, String parameter);


    void removeParameter(int index);

}
