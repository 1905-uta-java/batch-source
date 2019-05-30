package com.revature.abstraction;

public class InterfaceImpl extends MyAbstractClass 
							implements InterfaceA, InterfaceB {
	
	//override and implement method from InterfaceA
	public void doSomething() {
		System.out.println("Doing something first.");
	}

//	To mitigate method conflicts, pick which implementation to use.
//	Override the conflicting method and select whichever implementation designated
	@Override
	public void doSomethingElse() {
		// picked InterfaceA
		InterfaceA.super.doSomethingElse();
	}
	
	public void myAbstractMethod() {
		System.out.println("Abstract Method implemented!");
	}

}
