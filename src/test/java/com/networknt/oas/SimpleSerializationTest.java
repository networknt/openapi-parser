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

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.dataformat.yaml.YAMLMapper;
import com.networknt.jsonoverlay.Overlay;
import com.networknt.jsonoverlay.SerializationOptions.Option;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.model.Schema;
import com.networknt.oas.model.impl.OpenApi3Impl;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleSerializationTest {
	private static ObjectMapper mapper = new ObjectMapper();
	private static ObjectMapper yamlMapper = new YAMLMapper();

	@Nested
	public class ParameterizedTests {

		private static Collection<Object[]> findExamples() throws IOException {
			return SpecExamples.load();
		}

		@Test
		public void serializeExamples() throws Exception {
			Collection<Object[]> examples = findExamples();
			Assumptions.assumeFalse(examples.isEmpty(), "No bundled examples found");
			for (Object[] example : examples) {
				URL exampleUrl = (URL) example[0];
				if (!exampleUrl.toString().contains("callback-example")) {
					OpenApi3 model = (OpenApi3) new OpenApiParser().parse(exampleUrl);
					JsonNode serialized = Overlay.toJson((OpenApi3Impl) model);
					JsonNode expected;
					try (var input = exampleUrl.openStream()) {
						expected = yamlMapper.readTree(input);
					}
					JSONAssert.assertEquals(mapper.writeValueAsString(expected), mapper.writeValueAsString(serialized),
							JSONCompareMode.STRICT);
				}
			}
		}
	}

	@Nested
	public class NonParameterizedTests {

		@Test
		public void toJsonNoticesChanges() throws Exception {
			OpenApi3 model = parseLocalModel("simpleTest");
			assertEquals("simple model", model.getInfo().getTitle());
			assertEquals("simple model", Overlay.of(model).toJson().at("/info/title").asText());
			// this changes the overlay value but does not refresh cached JSON -
			// just marks
			// it as out-of-date
			model.getInfo().setTitle("changed title");
			assertEquals("changed title", model.getInfo().getTitle());
			assertEquals("changed title", Overlay.of(model).toJson().at("/info/title").asText());
		}

		@Test
		public void toJsonFollowsRefs() throws Exception {
			OpenApi3 model = parseLocalModel("simpleTest");
			Schema xSchema = model.getSchema("X");
			assertEquals("#/components/schemas/Y", Overlay.of(xSchema).toJson().at("/properties/y/$ref").asText());
			assertEquals("integer", Overlay.of(xSchema).toJson(Option.FOLLOW_REFS).at("/properties/y/type").asText());
		}
	}

	private static OpenApi3 parseLocalModel(String name) throws Exception {
		URL url = SimpleSerializationTest.class.getResource("/models/" + name + ".yaml");
		return (OpenApi3) new OpenApiParser().parse(url);
	}

}
