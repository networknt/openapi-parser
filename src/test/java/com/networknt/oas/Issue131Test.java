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

import com.networknt.jsonoverlay.Overlay;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.Schema;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.io.Resources;

public class Issue131Test extends Assert {

	@Test
	public void testSchemaRefs() throws Exception {
		OpenApi3 model = (OpenApi3) new OpenApiParser().parse(Resources.getResource("models/issue131.yaml"), true);
		assertEquals("SampleData", Overlay.getPathInParent(Overlay.of(model).find("/components/schemas/SampleData")));
		assertEquals("MoreData", Overlay.getPathInParent(Overlay.of(model).find("/components/schemas/MoreData")));
		Schema direct = model.getSchema("SampleData");
		Schema viaMoreData = model.getSchema("MoreData").getProperty("master");
		Schema viaPath = model.getPath("/sampledatamanagement/v1/sampledata/custom/{id}").getGet().getResponse("200")
				.getContentMediaType("application/json").getSchema();
		assertTrue(direct == viaMoreData);
		assertTrue(direct == viaPath);
	}
}
