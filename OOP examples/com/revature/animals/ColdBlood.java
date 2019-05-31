package com.revature.animals;

/*
 * 
 * @author 			Allen Rankin
 * @description 	Super class for a cold blooded animal
 * 
 * */

public class ColdBlood implements AnimalInterface {
	
	// Example of encapsulation 
	// We made the variables themselves private so they can only be accessed
	// through a getter and changed through a setter. 
	private int bloodTemp;
	private int numLegs;  
	private int age;
	private boolean alive;
	private String sciName;
	
	/*
	 * Empty constructor
	 * 
	 * */
	public ColdBlood() {
		super();
	}
	
	
	/*
	 * Constructor for a cold blooded animal
	 * 
	 * @params	bloodTemp - the temperature of animal's blood
	 * 			numLegs - number of legs
	 * 			age - age of animal
	 * 			alive - is the animal alive or not
	 * 			sciName - scientific name of animal
	 * 
	 * */
	public ColdBlood(int bloodTemp, int numLegs, int age, boolean alive, String sciName) {
		this.bloodTemp = bloodTemp;
		this.numLegs = numLegs;
		this.age = age;
		this.alive = alive;
		this.sciName = sciName;
	}
	
	
	/*
	 * Returns the temperature of animal's blood
	 * 
	 * @return bloodTemp - the temperature of animal's blood
	 * */
	public int getBloodTemp() {
		return bloodTemp;
	}
	
	
	/* 
	 * Sets the bloodTemp of animal
	 * 
	 * @param bloodTemp - the temperature of animal's blood
	 * 
	 * */
	public void setBloodTemp(int bloodTemp) {
		this.bloodTemp = bloodTemp;
	}
	
	
	/*
	 * Returns the number of legs animal has
	 * 
	 * @return numLegs - the number of legs animal has
	 * 
	 * */
	public int getNumLegs() { 
		return this.numLegs; 
	}
	
	
	/*
	 * Sets the number of legs animal has
	 * 
	 * @param numLegs - the number of legs animal has
	 * 
	 * */
	public void setNumLegs(int numLegs) { 
		this.numLegs = numLegs; 
	}
	
	
	/*
	 * Returns the age of the animal
	 * 
	 * @return age - age of the animal
	 * 
	 * */
	public int getAge() {
		return this.age;
	}
	
	
	/*
	 * Sets animal's age
	 * 
	 * @param age - age of the animal
	 * 
	 * */
	public void setAge(int age) {
		this.age = age;
	}
	
	
	/*
	 * Returns life status of animal
	 * 
	 * @return alive - is the animal alive or not?
	 * 
	 * */
	public boolean getAlive() {
		return this.alive;
	}
	
	
	/*
	 * Sets life status of animal
	 * 
	 * @param alive - is the animal alive or not?
	 * 
	 * */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	
	/*
	 * Returns scientific name of animal
	 * 
	 * @return sciName - scientific name of animal
	 * 
	 * */
	public String getSciName() {
		return this.sciName; 
	}
	
	
	/*
	 * Sets scientific name of animal
	 * 
	 * @param sciName - scientific name of animal
	 * 
	 * */
	public void setSciName(String sciName) { 
		this.sciName = sciName; 
	}
	
	
	/*
	 * Override, displays the current copyright information about cold-blooded animals
	 * 
	 * */
	@Override
	public void copyright() {
		System.out.println("While warm-blooded animals probably can't legally own a copyright unless they're human,"+
							" cold-blooded animals might be able to...though I'm not entirely sure");
	}

	
	/*
	 * Override default toString with our own, makes it look nicer when displayed through subclasses 
	 * 
	 * */
	@Override
	public String toString() {
		return "bloodTemp=" + getBloodTemp() + ", numLegs=" + getNumLegs() + ", age=" + getAge() + 
				", alive=" + getAlive() + ", sciName=" + getSciName();
	}

	
	/*
	 * Override default hashCode so we can manipulate our own hash
	 * 
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (alive ? 1231 : 1237);
		result = prime * result + bloodTemp;
		result = prime * result + numLegs;
		result = prime * result + ((sciName == null) ? 0 : sciName.hashCode());
		return result;
	}

	
	/*
	 * Override default equals so we can manually check if two objects are equal
	 * 
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColdBlood other = (ColdBlood) obj;
		if (age != other.age)
			return false;
		if (alive != other.alive)
			return false;
		if (bloodTemp != other.bloodTemp)
			return false;
		if (numLegs != other.numLegs)
			return false;
		if (sciName == null) {
			if (other.sciName != null)
				return false;
		} else if (!sciName.equals(other.sciName))
			return false;
		return true;
	}
}
