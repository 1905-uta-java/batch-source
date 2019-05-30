package com.revature.pillarsoop;

//inheriting from parent class Animals
public class Fish extends Animals implements Interface {
	
	private boolean breatheUnderWater;
	private boolean hasFins;
	
	public void swim() {
		Interface.super.fishSwims();
	}
	
	//Getters and Setters for Encapsulation
	public boolean isBreatheUnderWater() {
		return breatheUnderWater;
	}
	public void setBreatheUnderWater(boolean breatheUnderWater) {
		this.breatheUnderWater = breatheUnderWater;
	}
	public boolean isHasFins() {
		return hasFins;
	}
	public void setHasFins(boolean hasFins) {
		this.hasFins = hasFins;
	}
	
	//Hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (breatheUnderWater ? 1231 : 1237);
		result = prime * result + (hasFins ? 1231 : 1237);
		return result;
	}
	
	
	//Equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fish other = (Fish) obj;
		if (breatheUnderWater != other.breatheUnderWater)
			return false;
		if (hasFins != other.hasFins)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fish [breatheUnderWater=" + breatheUnderWater + ", hasFins=" + hasFins + ", getLegs()=" + getLegs()
				+ ", getSize()=" + getSize() + ", getAge()=" + getAge() + ", isHasFur()=" + isHasFur()
				+ ", isAquatic()=" + isAquatic() + "]";
	}
	
	
	
	
}
