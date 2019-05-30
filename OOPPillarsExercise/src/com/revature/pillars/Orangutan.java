package com.revature.pillars;

/*
 * Orangutans are Animals, and extends the SuperClass, Animal because the attributes and methods defined in
 * Animal are necessary for the Orangutan to function. This is an example of Inheritance.
 */
public class Orangutan extends Animal implements CanMove {
	// Attributes that an Orangutan has
	private int hairLength;
	
	// Default Constructor
	public Orangutan() {
		super(4, "Mammal", 200);
	}
	
	// Main Constructor for the Orangutan
	public Orangutan(int hairLength, int weight) {
		super(4, "Mammal", weight);
		this.hairLength = hairLength;
	}

	// Getter and Setter for the Orangutan's attributes
	// These getters and setters are an example of Encapsulation
	public int getHairLength() {
		return hairLength;
	}

	public void setHairLength(int hairLength) {
		if(hairLength>0)
			this.hairLength = hairLength;
	}

	/*
	 * These are the Overrides for the makeNoise method and the methods for movement
	 * defined in the interfaces. This is one of the examples of Polymorphism.
	 */
	
	// Override for the move method in CanMove
	@Override
	public void move() {
		System.out.println("The Orangutan walks accross the ground on its hands and feet.");
	}

	// Override for the makeNoise method in Animal
	@Override
	void makeNoise() {
		System.out.println("ook");
	}
	
	// Override for the overloaded move method in CanMove
	@Override
	public void move(int dist) {
		System.out.println("The Orangutan walks accross the ground on its hands and feet, moving a distance of " + dist + "ft.");
	}

	// Override of the hashCode method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + hairLength;
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
		Orangutan other = (Orangutan) obj;
		if (hairLength != other.hairLength)
			return false;
		return true;
	}

	// Override of the toString method
	@Override
	public String toString() {
		return "Orangutan [hairLength=" + hairLength + " limbs=" + super.getLimbs() + 
				" type=" + super.getType() + " weight=" + super.getWeight() + "]";
	}	
}
