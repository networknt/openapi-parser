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

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.networknt.jsonoverlay.JsonOverlay;
import com.networknt.jsonoverlay.Overlay;
import com.networknt.oas.model.OpenApi3;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.yaml.snakeyaml.Yaml;

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;
import com.google.common.base.Predicate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests basic parser operation by loading a swagger spec and then verifying
 * that all values can be obtained reliably from the model
 *
 * @author Andy Lowry
 *
 */

public class BigParseTest {

	public static Stream<URL> resources() {
		return Stream.of(BigParseTest.class.getResource("/models/parseTest.yaml"));
	}

	@ParameterizedTest
	@MethodSource("resources")
	public void test(URL modelUrl) throws Exception {
		Object parsedYaml = new Yaml().load(modelUrl.openStream());
		JsonNode tree = new YAMLMapper().convertValue(parsedYaml, JsonNode.class);
		final OpenApi3 model = (OpenApi3) new OpenApiParser().parse(modelUrl, false);
		Predicate<JsonNode> valueNodePredicate = new Predicate<JsonNode>() {
			@Override
			public boolean apply(JsonNode node) {
				return node.isValueNode();
			}
		};
		JsonTreeWalker.WalkMethod valueChecker = new JsonTreeWalker.WalkMethod() {
			@Override
			public void run(JsonNode node, JsonPointer path) {
				@SuppressWarnings("unchecked")
                JsonOverlay<?> overlay = Overlay.find((JsonOverlay<OpenApi3>) model, path);
				Object value = overlay != null ? Overlay.get(overlay) : null;
				assertNotNull(overlay, "No overlay object found for path: " + path);
				Object fromJson = getValue(node);
				String msg = String.format("Wrong overlay value for path '%s': expected '%s', got '%s'", path, fromJson,
						value);
				assertEquals(fromJson, value, msg);
			}
		};
		JsonTreeWalker.walkTree(tree, valueNodePredicate, valueChecker);
	}

	private Object getValue(JsonNode node) {
		if (node.isNumber()) {
			return node.numberValue();
		} else if (node.isTextual()) {
			return node.textValue();
		} else if (node.isBoolean()) {
			return node.booleanValue();
		} else if (node.isNull()) {
			return null;
		} else {
			throw new IllegalArgumentException("Non-value JSON node got through value node filter");
		}
	}
}
