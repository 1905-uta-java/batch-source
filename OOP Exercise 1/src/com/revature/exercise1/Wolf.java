package com.revature.exercise1;


public class Wolf extends Animal implements Carnivore{
	
	// This class extends the Animal class (Inheritance) and implements the Carnivore Interface (Abstraction)
	
	// Instance variable set to private. Only accessed by getters and setters. (Encapsulation)
	private int numOfWhiskers;
	
	public void howl() {
		System.out.println("Awoooo!");
	}
	
	// This is Method Overloading. A method with the same name, but different parameters. (Compile-Time Polymorphism)
	public void furColor(String color1) {
		System.out.println("Fur Color: " + color1);
	}
	
	public void furColor(String color1, String color2) {
		System.out.println("Fur Color: " + color1 + " and " + color2);
	}
	
	// Referencing the Interface (Abstraction)
	@Override
	public void hunt() {
		System.out.println("I hunt for prey to eat.");
	}
	
	public int getNumOfWhiskers() {
		return numOfWhiskers;
	}


	public void setNumOfWhiskers(int numOfWhiskers) {
		if (numOfWhiskers < 0) {
			numOfWhiskers = 0;
		} else {
			this.numOfWhiskers = numOfWhiskers;
		}
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numOfWhiskers;
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
		Wolf other = (Wolf) obj;
		if (numOfWhiskers != other.numOfWhiskers)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Wolf [Whiskers: " + numOfWhiskers + ", Legs: " + getLegs() + ", Size: " + getSize() + ", Has Fur: " + getHasFur() + "]";
	}
}
