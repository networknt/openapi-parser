module com.networknt.openapi.parser {
    exports com.networknt.oas;

    requires com.networknt.service;
    requires com.networknt.json.overlay;
    requires org.slf4j;
    requires tools.jackson.core;
    requires tools.jackson.databind;
    requires tools.jackson.dataformat.yaml;
    requires java.annotation;
    requires java.mail;
}
