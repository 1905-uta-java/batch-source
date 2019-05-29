package com.revature.oop;

public class Liger implements Lions, Tigers {
	//Liger attributes
	private boolean hasFur;
	private int numWhiskers;
	private String call;
	//constants
	//attributes that are static and final can use the access modifier public since they cannot be reassigned
	public static final String SPECIES = "Liger";
	
	//no args constructor
	public Liger() {
	}
	
	public Liger(boolean hasFur, int numWhiskers, String call) {
		this.hasFur = hasFur;
		this.setNumWhiskers(numWhiskers);
		this.setCall(call);
	}

	@Override
	public boolean hasFur() {
		return hasFur;
	}

	@Override
	public int getNumWhiskers() {
		return numWhiskers;
	}
	
	public void setNumWhiskers(int numWhiskers) {
		if(numWhiskers >= 0)
			this.numWhiskers = numWhiskers;
	}
	
	//both Lions and Tigers have an implemented method for getSpecies()
	//Override the getSpecies to specify to use either Lions' or Tigers'
	//Or Override with a new implementation as such
	@Override
	public String getSpecies() {
		// TODO Auto-generated method stub
		return SPECIES + " = " + Lions.super.getSpecies() + "+" + Tigers.super.getSpecies();
	}
	
	public String getCall() {
		return call;
	}
	
	public void setCall(String call) {
		this.call = call;
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
		Liger other = (Liger) obj;
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
		return "Liger [hasFur=" + hasFur + ", numWhiskers=" + numWhiskers + ", call=" + call + "]";
	}
	
	
	
}
