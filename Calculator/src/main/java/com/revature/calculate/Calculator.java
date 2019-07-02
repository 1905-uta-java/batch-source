package com.revature.calculate;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	
	public float add(float x, float y) {
		return x + y;
	}
	
	public float subtract(float x, float y) {
		return x - y;
	}
	
	public float multiply(float x, float y) {
		return x * y;
	}
	
	public float divide(float x, float y) {
		return x / y;
	}
}
