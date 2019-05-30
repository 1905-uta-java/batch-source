package com.revature.abstraction;

/*
 * Interfaces allow us to declare abstract methods
 */
public interface InterfaceA {
	
	//variables are implicitly static, final and public
	int MY_INT = 54;
	
	void doSomething();
	
	default void doSomethingElse() {
		System.out.println("I DID SOMETHING!");
	}
	
	
	
}
