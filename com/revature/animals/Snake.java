package com.revature.animals;

/*
 * 
 * @author			Allen Rankin
 * @description 	Snake is a cold-blooded animal (subclass of ColdBlood)
 * 
 * */

public class Snake extends ColdBlood {
	
	// Example of encapsulation 
	// We made the variables themselves private so they can only be accessed
	// through a getter and changed through a setter. 
	private int numScales;
	private int fangLength;
	private boolean shedding;
	private String slither;
	
	
	/*
	 * Returns the number of scales the snake has
	 * 
	 * @return numScales - number of scales on snake
	 * 
	 * */
	public int getNumScales() {
		return this.numScales;
	}
	
	
	/*
	 * Sets the number of scales on the snake
	 * 
	 * @param numScales - number of scales on snake
	 * 
	 * */
	public void setNumScales(int numScales) {
		this.numScales = numScales;
	}
	
	
	/*
	 * Returns the length of the snake's fangs
	 * 
	 * @return fangLength - length of snake's fangs
	 * 
	 * */
	public int getFangLength() {
		return this.fangLength;
	}
	
	
	/*
	 * Sets the length of the snake's fangs
	 * 
	 * @param fangLength - length of snake's fangs
	 * 
	 * */
	public void setFangLength(int fangLength) {
		this.fangLength = fangLength;
	}
	
	
	/*
	 * Returns the state of the snake, shedding or not
	 * 
	 *  @return shedding - is the snake shedding or not
	 *  
	 * */
	public boolean getShedding() {
		return this.shedding;
	}
	
	
	/*
	 * Sets the snakes shedding state, shedding or not
	 * 
	 * @param shedding - is the snake shedding or not
	 * 
	 * */
	public void setShedding(boolean shedding) {
		this.shedding = shedding;
	}

	
	/*
	 * Returns the snake's sliter noise
	 * 
	 * @return slither - snake's slither noise
	 * 
	 * */
	public String getSlither() {
		return this.slither;
	}
	
	
	/*
	 * Set's the snake's slither noise
	 * 
	 * @param slither - noise snake makes when moving
	 * 
	 * */
	public void setSlither(String slither) {
		this.slither = slither;
	}
	
	
	
	// Example of Polymorphism and method overriding
	// We're overriding the default methods so we can change how they operate
	
	/*
	 * Override default toString so we can make it our own
	 * 
	 * */
	@Override
	public String toString() {
		return "Information on Snake \r\n [numScales=" + getNumScales() + ", fangLength=" + getFangLength() + 
				", shedding=" + getShedding()+ ", slither="+ getSlither() + ", " + super.toString() + "]\r\n";
	}


	/*
	 * Override default hashCode to manually manipulate the hash
	 * 
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + fangLength;
		result = prime * result + numScales;
		result = prime * result + (shedding ? 1231 : 1237);
		result = prime * result + ((slither == null) ? 0 : slither.hashCode());
		return result;
	}

	/*
	 * Override the default equals to set our own properties to test if an object is the same as Starfish
	 * 
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Snake other = (Snake) obj;
		if (fangLength != other.fangLength)
			return false;
		if (numScales != other.numScales)
			return false;
		if (shedding != other.shedding)
			return false;
		if (slither == null) {
			if (other.slither != null)
				return false;
		} else if (!slither.equals(other.slither))
			return false;
		return true;
	}
	
}
