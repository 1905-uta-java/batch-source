package com.revature.animals;

public interface Predatory 
{
	// These track() and chase() methods have default implementations.
	// Unless otherwise overridden, these implementations will be used in any class which seeks to implement this interface.
	default void track()
	{
		System.out.println("The predator is tracking");
	}
	
	default void chase()
	{
		System.out.println("The predator picks up speed as it dials in on its lunch!");
	}
	
	// this method requires future implementation-- abstraction that lets the user of this interface worry less about 
	// "how" and more about the fact that a user of the Predatory interface can "bring prey home."
	void bringPreyHome();
}
