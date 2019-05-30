package com.revature.pillarsoop;

//inheriting from parent class Animals
public class Bird extends Animals implements Interface {
	
	private boolean canFly;

	public void chirp() {
		Interface.super.birdChirps();
	}
	
	//Getters and Setters for Encapsulation
	public boolean isCanFly() {
		return canFly;
	}
	
	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}

	//HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (canFly ? 1231 : 1237);
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
		Bird other = (Bird) obj;
		if (canFly != other.canFly)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bird [canFly=" + canFly + ", getLegs()=" + getLegs() + ", getSize()=" + getSize() + ", getAge()="
				+ getAge() + ", isHasFur()=" + isHasFur() + ", isAquatic()=" + isAquatic() + "]";
	}
	
	
	
	
}
