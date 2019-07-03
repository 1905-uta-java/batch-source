package com.revature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No Sanwich with given ID")
public class SandwichNotFoundException extends RuntimeException {
	
	public SandwichNotFoundException() {
		super();
	}

}
