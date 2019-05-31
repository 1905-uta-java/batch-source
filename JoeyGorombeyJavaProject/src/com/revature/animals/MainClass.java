package com.revature.animals;

public class MainClass 
{

	// Hawk, Pidgeon, and Wolf all inherit the move(), eat(), and sleep() methods defined in the abstract Animal class. 
	// Because of this, all three classes are free to use the eat(), sleep(), and move() methods, and implement them in their respective ways.
	// Additionally, these method overrides apply to interfaces as well.
	// Both Hawk and Wolf implement the Predatory interface while retaining unique implementations of bringPreyHome() and 
	public static void main(String[] args)
	{
		// Because of the Predatory interface, Hawk has access to methods defined in that interface.
		// These include bringPreyHome(), track(), and chase().
		Hawk h1 = new Hawk();
		h1.move();
		h1.eat();
		h1.sleep();
		h1.bringPreyHome();
		h1.track();
		h1.chase();
		
		// Because of the Domesticatable interface, Pidgeon has access to all methods defined in that interface.
		// These include feed() and train(). 
		Pidgeon p1 = new Pidgeon();
		p1.move();
		p1.eat();
		p1.sleep();
		p1.feed();
		p1.train();
		
		// The Wolf class implements both the Domesticatable and Predatory interfaces.
		// Because of this, it has access to the relevant methods from both interfaces.
		Wolf w1 = new Wolf();
		w1.move();
		w1.eat();
		w1.sleep();
		w1.feed();
		w1.train();
		w1.track();
		w1.chase();
		
	}

}
