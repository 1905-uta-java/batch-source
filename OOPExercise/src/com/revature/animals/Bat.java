package com.revature.animals;

/**
 * Bat adds the field isFrugivore on top of the inherited fields and behaviors
 * from Animal and Mammal. It also overrides the move and eat methods of Animal
 * and implements the fly and land methods in the Flyable interface, which allows
 * it to be referenced as an Animal, Mammal, or Flyable object through covariance
 */
public class Bat extends Mammal implements Flyable {
	
	private boolean isFrugivore;
	
	/**
	 * The Bat class uses method overloading to provide
	 * a no-argument constructor
	 */
	public Bat() {
		this("", 0, 0, true);
	}
	
	public Bat(String name, int age, int furLength, boolean isFrugivore) {
		
		super(name, age, 2, furLength);
		
		this.isFrugivore = isFrugivore;
	}
	
	public boolean isFrugivore() {
		return isFrugivore;
	}
	
	public void setFrugivore(boolean isFrugivore) {
		this.isFrugivore = isFrugivore;
	}
	
	@Override
	public void Fly() {
		System.out.println(getName() + " flaps up into the night sky.");
	}
	
	@Override
	public void Land() {
		System.out.println(getName() + " gently lands on the ground.");
	}
	
	@Override
	public void move() {
		System.out.println(getName() + " flies around quietly.");
	}
	
	@Override
	public void eat() {
		if(isFrugivore)
			System.out.println(getName() + " nibbles on some fruit.");
		else
			System.out.println(getName() + " eats some insects, probably.");
	}

	@Override
	public String toString() {
		return "Bat [ name = " + getName() + ", age = " + getAge() + ", numLegs = " + getNumLegs()
				+ ", furLength = " + getFurLength() + ", isFrugivore = " + isFrugivore + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isFrugivore ? 1231 : 1237);
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
		Bat other = (Bat) obj;
		if (isFrugivore != other.isFrugivore)
			return false;
		return true;
	}
}
