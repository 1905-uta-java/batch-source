package com.revature.models;

public class Cat extends Animal {
	
	private int numOfWhiskers;
	
	public void meow() {
		System.out.println("meow");
	}

	public int getNumOfWhiskers() {
		return numOfWhiskers;
	}

	public void setNumOfWhiskers(int numOfWhiskers) {
		this.numOfWhiskers = numOfWhiskers;
	}

	@Override
	public String toString() {
		return "Cat [numOfWhiskers=" + numOfWhiskers + "]";
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
		return true;
	}
	
	
	
	

}
