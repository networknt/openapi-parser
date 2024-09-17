package com.networknt.oas.validator.mail;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AddressException extends Exception {

	private static final long serialVersionUID = -4743764147111350332L;

	private static final String JAVAX_ADDRESSEXCEPTION = "javax.mail.internet.AddressException";
	private static final String JAKARTA_ADDRESSEXCEPTION = "jakarta.mail.internet.AddressException";

	protected static final Class<? extends Exception> addressException_Clazz;
	protected static final Method getRef_Method;
	protected static final Method getPos_Method;
	protected static final Method getNextException_Method;
	protected static final Method setNextException_Method;
	protected static final Method clone_protectedMethod;
	protected static final Method finalize_protectedMethod;

	static {
		Class<? extends Exception> aecJakarta = null;
		Class<? extends Exception> aecJavax = null;
		try {
			@SuppressWarnings("unchecked")
			Class<? extends Exception> aec = (Class<? extends Exception>) Class.forName(JAKARTA_ADDRESSEXCEPTION, true,
					Thread.currentThread().getContextClassLoader());
			aecJakarta = aec;
		} catch (ClassNotFoundException cnfe1) {
			try {
				@SuppressWarnings("unchecked")
				Class<? extends Exception> aec = (Class<? extends Exception>) Class.forName(JAVAX_ADDRESSEXCEPTION,
						true, Thread.currentThread().getContextClassLoader());
				aecJavax = aec;
			} catch (ClassNotFoundException cnfe2) {
				throw (ExceptionInInitializerError) new ExceptionInInitializerError("FATAL: Neither " + JAKARTA_ADDRESSEXCEPTION + " nor "
						+ JAVAX_ADDRESSEXCEPTION + " can be loaded").initCause(cnfe2);
			}
		} finally {
			if (aecJakarta != null) {
				addressException_Clazz = aecJakarta;
			} else if (aecJavax != null) {
				addressException_Clazz = aecJavax;
			} else {
				throw new ExceptionInInitializerError("FATAL: Neither " + JAKARTA_ADDRESSEXCEPTION + " nor "
						+ JAVAX_ADDRESSEXCEPTION + " have been assigned");
			}
		}
		try {
			getRef_Method = addressException_Clazz.getMethod("getRef");
		} catch (NoSuchMethodException | SecurityException e) {
			throw (ExceptionInInitializerError) new ExceptionInInitializerError(
					"FATAL: Unable to get getRef() Method reference").initCause(e);
		}
		try {
			getPos_Method = addressException_Clazz.getMethod("getPos");
		} catch (NoSuchMethodException | SecurityException e) {
			throw (ExceptionInInitializerError) new ExceptionInInitializerError(
					"FATAL: Unable to get getPos() Method reference").initCause(e);
		}
		try {
			getNextException_Method = addressException_Clazz.getMethod("getNextException");
		} catch (NoSuchMethodException | SecurityException e) {
			throw (ExceptionInInitializerError) new ExceptionInInitializerError(
					"FATAL: Unable to get getNextException() Method reference").initCause(e);
		}
		try {
			setNextException_Method = addressException_Clazz.getMethod("setNextException", Exception.class);
		} catch (NoSuchMethodException | SecurityException e) {
			throw (ExceptionInInitializerError) new ExceptionInInitializerError(
					"FATAL: Unable to get setNextException(Exception) Method reference").initCause(e);
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

	private final Exception delegate;

	public AddressException() {
		try {
			delegate = (Exception) addressException_Clazz.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new IllegalStateException("FATAL: Unable to instantiate delegate", e);
		}
	}

	public AddressException(String s, String ref, int pos) {
		try {
			delegate = (Exception) addressException_Clazz.getConstructor(String.class, String.class, int.class)
					.newInstance(s, ref, pos);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new IllegalStateException("FATAL: Unable to instantiate delegate", e);
		}
	}

	public AddressException(String s, String ref) {
		try {
			delegate = (Exception) addressException_Clazz.getConstructor(String.class, String.class)
					.newInstance(s, ref);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new IllegalStateException("FATAL: Unable to instantiate delegate", e);
		}
	}

	public AddressException(String s) {
		try {
			delegate = (Exception) addressException_Clazz.getConstructor(String.class).newInstance(s);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new IllegalStateException("FATAL: Unable to instantiate delegate", e);
		}
	}

	public String getRef() {
		try {
			return (String) getRef_Method.invoke(delegate);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalStateException("FATAL: Unable to call getRef()", e);
		}
	}

	public int getPos() {
		try {
			return (Integer) getPos_Method.invoke(delegate);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalStateException("FATAL: Unable to call getPos()", e);
		}
	}

	public Exception getNextException() {
		try {
			return (Exception) getNextException_Method.invoke(delegate);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalStateException("FATAL: Unable to call getNextException()", e);
		}
	}

	public boolean setNextException(Exception ex) {
		try {
			return (Boolean) setNextException_Method.invoke(delegate, ex);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalStateException("FATAL: Unable to call setNextException(Exception)", e);
		}
	}

	@Override
	public String getMessage() {
		return delegate.getMessage();
	}

	@Override
	public String getLocalizedMessage() {
		return delegate.getLocalizedMessage();
	}

	@Override
	public synchronized Throwable getCause() {
		return delegate.getCause();
	}

	@Override
	public synchronized Throwable initCause(Throwable cause) {
		return delegate.initCause(cause);
	}

	@Override
	public String toString() {
		return delegate.toString();
	}

	@Override
	public void printStackTrace() {
		delegate.printStackTrace();
	}

	@Override
	public void printStackTrace(PrintStream ps) {
		delegate.printStackTrace(ps);
	}

	@Override
	public void printStackTrace(PrintWriter pw) {
		delegate.printStackTrace(pw);
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
		return delegate.fillInStackTrace();
	}

	@Override
	public StackTraceElement[] getStackTrace() {
		return delegate.getStackTrace();
	}

	@Override
	public void setStackTrace(StackTraceElement[] stackTrace) {
		delegate.setStackTrace(stackTrace);
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

}
