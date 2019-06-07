package com.revature.animals;
// this is an example of an abstraction
public interface Live {
	static void breathe() {
		System.out.println("the animal breathes with lungs for now since all are mammals");
	};
	static void move() {
		System.out.println("the animal moves");
	};
}
