package com.revature.pillarsoop;
//Abstraction methods
public interface Interface {
	
	
	default void dogBarks() {
		System.out.println("WOOF");
	}
	
	default void birdChirps() {
		System.out.println("CHIRP CHIRP");
	}
	
	default void fishSwims() {
		System.out.println("Keep on Swimming");
	}
		
	

}
