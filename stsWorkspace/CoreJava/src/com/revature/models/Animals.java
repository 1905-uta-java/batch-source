package com.revature.models;

public class Animals {
	//class attributes
	private int legs;
	private boolean hasFur;
	private int size;
	
	public Animals() {
	}
	
	public Animals(int legs, boolean hasFur, int size) {
		this.setLegs(legs);
		this.hasFur = hasFur;
		this.setSize(size);
	}
	
	public void setLegs(int legs) {
		if(legs >= 0)
			this.legs = legs;
	}
	
	
	public void setSize(int size) {
		if(size > 0)
			this.size = size;
	}
	
	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}
	
	public int getLegs() {
		return this.legs;
	}
	
	
	public int getSize() {
		return this.size;
	}

	public boolean isHasFur() {
		return this.hasFur;
	}

	@Override
	public String toString() {
		return "Animals [legs=" + legs + ", hasFur=" + hasFur + ", size=" + size + "]";
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
		Animals other = (Animals) obj;
		if (hasFur != other.hasFur)
			return false;
		if (legs != other.legs)
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	
	
}
