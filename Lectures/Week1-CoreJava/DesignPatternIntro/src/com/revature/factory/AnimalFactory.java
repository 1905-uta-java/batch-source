package com.revature.factory;

public class AnimalFactory {
	
	public Animal getAnimal(String name) {
		if("cow".equals(name)) {
			return new Cow();
		} else if ("pigeon".equals(name)) {
			return new Pigeon();
		} else if ("squirrel".equals(name)) {
			return new Squirrel();
		}
		return null;
	}

}
