package com.revature.types;

public class DefaultDriver {
	
	//static and instance scoped values will be given their appropriate default value
	static boolean bool;
	
	static char ch;
	static double d;
	static String str;
	
	public static void main(String[] args) {
		System.out.println(bool);
		System.out.println(ch);
		System.out.println(d);
		System.out.println(str);
		
		//local/method scoped values are not assigned default values
	}

}
