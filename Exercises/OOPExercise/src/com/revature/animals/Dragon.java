package com.revature.animals;

/**
 * Dragon adds the isTerrifying field on top of the inherited fields and behaviors
 * from Animal and Reptile. It also overrides the move and eat methods of Animal and 
 * the findWarmth method of Reptile and it implements the rideTo, fly, and land methods
 * of the Rideable and Flyable interfaces, which allow Dragons to be referenced as Flyable
 * and Ridable objects or as Animals or Reptiles through covariance
 */
public class Dragon extends Reptile implements Flyable, Rideable {
	
	private boolean isTerrifying;
	
	/**
	 * The Dragon class uses method overloading to provide
	 * a no-argument constructor
	 */
	public Dragon() {
		this("", 0, "Brown", true);
	}
	
	public Dragon(String name, int age, String scaleColor, boolean isTerrifying) {
		super(name, age, 4, scaleColor);
		this.isTerrifying = isTerrifying;
	}
	
	public boolean isTerrifying() {
		return isTerrifying;
	}

	public void setTerrifying(boolean isTerrifying) {
		this.isTerrifying = isTerrifying;
	}
	
	@Override
	public void RideTo(String destination) {
		
		System.out.println(getName() + " flies you through the air to " + destination + ".");
	}
	
	@Override
	public void Fly() {
		System.out.println(getName() + " flaps its great wings and lifts into the air.");
	}
	
	@Override
	public void Land() {
		System.out.println(getName() + " lands with a mighty thud.");
	}
	
	@Override
	public void move() {
		System.out.println(getName() + " flies through the sky.");
	}
	
	@Override
	public void eat() {
		System.out.println(getName() + " devoures some livestock.");
	}
	
	@Override
	public void findWarmth() {
		System.out.println(getName() + " burns a village down for warmth.");
	}
	
	@Override
	public String toString() {
		return "Dragon [ name = " + getName() + ", age = " + getAge()
				+ ", numLegs = " + getNumLegs() + ", scaleColor = " + getScaleColor() + ", isTerrifying = " + isTerrifying + " ]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isTerrifying ? 1231 : 1237);
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
		Dragon other = (Dragon) obj;
		if (isTerrifying != other.isTerrifying)
			return false;
		return true;
	}
}
