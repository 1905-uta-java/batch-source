package com.revature.animals;

public class Deer extends Animal implements Live {
	int legs = 4;
	boolean hasTail = true;
	boolean isNocturnal = false;
	int weightInPounds = 230;
	
	public Deer(int legs, boolean hasTail, boolean isNocturnal, int weightInPounds, int health) {
		super(legs, hasTail, isNocturnal, weightInPounds, health);
		// TODO Auto-generated constructor stub
	}
	
}
