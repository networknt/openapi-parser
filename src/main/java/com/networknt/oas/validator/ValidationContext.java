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
package com.networknt.oas.validator;

public class ValidationContext implements AutoCloseable {

	static ThreadLocal<ValidationContext> threadInstance = new ThreadLocal<ValidationContext>();

	private ValidationResults validationResults;
	private VisitedObjectRegistry visitedObjectRegistry;

	public ValidationContext() {
		ValidationContext context = threadInstance.get();
		if (context != null) {
			throw new IllegalStateException();
		}
		this.validationResults = new ValidationResults();
		this.visitedObjectRegistry = new VisitedObjectRegistry();

		threadInstance.set(this);
	}

	public static ValidationContext open() {
		return new ValidationContext();
	}

	public static ValidationContext get() {
		return threadInstance.get();
	}

	public static ValidationResults getValidationResults() {
		ValidationContext context = get();
		if (context != null) {
			return context.validationResults;
		} else {
			throw new IllegalStateException();
		}
	}

	public static boolean visitIfUnvisited(Object o) {
		ValidationContext context = get();
		if (context != null) {
			return context.visitedObjectRegistry.visitIfUnvisited(o);
		} else {
			throw new IllegalStateException();
		}
	}

	@Override
	public void close() {
		threadInstance.remove();
		if (threadInstance.get() != null) {
			throw new IllegalStateException();
		}
	}
}