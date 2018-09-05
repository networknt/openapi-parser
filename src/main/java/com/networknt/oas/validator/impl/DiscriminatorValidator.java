package com.networknt.oas.validator.impl;

import com.networknt.oas.model.Discriminator;
import com.networknt.oas.model.impl.DiscriminatorImpl;
import com.networknt.oas.validator.ValidatorBase;

public class DiscriminatorValidator extends ValidatorBase<Discriminator> {

	@Override
	public void runValidations() {
		validateStringField(DiscriminatorImpl.F_propertyName, true);
		validateMapField("mappings", false, false, String.class, null);
	}
}
