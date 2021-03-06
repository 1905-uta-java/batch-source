package com.revature.models;

import java.io.Serializable;

public class Cat extends Animal implements Serializable, Cloneable {
	
	private int numOfWhiskers;
	
	public void meow() {
		System.out.println("meow");
	}

	public int getNumOfWhiskers() {
		return numOfWhiskers;
	}

	public void setNumOfWhiskers(int numOfWhiskers) {
		if(numOfWhiskers<21) {
			this.numOfWhiskers = numOfWhiskers;
		}
	}

	@Override
	public String toString() {
		return "Cat [numOfWhiskers=" + numOfWhiskers + ", legs="+getLegs()+", size="+getSize()+", hasFur="+getHasFur()+ "]";
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
