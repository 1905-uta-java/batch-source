package com.revature.exercise1;

public class Hippo extends Animal implements Herbivore {
	
	// This class extends the Animal class (Inheritance) and implements the Herbivore Interface (Abstraction)
	
	// Instance variable set to private. Only accessed by getters and setters. (Encapsulation)
	private boolean skin;
	
	public void swim() {
		System.out.println("I swim around in rivers!");
	}
	
	// Referencing the Interface (Abstraction)
	@Override
	public void search() {
		System.out.println("I search for plants to eat.");
	}

	public boolean isSkin() {
		return skin;
	}

	public void setSkin(boolean skin) {
		this.skin = skin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (skin ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hippo other = (Hippo) obj;
		if (skin != other.skin)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hippo [Legs: " + getLegs() + ", Size: " + getSize() + ", Has Fur: " + getHasFur() + ", Has Skin: " + skin + "]";
	}

}
