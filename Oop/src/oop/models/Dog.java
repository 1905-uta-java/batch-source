package oop.models;

import oop.abstraction.AnimalInterface;

// Inheritance
// Dog extends Animal class
public class Dog extends Animal implements AnimalInterface {

	// Encapsulation
	// hiding info
	private int runSpeed = 20;
	private String sound = "Woof";

	// Abstraction, implements interface's method
	@Override
	public int runSpeed() {
		return runSpeed;
	}
	
	public void setRunSpeed(int runSpeed) {
		this.runSpeed = runSpeed;
	}

	// Abstraction, implements interface's method
	@Override
	public String sound() {
		return sound;
	}

	// Polymorphism
	// overriding
	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + runSpeed;
		result = prime * result + ((sound == null) ? 0 : sound.hashCode());
		return result;
	}
	
	// Polymorphism
	// overriding
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (obj == this)
			return true;
		Dog dog = (Dog) obj;
		if (dog.runSpeed != this.runSpeed)
			return false;
		if (!dog.sound().equals(this.sound()))
			return false;
		return true;
	}

	// Polymorphism
	// overriding
	@Override
	public String toString() {
		return ("This is a Dog, usually " + super.typicalSize() + " in size, has " + super.numberOfLegs()
				+ " legs. Make " + sound() + " sound and has a running speed of " + runSpeed());
	}
}
