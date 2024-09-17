package com.networknt.oas.validator.mail;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InternetAddress implements Cloneable {

	private static final long serialVersionUID = -5817656766382648751L;

	private static final String JAVAX_INTERNETADDRESS = "javax.mail.internet.InternetAddress";
	private static final String JAKARTA_INTERNETADDRESS = "jakarta.mail.internet.InternetAddress";

	protected static final Class<?> internetAddress_Clazz;
	protected static final Method getType_Method;
	protected static final Method setAddress_Method;
	protected static final Method setPersonal_Method;
	protected static final Method setPersonal2_Method;
	protected static final Method getAddress_Method;
	protected static final Method getPersonal_Method;
	protected static final Method toUnicodeString_Method;
	protected static final Method validate_Method;
	protected static final Method isGroup_Method;
	protected static final Method getGroup_Method;
	protected static final Method clone_protectedMethod;
	protected static final Method finalize_protectedMethod;

	static {
		Class<?> iacJakarta = null;
		Class<?> iacJavax = null;
		try {
			Class<?> iac = (Class<?>) Class.forName(JAKARTA_INTERNETADDRESS, true,
					Thread.currentThread().getContextClassLoader());
			iacJakarta = iac;
		} catch (ClassNotFoundException cnfe1) {
			try {
				Class<?> iac = (Class<?>) Class.forName(JAVAX_INTERNETADDRESS, true,
						Thread.currentThread().getContextClassLoader());
				iacJavax = iac;
			} catch (ClassNotFoundException cnfe2) {
				throw (ExceptionInInitializerError) new ExceptionInInitializerError("FATAL: Neither " + JAKARTA_INTERNETADDRESS + " nor "
						+ JAVAX_INTERNETADDRESS + " can be loaded").initCause(cnfe2);
			}
		} finally {
			if (iacJakarta != null) {
				internetAddress_Clazz = iacJakarta;
			} else if (iacJavax != null) {
				internetAddress_Clazz = iacJavax;
			} else {
				throw new ExceptionInInitializerError("FATAL: Neither " + JAKARTA_INTERNETADDRESS + " nor "
						+ JAVAX_INTERNETADDRESS + " have been assigned");
			}
		}
		try {
			getType_Method = internetAddress_Clazz.getMethod("getType");
		} catch (NoSuchMethodException | SecurityException e) {
			throw (ExceptionInInitializerError) new ExceptionInInitializerError(
					"FATAL: Unable to get getType() Method reference").initCause(e);
		}
		try {
			setAddress_Method = internetAddress_Clazz.getMethod("setAddress", String.class);
		} catch (NoSuchMethodException | SecurityException e) {
			throw (ExceptionInInitializerError) new ExceptionInInitializerError(
					"FATAL: Unable to get setAddress(String) Method reference").initCause(e);
		}
		try {
			setPersonal_Method = internetAddress_Clazz.getMethod("setPersonal", String.class);
		} catch (NoSuchMethodException | SecurityException e) {
			throw (ExceptionInInitializerError) new ExceptionInInitializerError(
					"FATAL: Unable to get setPersonal(String) Method reference").initCause(e);
		}
		try {
			setPersonal2_Method = internetAddress_Clazz.getMethod("setPersonal", String.class, String.class);
		} catch (NoSuchMethodException | SecurityException e) {
			throw (ExceptionInInitializerError) new ExceptionInInitializerError(
					"FATAL: Unable to get setPersonal(String, String) Method reference").initCause(e);
		}
		try {
			getAddress_Method = internetAddress_Clazz.getMethod("getAddress");
		} catch (NoSuchMethodException | SecurityException e) {
			throw (ExceptionInInitializerError) new ExceptionInInitializerError(
					"FATAL: Unable to get getAddress() Method reference").initCause(e);
		}
		try {
			getPersonal_Method = internetAddress_Clazz.getMethod("getPersonal");
		} catch (NoSuchMethodException | SecurityException e) {
			throw (ExceptionInInitializerError) new ExceptionInInitializerError(
					"FATAL: Unable to get getPersonal() Method reference").initCause(e);
		}
		try {
			toUnicodeString_Method = internetAddress_Clazz.getMethod("toUnicodeString");
		} catch (NoSuchMethodException | SecurityException e) {
			throw (ExceptionInInitializerError) new ExceptionInInitializerError(
					"FATAL: Unable to get toUnicodeString() Method reference").initCause(e);
		}
		try {
			validate_Method = internetAddress_Clazz.getMethod("validate");
		} catch (NoSuchMethodException | SecurityException e) {
			throw (ExceptionInInitializerError) new ExceptionInInitializerError(
					"FATAL: Unable to get validate() Method reference").initCause(e);
		}
		try {
			isGroup_Method = internetAddress_Clazz.getMethod("isGroup");
		} catch (NoSuchMethodException | SecurityException e) {
			throw (ExceptionInInitializerError) new ExceptionInInitializerError(
					"FATAL: Unable to get isGroup() Method reference").initCause(e);
		}
		try {
			getGroup_Method = internetAddress_Clazz.getMethod("getGroup", boolean.class);
		} catch (NoSuchMethodException | SecurityException e) {
			throw (ExceptionInInitializerError) new ExceptionInInitializerError(
					"FATAL: Unable to get getGroup(boolean) Method reference").initCause(e);
		}

		try {
			finalize_protectedMethod = Object.class.getDeclaredMethod("finalize");
			finalize_protectedMethod.setAccessible(true);
		} catch (NoSuchMethodException | SecurityException e) {
			throw (ExceptionInInitializerError) new ExceptionInInitializerError(
					"FATAL: Unable to get finalize() Method reference").initCause(e);
		}
		try {
			clone_protectedMethod = Object.class.getDeclaredMethod("clone");
			clone_protectedMethod.setAccessible(true);
		} catch (NoSuchMethodException | SecurityException e) {
			throw (ExceptionInInitializerError) new ExceptionInInitializerError(
					"FATAL: Unable to get clone() Method reference").initCause(e);
		}
	}

	private final Cloneable delegate;

	public InternetAddress() {
		try {
			delegate = (Cloneable) internetAddress_Clazz.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new IllegalStateException("FATAL: Unable to instantiate delegate", e);
		}
	}

	public InternetAddress(String address, boolean strict) throws AddressException {
		try {
			delegate = (Cloneable) internetAddress_Clazz.getConstructor(String.class, boolean.class).newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new IllegalStateException("FATAL: Unable to instantiate delegate", e);
		}
	}

	public InternetAddress(String address, String personal, String charset) throws UnsupportedEncodingException {
		try {
			delegate = (Cloneable) internetAddress_Clazz.getConstructor(String.class, String.class, String.class)
					.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new IllegalStateException("FATAL: Unable to instantiate delegate", e);
		}
	}

	public InternetAddress(String address, String personal) throws UnsupportedEncodingException {
		try {
			delegate = (Cloneable) internetAddress_Clazz.getConstructor(String.class, String.class).newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new IllegalStateException("FATAL: Unable to instantiate delegate", e);
		}
	}

	public InternetAddress(String address) throws AddressException {
		try {
			delegate = (Cloneable) internetAddress_Clazz.getConstructor(String.class).newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new IllegalStateException("FATAL: Unable to instantiate delegate", e);
		}
	}

	public String getType() {
		try {
			return (String) getType_Method.invoke(delegate);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalStateException("FATAL: Unable to call getType()", e);
		}
	}

	public void setAddress(String address) {
		try {
			setAddress_Method.invoke(delegate, address);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalStateException("FATAL: Unable to call setAddress(String)", e);
		}
	}

	public void setPersonal(String name) throws UnsupportedEncodingException {
		try {
			setPersonal_Method.invoke(delegate, name);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalStateException("FATAL: Unable to call setPersonal(String)", e);
		}
	}

	public void setPersonal(String name, String charset) throws UnsupportedEncodingException {
		try {
			setPersonal2_Method.invoke(delegate, name, charset);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalStateException("FATAL: Unable to call setPersonal(String, String)", e);
		}
	}

	public String getAddress() {
		try {
			return (String) getAddress_Method.invoke(delegate);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalStateException("FATAL: Unable to call getAddress()", e);
		}
	}

	public String getPersonal() {
		try {
			return (String) getPersonal_Method.invoke(delegate);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalStateException("FATAL: Unable to call getPersonal()", e);
		}
	}

	@Override
	public String toString() {
		return delegate.toString();
	}

	public String toUnicodeString() {
		try {
			return (String) toUnicodeString_Method.invoke(delegate);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalStateException("FATAL: Unable to call toUnicodeString()", e);
		}
	}

	@Override
	public int hashCode() {
		return delegate.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return delegate.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		try {
			return clone_protectedMethod.invoke(delegate);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalStateException("FATAL: Unable to call clone()", e);
		}
	}

	@Override
	protected void finalize() throws Throwable {
		try {
			finalize_protectedMethod.invoke(delegate);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalStateException("FATAL: Unable to call finalize()", e);
		}
	}

	public void validate() throws AddressException {
		// super.validate();
	}

	public boolean isGroup() {
		// TODO Auto-generated method stub
		return false;
	}

	public InternetAddress[] getGroup(boolean strict) throws AddressException {
		// TODO Auto-generated method stub
		return null;
	}

}
