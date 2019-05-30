package com.revature.models;

import com.revature.extraction.BirdActions;

//Class inherits the Animal class and implements the interface BirdActions
public class BlueJay extends Animal implements BirdActions{

	//Private variables to provide encapsulation
	private String chirp;
	private double wingSpan;
	
	//Default constructor
	public BlueJay() {
		super();
	}
	
	//Constructor to initialize all the variables for BlueJay
	public BlueJay(String chirp,double wingSpan, int eyes, int legs, int speed, boolean isAquatic) {
		super(eyes,legs,isAquatic, speed);
		this.chirp = chirp;
		this.wingSpan = wingSpan;
	}
	
	//Provide sound of the bird 
	@Override
	public void Chirp() {
		System.out.println("The bird makes a "+chirp+" sound.");
		
	}

	//Provides information on Birds speed of flight through interface
	@Override
	public void flight() {
		System.out.println("The bird can fly at a rate of "+this.getSpeed());
		
	}
	
	//Provides connection to flight method to describe birds movement
	@Override
	public void AnimalMovement() {
		this.flight();
		
	}

	//Override the Animal toString to contain the information for the BlueJay
	@Override
	public String toString() {
		return "BlueJay [Chirp=" + chirp + ", Wing Span=" + wingSpan + ", Eyes=" + getEyes() + ", Legs="
				+ getLegs() + ", Speed=" + getSpeed() + "]";
	}

	//Getter for chirp
	public String getChirp() {
		return chirp;
	}
	
	//Setter for chirp
	public void setChirp(String chirp) {
		this.chirp = chirp;
	}

	//Getter for wingSpan
	public double getWingSpan() {
		return wingSpan;
	}

	//Setter for wingSpan
	public void setWingSpan(double wingSpan) {
		this.wingSpan = wingSpan;
	}

	//Provides the hash of the object
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((chirp == null) ? 0 : chirp.hashCode());
		long temp;
		temp = Double.doubleToLongBits(wingSpan);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		BlueJay other = (BlueJay) obj;
		if (chirp == null) {
			if (other.chirp != null)
				return false;
		} else if (!chirp.equals(other.chirp))
			return false;
		if (Double.doubleToLongBits(wingSpan) != Double.doubleToLongBits(other.wingSpan))
			return false;
		return true;
	}
	
	

}
