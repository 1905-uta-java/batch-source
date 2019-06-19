package com.revature.service;

public class CalculatorService {
	
	
	public int calculate(int n1, int n2, String op) {
		int result = 0;
		
		switch(op) {
		case "add":
			result = n1 + n2;
			break;
		case "subtract":
			result = n1 - n2;
			break;
		case "multiply":
			result = n1*n2;
			break;	
		}
		
		return result;
	}

}
