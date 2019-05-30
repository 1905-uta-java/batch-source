package com.revature.oopexercise;

//Interfaces are entirely abstract
/*
 * Animal
 * 
 * Definition of Animal interface
 * 
 * Functions defined:
 * Animal::makeNoise()
 * Animal::move()
 */
public interface Animal {
	//All animals are to implement these functionalities or make
	//their children do so if abstract
		
	/*
	 * Animal::makeNoise()
	 * args: None
	 * returns: None
	 * 
	 * Intended to print appropriate animal noises to sysout
	 */
	public void makeNoise();
	
	/*
	 * Animal::move()
	 * args: None
	 * returns: None
	 * 
	 * Intended to print details of animal movement to sysout
	 */
	public void move();
	
}
