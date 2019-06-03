package com.revature.oop;
//Class Cat must implement methods that were declared in the interface Felidae
public class Cat implements Felidae {
	//Cat attributes
	private boolean hasFur;
	private int numWhiskers;
	private String call;
	
	//constants
	//attributes that are static and final can use the access modifier public since they cannot be reassigned
	public static final String SPECIES = "Cat";
	
	//no args constructor
	public Cat() {
	}
	
	public Cat(boolean hasFur, int numWhiskers, String call) {
		this.setHasFur(hasFur);
		this.setNumWhiskers(numWhiskers);
		this.setCall(call);
	}

	public boolean hasFur() {
		return hasFur;
	}

	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}

	public int getNumWhiskers() {
		return numWhiskers;
	}

	public void setNumWhiskers(int numWhiskers) {
		if(numWhiskers >= 0)
			this.numWhiskers = numWhiskers;
	}

	public String getCall() {
		return call;
	}

	public void setCall(String call) {
		this.call = call;
	}
	
	public String getSpecies() {
		return SPECIES;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((call == null) ? 0 : call.hashCode());
		result = prime * result + (hasFur ? 1231 : 1237);
		result = prime * result + numWhiskers;
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
		Cat other = (Cat) obj;
		if (call == null) {
			if (other.call != null)
				return false;
		} else if (!call.equals(other.call))
			return false;
		if (hasFur != other.hasFur)
			return false;
		if (numWhiskers != other.numWhiskers)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cat [hasFur=" + hasFur + ", numWhiskers=" + numWhiskers + ", call=" + call + "]";
	}
	
	
	
	
	
}
