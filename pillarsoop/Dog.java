package com.revature.pillarsoop;

//inheriting from parent class Animals
public class Dog extends Animals implements Interface {
	
	private int tailLength;

	public void bark() {
		Interface.super.dogBarks();
	}
	
	//Getters and Setters for Encapsulation
	public int getTailLength() {
		return tailLength;
	}

	public void setTailLength(int tailLength) {
		if(tailLength>-1)
			this.tailLength = tailLength;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + tailLength;
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
		Dog other = (Dog) obj;
		if (tailLength != other.tailLength)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dog [tailLength=" + tailLength + ", getLegs()=" + getLegs() + ", getSize()=" + getSize() + ", getAge()="
				+ getAge() + ", isHasFur()=" + isHasFur() + ", isAquatic()=" + isAquatic() + "]";
	}

	
	
	
}
