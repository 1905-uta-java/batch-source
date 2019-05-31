package com.revature.animals;

public interface Domesticatable 
{
	// Default implementation still allows for some concrete implementation if one is not provided by the class which uses the interface
	default void train()
	{
		System.out.println("This animal is being trained!");
	}
	
	// Implementation of feed() left to implementing class. This is an example of Abstraction-- anyone using this interface need only know
	// that classes implementing it will have domesticatable behaviors-- such as being trained, and being fed.
	void feed();
}
