package com.revature.pillars;

// Animal is an abstract class that defines the base methods and attributes that animals should generally have
public abstract class Animal {
	// Attributes that all animals will have
	private int limbs;
	private String type;
	private int weight;
	
	// Default constructor
	public Animal() {
		super();
	}
	
	// Main constructor
	public Animal(int limbs, String type, int weight) {
		this.limbs = limbs;
		this.type = type;
		this.weight = weight;
	}
	
	// Getters and Setters for the attributes for proper encapsulation
	public int getLimbs() {
		return limbs;
	}
	public void setLimbs(int limbs) {
		if(limbs>-1)
			this.limbs = limbs;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		if(weight>0)
			this.weight = weight;
	}
	
	// Override for the hashCode method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + limbs;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + weight;
		return result;
	}

	// Override for the equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (limbs != other.limbs)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	// Override for the toString method	
	@Override
	public String toString() {
		return "Animal [limbs=" + limbs + ", type=" + type + ", weight=" + weight + "]";
	}

	// Animals generally make noise but it is unique to each animal so the method will be abstract
	// This is where the abstraction is implemented here, because each animal is going to be making
	// a different noise there's no real need for the superclass to have it strictly defined
	// but since it's a method each subclass is going to use, having the definition is necessary
	abstract void makeNoise();
}
