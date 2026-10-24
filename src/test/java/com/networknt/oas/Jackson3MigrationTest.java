package com.networknt.oas;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import tools.jackson.core.JacksonException;

import com.networknt.oas.OpenApiParser.OpenApiParserException;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.validator.ValidationResults.Severity;

import static org.junit.jupiter.api.Assertions.*;

class Jackson3MigrationTest {
    private static java.net.URL resolutionBase() {
        try {
            return java.net.URI.create("file:/jackson3-migration.yaml").toURL();
        } catch (java.net.MalformedURLException e) {
            throw new AssertionError(e);
        }
    }

    private static final String HEADER = "openapi: 3.0.3\ninfo: {title: migration, version: '1.0'}\n";
    private static final String PATHS = "paths:\n  /items:\n    get:\n      responses:\n        '200': {description: ok}\n";

    @Test
    void preservesYaml12StringEnumsAndNumericLookingExamples() {
        String spec = HEADER + PATHS + "components:\n  schemas:\n    Values:\n      type: string\n"
                + "      enum: [yes, no, on, off, True, TRUE, False, FALSE, Null, NULL, 012, 0b11, 0x1F, 1_000, ~]\n"
                + "      example: 012\n";
        OpenApi3 model = new OpenApi3Parser().parse(spec, resolutionBase());
        assertEquals(List.of("yes", "no", "on", "off", "True", "TRUE", "False", "FALSE", "Null", "NULL",
                "012", "0b11", "0x1F", "1_000", "~"), model.getSchema("Values").getEnums());
        assertEquals("012", model.getSchema("Values").getExample());
        assertTrue(model.isValid(), () -> model.getValidationItems().toString());
    }

    private String parameterSpec(String required, String deprecated) {
        return HEADER + "paths:\n  /items:\n    get:\n      parameters:\n"
                + "        - name: query\n          in: query\n          required: " + required
                + "\n          deprecated: " + deprecated + "\n          schema: {type: string}\n"
                + "      responses:\n        '200': {description: ok}\n";
    }

    @Test
    void reportsNonCanonicalBooleanStringsAsValidationErrors() {
        OpenApi3 model = new OpenApi3Parser().parse(parameterSpec("True", "FALSE"), resolutionBase());
        var parameter = model.getPath("/items").getOperation("get").getParameter(0);
        assertNull(parameter.getRequired());
        assertNull(parameter.getDeprecated());
        assertFalse(model.isValid());
        // Both parameter Boolean fields must report invalid scalar types.
        // Text remains the validation label despite Jackson 3's StringNode name.
        assertEquals(2, model.getValidationItems().stream().filter(item -> item.getSeverity() == Severity.ERROR
                && item.getMsg().contains("Text") && item.getMsg().contains("Boolean")).count());
    }

    @Test
    void acceptsCanonicalBooleanValues() {
        OpenApi3 model = new OpenApi3Parser().parse(parameterSpec("true", "false"), resolutionBase());
        var parameter = model.getPath("/items").getOperation("get").getParameter(0);
        assertEquals(Boolean.TRUE, parameter.getRequired());
        assertEquals(Boolean.FALSE, parameter.getDeprecated());
        assertTrue(model.isValid(), () -> model.getValidationItems().toString());
    }

    @Test
    void wrapsUncheckedParseFailuresForStringEntryPoint() {
        var failure = assertThrows(OpenApiParserException.class,
                () -> new OpenApiParser().parse("openapi: [unterminated", resolutionBase()));
        assertEquals("Failed to parse spec as JSON or YAML", failure.getMessage());
        assertInstanceOf(JacksonException.class, failure.getCause());
    }

    @Test
    void wrapsUncheckedParseFailuresForFileAndUrlEntryPoints(@TempDir Path directory) throws Exception {
        Path file = directory.resolve("invalid.yaml");
        Files.writeString(file, "openapi: [unterminated");
        var parser = new OpenApiParser();
        assertInstanceOf(JacksonException.class,
                assertThrows(OpenApiParserException.class, () -> parser.parse(file.toFile())).getCause());
        assertInstanceOf(JacksonException.class,
                assertThrows(OpenApiParserException.class, () -> parser.parse(file.toUri().toURL())).getCause());
    }

    @Test
    void rejectsEmptyAndCommentOnlyDocumentsWithoutNullDereferences(@TempDir Path directory) throws Exception {
        Path file = directory.resolve("empty.yaml");
        for (String document : new String[]{"", "# comment only\n"}) {
            Files.writeString(file, document);
            for (OpenApiParser parser : new OpenApiParser[]{new OpenApiParser(), new OpenApi3Parser()}) {
                assertEquals("Spec document is empty", assertThrows(OpenApiParserException.class,
                        () -> parser.parse(document, resolutionBase(), false)).getMessage());
                assertEquals("Spec document is empty", assertThrows(OpenApiParserException.class,
                        () -> parser.parse(file.toUri().toURL(), false)).getMessage());
            }
        }
    }
    @Test
    void rejectsNonCanonicalNumericKeywordsWithoutCrashing() {
        for (String keyword : List.of("maxLength", "minLength", "minItems", "maxItems",
                "minProperties", "maxProperties", "minimum", "maximum", "multipleOf")) {
            for (String scalar : List.of("012", "0x10", "1_0")) {
                String spec = HEADER + PATHS + "components:\n  schemas:\n    Value:\n      "
                        + keyword + ": " + scalar + "\n";
                OpenApi3 model = assertDoesNotThrow(() -> new OpenApi3Parser().parse(spec, resolutionBase()),
                        keyword + ": " + scalar);
                assertFalse(model.isValid(), keyword + ": " + scalar);
                assertTrue(model.getValidationItems().stream().anyMatch(item ->
                        item.getSeverity() == Severity.ERROR && item.getMsg().contains("Text")),
                        () -> model.getValidationItems().toString());
            }
        }
    }

    @Test
    void validatesRequiredTypeForQueryAndHeaderParameters() {
        for (String location : List.of("query", "header")) {
            for (String scalar : List.of("True", "yes")) {
                OpenApi3 model = new OpenApi3Parser().parse(
                        parameterSpec(scalar, "false").replace("in: query", "in: " + location), resolutionBase());
                assertFalse(model.isValid(), location + ": " + scalar);
                assertEquals(1, model.getValidationItems().stream()
                        .filter(item -> item.getSeverity() == Severity.ERROR).count());
            }
        }
    }

    @Test
    void readsOnlyTheFirstYamlDocument() {
        OpenApi3 model = new OpenApi3Parser().parse(HEADER + PATHS
                + "---\nopenapi: 2.0\ninfo: {title: ignored}\n", resolutionBase());
        assertEquals("migration", model.getInfo().getTitle());
        assertTrue(model.isValid());
    }

}
