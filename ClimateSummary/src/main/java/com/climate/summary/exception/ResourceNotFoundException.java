package com.climate.summary.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is custom exception class use to handle errors
 * 
 * @author KhatriZ
 *
 */
@ResponseStatus
public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
