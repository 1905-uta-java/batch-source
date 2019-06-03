package com.revature.oop;

public class FelidaeDriver {

	public static void main(String[] args) {
		//Initialize a Cat object and a SphynxCat object
		Cat cat1 = new Cat(true, 11, "Meow.");
		Cat cat2 = new Cat(false, 4, "...");
		
		System.out.println(cat1.toString());
		System.out.println(cat2.toString());
		
		//Prints false as they are not equal in their attributes
		System.out.println(cat1.equals(cat2));
		
		cat2.setCall(cat1.getCall());
		cat2.setHasFur(cat1.hasFur());
		cat2.setNumWhiskers(cat1.getNumWhiskers());
		
		//Prints true as Cats are equal in attributes
		System.out.println(cat1.equals(cat2));
		
		//Since SphynxCat is a child of Cat, Cat can be initialized as a SphynxCat
		Cat cat3 = new SphynxCat("Meow.", "Jingles.");
		
		//However any methods that share the same signature between the two classes will result in the child's being utilized first
		//since cat3 is a SphynxCat
		System.out.println(cat3.toString());
		
		//Liger implements both Lions and Tigers that extend the interface Felidae
		Liger liger = new Liger(true, 10, "Fierce and Ferocious RAWR!");
		
		System.out.println(liger.getSpecies());
		System.out.println(liger.toString());
		

	}

}
