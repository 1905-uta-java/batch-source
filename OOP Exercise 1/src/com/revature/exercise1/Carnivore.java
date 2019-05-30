package com.revature.exercise1;

public interface Carnivore {

	// This is an interface. An interface is implicitly abstract and can not be initialized. It focuses on the what more than the how.
	// This is an example of Abstraction.
	
	default void eatMeat() {
		System.out.println("I eat meat.");
	}
	
	void hunt();
	
}
