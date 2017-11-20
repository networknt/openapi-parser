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

import com.networknt.oas.model.*;
import com.networknt.oas.validator.ObjectValidatorBase;
import com.networknt.oas.validator.ValidationResults;
import com.networknt.oas.validator.Validator;
import com.networknt.service.SingletonServiceFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.networknt.oas.validator.Messages.m;

public class LinkValidator extends ObjectValidatorBase<Link> {

	private static Validator<Header> headerValidator = SingletonServiceFactory.getBean(Validator.class, Header.class);

	@Override
	public void validateObject(Link link, ValidationResults results) {
		// no validation for: description
		// TODO: Validate operationRef value (why didn't they must make it a ref
		// object???!)
		Operation op = checkValidOperation(link, results);
		if (op != null) {
			checkParameters(link, op, results);
		}
		validateMap(link.getHeaders(false), results, false, "headers", Regexes.NOEXT_REGEX, headerValidator);
		validateExtensions(link.getExtensions(false), results);
	}

	private Operation checkValidOperation(Link link, ValidationResults results) {
		String opId = link.getOperationId(false);
		String operationRef = link.getOperationRef(false);
		Operation op = null;
		if (opId == null && operationRef == null) {
			results.addError(
					m.msg("NoOpIdNoOpRefInLink|Link must contain eitehr 'operationRef' or 'operationId' properties"));
		} else if (opId != null && operationRef != null) {
			results.addError(
					m.msg("OpIdAndOpRefInLink|Link may not contain both 'operationRef' and 'operationId' properties"));
		}
		if (opId != null) {
			op = findOperationById(link.getModel(), opId);
			if (op == null) {
				results.addError(
						m.msg("OpIdNotFound|OperationId in Link does not identify an operation in the containing model",
								opId),
						"operationId");
			}
		}
		String relativePath = getRelativePath(operationRef, results);
		if (relativePath != null) {
			op = findOperationByPath(link.getModel(), relativePath, results);
			if (op == null) {
				results.addError(m.msg(
						"OpPathNotFound|Relative OperationRef in Link does not identify a GET operation in the containing model",
						operationRef), "operationRef");
			}
			//
		}
		return op;
	}

	private void checkParameters(Link link, Operation op, ValidationResults results) {
		// TODO Q: parameter name is not sufficient to identify param in operation; will
		// allow if it's unique, warn if
		// it's not
		Map<String, Integer> opParamCounts = getParamNameCounts(op.getParameters(false));
		for (String paramName : link.getParameters(false).keySet()) {
			int count = opParamCounts.get(paramName);
			if (count == 0) {
				results.addError(m.msg("BadLinkParam|Link parameter does not appear in linked operation", paramName),
						paramName);
			} else if (count > 1) {
				results.addWarning(
						m.msg("AmbigLinkParam|Link parameter name appears more than once in linked operation",
								paramName),
						paramName);
			}
		}
	}

	private Operation findOperationById(OpenApi3 model, String operationId) {
		for (Path path : model.getPaths(false).values()) {
			for (Operation op : path.getOperations(false).values()) {
				if (operationId.equals(op.getOperationId(false))) {
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
			results.addWarning("OperationRefUnSupp|Link.operationRef is not yet supported", "operationRef");
		}
		return null;
	}

	private Map<String, Integer> getParamNameCounts(Collection<? extends Parameter> parameters) {
		Map<String, Integer> counts = new HashMap<>();
		for (Parameter parameter : parameters) {
			String name = parameter.getName(false);
			if (counts.containsKey(name)) {
				counts.put(name, 1 + counts.get(name));
			} else {
				counts.put(name, 1);
			}
		}
		return counts;
	}
}
