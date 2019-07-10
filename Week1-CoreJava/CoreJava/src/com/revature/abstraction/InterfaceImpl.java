package com.revature.abstraction;

public class InterfaceImpl extends MyAbstractClass implements InterfaceA, InterfaceB{

	@Override
	public void doSomething() {
		System.out.println("doing something");
	}

	// we need to adopt one of the implementations to prevent the "diamond problem"
	@Override
	public void doSomethingElse() {
		InterfaceA.super.doSomethingElse();
	}

	@Override
	public void myAbstractMethod() {
		System.out.println("not so abstract anymore");
	}

}
