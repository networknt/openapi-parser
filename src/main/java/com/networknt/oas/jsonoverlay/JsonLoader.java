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
package com.networknt.oas.jsonoverlay;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.networknt.utility.NioUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class JsonLoader {

	private static ObjectMapper jsonMapper = new ObjectMapper();
	private static ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

	private Yaml yaml = new Yaml();

	private Map<String, JsonNode> cache = new HashMap<>();

	public JsonLoader() {
	}

	public JsonNode load(URL url) throws IOException {
		String urlString = url.toString();
		if (cache.containsKey(urlString)) {
			return cache.get(urlString);
		}
		String json = NioUtils.toString(url.openStream());
		return loadString(url, json);
	}

	public JsonNode loadString(URL url, String json) throws IOException, JsonProcessingException {
		JsonNode tree;
		if (json.trim().startsWith("{")) {
			tree = jsonMapper.readTree(json);
		} else {
			Object parsedYaml = yaml.load(json); // this handles aliases - YAMLMapper doesn't
			tree = yamlMapper.convertValue(parsedYaml, JsonNode.class);
		}
		if (url != null) {
			cache.put(url.toString(), tree);
		}
		return tree;
	}
}
