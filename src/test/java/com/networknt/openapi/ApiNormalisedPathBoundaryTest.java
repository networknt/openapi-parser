package com.networknt.openapi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiNormalisedPathBoundaryTest {
    @Test
    void removesOnlyLeadingCompleteSegments() {
        assertEquals("/pets", new ApiNormalisedPath("/v1/pets", "/v1").normalised());
        assertEquals("/", new ApiNormalisedPath("/v1", "/v1").normalised());
        assertEquals("/pets/v1", new ApiNormalisedPath("/pets/v1", "/v1").normalised());
        assertEquals("/v10/pets", new ApiNormalisedPath("/v10/pets", "/v1").normalised());
        assertEquals("/pets", new ApiNormalisedPath("/pets", "/v1").normalised());
        assertEquals("/pets", new ApiNormalisedPath("/v1/pets", "/v1/").normalised());
        assertEquals("/pets", new ApiNormalisedPath("/v1/pets", "\\/v1\\/").normalised());
    }

    @Test
    void aFinalLineTerminatorIsNotASegmentBoundary() {
        for (String end : new String[]{"\n", "\r", "\r\n", "\u0085", "\u2028", "\u2029"}) {
            assertEquals("/v1" + end, new ApiNormalisedPath("/v1" + end, "/v1").normalised());
            assertEquals("/v1" + end, new ApiNormalisedPath("/v1" + end, "/v[0-9]+").normalised());
        }
    }

    @Test
    void pathKeysThatEmbedTheServerPrefixAreStillRelativeToThatServer() {
        OpenApiHelper helper = new OpenApiHelper("""
                {"openapi":"3.0.0","info":{"title":"test","version":"1"},
                 "servers":[{"url":"/v1"}],"paths":{
                   "/v1/pets":{"get":{"responses":{"200":{"description":"OK"}}}}
                 }}
                """);
        assertTrue(helper.findMatchingApiPath(new ApiNormalisedPath("/v1/pets", helper.basePath)).isEmpty());
        NormalisedPath operation = helper.findMatchingApiPath(
                new ApiNormalisedPath("/v1/v1/pets", helper.basePath)).orElseThrow();
        assertEquals("/v1/pets", operation.original());
        assertEquals("/v1/v1/pets@get", helper.basePath + operation.normalised() + "@get");
    }

    @Test
    void preservesRegexBasePathsAndChecksTheirBoundary() {
        assertEquals("/pets", new ApiNormalisedPath("/v12/pets", "/v[0-9]+").normalised());
        assertEquals("/v12suffix/pets", new ApiNormalisedPath("/v12suffix/pets", "/v[0-9]+").normalised());
        assertEquals("/pets/v12", new ApiNormalisedPath("/pets/v12", "/v[0-9]+").normalised());
        assertEquals("/pets", new ApiNormalisedPath("/v2/pets", "/v1|/v2").normalised());
    }

    @Test
    void rootAndEmptyBasePathsPreservePaths() {
        for (String base : new String[]{"", "/"}) {
            assertEquals("/pets", new ApiNormalisedPath("/pets", base).normalised());
            assertEquals("/", new ApiNormalisedPath("/", base).normalised());
        }
    }

    @Test
    void preservesRootDoubleSlashCompatibilityAndRejectsNullBaseExplicitly() {
        assertEquals("/pets", new ApiNormalisedPath("//pets", "/").normalised());
        assertThrows(NullPointerException.class, () -> new ApiNormalisedPath("/pets", null));
    }

    @Test
    void specificationPathsAreNeverStrippedEvenWhenTheyStartWithTheBase() {
        OpenApiHelper helper = new OpenApiHelper("""
                {"openapi":"3.0.0","info":{"title":"test","version":"1"},
                 "servers":[{"url":"/pets"}],"paths":{
                   "/pets":{"get":{"responses":{"200":{"description":"OK"}}}},
                   "/pets/{petId}":{"get":{"responses":{"200":{"description":"OK"}}}}
                 }}
                """);
        assertEquals("/pets/{petId}", helper.findMatchingApiPath(
                new ApiNormalisedPath("/pets/pets/42", helper.basePath)).orElseThrow().normalised());
        assertEquals("/pets", helper.findMatchingApiPath(
                new ApiNormalisedPath("/pets/pets", helper.basePath)).orElseThrow().normalised());
        assertTrue(helper.findMatchingApiPath(new ApiNormalisedPath("/pets/42", helper.basePath)).isEmpty());
    }

    @Test
    void doesNotCollapseAnOperationOrParameterContainingTheBasePath() {
        OpenApiHelper helper = new OpenApiHelper("""
                {"openapi":"3.0.0","info":{"title":"test","version":"1"},
                 "servers":[{"url":"/v1"}],"paths":{
                   "/pets":{"get":{"responses":{"200":{"description":"OK"}}}},
                   "/pets/{petId}":{"get":{"responses":{"200":{"description":"OK"}}}},
                   "/reports/v1":{"get":{"responses":{"200":{"description":"OK"}}}}
                 }}
                """);
        assertEquals("/pets/{petId}", helper.findMatchingApiPath(
                new ApiNormalisedPath("/pets/v1", helper.basePath)).orElseThrow().original());
        assertEquals("/reports/v1", helper.findMatchingApiPath(
                new ApiNormalisedPath("/v1/reports/v1", helper.basePath)).orElseThrow().normalised());
    }
}
