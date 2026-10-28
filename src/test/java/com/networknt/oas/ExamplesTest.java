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

import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.validator.ValidationResults.ValidationItem;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExamplesTest {
	private static Collection<Object[]> findExamples() throws IOException {
		return SpecExamples.load();
	}

	@Test
	public void exampleCanBeParsed() throws Exception {
		Collection<Object[]> examples = findExamples();
		Assumptions.assumeFalse(examples.isEmpty(), "No bundled examples found");
		for (Object[] example : examples) {
			URL exampleUrl = (URL) example[0];
			if (!exampleUrl.toString().contains("callback-example")) {
				OpenApi3 model = (OpenApi3) new OpenApiParser().parse(exampleUrl);
				for (ValidationItem item : model.getValidationItems()) {
					System.out.println(item);
				}
				assertTrue(model.isValid(), "Example was not valid: " + exampleUrl);
			}
		}
	}

}
