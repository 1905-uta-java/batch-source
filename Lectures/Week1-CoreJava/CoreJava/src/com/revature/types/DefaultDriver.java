package com.revature.types;

public class DefaultDriver {

	//static and instance scoped values will be given their appropriate default value
	static boolean bool;
	static char ch;
	static double d;
	static String str;
	static boolean[] arr = new boolean[4];
	
	
	public static void main(String[] args){
		System.out.println(bool);
		System.out.println(ch);
		System.out.println(d);
		System.out.println(str);
		System.out.println(arr[2]);
		
		
		// local/method, and block scoped values are not assigned default values
//		int x;
//		System.out.println(x);
	}
	
	
}
