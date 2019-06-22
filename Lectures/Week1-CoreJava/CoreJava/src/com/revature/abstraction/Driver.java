package com.revature.abstraction;

public class Driver {

	public static void main(String[] args) {
		InterfaceImpl i = new InterfaceImpl();
		i.doSomething();
		i.doSomethingElse();
		i.myAbstractMethod();
		i.myConcreteMethod();

	}

}
