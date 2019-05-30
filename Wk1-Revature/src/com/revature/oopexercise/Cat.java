package com.revature.oopexercise;

/*
 * Cat
 * 
 * Definition of the Cat abstract class
 * Inherits from Animal interface
 * 
 * Constructors defined:
 * Cat::Cat()
 * 
 * Abstract Functions newly defined:
 * Cat::sneak()
 * 
 * Functions implemented or Overridden:
 * Cat::makeNoise()
 * Cat::move()
 * int Cat::hashCode()
 * boolean Cat::equals(Object obj)
 */
public abstract class Cat implements Animal {
	//Cat inherits traits of animal
	
	//place of cat residence, to be changed for cat variants
	//stays protected to allow for subclasses to alter while
	//maintaining immutability from the outside.
	protected String biome = "Default biome";
	
	/*
	 * Cat::Cat()
	 * Default Constructor
	 * args: None
	 * 
	 * Creates a Cat in the default state.
	 */
	public Cat() {
		super();
	}
	
	/*
	 * Cat::getBiome()
	 * args: None
	 * returns: String - the biome.
	 * 
	 * Gets the biome variable, retaining encapsulation.
	 */
	public String getBiome() {
		return biome;
	}

	@Override
	// Abstracting out noisemaking to allow for cat variants
	/*
	 * (non-Javadoc)
	 * @see com.revature.oopexercise.Animal#makeNoise()
	 * 
	 * Cat::makeNoise()
	 * args: None
	 * returns: None
	 * 
	 * Prints a noise to sysout.
	 * 
	 * Remains abstract, but otherwise takes the role of the
	 * function inherited from Animal
	 */
	public abstract void makeNoise();
	
	//Cats can generally sneak, but how and where? See variants.
	/*
	 * Cat::sneak()
	 * args: None
	 * returns: None
	 * 
	 * Prints out details about cat stealth.
	 * Abstract for future variants.
	 */
	public abstract void sneak();

	@Override
	//Implementing move functionality provided by animal
	/*
	 * (non-Javadoc)
	 * @see com.revature.oopexercise.Animal#move()
	 * 
	 * Cat::move()
	 * args: None
	 * returns: None
	 * 
	 * Prints that the Cat has moved, and where.
	 * 
	 * Implements the inherited abstract function from Animal
	 */
	public void move() {
		String prefix = this.getClass() + " has moved through the ";
		String totality = prefix + biome + ".";
		System.out.println(totality);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * 
	 * Cat::hashCode()
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
	 * Cat::equals(Object obj)
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
		if (((Cat) obj).biome != this.biome) return false;
		
		
		return true;
	}
	
}
