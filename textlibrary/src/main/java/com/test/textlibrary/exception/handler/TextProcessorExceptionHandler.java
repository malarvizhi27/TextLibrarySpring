package com.test.textlibrary.exception.handler;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.test.textlibrary.exception.TextProcessorException;

/**
 * 
 * Global Exception Handler for Text Processing Service
 *
 */

@RestControllerAdvice
public class TextProcessorExceptionHandler {

	@ExceptionHandler(TextProcessorException.class)
	public ResponseEntity<ErrorResponse> handleEmptyText(TextProcessorException textProcessorException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorMessage(textProcessorException.getErrorMessage());
		errorResponse.setErrorCode(textProcessorException.getErrorCode());
		errorResponse.setExceptionStackTrace(textProcessorException.getStackTrace());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
