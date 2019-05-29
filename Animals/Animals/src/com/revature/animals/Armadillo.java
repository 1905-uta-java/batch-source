package com.revature.animals;

public class Armadillo extends Animal implements Live {
	int legs = 4;
	boolean hasTail = true;
	boolean isNocturnal = true;
	int weightInPounds = 15;
	
	
	public Armadillo(int legs, boolean hasTail, boolean isNocturnal, int weightInPounds, int health) {
		super(legs, hasTail, isNocturnal, weightInPounds, health);
		// TODO Auto-generated constructor stub
	}

}
