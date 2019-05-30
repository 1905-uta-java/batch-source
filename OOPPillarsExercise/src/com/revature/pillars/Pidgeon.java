package com.revature.pillars;

/*
 * Pidgeons are Animals, and extends the SuperClass, Animal because the attributes and methods defined in
 * Animal are necessary for a Pidgeon to function. This is an example of Inheritance.
 */
public class Pidgeon extends Animal implements CanFly {
	// Attributes that a Pidgeon has
	private String color;
	
	// Default Constructor
	public Pidgeon() {
		super(4, "Avian", 1);
	}
	
	// Main Constructor for the Pidgeon
	public Pidgeon(String color, int weight) {
		super(4, "Avian", weight);
		this.color = color;
	}
	
	// Getter and Setter for the color of the Pidgeon
	// These getters and setters are an example of Encapsulation
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	/*
	 * These are the Overrides for the makeNoise method and the methods for movement
	 * defined in the interfaces. This is one of the examples of Polymorphism.
	 */
	
	// Override for the fly method in CanFly
	@Override
	public void fly() {
		System.out.println("The Pidgeon flaps its wings and flies.");		
	}

	// Override for the makeNoise method in Animal
	@Override
	void makeNoise() {
		System.out.println("coo");
	}
	
	// Override for the Overloaded fly method in CanFly
	@Override
	public void fly(int dist) {
		System.out.println("The Pidgeon flaps its wings and flies, flying a distance of " + dist + "ft.");
	}

	// Override for the hashCode method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	// Override for the equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pidgeon other = (Pidgeon) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}

	// Override for the toString Method
	@Override
	public String toString() {
		return "Pidgeon [color=" + color + " limbs=" + super.getLimbs() + 
				" type=" + super.getType() + " weight=" + super.getWeight() + "]";
	}
}
