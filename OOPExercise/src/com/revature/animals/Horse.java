package com.revature.animals;

/**
 * Horse adds the field runSpeed on top of the inherited fields and behaviors
 * from Animal and Mammal. It also overrides the move and eat methods of Animal
 * and implements the rideTo method of Rideable, which allows Horses can be 
 * referenced as Animals, Mammals, or Rideable objects through covariance
 */
public class Horse extends Mammal implements Rideable {
	
	private int runSpeed;
	
	/**
	 * The Horse class uses method overloading to provide
	 * a no-argument constructor
	 */
	public Horse() {
		this("", 0, 0, 20);
	}
	
	public Horse(String name, int age, int furLength, int runSpeed) {
		super(name, age, 4, furLength);
		
		this.runSpeed = runSpeed;
	}
	
	public int getRunSpeed() {
		return runSpeed;
	}
	
	public void setRunSpeed(int runSpeed) {
		if(runSpeed > 0)
			this.runSpeed = runSpeed;
	}

	@Override
	public void RideTo(String destination) {
		System.out.println(getName() + " carries you along the road to " + destination + ".");
	}
	
	@Override
	public void move() {
		System.out.println(getName() + " trots around.");
	}
	
	@Override
	public void eat() {
		System.out.println(getName() + " chomps an apple.");
	}

	@Override
	public String toString() {
		return "Horse [ name = " + getName() + ", age = " + getAge() + ", numLegs = " + getNumLegs() 
				+ ", furLength = " + getFurLength() + ", runSpeed = " + runSpeed + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + runSpeed;
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
		Horse other = (Horse) obj;
		if (runSpeed != other.runSpeed)
			return false;
		return true;
	}
}
