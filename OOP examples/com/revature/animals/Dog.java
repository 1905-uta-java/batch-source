package com.revature.animals;

/*
 * @author 			Allen Rankin
 * @description		Creates a dog subclass from the WarmBlood superclass 
 * */

public class Dog extends WarmBlood{
	
	// Example of encapsulation 
	// We made the variables themselves private so they can only be accessed
	// through a getter and changed through a setter. 
	private String playing;
	private String eat;
	private int timeSlept;
	private boolean awake;
	
	/*
	 * Returns the value set for the variable playing
	 * */
	public String getPlaying() {
		return playing;
	}

	/*
	 * Sets a value for the variable playing
	 * @params playing 	the value of this will set the playing value for the object
	 * */
	public void setPlaying(String playing) {
		this.playing = playing;
	}

	/*
	 * Returns the value set for the variable eat
	 * */
	public String getEat() {
		return eat;
	}

	/*
	 * Sets a value for the variable eat 
	 * @params eat 	the value of this will set the eat value for the object
	 * */
	public void setEat(String eat) {
		this.eat = eat;
	}
	
	
	/*
	 * Returns the time the dog has slept
	 * 
	 * @return timeSlept - time dog has slept
	 * 
	 * */
	public int getTimeSlept() {
		return this.timeSlept;
	}
	
	
	/*
	 * Sets the amount of time the dog has slept
	 * 
	 * @param timeSlept - time dog has slept
	 * 
	 * */
	public void setTimeSlept(int timeSlept) {
		this.timeSlept = timeSlept;
	}
	
	
	/*
	 * Returns dog's state of consciousness, awake or asleep
	 * 
	 * @return awake - is the dog awake or asleep
	 * 
	 * */
	public boolean getAwake() {
		return this.awake;
	}
	
	
	/*
	 * Sets dog's state of consciousness, awake or asleep, true or false
	 * 
	 * @param awake - is the dog awake or asleep
	 * 
	 * */
	public void setAwake(boolean awake) {
		this.awake = awake;
	}


	
	// Example of Polymorphism and method overriding
	// We're overriding the default methods so we can change how they operate
	
	/*
	 * Overrides the default object toString method, adds in the toString method from the super class
	 * Some abstraction here. We won't need to list out every detail Dog has, some is in Super's toString 
	 * */
	@Override
	public String toString() {
		return "Information on Dog \r\n [playing=" + getPlaying() + ", eat=" + getEat() + ", timeSlept=" + getTimeSlept() + 
				", awake=" + getAwake() +", " + super.toString() + "]";
	}


	/*
	 * Overridden from the default hashCode object method. Now we can manipulate how the hash code is generated
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (awake ? 1231 : 1237);
		result = prime * result + ((eat == null) ? 0 : eat.hashCode());
		result = prime * result + ((playing == null) ? 0 : playing.hashCode());
		result = prime * result + timeSlept;
		return result;
	}

	

	/*
	 * Overridden from the default equals object method. Now we can manipulate how to compare this object to another
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (awake != other.awake)
			return false;
		if (eat == null) {
			if (other.eat != null)
				return false;
		} else if (!eat.equals(other.eat))
			return false;
		if (playing == null) {
			if (other.playing != null)
				return false;
		} else if (!playing.equals(other.playing))
			return false;
		if (timeSlept != other.timeSlept)
			return false;
		return true;
	}
	 
}
