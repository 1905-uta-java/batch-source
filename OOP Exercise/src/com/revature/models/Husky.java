package com.revature.models;

//Class inherits the Animal class
public class Husky extends Animal{
	
	//Private variables for encapsulation
	private String coat;
	private String bark;
	
	//Default constructor
	public Husky() {
		super();
	}
	
	//Constructor for initializing Husky Variables
	public Husky(String coat,String bark, int eyes, int legs, int speed, boolean isAquatic) {
		super(eyes,legs,isAquatic, speed);
		this.coat = coat;
		this.bark = bark;
	}
	
	//Provides information for animal movement
	@Override
	public void AnimalMovement() {
		System.out.println("The dog can run at a rate of "+this.getSpeed());
		
	}
	
	//Getter for coat
	public String getCoat() {
		return coat;
	}
	
	//Setter for coat
	public void setCoat(String coat) {
		this.coat = coat;
	}

	//Getter for bark
	public String getBark() {
		return bark;
	}

	//Setter for bark
	public void setBark(String bark) {
		this.bark = bark;
	}

	//Override the original Animal toString to provide more information
	@Override
	public String toString() {
		return "Husky [Coat=" + coat + ", Bark=" + bark + ", Eyes=" + getEyes() + ", Legs=" + getLegs()
				+ ", Speed=" + getSpeed() + "]";
	}

	//Provides the hash of the object
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bark == null) ? 0 : bark.hashCode());
		result = prime * result + ((coat == null) ? 0 : coat.hashCode());
		return result;
	}
	
	//Checks if the object is equivalent to the provided object
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Husky other = (Husky) obj;
		if (bark == null) {
			if (other.bark != null)
				return false;
		} else if (!bark.equals(other.bark))
			return false;
		if (coat == null) {
			if (other.coat != null)
				return false;
		} else if (!coat.equals(other.coat))
			return false;
		return true;
	}
	
	

}
