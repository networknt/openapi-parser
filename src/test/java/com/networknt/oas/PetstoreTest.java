package com.networknt.oas;

import com.networknt.oas.model.OpenApi3;
import org.junit.Assert;
import org.junit.Test;

public class PetstoreTest {
    @Test
    public void testLoadPetstore() {
        OpenApi3 openApi3 = (OpenApi3) new OpenApiParser().parse(PetstoreTest.class.getClassLoader().getResource("models/openapi.json"), true);
        Assert.assertNotNull(openApi3);
    }
}
