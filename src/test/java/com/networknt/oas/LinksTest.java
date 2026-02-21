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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LinksTest {

	@Test
	public void testLinks() throws Exception {
		OpenApi3 model = (OpenApi3) new OpenApiParser().parse(Resources.getResource("models/linksTest.yaml"), false);

		assertNotNull(model.getLink("PullRequestMerge").getOperationId());
		assertNotNull(model.getLink("PullRequestMerge").getOperationRef());
		assertNotNull(model.getLink("PullRequestMerge").getServer());

		assertEquals("http://localhost", model.getLink("PullRequestMerge").getServer().getUrl());
		assertEquals("server", model.getLink("PullRequestMerge").getServer().getDescription());
	}

}
