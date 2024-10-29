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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.*;
import com.networknt.jsonoverlay.*;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

import static com.networknt.oas.validator.BaseValidationMessages.*;
import static com.networknt.oas.validator.msg.Messages.msg;

public abstract class ValidatorBase<V> implements Validator<V> {
	protected Overlay<V> value;
	protected ValidationResults results;

	@Override
	public final void validate(Overlay<V> value) {
		this.value = value;
		this.results = ValidationContext.getValidationResults();
		checkJsonType(value, getAllowedJsonTypes(value), results);
		runValidations();
	}

	public abstract void runValidations();

	public Overlay<Boolean> validateBooleanField(String name, boolean required) {
		return validateField(name, required, Boolean.class, null);
	}

	public Overlay<String> validateStringField(String name, boolean required) {
		return validateStringField(name, required, (Pattern) null);
	}

	public Overlay<String> validateStringField(String name, boolean required, String pattern) {
		return validateStringField(name, required, Pattern.compile(pattern));
	}

	@SafeVarargs
	public final Overlay<String> validateStringField(String name, boolean required, Pattern pattern,
			Consumer<Overlay<String>>... otherChecks) {
		Overlay<String> field = validateField(name, required, String.class, null);
		checkMissing(field, required);
		if (field != null && field.isPresent()) {
			if (pattern != null) {
				checkPattern(field, pattern);
			}
			for (Consumer<Overlay<String>> otherCheck : otherChecks) {
				otherCheck.accept(field);
			}
		}
		return field;
	}

	void checkPattern(Overlay<String> field, Pattern pattern) {
		if (!pattern.matcher(field.get()).matches()) {
			results.addError(msg(PatternMatchFail, field.get(), pattern), field);
		}
	}

	public Overlay<String> validatePatternField(String name, boolean required) {
		return validateStringField(name, required, null, this::checkRegex);
	}

	private void checkRegex(Overlay<String> field) {
		String regex = field.get();
		try {
			Pattern.compile(regex);
		} catch (PatternSyntaxException e) {
			results.addWarning(msg(BadPattern, regex), field);
		}
	}

	public Overlay<String> validateUrlField(String name, boolean required, boolean allowRelative, boolean allowVars) {
		return validateUrlField(name, required, allowRelative, allowVars, (Pattern) null);
	}

	public Overlay<String> validateUrlField(String name, boolean required, boolean allowRelative, boolean allowVars,
			String pattern) {
		return validateUrlField(name, required, allowRelative, allowVars, Pattern.compile(pattern));
	}

	public Overlay<String> validateUrlField(String name, boolean required, boolean allowRelative, boolean allowVars,
			Pattern pattern) {
		return validateStringField(name, required, pattern, field -> checkUrl(field, allowRelative, allowVars));
	}

	private static String FAKE_SCHEME = "oasparser.fake.scheme";
	private static URLStreamHandler fakeHandler = new URLStreamHandler() {
		@Override
		protected URLConnection openConnection(URL u) throws IOException {
			return null;
		}
	};

	private void checkUrl(Overlay<String> overlay, boolean allowRelative, boolean allowVars) {
		// TODO Q: Any help from spec in being able to validate URLs with vars? E.g is
		// our treatment here valid? We assume vars can only appear where simple text
		// can appear, so handling vars means relacing {.*} with "1" and testing for URL
		// validity. We use a digit instead of a letter because it covers vars in the
		// port, and elsewhere digits are always allowed where letters are.
		String origUrl = overlay.get();
		String url = origUrl;
		boolean fake = false;
		if (allowVars) {
			url = url.replaceAll("\\{[^}]+\\}", "1");
			if (url.startsWith("1:")) {
				// "1" is not a valid scheme name, so we need to replace it with special scheme,
				// for which we provide a do-nothing protocol handler implementation
				url = FAKE_SCHEME + url.substring(1);
				fake = true;
			}
		}
		try {
			new URL(null, url, fake ? fakeHandler : null);
		} catch (MalformedURLException e) {
			try {
				URL context = new URL(null, FAKE_SCHEME + ":/", fakeHandler);
				new URL(context, url);
				if (!allowRelative) {
					results.addError(msg(BaseValidationMessages.NoRelUrl, origUrl, e.toString()), overlay);
				}
			} catch (MalformedURLException e1) {
				results.addError(msg(BadUrl, origUrl, e.toString()), overlay);
			}
		}
	}

	public Overlay<String> validateEmailField(String name, boolean required) {
		return validateEmailField(name, required, (Pattern) null);
	}

	public Overlay<String> validateUrlField(String name, boolean required, String pattern) {
		return validateEmailField(name, required, Pattern.compile(pattern));
	}

	public Overlay<String> validateEmailField(String name, boolean required, Pattern pattern) {
		return validateStringField(name, required, pattern, this::checkEmail);
	}

