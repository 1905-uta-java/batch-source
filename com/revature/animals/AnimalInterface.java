package com.revature.animals;

/*
 * 
 * @author			Allen Rankin
 * @description 	Interface for any type of animal - currently cold or warm blooded animals
 * 
 * */

public interface AnimalInterface {
	
	/*
	 * Can an animal obtain copyright? It is explained here
	 * */
	void copyright();
	
	/*
	 * General animal information
	 * */
	default void information() {
		System.out.println("An animal is a biological organism ");
	}
}
