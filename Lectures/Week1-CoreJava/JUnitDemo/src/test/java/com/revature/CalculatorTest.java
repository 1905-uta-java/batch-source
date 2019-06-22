package com.revature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void emptyStringReturnsZero() {
		int sum = Calculator.add("");
		assertEquals(0, sum);
	}
	
	@Test
	public void singleValueReturns() {
		int sum = Calculator.add("5");
		assertEquals(5, sum);
	}
	
	@Test
	public void twoNumbersReturnSum() {
		int sum = Calculator.add("4,2");
		assertEquals(6, sum);
	}
	
	@Test
	public void invalidInput() {
		int sum = Calculator.add("fksfakl");
		assertEquals(-1, sum);
	}
	
	@Test
	public void testNullInput() {
		int sum = Calculator.add(null);
		assertEquals(-1, sum);
	}

}
