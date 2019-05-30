package com.revature.exercise1;


public class Animal {
	
	// instance variables 
	// Theses variables are set to private and must be accessed with getters and setters. This is an example of Encapsulation
	private int legs;
	private boolean hasFur;
	private int size;
	
	public Animal() {
		super(); // The Animal class is referencing the Object class using keyword super. This is an example of Inheritance.
	}
	
	public Animal(int legs, boolean hasFur, int size) {
		super();
		this.legs = legs;
		this.hasFur = hasFur;
		this.size = size;
	}
	
	public int getLegs() {
		return this.legs; 
	}
	
	public void setLegs(int legs) {
		if (legs > -1) {
			
			this.legs = legs;
		}	
	}
	
	public boolean getHasFur() {
		return this.hasFur;
	}
	
	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void setSize(int size) {
		if (size > 0) {
		this.size = size;
		}
	}

	@Override
	public String toString() {
		return "Animal [legs = " + legs + ", hasFur = " + hasFur + ", size = " + size + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (hasFur ? 1231 : 1237);
		result = prime * result + legs;
		result = prime * result + size;
		return result;
	}
	
	
	// Value equality
	@Override
	public boolean equals(Object obj) {
		if (this == obj) // Check that it is an object
			return true; 
		if (obj == null) // Make sure object is not null
			return false;
		if (getClass() != obj.getClass()) // Make sure objects are the same class (i.e, both animals)
			return false;
		Animal other = (Animal) obj;
		if (hasFur != other.hasFur)
			return false;
		if (legs != other.legs)
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	
	
	
	
	
	

}
