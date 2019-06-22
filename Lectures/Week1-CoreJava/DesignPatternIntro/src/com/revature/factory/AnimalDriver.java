package com.revature.factory;

public class AnimalDriver {

	public static void main(String[] args) {
		
		AnimalFactory af = new AnimalFactory();
		Animal a1 = af.getAnimal("cow");
		Animal a2 = af.getAnimal("pigeon");
		Animal a3 = af.getAnimal("squirrel");
		
		a1.makeNoise();
		a2.makeNoise();
		a3.makeNoise();

	}

}