	private void checkEmail(Overlay<String> overlay) {
		String email = overlay.get();
		try {
			InternetAddress addr = new InternetAddress();
			addr.setAddress(email);
			addr.validate();
		} catch (AddressException e) {
			results.addError(msg(BadEmail, email, e.toString()), overlay);
		}
	}

	public Overlay<Number> validatePositiveField(String name, boolean required) {
		return validateNumericField(name, required, NumericUtils::isPositive, "be positive");
	}

	public Overlay<Number> validateNonNegativeField(String name, boolean required) {
		return validateNumericField(name, required, NumericUtils::isNonNegative, "not be positive");
	}

	public Overlay<Number> validateNumericField(String name, boolean required, Function<Number, Boolean> test,
			String desc) {
		Overlay<Number> field = validateField(name, required, Number.class, null);
		checkMissing(field, required);
		if (field != null && field.isPresent() && test != null) {
			Number n = field.get();
			if (!test.apply(n)) {
				results.addError(msg(NumberConstraint, desc, n), field);
			}
		}
		return field;
	}

	@SafeVarargs
	public final <F> Overlay<F> validateField(String name, boolean required, Class<F> fieldClass,
			Validator<F> validator, Consumer<Overlay<F>>... otherChecks) {
		@SuppressWarnings("unchecked")
		PropertiesOverlay<V> propValue = (PropertiesOverlay<V>) value.get();
		Overlay<F> field = Overlay.of(propValue, name, fieldClass);
		checkJsonType(field, getAllowedJsonTypes(field), results);
		checkMissing(field, required);
		if (field != null && field.isPresent() && validator != null) {
			validator.validate(field);
			for (Consumer<Overlay<F>> otherCheck : otherChecks) {
				otherCheck.accept(field);
			}
		}
		return field;
	}

	public <X> Overlay<List<X>> validateListField(String name, boolean nonEmpty, boolean unique, Class<X> itemClass,
			Validator<X> itemValidator) {
		@SuppressWarnings("unchecked")
		Overlay<List<X>> list = (Overlay<List<X>>) (Object) Overlay.of((PropertiesOverlay<V>) value.get(), name,
				List.class);
		validateList(list, nonEmpty, unique, itemValidator);
		return list;
	}

	private <X> void validateList(Overlay<List<X>> list, boolean nonEmpty, boolean unique, Validator<X> itemValidator) {
		new ListValidator<X>(itemValidator).validate(list);
		checkListNotEmpty(list, nonEmpty);
		checkListUnique(list, unique);
	}

	private <X> void checkListNotEmpty(Overlay<List<X>> list, boolean nonEmpty) {
		if (nonEmpty) {
			ListOverlay<X> listOverlay = Overlay.getListOverlay(list);
			if (list != null && !list.isPresent()) {
				if (nonEmpty && listOverlay.size() == 0) {
					results.addError(msg(EmptyList), list);
				}
			}
		}
	}

	private <X> void checkListUnique(Overlay<List<X>> list, boolean unique) {
		if (unique) {
			ListOverlay<X> listOverlay = Overlay.getListOverlay(list);
			Set<X> seen = new HashSet<>();
			for (int i = 0; i < listOverlay.size(); i++) {
				X item = listOverlay.get(i);
				if (seen.contains(item)) {
					results.addError(msg(DuplicateValue, item, i), Overlay.of(listOverlay, i));
				} else {
					seen.add(item);
				}
			}
		}
	}

	public <X> Overlay<Map<String, X>> validateMapField(String name, boolean nonEmpty, boolean unique,
			Class<X> valueClass, Validator<X> valueValidator) {
		@SuppressWarnings("unchecked")
		Overlay<Map<String, X>> map = (Overlay<Map<String, X>>) (Object) Overlay.of((PropertiesOverlay<V>) value.get(),
				name, Map.class);
		validateMap(map, nonEmpty, unique, valueValidator);
		return map;
	}

	private <X> void validateMap(Overlay<Map<String, X>> map, boolean nonEmpty, boolean unique,
			Validator<X> valueValidator) {
		new MapValidator<X>(valueValidator).validate(map);
		checkMapNotEmpty(map, nonEmpty);
		checkMapUnique(map, unique);
	}

	private <X> void checkMapNotEmpty(Overlay<Map<String, X>> list, boolean nonEmpty) {
		if (nonEmpty) {
			MapOverlay<X> mapOverlay = Overlay.getMapOverlay(list);
			if (list != null && !list.isPresent()) {
				if (nonEmpty && mapOverlay.size() == 0) {
					results.addError(msg(EmptyList), list);
				}
			}
		}
	}

