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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import com.networknt.oas.model.OpenApi3;

public class PathsTest {

    @Test
    public void testGetPaths() {
        OpenApi3 model = (OpenApi3) new OpenApiParser().parse(PathsTest.class.getClassLoader().getResource("models/pathsTest.yaml"), false);

        assertEquals(2, model.getPaths().size());
        assertTrue(model.hasPath("/"));
        assertTrue(model.hasPath("/v2"));
        assertNotNull(model.getPath("/"));
        assertNotNull(model.getPath("/v2"));
    }

}
