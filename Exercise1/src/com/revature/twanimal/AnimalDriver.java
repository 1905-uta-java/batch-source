package com.revature.twanimal;

public class AnimalDriver {
	
	public static void main(String[] args) {
		// Polymorphism, b1 is a bear but is being used as an Animal
		Animal b1 = new PolarBear();
		Bear b2 = new PolarBear();
		Wolf w1 = new Wolf();
		
		b1.makeNoise();
		
		System.out.println("b2 Hunger: " + b2.getHunger());
		b2.searchForFood();
		System.out.println("b2 Hunger: " + b2.getHunger());
		
		w1.makeNoise();
	}
}
