package com.revature.models;

import com.revature.exception.NegativeSizeException;

public class Animal {

	private int legs;
	private boolean hasFur;
	private int size;
	
	public Animal() {
		super();
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
		if(legs>-1) {
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
		return size;
	}

	public void setSize(int size) {
		if(size<1) {
			try {
				throw new NegativeSizeException();
			} catch (NegativeSizeException e) {
				// this code is excecuted if the NegativeSizeException is thrown within the execution of our try block
				System.out.println("cannot set size to a negative value");
			} finally {	
				// anything included in a finally block will execute whether or not an exception is thrown in our try block -- this is generally used to close or clean up resources 
				System.out.println("this was printed either way");
			}
		} else {
			this.size = size;	
		}
	}

	@Override
	public String toString() {
		return "Animal [legs=" + legs + ", hasFur=" + hasFur + ", size=" + size + "]";
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
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
