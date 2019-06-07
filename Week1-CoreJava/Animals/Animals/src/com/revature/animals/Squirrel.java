package com.revature.animals;

public class Squirrel extends Animal implements Live {
	int legs = 4;
	boolean hasTail = true;
	boolean isNocturnal = false;
	int weightInPounds = 7;

	public Squirrel(int legs, boolean hasTail, boolean isNocturnal, int weightInPounds, int health) {
		super(legs, hasTail, isNocturnal, weightInPounds, health);
		// TODO Auto-generated constructor stub
	}
	
}
