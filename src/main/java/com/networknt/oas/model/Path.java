package com.networknt.oas.model;

import com.networknt.oas.jsonoverlay.Reference;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public interface Path extends OpenApiObject<OpenApi3, Path> {

    // Summary

    String getSummary();


    String getSummary(boolean elaborate);


    void setSummary(String summary);

    // Description

    String getDescription();


    String getDescription(boolean elaborate);


    void setDescription(String description);

    // Operation

    Map<String, Operation> getOperations();


    Map<String, Operation> getOperations(boolean elaborate);


    boolean hasOperation(String name);


    Operation getOperation(String name);


    void setOperations(Map<String, Operation> operations);


    void setOperation(String name, Operation operation);


    void removeOperation(String name);

    // Get

    Operation getGet();


    Operation getGet(boolean elaborate);


    void setGet(Operation get);

    // Put

    Operation getPut();


    Operation getPut(boolean elaborate);


    void setPut(Operation put);

    // Post

    Operation getPost();


    Operation getPost(boolean elaborate);


    void setPost(Operation post);

    // Delete

    Operation getDelete();


    Operation getDelete(boolean elaborate);


    void setDelete(Operation delete);

    // Options

    Operation getOptions();


    Operation getOptions(boolean elaborate);


    void setOptions(Operation options);

    // Head

    Operation getHead();


    Operation getHead(boolean elaborate);


    void setHead(Operation head);

    // Patch

    Operation getPatch();


    Operation getPatch(boolean elaborate);


    void setPatch(Operation patch);

    // Trace

    Operation getTrace();


    Operation getTrace(boolean elaborate);


    void setTrace(Operation trace);

    // Server

    Collection<Server> getServers();


    Collection<Server> getServers(boolean elaborate);


    boolean hasServers();


    Server getServer(int index);


    void setServers(Collection<Server> servers);


    void setServer(int index, Server server);


    void addServer(Server server);


    void insertServer(int index, Server server);


    void removeServer(int index);

    // Parameter

    Collection<Parameter> getParameters();


    Collection<Parameter> getParameters(boolean elaborate);


    boolean hasParameters();


    Parameter getParameter(int index);


    void setParameters(Collection<Parameter> parameters);


    void setParameter(int index, Parameter parameter);


    void addParameter(Parameter parameter);


    void insertParameter(int index, Parameter parameter);


    void removeParameter(int index);


    boolean isParameterReference(int index);


    Reference getParameterReference(int index);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
