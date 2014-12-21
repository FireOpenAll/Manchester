package com.lepeng.admin.exception;


public class BusinessException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message, Throwable t, boolean arg2, boolean arg3) {
		super(message, t, arg2, arg3);
	}

	public BusinessException(String message, Throwable t) {
		super(message, t);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable t) {
		super(t);
	}

}
