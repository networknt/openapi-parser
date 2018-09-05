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

import com.google.common.io.Resources;
import com.networknt.oas.model.OpenApi3;
import org.junit.Test;

import static org.junit.Assert.*;

public class PathsTest {

	@Test
	public void testGetPaths() throws Exception {
		OpenApi3 model = (OpenApi3) new OpenApiParser().parse(Resources.getResource("models/pathsTest.yaml"), false);

		assertEquals(2, model.getPaths().size());
		assertTrue(model.hasPath("/"));
		assertTrue(model.hasPath("/v2"));
		assertEquals("/", model.getPath("/").getPathString());
		assertEquals("/v2", model.getPath("/v2").getPathString());
		assertNotNull(model.getPath("/"));
		assertNotNull(model.getPath("/v2"));
	}

}
