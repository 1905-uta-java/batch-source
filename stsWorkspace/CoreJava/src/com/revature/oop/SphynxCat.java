package com.revature.oop;
//Class SphynxCat will inherit public methods from Cat
public class SphynxCat extends Cat {
	//SphynxCat attributes
	private String name;
	//constants
	//attributes that are static and final can use the access modifier public since they cannot be reassigned
	public static final boolean HAS_FUR = false;
	public static final int NUM_WHISKERS = 0;
	
	//no args constructor
	public SphynxCat() {
		super.setHasFur(HAS_FUR);
		super.setNumWhiskers(NUM_WHISKERS);
	}
	
	//constructor that accepts integer arguments for call and name
	public SphynxCat(String call, String name) {
		super.setHasFur(HAS_FUR);
		super.setNumWhiskers(NUM_WHISKERS);
		super.setCall(call);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		SphynxCat other = (SphynxCat) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if(!super.equals(other))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SphynxCat [name=" + name + ", call=" + this.getCall() + "]";
	}
	
	
	
	
	
}
