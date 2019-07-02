package com.revature.animals;

/**
 * Mammal adds the furLength field the trimFur behavior on top of the inherited
 * fields and behaviors from Animal
 */
public abstract class Mammal extends Animal {
	
	private int furLength;
	
	public Mammal() {
		this("", 0, 4, 0);
	}
	
	public Mammal(String name, int age, int numLegs, int furLength) {
		super(name, age, numLegs);
		this.furLength = furLength;
	}
	
	public int getFurLength() {
		return furLength;
	}
	
	public void growFur() {
		furLength += 3;
	}
	
	public void trimFur(int trimLength) {
		
		// if the fur length specified is negative, let the user know. They probably didn't mean to do that
		// if the fur length specified is below the current fur length, don't do anything
		if(trimLength < 0)
			System.out.println("You can't trim " + this.getName() +"'s fur below 0");
		else if(furLength >= trimLength)
			furLength = trimLength;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + furLength;
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
		Mammal other = (Mammal) obj;
		if (furLength != other.furLength)
			return false;
		return true;
	}
}