	private <X> void checkMapUnique(Overlay<Map<String, X>> map, boolean unique) {
		if (unique) {
			MapOverlay<X> mapOverlay = Overlay.getMapOverlay(map);
			Set<X> seen = new HashSet<>();
			for (String key : mapOverlay.keySet()) {
				X value = mapOverlay.get(key);
				if (seen.contains(value)) {
					results.addError(msg(DuplicateValue, value, key), Overlay.of(mapOverlay, key));
				} else {
					seen.add(value);
				}
			}
		}
	}

	void checkMissing(Overlay<?> field, boolean required) {
		if (required && (field == null || !field.isPresent())) {
			results.addError(msg(MissingField, field.getPathInParent()), value);
		}
	}

	public Overlay<Map<String, Object>> validateExtensions(Map<String, Object> extensions) {
		return validateExtensions(extensions, null);
	}

	public Overlay<Map<String, Object>> validateExtensions(Map<String, Object> extensions, String crumb) {
		Overlay<Map<String, Object>> mapOverlay = Overlay.of(extensions);
		validateMap(mapOverlay, false, false, null);
		return mapOverlay;
	}

	public Overlay<String> validateFormatField(String name, boolean required, String type) {
		Overlay<String> field = validateStringField(name, required);
		if (field != null && field.isPresent()) {
			String normalType = null;
			switch (field.get()) {
			case "int32":
			case "int64":
				normalType = "integer";
				break;
			case "float":
			case "double":
				normalType = "number";
				break;
			case "byte":
			case "binary":
			case "date":
			case "date-time":
			case "password":
				normalType = "string";
			}
			if (normalType != null) {
				if (type == null || !type.equals(normalType)) {
					results.addWarning(msg(BaseValidationMessages.WrongTypeFormat, field, type, normalType), field);
				}
			}
		}
		return field;
	}

	public void checkDefault(Overlay<?> overlay, String type) {
		if (overlay != null && overlay.isPresent() && type != null) {
			Object defaultValue = overlay.get();
			boolean ok = false;
			switch (type) {
			case "string":
				ok = defaultValue instanceof String;
				break;
			case "number":
				ok = NumericUtils.isNumeric(defaultValue);
				break;
			case "integer":
				ok = NumericUtils.isIntegral(defaultValue);
				break;
			case "boolean":
				ok = defaultValue instanceof Boolean;
				break;
			case "object":
				ok = defaultValue instanceof Map<?, ?>;
				break;
			case "array":
				ok = defaultValue instanceof List<?>;
				break;
			}
			if (!ok) {
				results.addError(msg(BaseValidationMessages.WrongTypeValue, type, defaultValue), overlay);
			}
		}
	}

	public void checkJsonType(Overlay<?> value, Collection<Class<? extends JsonNode>> allowedJsonTypes,
			ValidationResults results) {
		JsonNode json = value.getParsedJson();
		if (json != null && !json.isMissingNode()) {
			for (Class<? extends JsonNode> type : allowedJsonTypes) {
				if (type.isAssignableFrom(json.getClass())) {
					return;
				}
			}
			String allowed = allowedJsonTypes.stream().map(type -> getJsonValueType(type))
					.collect(Collectors.joining(", "));
			results.addError(msg(WrongTypeJson, getJsonValueType(json.getClass()), allowed), value);
		}
	}

	private String getJsonValueType(Class<? extends JsonNode> node) {
		String type = node.getSimpleName();
		return type.endsWith("Node") ? type.substring(0, type.length() - 4) : type;
	}

	protected static Map<Class<?>, List<Class<? extends JsonNode>>> allowedJsonTypes = null;

	protected Collection<Class<? extends JsonNode>> getAllowedJsonTypes(Overlay<?> value) {
		if (allowedJsonTypes == null) {
			createAllowedJsonTypes();
		}
		JsonOverlay<?> overlay = value.getOverlay();
		return allowedJsonTypes
				.get(overlay instanceof PropertiesOverlay ? PropertiesOverlay.class : overlay.getClass());
	}

	private static void createAllowedJsonTypes() {
		Map<Class<?>, List<Class<? extends JsonNode>>> types = new HashMap<>();
		types.put(StringOverlay.class, Arrays.asList(TextNode.class));
		types.put(BooleanOverlay.class, Arrays.asList(BooleanNode.class));
		types.put(IntegerOverlay.class, Arrays.asList(IntNode.class, ShortNode.class, BigIntegerNode.class));
		types.put(NumberOverlay.class, Arrays.asList(NumericNode.class));
		types.put(PrimitiveOverlay.class, Arrays.asList(TextNode.class, NumericNode.class, BooleanNode.class));
		types.put(ObjectOverlay.class, Arrays.asList(JsonNode.class));
		types.put(MapOverlay.class, Arrays.asList(ObjectNode.class));
		types.put(ListOverlay.class, Arrays.asList(ArrayNode.class));
		types.put(PropertiesOverlay.class, Arrays.asList(ObjectNode.class));
		allowedJsonTypes = types;
	}
}
