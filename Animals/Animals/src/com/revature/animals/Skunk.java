package com.revature.animals;

public class Skunk extends Animal implements Live {
	int legs = 4;
	boolean hasTail = true;
	boolean isNocturnal = false;
	int weightInPounds = 13;
	
	public Skunk(int legs, boolean hasTail, boolean isNocturnal, int weightInPounds, int health) {
		super(legs, hasTail, isNocturnal, weightInPounds, health);
		// TODO Auto-generated constructor stub
	}

}
