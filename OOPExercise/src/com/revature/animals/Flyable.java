package com.revature.animals;

/**
 * The Flyable interface uses abstraction to allow multiple
 * kinds of Flyable classes to be created without the need
 * for other classes using them to know anything about the
 * implementing classes
 */
public interface Flyable {
	void Fly();
	void Land();
}
