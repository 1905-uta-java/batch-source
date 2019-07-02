package com.revature.calculator2;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	//class fields
	
	
	public Calculator() {
		super();
	}
	
	public double add(double n1, double n2) {
		double n3 = n1 + n2;
		
		return n3;
	}
	
	public double subtract(double n1, double n2) {
		double n3 = n1 - n2;
		
		return n3;
	}
	
	public double multiply(double n1, double n2) {
		double n3 = n1 * n2;
		
		return n3;
	}
	
	public double division(double n1, double n2) {
		if(n2 == 0) {
			throw new ArithmeticException();
		}
			double n3 = n1/n2;
		return n3;
	}

}
