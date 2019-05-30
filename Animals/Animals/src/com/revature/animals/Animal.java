package com.revature.animals;

public class Animal {
	private int legs;
	private boolean hasTail;
	private boolean isNocturnal;
	private int weightInPounds;
	private int health;
	
	public Animal(int legs, boolean hasTail, boolean isNocturnal, int weightInPounds, int health) {
		super();
		this.legs = 4;
		this.hasTail = hasTail;
		this.isNocturnal = isNocturnal;
		this.weightInPounds = weightInPounds;
		this.health = 100;		
	}

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		if(legs>-1)
		this.legs = legs;
	}

	public boolean isHasTail() {
		return hasTail;
	}

	public void setHasTail(boolean hasTail) {
		this.hasTail = hasTail;
	}

	public boolean isNocturnal() {
		return isNocturnal;
	}

	public void setNocturnal(boolean isNocturnal) {
		this.isNocturnal = isNocturnal;
	}

	public int getWeightInPounds() {
		return weightInPounds;
	}

	public void setWeightInPounds(int weightInPounds) {
		if(weightInPounds>0)
		this.weightInPounds = weightInPounds;
	}

	@Override
	public String toString() {
		return "Animal [legs=" + legs + ", hasTail=" + hasTail + ", isNocturnal=" + isNocturnal + ", weightInPounds="
				+ weightInPounds + "]";
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (hasTail ? 1231 : 1237);
		result = prime * result + (isNocturnal ? 1231 : 1237);
		result = prime * result + legs;
		result = prime * result + weightInPounds;
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
		Animal other = (Animal) obj;
		if (hasTail != other.hasTail)
			return false;
		if (isNocturnal != other.isNocturnal)
			return false;
		if (legs != other.legs)
			return false;
		if (weightInPounds != other.weightInPounds)
			return false;
		return true;
	}
	
	
}
