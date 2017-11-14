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

import java.net.URL;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Resolver {

	private Set<ResolutionBase> resolvedBases = new HashSet<>();
	private final ReferenceRegistry referenceRegistry;
	private final ResolutionBaseRegistry resolutionBaseRegistry;

	public Resolver(ReferenceRegistry referenceRegistry, ResolutionBaseRegistry resolutionBaseRegistry) {
		this.referenceRegistry = referenceRegistry;
		this.resolutionBaseRegistry = resolutionBaseRegistry;
	}

	public void preresolve(String... baseUrls) {
		for (String url : baseUrls) {
			preresolve(resolutionBaseRegistry.of(url, true));
		}
	}

	public void preresolve(URL... baseUrls) {
		for (URL url : baseUrls) {
			preresolve(resolutionBaseRegistry.of(url, true));
		}
	}

	public void preresolve(ResolutionBase base) {
		Queue<ResolutionBase> toResolve = new ArrayDeque<>();
		toResolve.add(base);
		while (!toResolve.isEmpty()) {
			toResolve.addAll(preresolveBase(toResolve.remove()));
		}
	}

	private Collection<ResolutionBase> preresolveBase(ResolutionBase base) {
		List<ResolutionBase> discoveredBases = new ArrayList<>();
		if (!resolvedBases.contains(base)) {
			resolvedBases.add(base);
			if (base.isValid()) {
				List<JsonNode> nodes =
						StreamSupport.stream(treeWalk(base.getJson()).spliterator(), false)
						.filter(n -> (n.isObject() && n.has("$ref")))
						.collect(Collectors.<JsonNode>toList());
				for (JsonNode refNode : nodes) {
					JsonNode refString = refNode.get("$ref");
					String key = referenceRegistry.registerRef(refString, base, true);
					((ObjectNode) refNode).put("key", key);
					Reference ref = referenceRegistry.getRef(key);
					if (ref.isValid() && !resolvedBases.contains(ref.getBase())) {
						discoveredBases.add(ref.getBase());
					}
				}
			}
		}
		return discoveredBases;
	}

	private Iterable<JsonNode> treeWalk(JsonNode tree) {
		final ArrayDeque<JsonNode> toVisit = new ArrayDeque<>();
		toVisit.add(tree);
		return new Iterable<JsonNode>() {
			@Override
			public Iterator<JsonNode> iterator() {
				return new Iterator<JsonNode>() {
					@Override
					public boolean hasNext() {
						return !toVisit.isEmpty();
					}

					@Override
					public JsonNode next() {
						if (hasNext()) {
							JsonNode next = toVisit.remove();
							queueChildren(next);
							return next;
						} else {
							throw new NoSuchElementException();
						}
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}

					private void queueChildren(JsonNode node) {
						if (node.isArray()) {
							for (Iterator<JsonNode> iter = node.elements(); iter.hasNext();) {
								toVisit.addFirst(iter.next());
							}
						} else if (node.isObject()) {
							for (Iterator<Entry<String, JsonNode>> iter = node.fields(); iter.hasNext();) {
								toVisit.addFirst(iter.next().getValue());
							}
						}
					}
				};
			}
		};
	}
}
