package com.revature.oop;

public interface Tigers extends Felidae {
	//Attributes that are declared in interfaces are implicitly public, static, and final
	String SPECIES = "Tigers";
		
	//methods
	//an implementation of getSpecies from interface Felidae
	public default String getSpecies() {
		return SPECIES;
	}
}
