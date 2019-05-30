package com.revature.pillars;

public class Driver {

	public static void main(String[] args) {
		// Create two of each Animal subclass
		Orangutan ora1 = new Orangutan(4, 195);
		Orangutan ora2 = new Orangutan(5, 220);
		Pidgeon pidge1 = new Pidgeon("White", 1);
		Pidgeon pidge2 = new Pidgeon("Grey", 1);
		Carp carp1 = new Carp(20, 21);
		Carp carp2 = new Carp(16, 13);
		
		// Orangutan 1 moves
		ora1.move();
		// Carp 2 swims
		carp2.swim();
		// Pidgeon 1 flies
		pidge1.fly();
		
		// Orangutan 2 makes some noise
		ora2.makeNoise();
		// Carp 1 makes some noise
		carp1.makeNoise();
		// Pidgeon 2 makes some noise
		pidge2.makeNoise();
		
		// Orangutan 1 moves 10ft
		ora1.move(10);
		// Carp 2 swims 20ft
		carp2.swim(20);
		// Pidgeon 1 flies 35ft
		pidge1.fly(35);
		
		// Check if the different animals 1 and 2 are the same
		System.out.println(ora1.equals(ora2));
		System.out.println(pidge1.equals(pidge2));
		System.out.println(carp1.equals(carp2));
		// Get the hashCode of each animal
		System.out.println("Orangutans");
		System.out.println(ora1.hashCode());
		System.out.println(ora2.hashCode());
		
		System.out.println("Pidgeons");
		System.out.println(pidge1.hashCode());
		System.out.println(pidge2.hashCode());
		
		System.out.println("Carp");
		System.out.println(carp1.hashCode());
		System.out.println(carp2.hashCode());
		
		// toString of each
		System.out.println(ora1.toString());
		System.out.println(ora2.toString());
		System.out.println(pidge1.toString());
		System.out.println(pidge2.toString());
		System.out.println(carp1.toString());
		System.out.println(carp2.toString());
		
		/*
		 * Covariance to make sure everything works properly. Since Carp, Pidgeon and Orangutan are all subclasses of 
		 * Animal then an animal object should be able to be initialized as one of its subclasses. This is one of the
		 * examples of Polymorphism.
		 */
		Animal[] animArr = {new Carp(30, 31), new Pidgeon("Grey and Green", 1), new Orangutan(6, 180)};
		
		for(Animal a : animArr) {
			a.setWeight(a.getWeight()+1);
			System.out.println(a.toString());
		}
	}

}
