package com.revature.pillars;

// An interface to be used by animals that move across the ground
/*
 * All animals move but not all animals move in the same way, so having an abstract method in Animal
 * isn't going to be specific enough to match that. So having interfaces that Animal subclasses can
 * use to cater to how they move is required. This is another use of Abstraction.
 */
public interface CanMove {
	// The movement method to be overridden by the terestial animal
	public void move();
	
	// This is an Overload of the move method to include a distance for the animal to fly. This is an example of Polymorphism.
	public void move(int dist);
}
