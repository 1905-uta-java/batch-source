package com.revature.beans;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	public int add(int n1, int n2) {
		return n1 + n2;
	}
	public int subtract(int n1, int n2) {
		return n1 - n2;
	}
	public int multiply(int n1, int n2) {
		return n1 * n2;
	}
	public int divide(int n1, int n2) {
		if(n2 != 0)
			return n1 / n2;
		throw(new ArithmeticException());
	}
}
