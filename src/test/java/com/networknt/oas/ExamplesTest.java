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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExamplesTest {
	@ParameterizedTest(name = "{0}")
	@MethodSource("com.networknt.oas.SpecExamples#load")
	public void exampleCanBeParsed(SpecExamples.Example example) throws Exception {
		OpenApi3 model = (OpenApi3) new OpenApiParser().parse(example.url());
		for (ValidationItem item : model.getValidationItems()) {
			System.out.println(item);
		}
		assertTrue(model.isValid(), "Example was not valid: " + example.name());
	}
}
