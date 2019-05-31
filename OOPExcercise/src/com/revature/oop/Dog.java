// Name: Benjamin Onwenu

package com.revature.oop;

// Abstraction by making use of an interface

public class Dog implements Animal {
	
	// Encapsulation- Making use of access modifiers along with getters and setters
	
	private int numOfLegs;
	private boolean isVertebrate;
	
	public Dog() {
		super();  // Inheritance from Object class
		numOfLegs = 4;
		isVertebrate = true;
	}

	public int getNumOfLegs() {
		return numOfLegs;
	}

	public void setNumOfLegs(int numOfLegs) {
		this.numOfLegs = numOfLegs;
	}

	public boolean isVertebrate() {
		return isVertebrate;
	}

	public void setVertebrate(boolean isVertebrate) {
		this.isVertebrate = isVertebrate;
	}

	@Override
	public void eats() {
		System.out.println("Eats: Kibble");
		
	}

	@Override
	public void greets() {
		System.out.println("Greets by: barking");
		
	}

	@Override
	public void reproduce() {
		System.out.println("Reproduction Method: Live bearing");
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isVertebrate ? 1231 : 1237);
		result = prime * result + numOfLegs;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (isVertebrate != other.isVertebrate)
			return false;
		if (numOfLegs != other.numOfLegs)
			return false;
		return true;
	}
	

	
	
} 