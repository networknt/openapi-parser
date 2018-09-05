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
package com.networknt.oas.validator.impl;

import com.networknt.jsonoverlay.Overlay;
import com.networknt.oas.model.*;
import com.networknt.oas.model.impl.LinkImpl;
import com.networknt.oas.validator.ObjectValidatorBase;
import com.networknt.oas.validator.ValidationResults;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.networknt.oas.model.impl.LinkImpl.F_description;
import static com.networknt.oas.model.impl.LinkImpl.F_requestBody;
import static com.networknt.oas.validator.impl.OpenApi3Messages.*;
import static com.networknt.oas.validator.msg.Messages.msg;

public class LinkValidator extends ObjectValidatorBase<Link> {

	@Override
	public void runObjectValidations() {
		// TODO: Validate operationRef value (why didn't they must make it a ref
		// object???!)
		Link link = (Link) value.getOverlay();
		validateStringField(F_description, false);
		Operation op = checkValidOperation(link);
		if (op != null) {
			checkParameters(link, op);
		}
		Overlay<Object> requestBody = validateField(F_requestBody, false, Object.class, null);
		checkRequestBody(requestBody);
		validateField(LinkImpl.F_server, false, Server.class, new ServerValidator());
		validateExtensions(link.getExtensions());
	}

	private Operation checkValidOperation(Link link) {
		String opId = link.getOperationId();
		String operationRef = link.getOperationRef();
		Operation op = null;
		if (opId == null && operationRef == null) {
			results.addError(msg(NoOpIdNoOpRefInLink), value);
		} else if (opId != null && operationRef != null) {
			results.addError(msg(OpIdAndOpRefInLink), value);
		}
		if (opId != null) {
			op = findOperationById(Overlay.of(link).getModel(), opId);
			if (op == null) {
				results.addError(msg(OpIdNotFound, opId), value);
			}
		}
		String relativePath = getRelativePath(operationRef, results);
		if (relativePath != null) {
			op = findOperationByPath(Overlay.of(link).getModel(), relativePath, results);
			if (op == null) {
				results.addError(msg(OpPathNotFound, operationRef), value);
			}
		}
		return op;
	}

	private void checkParameters(Link link, Operation op) {
		// TODO Q: parameter name is not sufficient to identify param in
		// operation; will
		// allow if it's unique, warn if
		// it's not
		Map<String, Integer> opParamCounts = getParamNameCounts(op.getParameters());
		Map<String, String> params = link.getParameters();
		for (String paramName : params.keySet()) {
			int count = opParamCounts.get(paramName);
			if (count == 0) {
				results.addError(msg(OpenApi3Messages.BadLinkParam, paramName), Overlay.of(params, paramName));
			} else if (count > 1) {
				results.addWarning(msg(OpenApi3Messages.AmbigLinkParam, paramName), Overlay.of(params, paramName));
			}
		}
	}

	private Operation findOperationById(OpenApi3 model, String operationId) {
		for (Path path : model.getPaths().values()) {
			for (Operation op : path.getOperations().values()) {
				if (operationId.equals(op.getOperationId())) {
					return op;
				}
			}
		}
		return null;
	}

	private Operation findOperationByPath(OpenApi3 model, String relativePath, ValidationResults results) {
		Path path = model.getPath(relativePath);
		return path != null ? path.getGet(false) : null;
	}

	private String getRelativePath(String operationRef, ValidationResults results) {
		// TODO Q: will braces be pct-encoded as required for URIs?
		if (operationRef != null) {
			results.addWarning(msg(OpenApi3Messages.OperationRefUnSupp), value);
		}
		return null;
	}

	private Map<String, Integer> getParamNameCounts(Collection<? extends Parameter> parameters) {
		Map<String, Integer> counts = new HashMap<>();
		for (Parameter parameter : parameters) {
			String name = parameter.getName();
			if (counts.containsKey(name)) {
				counts.put(name, 1 + counts.get(name));
			} else {
				counts.put(name, 1);
			}
		}
		return counts;
	}

	private void checkRequestBody(Overlay<Object> rbField) {
		if (rbField != null && rbField.isPresent() && rbField.get() instanceof String) {
			// TODO if this looks like it's meant to be an expression, check that it's a
			// valid one, and warn if not
		}
	}
}
