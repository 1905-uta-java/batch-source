package com.revature.pillarsoop;
//Abstraction class
public abstract class Animals {
	private int legs;
	private int size;
	private int age;
	private boolean hasFur;
	private boolean aquatic;
	
	
	
	public Animals() {
		super();
	}
	public Animals(int legs, int size, int age, boolean hasFur) {
		super();
		this.legs = legs;
		this.size= size;
		this.age =age;
		this.hasFur = hasFur;
	}

	//Getters and Setters for Encapsulation
	public int getLegs() {
		return legs;
	}
	public void setLegs(int legs) {
		if(legs>-1)
			this.legs = legs;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		if(size>0)
			this.size = size;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age>-1)
			this.age = age;
	}
	public boolean isHasFur() {
		return hasFur;
	}
	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}
	public boolean isAquatic() {
		return aquatic;
	}
	public void setAquatic(boolean aquatic) {
		this.aquatic = aquatic;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (aquatic ? 1231 : 1237);
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
		if (age != other.age)
			return false;
		if (aquatic != other.aquatic)
			return false;
		if (hasFur != other.hasFur)
			return false;
		if (legs != other.legs)
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	
	

}
