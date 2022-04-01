package com.test.textlibrary.exception.handler;


public class ErrorResponse {
	
	String errorCode;
	String errorMessage;
	StackTraceElement[] exceptionStackTrace;
	
	public ErrorResponse() {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.exceptionStackTrace = exceptionStackTrace;
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
	public StackTraceElement[] getExceptionStackTrace() {
		return exceptionStackTrace;
	}
	public void setExceptionStackTrace(StackTraceElement[] stackTraceElements) {
		this.exceptionStackTrace = stackTraceElements;
	}

}
