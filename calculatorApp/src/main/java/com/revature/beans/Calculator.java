package com.revature.beans;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

	
	public int add(int one, int two) {
		return one + two;
	}
	
	public int sub(int one, int two) {
		return one - two;
	}
	
	public int mult(int one, int two) {
		return one * two;
	}
	
	public int div(int one, int two) {
		if(two != 0) {
			return one / two;
		} else {
			//throw ArithmeticException
			throw new ArithmeticException("Cannot divide by zero");
		}
	}
}
