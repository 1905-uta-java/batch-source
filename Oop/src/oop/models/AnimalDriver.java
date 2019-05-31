package oop.models;

public class AnimalDriver {

	public static void main(String[] args) {
		
		// creating null animal 1 and animal 2
		Animal a1 = new Animal();
		Animal a2 = new Animal();
		System.out.println(a1);
		System.out.println(a2);
		
		// check equality
		// false
		System.out.println(a1==a2);
		//should be true
		System.out.println(a1.equals(a2));
		
		// creating animal 3 and animal 4 with values
		Animal a3 = new Animal(4, "small");
		Animal a4 = new Animal(4, "small");
		
		// toString()
		System.out.println(a3);
		System.out.println(a4);
		
		// should be true
		System.out.println(a3.equals(a4));
		
		// let's change a4
		a4.setTypicalSize("big");
		
		// toString()
		System.out.println(a3);
		System.out.println(a4);
		
		// should be false
		System.out.println(a3.equals(a4));
		
		// create cat1
		Cat cat1 = new Cat();
		cat1.setNumberOfLegs(4);
		cat1.setTypicalSize("small");
		
		// create cat2
		Cat cat2 = new Cat();
		cat2.setNumberOfLegs(4);
		cat2.setTypicalSize("small");
		
		// Try toString() and comparing two cats
		System.out.println(cat1);
		System.out.println(cat2);
	
		// should be "True"
		System.out.println(cat1.equals(cat2));
		System.out.println(cat1.hashCode() == cat2.hashCode());
		
		// cat2 is now different
		cat2.setRunSpeed(25);
		
		// Try toString() and comparing again
		System.out.println(cat1);
		System.out.println(cat2);
		
		// should be "False"
		System.out.println(cat1.equals(cat2));
		System.out.println(cat1.hashCode() == cat2.hashCode());

		
		// create dog1
		Dog dog1 = new Dog();
		dog1.setNumberOfLegs(4);
		dog1.setTypicalSize("medium");
		
		// create dog 2
		Dog dog2 = new Dog();
		dog2.setNumberOfLegs(4);
		dog2.setTypicalSize("medium");
		
		
		// Try toString() and comparing two dogs
		System.out.println(dog1);
		System.out.println(dog2);
	
		// should be "True"
		System.out.println(dog1.equals(dog2));
		System.out.println(dog1.hashCode() == dog2.hashCode());
		
		// cat2 is now different
		dog2.setRunSpeed(15);
		
		// Try toString() and comparing again
		System.out.println(dog1);
		System.out.println(dog2);
		
		// should be "False"
		System.out.println(dog1.equals(dog2));
		System.out.println(dog1.hashCode() == dog2.hashCode());
	}
}
