package com.revature;

public class Driver {
	public static void main(String[] args) {
		MySingleton singleton1 = MySingleton.getInstance();
		MySingleton singleton2 = MySingleton.getInstance();
		System.out.println(singleton1 == singleton2);
	}
	
	
}
