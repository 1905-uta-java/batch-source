package com.revature.twanimal;

// Inheritance, PolarBear inherits methods from Bear
public class PolarBear extends Bear {

	// Polar Bear's fur color is clear, and is set as such when created.
	public PolarBear() {
		setFurColor("Clear");
	}
	
	// Polar Bear's home is wherever it is currently.
	@Override
	public void findHome() {
		System.out.println("Lied down where it was.");
	}

	// Polar bear searches for fish specifically, not berries.
	@Override
	public void searchForFood() {
		System.out.println("Found fish");
		setHunger(getHunger()-30);
	}
}
