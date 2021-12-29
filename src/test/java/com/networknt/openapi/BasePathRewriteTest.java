package com.networknt.openapi;

import com.google.common.io.Resources;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.Scanner;

public class BasePathRewriteTest {
    @Before
    public void testOAuth2Name() throws Exception {
        URL url = Resources.getResource("models/openapi-server-url-rewrite.yaml");
        String spec = new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next();
        OpenApiHelper.init(spec);
    }

    @After
    public void tearDown() throws NoSuchFieldException, IllegalAccessException {
        Field instance = OpenApiHelper.class.getDeclaredField("INSTANCE");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void testBasePath() {
        Assert.assertEquals("/namespace/application/v1", OpenApiHelper.basePath);
    }

    @Test
    public void testApiNormalizedPathWithRegex() {
        ApiNormalisedPath normalisedPath = new ApiNormalisedPath("/v1/pets/26", "\\/[^\\/]+");
        Assert.assertEquals(normalisedPath.normalised(), "/pets/26");
    }
}
