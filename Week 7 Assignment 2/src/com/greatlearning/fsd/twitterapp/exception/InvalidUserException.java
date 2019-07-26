package com.greatlearning.fsd.twitterapp.exception;

public class InvalidUserException extends Exception {
	public InvalidUserException(String errorMessage) {
		super(errorMessage);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}