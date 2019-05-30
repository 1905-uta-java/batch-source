package com.revature.exercise1;

public class Driver {

	public static void main(String[] args) {
		
		// Instantiating Wolf
		Wolf wolf = new Wolf();
		
		// Setting Wolf - Using setters to modify variables (Encapsulation)
		// - Setting uses methods from the Animal class (Inheritance)
		wolf.setLegs(4);
		wolf.setHasFur(true);
		wolf.setSize(100);
		wolf.setNumOfWhiskers(15);
		
		// Printing Wolf
		// - The hunt() and eatMeat() methods are from the Carnivore Interface (Abstraction)
		System.out.println(wolf);
		wolf.furColor("Brown", "black"); // Method Overloading in Wolf Class (Compile-Time Polymorphism)
		wolf.eatMeat();
		wolf.hunt();
		wolf.howl();
		System.out.println();
		
		
		
		// Instantiating Hippo
		Hippo hippo = new Hippo();
		
		// Setting Hippo - Using setters to modify variables (Encapsulation)
		// - Setting uses methods from the Animal class (Inheritance)
		hippo.setLegs(4);
		hippo.setHasFur(false);
		hippo.setSize(3000);
		hippo.setSkin(true);
		
		// Printing Hippo
		// - The search() method is from the Herbivore Interface (Abstraction)
		System.out.println(hippo);
		hippo.eatPlants();
		hippo.search();
		hippo.swim();
		System.out.println();
		
		
		
		// Instantiating Tiger
		Tiger tiger = new Tiger();
		
		//Setting Tiger - Using setters to modify variables (Encapsulation)
		// - Setting uses methods from the Animal class (Inheritance)
		tiger.setLegs(4);
		tiger.setHasFur(true);
		tiger.setSize(300);
		tiger.setNumOfStripes(120);
		
		// Printing Tiger
		// - The hunt() and eatMeat() methods are from the Carnivore Interface (Abstraction)
		System.out.println(tiger);
		tiger.eatMeat();
		tiger.hunt();
		tiger.roar();
	}



}
