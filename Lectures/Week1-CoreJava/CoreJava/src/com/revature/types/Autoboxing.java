package com.revature.types;

public class Autoboxing {
	
	public static void main(String[] args) {
		
		// Boxing - we explicitly "box" the primitive
		int num1 = 7;
		Integer num2 = new Integer(num1);
		
		// Unboxing
		Integer num3 = new Integer (3);
		int num4 = num3.intValue();
		
		// Autoboxing
		int num5 = 12;
		Integer num6 = num5;
		
		// Autounboxing
		Integer num7 = new Integer(54);
		int num8 = num7;
	}

}
