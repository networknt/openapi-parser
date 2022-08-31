package com.networknt.openapi;

import com.google.common.io.Resources;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.Scanner;

public class RelativeBasePathTest {
    OpenApiHelper helper = null;
    @Before
    public void testOAuth2Name() throws Exception {
        URL url = Resources.getResource("models/openapi-relative-server-url.yaml");
        String spec = new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next();
        helper = new OpenApiHelper(spec);
    }

    @After
    public void tearDown() throws NoSuchFieldException, IllegalAccessException {
        helper = null;
    }

    @Test
    public void testBasePath() {
        Assert.assertEquals("/v1", helper.basePath);
    }

    @Test
    public void testApiNormalized() {
        ApiNormalisedPath normalisedPath = new ApiNormalisedPath("/v1/pets/26", helper.basePath);
        Assert.assertEquals("/pets/26", normalisedPath.normalised());
    }
}
