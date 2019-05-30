package com.revature.twanimal;

public class AnimalDriver {
	
	public static void main(String[] args) {
		// Polymorphism, b1 is a bear but is being used as an Animal
		Animal b1 = new PolarBear();
		// b2 is a PolarBear instance, but is referenced as a Bear
		Bear b2 = new PolarBear();
		// b3 is a BrownBear instance, but is referenced as a Bear
		Bear b3 = new BrownBear();
		// w1 is a Wolf instance and is referenced as such.
		Wolf w1 = new Wolf();
		
		// b1 will make a Bear noise even though it is referenced as an Animal
		b1.makeNoise();
		
		// b2 is referenced as a Bear, so it has a getHunger method.
		// Animal does not have this method so b1 could not use it.
		System.out.println("b2 Hunger: " + b2.getHunger());
		b2.searchForFood();
		System.out.println("b2 Hunger: " + b2.getHunger());
		
		// b3 will use Bear's implementation of searchForFood, unlike b2
		// because b3 does not override searchForFood, while b2 does.
		b3.searchForFood();
		
		w1.makeNoise();
	}
}
