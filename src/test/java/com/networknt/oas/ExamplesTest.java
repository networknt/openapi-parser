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

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.jsonoverlay.JsonLoader;
import com.networknt.oas.model.OpenApi3;
import com.networknt.oas.validator.ValidationResults.ValidationItem;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExamplesTest {

	private static final String SPEC_REPO = "OAI/OpenAPI-specification";
	private static final String EXAMPLES_BRANCH = "main";
	private static final String EXAMPLES_ROOT = "tests/md2html";

	private static Collection<Object[]> findExamples() throws IOException {
		Collection<Object[]> examples = Lists.newArrayList();
		Deque<URL> dirs = Queues.newArrayDeque();
		String auth = System.getenv("GITHUB_AUTH") != null ? System.getenv("GITHUB_AUTH") + "@" : "";
		String request = String.format("https://%sapi.github.com/repos/%s/contents/%s?ref=%s", auth, SPEC_REPO,
				EXAMPLES_ROOT, EXAMPLES_BRANCH);
		dirs.add(new URL(request));
		while (!dirs.isEmpty()) {
			URL url = dirs.remove();
			JsonNode tree = new JsonLoader().load(url);
			for (JsonNode result : iterable(tree.elements())) {
				String type = result.get("type").asText();
				String path = result.get("path").asText();
				String resultUrl = result.get("url").asText();
				if (type.equals("dir")) {
					dirs.add(new URL(resultUrl));
				} else if (type.equals("file") && (path.endsWith(".yaml") || path.endsWith(".json"))) {
					String downloadUrl = result.get("download_url").asText();
					examples.add(new Object[] { new URL(downloadUrl), result.get("name").asText() });
				}
			}
		}
		return examples;
	}

	@Test
	public void exampleCanBeParsed() throws Exception {
		Collection<Object[]> examples = findExamples();
		Assumptions.assumeFalse(examples.isEmpty(), "No examples found (GITHUB_AUTH may not be set)");
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

	private static <T> Iterable<T> iterable(final Iterator<T> iterator) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return iterator;
			}
		};
	}
}
