package com.revature.abstraction;

public abstract class MyAbstractClass {
	
	// can include both concrete and abstract methods
	
	// can alos include instance variables which aren't necessarily public or final
	
	public abstract void myAbstractMethod();
	
	public void myConcreteMethod() {
		System.out.println("we can still provide implemented methods");
	}

}
