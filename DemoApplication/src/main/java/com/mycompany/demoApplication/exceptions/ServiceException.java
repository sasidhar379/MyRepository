package com.mycompany.demoApplication.exceptions;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public static ServiceException wrap(Throwable exception) {
		return wrap(exception);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
