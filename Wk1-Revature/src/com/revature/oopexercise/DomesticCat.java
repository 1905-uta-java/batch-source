package com.revature.oopexercise;

/*
 * DomesticCat
 * 
 * Definition of the DomesticCat class
 * Inherits from Cat abstract class
 * 
 * Constructors defined:
 * DomesticCat::DomesticCat()
 * DomesticCat::DomesticCat(String overrideBiome)
 * 
 * Functions implemented or Overridden:
 * DomesticCat::sneak()
 * DomesticCat::makeNoise()
 * DomesticCat::move()
 * int DomesticCat::hashCode()
 * boolean DomesticCat::equals(Object obj)
 */
public class DomesticCat extends Cat {
	
	/*
	 * DomesticCat::DomesticCat()
	 * Default Constructor
	 * args: None
	 * 
	 * Creates a DomesticCat in the default state.
	 * Overwrites the default biome inherited from Cat.
	 */
	public DomesticCat() {
		super();
		super.biome = "house";
	}

	/*
	 * DomesticCat::DomesticCat(String overrideBiome)
	 * Constructor
	 * args: String overrideBiome - new biome to apply to the
	 * DomesticCat.
	 * 
	 * Creates a DomesticCat that inhabits overrideBiome.
	 * Overwrites the default biome inherited from Cat.
	 */
	public DomesticCat(String overrideBiome) {
		super();
		super.biome = overrideBiome;
	}
	
	@Override
	//Implement abstract function from Cat
	/*
	 * (non-Javadoc)
	 * @see com.revature.oopexercise.Cat#makeNoise()
	 * 
	 * DomesticCat::makeNoise()
	 * args: None
	 * returns: None
	 * 
	 * Prints a domestic housecat noise to sysout.
	 * 
	 * Overrides the inherited function from Cat
	 */
	public void makeNoise() {
		System.out.println("Meow");
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.revature.oopexercise.Cat#sneak()
	 * 
	 * DomesticCat::sneak()
	 * args: None
	 * returns: None
	 * 
	 * Prints details of the domestic housecat's stealth to 
	 * sysout.
	 * 
	 * Overrides the inherited function from Cat
	 */
	@Override
	public void sneak() {
		System.out.println("The DomesticCat hides in a cardboard box!");
	}
	
	
	
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * 
	 * DomesticCat::hashCode()
	 * args: None
	 * returns: int - the hash code of the DomesticCat.
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
	 * DomesticCat::equals(Object obj)
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
