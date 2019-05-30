package com.revature.exceptions;

public class NegativeSizeException extends RuntimeException {
	
	public NegativeSizeException() {
		
	}
	
	public NegativeSizeException(String message) {
		super(message);
	}

}
