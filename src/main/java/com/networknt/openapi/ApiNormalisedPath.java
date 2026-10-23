/*
 * Copyright (c) 2016 Network New Technologies Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.networknt.openapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static java.util.Objects.requireNonNull;

/**
 * This utility normalize the RESTful API path so that they can be
 * handled identically.
 *
 * @author Steve Hu
 */
public class ApiNormalisedPath implements NormalisedPath {
    private static final LoadingCache<String, BasePrefix> BASE_PREFIXES = prefixCache(BasePrefix::compile);
    private static final Logger logger = LoggerFactory.getLogger(ApiNormalisedPath.class);

    static LoadingCache<String, BasePrefix> prefixCache(Function<String, BasePrefix> loader) {
        return Caffeine.newBuilder().maximumSize(64).build(loader::apply);
    }

    private final List<String> pathParts;
    private final String original;
    private final String normalised;

    /**
     * Construct normalized path
     * @param path original path
     * @param basePath the path you want to overwrite
     *                 - must not be null; use the helper base path explicitly
     *                 - put "" empty String will not trigger any overwrites
     *                 - put regex will remove a matching leading base path at a segment boundary
     */
    public ApiNormalisedPath(final String path, final String basePath) {
        if (logger.isDebugEnabled()) logger.debug("path = {}, base path is set to: {}", path, basePath);
        this.original = requireNonNull(path, "A path is required");
        this.normalised = normalise(path, basePath);
        if (logger.isDebugEnabled()) logger.debug("normalised = " + this.normalised);
        this.pathParts = List.of(normalised.split("/"));
    }

    @Override
    public List<String> parts() {
        return pathParts;
    }

    @Override
    public String part(int index) {
        return pathParts.get(index);
    }

    @Override
    public boolean isParam(int index) {
        final String part = part(index);
        return part.startsWith("{") && part.endsWith("}");
    }

    @Override
    public String paramName(int index) {
        if (!isParam(index)) {
            return null;
        }
        final String part = part(index);
        return part.substring(1, part.length() - 1);
    }

    @Override
    public String original() {
        return original;
    }

    @Override
    public String normalised() {
        return normalised;
    }

    private String normalise(String requestPath, String basePath) {
        requireNonNull(basePath, "A base path is required; use an empty string for specification paths");
        if ("/".equals(basePath)) {
            // Preserve the historical root behavior, including //pets -> /pets.
            if (requestPath.startsWith("/")) requestPath = requestPath.substring(1);
        } else if (!basePath.isEmpty()) {
            requestPath = BASE_PREFIXES.get(basePath).removeFrom(requestPath);
        }
        return requestPath.startsWith("/") ? requestPath : "/" + requestPath;
    }

    record BasePrefix(String literal, Pattern regex) {
        static BasePrefix compile(String basePath) {
            String prefix = basePath;
            while (prefix.endsWith("/")) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.endsWith("\\")) prefix = prefix.substring(0, prefix.length() - 1);
            }
            boolean literal = prefix.chars().noneMatch(c -> ".[]{}()*+?^$|\\".indexOf(c) >= 0);
            return literal ? new BasePrefix(prefix, null)
                    : new BasePrefix(null, Pattern.compile("^(?:" + prefix + ")(?=/|\\z)"));
        }

        String removeFrom(String path) {
            if (regex == null) {
                int end = literal.length();
                return path.startsWith(literal) && (end == path.length() || path.charAt(end) == '/')
                        ? path.substring(end) : path;
            }
            Matcher matcher = regex.matcher(path);
            return matcher.lookingAt() ? path.substring(matcher.end()) : path;
        }
    }
}
