package com.networknt.oas.model;

import java.util.Map;

public interface Info extends OpenApiObject<OpenApi3, Info> {

    // Title

    String getTitle();


    String getTitle(boolean elaborate);


    void setTitle(String title);

    // Description

    String getDescription();


    String getDescription(boolean elaborate);


    void setDescription(String description);

    // TermsOfService

    String getTermsOfService();


    String getTermsOfService(boolean elaborate);


    void setTermsOfService(String termsOfService);

    // Contact

    Contact getContact();


    Contact getContact(boolean elaborate);


    void setContact(Contact contact);

    // License

    License getLicense();


    License getLicense(boolean elaborate);


    void setLicense(License license);

    // Version

    String getVersion();


    String getVersion(boolean elaborate);


    void setVersion(String version);

    // Extension

    Map<String, Object> getExtensions();


    Map<String, Object> getExtensions(boolean elaborate);


    boolean hasExtension(String name);


    Object getExtension(String name);


    void setExtensions(Map<String, Object> extensions);


    void setExtension(String name, Object extension);


    void removeExtension(String name);

}
