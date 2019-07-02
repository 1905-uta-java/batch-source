package com.revature.animals;

/**
 * Animal is the base class for all animals. It defines three fields common
 * to all animals, and some abstract and concrete methods. The Animal class
 * and it's subclasses use encapsulation to protect the data held at each layer
 * and to guarantee specific features of the data (for example, that age
 * cannot be a negative number).
 */
public abstract class Animal {
	
	private String name;
	private int age;
	private int numLegs;
	
	public Animal() {
		this("", 0, 0);
	}
	
	public Animal(String name, int age, int numLegs) {
		this.name = name;
		this.age = age;
		this.numLegs = numLegs;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name != null)
			this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		if(age > -1)
			this.age = age;
	}
	
	public int getNumLegs() {
		return numLegs;
	}
	
	public void haveBirthday() {
		age++;
	}
	
	public abstract void move();
	
	public abstract void eat();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numLegs;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numLegs != other.numLegs)
			return false;
		return true;
	}
}