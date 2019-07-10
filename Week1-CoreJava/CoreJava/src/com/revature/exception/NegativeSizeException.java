package com.revature.exception;

public class NegativeSizeException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NegativeSizeException() {
		super();
	}
	
	public NegativeSizeException(String message) {
		super(message);
	}

}
