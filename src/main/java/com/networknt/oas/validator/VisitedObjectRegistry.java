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

import java.util.IdentityHashMap;
import java.util.Map;

public class VisitedObjectRegistry {

	private Map<Object, Object> visitedObjects = new IdentityHashMap<>();

	public boolean visitIfUnvisited(Object o) {
		if (visitedObjects.containsKey(o)) {
			return false;
		} else {
			visitedObjects.put(o, o);
			return true;
		}
	}
}
