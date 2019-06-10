package com.revature.factory;

public class AnimalFactory {
	
	public AnimalFactory() {
		
	}
	
	public Animal getAnimal(String name) {
		if(name.equalsIgnoreCase("cow")) {
			return new Cow();
		} else if(name.equalsIgnoreCase("squirrel")) {
			return new Squirrel();
		} else if (name.equalsIgnoreCase("pidgeon")) {
			return new Pidgeon();
		}
		return null;
	}
	
	
}
