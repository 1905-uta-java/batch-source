package com.revature.animals;

/**
 * Reptile adds the scaleColor field the findWarmth behavior on top of the inherited
 * fields and behaviors from Animal
 */
public abstract class Reptile extends Animal {
	
	private String scaleColor;
	
	public Reptile() {
		this("", 0, 4, "");
	}
	
	public Reptile(String name, int age, int numLegs, String scaleColor) {
		super(name, age, numLegs);
		this.scaleColor = scaleColor;
	}
	
	public String getScaleColor() {
		return scaleColor;
	}
	
	public void findWarmth() {
		System.out.println(getName() + " found a warm rock.");
	}
}
