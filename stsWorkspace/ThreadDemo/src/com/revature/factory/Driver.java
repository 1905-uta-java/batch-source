package com.revature.factory;

public class Driver {
	public static void main(String[] args) {
		
		AnimalFactory af = new AnimalFactory();
		Animal a1 = af.getAnimal("Cow");
		Animal a2 = af.getAnimal("Squirrel");
		Animal a3 = af.getAnimal("Pidgeon");
		Animal a4 = af.getAnimal("pidgeon");
		Animal a5 = af.getAnimal("cow");
		
		a1.makeNoise();
		a5.makeNoise();
		a4.makeNoise();
		a3.makeNoise();
		a2.makeNoise();
	}
}
