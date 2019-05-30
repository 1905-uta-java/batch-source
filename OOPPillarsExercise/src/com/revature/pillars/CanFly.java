package com.revature.pillars;

// An interface to be used by animals that fly in order to move
/*
 * All animals move but not all animals move in the same way, so having an abstract method in Animal
 * isn't going to be specific enough to match that. So having interfaces that Animal subclasses can
 * use to cater to how they move is required. This is another use of Abstraction.
 */
public interface CanFly {
	// The movement method to be overridden by the flying animal
	public void fly();
	
	// This is an Overload of the fly method to include a distance for the animal to fly. This is an example of Polymorphism.
	public void fly(int dist);
}
