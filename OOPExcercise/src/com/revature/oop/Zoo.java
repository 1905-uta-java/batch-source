// Name: Benjamin Onwenu

package com.revature.oop;

public class Zoo {

	public static void main(String[] args) {
		
		
		// Polymorphism/Covarience
		// I am able to refer to BorderCollie as an instance of a Dog
		Dog dog = new BorderCollie();
		BorderCollie bc1 = new BorderCollie();
		BorderCollie bc2 = new BorderCollie();
		
		dog.eats();
		System.out.println();
		bc1.displayName();
		bc1.eats();				// Inherits eat, greet, and reproduce methods
		bc1.greets();
		bc1.reproduce();
		
		// Polymorphism/ Covarience
		// I am able to refer to Brant as an instance of a Duck
		Duck duck = new Brant();
		Brant brant1 = new Brant();
		Brant brant2 = new Brant();
		
		System.out.println();
		brant1.displayName();
		brant1.eats();			// Inherits eat, greet, and reproduce methods
		brant1.greets();
		brant1.reproduce();
		
		bc2.setNumOfLegs(10);
		System.out.println("\nbc1 is equal to bc2.\n" +bc1.equals(bc2));
		System.out.println("bc1 hashcode: " + bc1.hashCode());
		System.out.println("bc2 hashcode: " + bc1.hashCode());
		
		System.out.println("\nbrant1 is equal to brant2.\n" +brant1.equals(brant2));
		System.out.println("brant1 hashcode: " + brant1.hashCode());
		System.out.println("brant2 hashcode: " + brant2.hashCode());
		
		

	}

}
