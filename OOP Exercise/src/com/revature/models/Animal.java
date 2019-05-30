package com.revature.models;

public abstract class Animal{
	
	//Private variables to provide encapsulation
	private int eyes;
	private int legs;
	private boolean isAquatic;
	private int speed;
	
	//Defualt Constructor
	public Animal() {
		super();
	}
	
	//Constructor to initialize variables of Animal objects
	public Animal(int eyes, int legs, boolean isAquatic, int speed) {
		super();
		this.eyes = eyes;
		this.legs = legs;
		this.isAquatic = isAquatic;
		this.speed = speed;
	}

	//Abstract method to provide information on an animals movement
	public abstract void AnimalMovement();

	@Override
	public String toString() {
		return "Animal [eyes=" + eyes + ", legs=" + legs + ", isAquatic=" + isAquatic + ", speed=" + speed + "]";
	}

	//Getter for eyes
	public int getEyes() {
		return eyes;
	}

	//Setter for eyes
	public void setEyes(int eyes) {
		this.eyes = eyes;
	}

	//Getter for legs
	public int getLegs() {
		return legs;
	}

	//Setter for legs
	public void setLegs(int legs) {
		this.legs = legs;
	}

	//Getter for isAquatic
	public boolean isAquatic() {
		return isAquatic;
	}

	//Setter for isAquatic
	public void setAquatic(boolean isAquatic) {
		this.isAquatic = isAquatic;
	}

	//Getter for speed
	public int getSpeed() {
		return speed;
	}

	//Setter for speed
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	//Provides the hash of the object
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eyes;
		result = prime * result + (isAquatic ? 1231 : 1237);
		result = prime * result + legs;
		result = prime * result + speed;
		return result;
	}
	
	//Checks if the object is equivalent to the provided object
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (eyes != other.eyes)
			return false;
		if (isAquatic != other.isAquatic)
			return false;
		if (legs != other.legs)
			return false;
		if (speed != other.speed)
			return false;
		return true;
	} 

	
	
	
	

}
