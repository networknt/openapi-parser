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
package com.networknt.oas.model;

import java.util.Map;

import com.networknt.jsonoverlay.IJsonOverlay;
import com.networknt.jsonoverlay.IModelPart;

public interface Response extends IJsonOverlay<Response>, IModelPart<OpenApi3, Response> {

	String getName();

	// Description
	String getDescription();

	void setDescription(String description);

	// Header
	Map<String, Header> getHeaders();

	Map<String, Header> getHeaders(boolean elaborate);

	boolean hasHeaders();

	boolean hasHeader(String name);

	Header getHeader(String name);

	void setHeaders(Map<String, Header> headers);

	void setHeader(String name, Header header);

	void removeHeader(String name);

	// ContentMediaType
	Map<String, MediaType> getContentMediaTypes();

	Map<String, MediaType> getContentMediaTypes(boolean elaborate);

	boolean hasContentMediaTypes();

	boolean hasContentMediaType(String name);

	MediaType getContentMediaType(String name);

	void setContentMediaTypes(Map<String, MediaType> contentMediaTypes);

	void setContentMediaType(String name, MediaType contentMediaType);

	void removeContentMediaType(String name);

	// Link
	Map<String, Link> getLinks();

	Map<String, Link> getLinks(boolean elaborate);

	boolean hasLinks();

	boolean hasLink(String name);

	Link getLink(String name);

	void setLinks(Map<String, Link> links);

	void setLink(String name, Link link);

	void removeLink(String name);

	// Extension
	Map<String, Object> getExtensions();

	Map<String, Object> getExtensions(boolean elaborate);

	boolean hasExtensions();

	boolean hasExtension(String name);

	Object getExtension(String name);

	void setExtensions(Map<String, Object> extensions);

	void setExtension(String name, Object extension);

	void removeExtension(String name);
}
