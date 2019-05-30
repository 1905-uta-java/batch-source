package com.revature.oopexercise;

/*
 * BigCat
 * 
 * Definition of the BigCat class
 * Inherits from Cat abstract class
 * 
 * Constructors defined:
 * BigCat::BigCat()
 * BigCat::BigCat(String overrideBiome)
 * 
 * Functions newly defined:
 * BigCat::getMass()
 * 
 * Functions implemented or Overridden:
 * BigCat::sneak()
 * BigCat::makeNoise()
 * BigCat::move()
 * int BigCat::hashCode()
 * boolean BigCat::equals(Object obj)
 */

public class BigCat extends Cat {

	//How big is this cat anyway?
	//mass is private to maintain encapsulation
	private double mass;
	
	/*
	 * BigCat::BigCat()
	 * Default Constructor
	 * args: None
	 * 
	 * Alters Cat's biome and BigCat's mass to a new set of 
	 * default values.
	 */
	public BigCat() {
		super();
		super.biome = "jungle";
		this.mass = 100.;
	}
	
	/*
	 * BigCat::BigCat(String overrideBiome, double newMass)
	 * Constructor
	 * args: String overrideBiome - new biome to apply to the 
	 * BigCat.
	 * 		double newMass - new mass to apply to the BigCat.
	 * 
	 * Alters Cat's biome and BigCat's mass to a new set of
	 * default values.
	 */
	public BigCat(String overrideBiome, double newMass) {
		super();
		super.biome = overrideBiome;
		this.mass = newMass;
	}
	
	/*
	 * BigCat::getMass()
	 * args: None
	 * returns: double - mass of the BigCat
	 * 
	 * Gets the mass of the BigCat to allow BigCat data to be
	 * read while preventing mutability from the outside,
	 * encapsulating the data.
	 */
	public double getMass() {
		return mass;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.revature.oopexercise.Cat#sneak()
	 * 
	 * BigCat::sneak()
	 * args: None
	 * returns: None
	 * 
	 * Prints details of the large cat's stealth to 
	 * sysout.
	 * 
	 * Overrides the inherited function from Cat
	 */
	@Override
	public void sneak() {
		System.out.println("The BigCat has hidden in the underbrush, waiting to strike!");
	}

	/*
	 * (non-Javadoc)
	 * @see com.revature.oopexercise.Cat#makeNoise()
	 * 
	 * BigCat::makeNoise()
	 * args: None
	 * returns: None
	 * 
	 * Prints a large cat noise to sysout.
	 * 
	 * Overrides the inherited function from Cat
	 */
	@Override
	public void makeNoise() {
		System.out.println("GROWL");
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
		if (((Cat) obj).biome != this.biome) return false;
		if (((BigCat) obj).mass != this.mass) return false;
		
		
		return true;
	}
	
}
