package com.networknt.oas;

import com.networknt.oas.model.OpenApi3;
import org.junit.Test;

import javax.annotation.Resources;

import static org.junit.Assert.assertEquals;

public class CircularTest {
    @Test
    public void testCircular() throws Exception {
        OpenApi3 model = (OpenApi3) new OpenApiParser().parse(BigParseTest.class.getClassLoader().getResource("models/circular.yaml"), false);
        assertEquals(9, model.getPaths().size());

    }

}
