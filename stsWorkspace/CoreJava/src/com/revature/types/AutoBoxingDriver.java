package com.revature.types;

public class AutoBoxingDriver {

	public static void main(String[] args) {
		//System.out.println("Boxing and Unboxing:");
		//Boxing - we explicitly "box" the primitive
		int num1 = 7;
		Integer num2 = new Integer(num1);
		
		//unboxing - we explicitly "unbox" the primitive
		Integer num3 = new Integer(3);
		int num4 = num3.intValue();
		
		//System.out.println("Autoboxing and Autounboxing:");
		//Autoboxing
		int num5 = 12;
		Integer num6 = num5;
		
		//Autounboxing
		Integer num7 = new Integer(12);
		int num8 = num7;

	}

}
