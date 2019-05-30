package com.revature.models;

public class Cat extends Animals{
	//cat attributes
	private int numOfWhiskers;
	public Cat() {
	}
	
	public Cat(int numOfWhiskers) {
		this.setNumOfWhiskers(numOfWhiskers);
	}
	
	public int getNumOfWhiskers() {
		return this.numOfWhiskers;
	}

	public void setNumOfWhiskers(int numOfWhiskers) {
		this.numOfWhiskers = numOfWhiskers;
	}

	public void meow() {
		System.out.println("Meow.");	
	}
	
	@Override
	public String toString() {
		return "Cat [numOfWhiskers=" + numOfWhiskers + "," + "legs=" +getLegs() + "," + "size=" + getSize() + "," + "hasFur=" + isHasFur() +"]";
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
		Cat other = (Cat) obj;
		if (numOfWhiskers != other.numOfWhiskers)
			return false;
		if(!super.equals(obj))
			return false;
		return true;
	}

	
	

}
