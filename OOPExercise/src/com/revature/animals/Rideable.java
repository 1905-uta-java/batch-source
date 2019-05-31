package com.revature.animals;

/**
 * The Rideable interface uses abstraction to allow multiple
 * kinds of Rideable classes to be created without the need
 * for the riders to know anything about the implementing classes
 */
public interface Rideable {
	void RideTo(String destination);
}
