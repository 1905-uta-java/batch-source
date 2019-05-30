package com.revature.pillarsoop;

public class Driver {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.setLegs(4);
		dog.setAquatic(false);
		dog.setSize(6);
		dog.setAge(5);
		dog.setHasFur(true);
		dog.setTailLength(2);
		
		
		System.out.println(dog);
		dog.bark();
		
		System.out.println();
		System.out.println();
		
		//Covariance
		Animals a = new Fish();
		
		a.setAquatic(true);
		//Runtime Polymorphism
		System.out.println(a.toString());
		
		System.out.println();
		System.out.println();
		
		Bird b = new Bird();
		System.out.println(b);
		
		
	}
}
