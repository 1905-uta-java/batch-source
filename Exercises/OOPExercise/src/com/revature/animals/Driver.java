package com.revature.animals;

public class Driver {
	
	static void showAnimals(Animal...animals) {
		
		for(Animal a : animals) {
			
			System.out.println("Name: " + a.getName());
			System.out.println("Species: " + a.getClass().getSimpleName());
			System.out.println("Age: " + a.getAge());
			System.out.println("Number of Legs: " + a.getNumLegs());
			
			System.out.print("Move: ");
			a.move();
			
			System.out.print("Eat: ");
			a.eat();
			
			System.out.println();
		}
	}
	
	static void trimMammalsFur(int furLength, Mammal... mammals) {
		
		for(Mammal m : mammals) {
			
			m.trimFur(furLength);
			
			if(m.getFurLength() < furLength)
				System.out.println(m.getName() + "'s fur was not trimmed because it was already as short as " + m.getFurLength() + " units long");
			else
				System.out.println(m.getName() + "'s fur is now " + m.getFurLength() + " units long.");
		}
	}
	
	static void letReptilesFindWarmth(Reptile... reptiles) {
		
		for(Reptile r : reptiles) {
			
			r.findWarmth();
		}
	}
	
	static void rideToDestination(Rideable mount, String destination) {
		
		mount.RideTo(destination);
	}
	
	static void flyUpThenLand(Flyable flyer) {
		flyer.Fly();
		flyer.Land();
	}
	
	public static void main(String[] args) {
		
		// Dragon constructor -> Dragon(name, age, scaleColor, isTerrifying)
		Dragon smaug = new Dragon("Smaug", 10000, "Black", true);
		Dragon spyro = new Dragon("Spyro", 12, "Purple", false);
		
		// Snake constructor -> Snake(name, age, scaleColor, isPoisonous)
		Snake kaa = new Snake("Kaa", 100, "Brown", false);
		Snake nagini = new Snake("Nagini", 1000, "Brown", true);
		
		// Bat constructor -> Bat(name, age, furLength, isFrugivore)
		Bat bartok = new Bat("Bartok", 20, 1, true);
		Bat batman = new Bat("Batman", 41, 0, false);
		
		// Horse constructor -> Horse(name, age, furLength, runSpeed)
		Horse beauty = new Horse("Beauty", 20, 10, 40);
		Horse roach = new Horse("Roach", 15, 20, 35);
		
		System.out.println(smaug);
		System.out.println(spyro);
		System.out.println(kaa);
		System.out.println(nagini);
		System.out.println(bartok);
		System.out.println(batman);
		System.out.println(beauty);
		System.out.println(roach);
		
		System.out.println();
		
		System.out.println("Trimming some mammals' fur to 9.");
		
		trimMammalsFur(9, roach, batman);
		
		System.out.println();
		
		System.out.println("Letting some reptiles find warmth.");
		
		letReptilesFindWarmth(nagini, smaug);
		
		System.out.println();
		
		System.out.println("Riding some ridable animals");
		
		rideToDestination(spyro, "Cincinatti");
		rideToDestination(roach, "Novigrad");
		
		System.out.println();
		
		System.out.println("Flying some flyers");
		
		flyUpThenLand(bartok);
		flyUpThenLand(smaug);
		
		System.out.println();
		
		System.out.println(smaug);
		System.out.println(spyro);
		System.out.println(kaa);
		System.out.println(nagini);
		System.out.println(bartok);
		System.out.println(batman);
		System.out.println(beauty);
		System.out.println(roach);
		
		System.out.println();
		
		// This method call takes advantage of covariance to call a set of methods declared in Animal using a for loop and referencing
		// the various Animal subclass instances as instances of Animal
		showAnimals(smaug, kaa, roach, nagini, bartok, spyro, beauty, batman);
	}
}
