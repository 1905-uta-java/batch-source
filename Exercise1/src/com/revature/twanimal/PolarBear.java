package com.revature.twanimal;

// Inheritance, PolarBear inherits methods from Bear
public class PolarBear extends Bear {

	public PolarBear() {
		setFurColor("White");
	}
	@Override
	public void findHome() {
		// TODO Auto-generated method stub
		System.out.println("Lied down where it was.");
	}

	@Override
	public void searchForFood() {
		System.out.println("Found fish");
		setHunger(getHunger()-30);
	}
}
