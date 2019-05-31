package com.revature.animals;

/*
 * 
 * @author			Allen Rankin
 * @description		Starfish is a cold-blooded animal (subclass of ColdBlood)
 *  
 * */

public class Starfish extends ColdBlood{
	
	
	// Example of encapsulation 
	// We made the variables themselves private so they can only be accessed
	// through a getter and changed through a setter. 
	private int currentDepth;
	private boolean underRock;
	private String bestFriendName;

	
	/*
	 * Returns the current depth the starfish is at
	 * 
	 * @return currentDepth - currentDepth of starfish in ocean
	 * 
	 * */
	public int getCurrentDepth() {
		return this.currentDepth;
	}
	
	
	/*
	 * Sets the current depth of starfish
	 * 
	 * @param currentDepth - currentDepth of starfish in ocean
	 * 
	 * */
	public void setCurrentDepth(int currentDepth) {
		this.currentDepth = currentDepth;
	}

	
	/*
	 * Returns the living quarters of the starfish, under rock or not?
	 * 
	 * @return underRock - is the starfish under a rock or not
	 * 
	 * */
	public boolean getUnderRock() {
		return this.underRock;
	}
	
	
	/*
	 * Sets the living quarters of the starfish
	 * 
	 * @param underRock - is the starfish under a rock or not
	 * 
	 * */
	public void setUnderRock(boolean underRock) {
		this.underRock = underRock;
	}
	
	
	/*
	 * Returns the name of starfish's best friend
	 * 
	 * @return bestFriendName - name of starfish's BFF
	 * 
	 * */
	public String getBestFriendName() {
		return this.bestFriendName;
	}
	
	
	/*
	 * Sets the name of starfish's best friend
	 * 
	 * @param bestFriendName - name of starfish's BFF
	 * 
	 * */
	public void setBestFriendName(String bestFriendName) {
		this.bestFriendName = bestFriendName;
	}
	
	
	
	// Example of Polymorphism and method overriding
	// We're overriding the default methods so we can change how they operate
	
	/*
	 * 
	 * Override default toString and make it our own
	 * 
	 * @return string to print 
	 * 
	 * */
	@Override
	public String toString() {
		return "Information on Starfish  \r\n [currentDepth=" + currentDepth + ", underRock=" + underRock + ", bestFriendName="
				+ bestFriendName + ", "+ super.toString() +" ]\r\n";
	}

	
	/*
	 * Override default hashCode to manually manipulate the hash
	 * 
	 * */
	@Override	
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + currentDepth;
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
		Starfish other = (Starfish) obj;
		if (currentDepth != other.currentDepth)
			return false;
		return true;
	}
}
