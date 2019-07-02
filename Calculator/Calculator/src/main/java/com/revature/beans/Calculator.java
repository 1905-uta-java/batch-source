package com.revature.beans;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

		
	public float add(float n1, float n2) {
		return n1 + n2;
	}
	
	public float subtract(float n1, float n2) {
		return n1 - n2;
	}
	
	public float multiply(float n1, float n2) {
		return n1 * n2;
	}
	
	public float divide(float n1, float n2) {
		return n1/n2;
	}
}
