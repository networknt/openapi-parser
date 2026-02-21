package com.networknt.openapi;

import com.google.common.io.Resources;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.Scanner;

public class BasePathRewriteTest {
    OpenApiHelper helper = null;
    @BeforeEach
    public void testOAuth2Name() throws Exception {
        URL url = Resources.getResource("models/openapi-server-url-rewrite.yaml");
        String spec = new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next();
        helper = new OpenApiHelper(spec);
    }

    @AfterEach
    public void tearDown() throws NoSuchFieldException, IllegalAccessException {
        helper = null;
    }

    @Test
    public void testBasePath() {
        Assertions.assertEquals("/namespace/application/v1", helper.basePath);
    }

    @Test
    public void testApiNormalizedPathWithRegex() {
        ApiNormalisedPath normalisedPath = new ApiNormalisedPath("/v1/pets/26", "\\/[^\\/]+");
        Assertions.assertEquals(normalisedPath.normalised(), "/pets/26");
    }
}
