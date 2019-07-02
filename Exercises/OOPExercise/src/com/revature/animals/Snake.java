package com.revature.animals;

/**
 * Snake adds the isPoisonous field on top of the inherited fields and behaviors
 * from Animal and Reptile. It also overrides the move and eat methods of Animal
 */
public class Snake extends Reptile {
	
	private boolean isPoisonous;
	
	/**
	 * The Snake class uses method overloading to provide
	 * a no-argument constructor
	 */
	public Snake() {
		this("", 0, "Red", false);
	}
	
	public Snake(String name, int age, String scaleColor, boolean isPoisonous) {
		super(name, age, 0, scaleColor);
		this.isPoisonous = isPoisonous;
	}
	
	public boolean isPoisonous() {
		return isPoisonous;
	}
	
	public void setPoisonous(boolean isPoisonous) {
		this.isPoisonous = isPoisonous;
	}
	
	@Override
	public void move() {
		System.out.println(getName() + " slithers accross the ground.");
	}
	
	@Override
	public void eat() {
		System.out.println(getName() + " swallows a mouse whole.");
	}
	
	@Override
	public String toString() {
		return "Snake [ name = " + getName()
				+ ", age = " + getAge() + ", numLegs = " + getNumLegs() + ", scaleColor = " + getScaleColor() + ", isPoisonous = " + isPoisonous + " ]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isPoisonous ? 1231 : 1237);
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
		Snake other = (Snake) obj;
		if (isPoisonous != other.isPoisonous)
			return false;
		return true;
	}
}
