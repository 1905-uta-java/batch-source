package com.revature.oopexercise;

/*
 * Core
 * 
 * Definition of the Core class, used for the main running of 
 * the program
 * 
 * CONTAINS MAIN
 * 
 */
public class Core 
{
	/*
	 * main: MAIN RUN FUNCTION
	 * args: taken, but not used.
	 * returns: nothing
	 * 
	 * Creates arrays of various animals and animal subtypes and
	 * runs through their functionalities, first treating the 
	 * animals as merely animals, then cats as cats, and then
	 * finally the bigcat as a bigcat, using polymorphism to
	 * use functionalities that exist in each of the object sets.
	 */
	public static void main(String[] args) 
	{
		Animal[] animals = new Animal[4];
		Cat[] cats = new Cat[3];
		animals[0] = new Dog();
		cats[0] = new DomesticCat();
		cats[1] = new DomesticCat("yard");
		BigCat bc = new BigCat();
		cats[2] = bc;
		animals[1] = cats[0];
		animals[2] = cats[1];
		animals[3] = cats[2];
		for (int an = 0; an < 4; an++)
		{
			System.out.println(animals[an].getClass());
			System.out.println(animals[an].hashCode());
			animals[an].move();
			animals[an].makeNoise();
		}
		for (int cat = 0; cat < 3; cat ++) 
		{
			System.out.println(cats[cat].getClass());
			System.out.println(cats[cat].hashCode());
			cats[cat].sneak();
		}
		System.out.println(bc.getMass());
	}

}
