package oop.models;

import oop.abstraction.AnimalInterface;

class Animal implements AnimalInterface {

	private int numberOfLegs;
	private String typicalSize;

	public Animal() {
		super();
	}

	public Animal(int numberOfLegs, String typicalSize) {
		super();
		this.numberOfLegs = numberOfLegs;
		this.typicalSize = typicalSize;
	}

	public int numberOfLegs() {
		return this.numberOfLegs;
	}

	public void setNumberOfLegs(int numberOfLegs) {
		if (numberOfLegs < 0) {
			System.out.println("Number of legs can't be negative");
		} else {
			this.numberOfLegs = numberOfLegs;
		}
	}

	public String typicalSize() {
		return this.typicalSize;
	}

	public void setTypicalSize(String typicalSize) {
		this.typicalSize = typicalSize;
	}

	@Override
	public String toString() {
		String output = "This animal is typical " + this.typicalSize + " in size and has " + this.numberOfLegs
				+ " legs.";
		return output;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + numberOfLegs;
		result = prime * result + ((typicalSize == null) ? 0 : typicalSize.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Animal))
			return false;
		if (obj == this)
			return true;
		Animal animal = (Animal) obj;
		if (animal.numberOfLegs != this.numberOfLegs)
			return false;
		if (animal.typicalSize != this.typicalSize)
			return false;
		return true;
	}

	@Override
	public String sound() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int runSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}
}
