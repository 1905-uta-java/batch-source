package com.revature.models;

//Class inherits the Animal class
public class Walleye extends Animal{

	//Private variables for encapsulation
	private String preferredBait;

	//Default constructor
	public Walleye() {
		super();
	}
	
	//Constructor to initialize all variables of Walleye
	public Walleye(String preferredBait, int eyes, int legs, int speed) {
		super(eyes,legs,true, speed);
		this.preferredBait = preferredBait;
	}
	
	//Provide more information for the speed of the fish
	@Override
	public void AnimalMovement() {
		System.out.println("The fish can swim at a rate of "+this.getSpeed());
		
	}

	//Overriding original Animal toString to provide more information
	@Override
	public String toString() {
		return "Walleye [Preferred Bait=" + preferredBait + ", Eyes=" + getEyes() + ", Legs=" + getLegs()
				+ ", Aquatic=" + isAquatic() + ", Speed=" + getSpeed() + "]";
	}

	//Getter for preferredBait
	public String getPreferredBait() {
		return preferredBait;
	}

	//Setter for preferredBait
	public void setPreferredBait(String preferredBait) {
		this.preferredBait = preferredBait;
	}

	//Provides the hash of the object
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((preferredBait == null) ? 0 : preferredBait.hashCode());
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
		Walleye other = (Walleye) obj;
		if (preferredBait == null) {
			if (other.preferredBait != null)
				return false;
		} else if (!preferredBait.equals(other.preferredBait))
			return false;
		return true;
	}
	
	

}
