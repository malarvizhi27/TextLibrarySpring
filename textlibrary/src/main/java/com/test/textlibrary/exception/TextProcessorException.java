package com.test.textlibrary.exception;

public class TextProcessorException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String errorMessage;

	public TextProcessorException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public TextProcessorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TextProcessorException(String message, Throwable cause) {
		super(message, cause);
	}

	public TextProcessorException(String message) {
		super(message);
	}

	public TextProcessorException(Throwable cause) {
		super(cause);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
