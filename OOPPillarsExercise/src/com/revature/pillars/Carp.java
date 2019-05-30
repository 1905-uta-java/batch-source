package com.revature.pillars;

/*
 * Carp is an Animal, and extends the SuperClass, Animal because the attributes and methods defined in
 * Animal are necessary for Carp to function. This is an example of Inheritance.
 */
public class Carp extends Animal implements CanSwim {
	// Attributes that a Carp may have
	private int length;
	
	// Default Constructor
	public Carp() {
		super(0, "Fish", 20);
	}
	
	// Main Constructor
	public Carp(int length, int weight) {
		super(0, "Fish", weight);
		this.length = length;
	}
	
	// Override of the toString method
	@Override
	public String toString() {
		return "Carp [length=" + length + " limbs=" + super.getLimbs() + 
				" type=" + super.getType() + " weight=" + super.getWeight() + "]";
	}

	// Override of the hashCode method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + length;
		return result;
	}

	// Override of the equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carp other = (Carp) obj;
		if (length != other.length)
			return false;
		return true;
	}

	// Getter and Setter for the length of the Carp
	// These getters and setters are an example of Encapsulation
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		if(length>0)
			this.length = length;
	}

	/*
	 * These are the Overrides for the makeNoise method and the methods for movement
	 * defined in the interfaces. This is one of the examples of Polymorphism.
	 */
	
	// Override of the swim method in CanSwim
	@Override
	public void swim() {
		System.out.println("The carp uses its fins to swim through the water.");
	}

	// Override of the makeNoise method in Animal
	@Override
	void makeNoise() {
		System.out.println("glub");
	}

	@Override
	public void swim(int dist) {
		System.out.println("The carp uses its fins to swim through the water, swimming a distance of " + dist + "ft.");
	}

}
