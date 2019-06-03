package com.revature.oop;

public interface Lions extends Felidae{
	//Attributes that are declared in interfaces are implicitly public, static, and final
	String SPECIES = "Lion";
	String CALL = "Fierce RAWR";
	
	//methods
	//an implementation of getSpecies from interface Felidae
	public default String getSpecies() {
		return SPECIES;
	}
}
