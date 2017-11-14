/*******************************************************************************
 *  Copyright (c) 2017 ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.networknt.oas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.networknt.oas.OpenApiParser;
import com.networknt.oas.model.Example;
import com.networknt.oas.model.OpenApi3;

public class ExampleTest {

    private static OpenApi3 model;
    private static Map<String, Object> exampleFixture = new HashMap<>();
    private static Map<String, Object> personFixture = new HashMap<>();

    @BeforeClass
    public static void beforeClass() {
        personFixture.put("name", "Paul");
        exampleFixture.put("foo", "bar");
        exampleFixture.put("person", personFixture);
        model = (OpenApi3) new OpenApiParser().parse(ExampleTest.class.getClassLoader().getResource("models/examplesTest.yaml"), true);
    }

    @Test
    public void testExample() {
        Object example = model.getPath("/v2") //
                .getOperation("get") //
                .getResponse("203") //
                .getContentMediaType("application/json") //
                .getExample();

        assertEquals(exampleFixture, example);
    }

    @Test
    public void testExamples() {
        Map<String, ? extends Example> examples = model.getPath("/v2") //
                .getOperation("get") //
                .getResponse("200") //
                .getContentMediaType("application/json") //
                .getExamples();

        assertEquals(1, examples.size());
        assertTrue(examples.containsKey("foo"));

        Example example = examples.get("foo");

        assertEquals(exampleFixture, example.getValue());
        assertEquals("First Example", example.getSummary());
        assertEquals("An Example", example.getDescription());
    }

    @Test
    public void testValidate() {
        assertTrue(model.isValid());
    }

}
