module com.networknt.openapi.parser {
    exports com.networknt.oas;

    requires com.networknt.service;
    requires com.networknt.json.overlay;
    requires org.slf4j;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;
    requires java.annotation;
    requires java.mail;
}
