package com.revature.oopexercise;

/*
 * Dog
 * 
 * Definition of the Dog class
 * Inherits from Animal interface
 * 
 * Constructors defined:
 * Dog::Dog()
 * Dog::Dog(String newBreed)
 * 
 * Functions newly defined:
 * String Dog::getBreed()
 * 
 * Functions implemented or Overridden:
 * Dog::makeNoise()
 * Dog::move()
 * int Dog::hashCode()
 * boolean Dog::equals(Object obj)
 */
public class Dog implements Animal {
	
	//keeping internal data as encapsulated as possible with 
	//private
	private String breed = "Default Breed";
	
	/*
	 * Dog::Dog()
	 * Default constructor
	 * args: none
	 * 
	 * Creates a Dog in the default state.
	 */
	public Dog() {
		super();
	}
	
	/*
	 * Dog::Dog(String newBreed)
	 * Constructor
	 * args: String newBreed - new breed to apply to the Dog at
	 * Dog creation time
	 * 
	 * Creates a dog with breed = newBreed
	 */
	public Dog(String newBreed) {
		this.breed = newBreed;
	}

	/*
	 * Dog::getBreed()
	 * args: None
	 * returns: String - the breed of the dog
	 * 
	 * Provides breed as a getter to prevent the breed from
	 * changing unexpectedly, and encapsulating the data
	 */
	public String getBreed() {
		return breed;
	}

	/*
	 * (non-Javadoc)
	 * @see com.revature.oopexercise.Animal#makeNoise()
	 * 
	 * Dog::makeNoise()
	 * args: None
	 * returns: None
	 * 
	 * Prints a dog noise to sysout.
	 * 
	 * Implements the inherited abstract function from Animal
	 */
	@Override
	public void makeNoise() {
		System.out.println("Woof");
	}

	/*
	 * (non-Javadoc)
	 * @see com.revature.oopexercise.Animal#move()
	 * 
	 * Dog::move()
	 * args: None
	 * returns: None
	 * 
	 * Prints that the Dog has moved somewhat uninterestingly.
	 * 
	 * Implements the inherited abstract function from Animal
	 */
	@Override
	public void move() {
		System.out.println("Dog has moved.");
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * 
	 * Dog::hashCode()
	 * args: None
	 * returns: int - the hash code of the Dog.
	 * 
	 * Overrides the inherited function from Object
	 */
	@Override
	public int hashCode()
	{
		return System.identityHashCode(this);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * Dog::equals(Object obj)
	 * args: Object obj - the object to compare
	 * returns: boolean - whether or not the object is equal.
	 * 
	 * Overides the inherited function from Object
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == this) return true;
		if (obj == null) return false;
		if (obj.getClass() != this.getClass()) return false;
		
		
		
		return true;
	}
}
