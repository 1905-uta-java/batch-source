package com.revature.animals;

/*
 * 
 * @author			Allen Rankin
 * @description		Operates the animal project
 * */

public class Driver {
	
	public static void main(String[] args) {

		// Dog
		Dog d = new Dog();
		d.setNumLegs(3);
		d.setTopSpeed(40);
		d.setAge(3);
		d.setAlive(true);
		d.setSciName("Canis lupus familiaris");
		d.setNoise("Yip!");
		d.setPlaying("rope pull");
		d.setEat("from the can");
		d.setTimeSlept(20);
		d.setAwake(false);
		//more abstraction with the toString
		System.out.println(d.toString());	
		System.out.println("d Hash Code: " + d.hashCode());
		System.out.println();
		
		
		// Snake
		Snake sn = new Snake();
		sn.setBloodTemp(2);
		sn.setNumLegs(0);
		sn.setAge(12);
		sn.setAlive(false);
		sn.setSciName("Serpentes");
		sn.setNumScales(1200);
		sn.setFangLength(1);
		sn.setShedding(true);
		sn.setSlither("A sssssssssssslithery sneek");
		
		System.out.println(sn.toString());
		System.out.println("sn Hash Code: " +sn.hashCode());
		System.out.println("sn Equals d: " + sn.equals(d)); // is a snake a dog?
		System.out.println("d Equals sn: " + d.equals(sn)); // is a dog a snake?
		System.out.println();
		
		
		
		// Starfish
		Starfish st = new Starfish();
		st.setBloodTemp(40);
		st.setNumLegs(5);
		st.setAge(3);
		st.setAlive(true);
		st.setSciName("Asteroidea");
		st.setCurrentDepth(10);
		st.setUnderRock(true);
		st.setBestFriendName("Squidward");
		
		System.out.println(st.toString());
		System.out.println("st Hash Code: " + st.hashCode());
		System.out.println("st Equals sn: " + st.equals(sn)); // is a starfish the same as a snake?
		System.out.println();
		
		
		
		// Example of Polymorphism and covariance 
		// A dog is a warm-blooded animal, so this object can be Cast as a dog
		
		WarmBlood wd = new Dog();
		Dog d2 = (Dog) wd;
		
		d2.setNumLegs(3);
		d2.setTopSpeed(40);
		d2.setAge(3);
		d2.setAlive(true);
		d2.setSciName("Canis lupus familiaris");
		d2.setNoise("Yip!");
		d2.setPlaying("rope pull");
		d2.setEat("from the can");
		d2.setTimeSlept(20);
		d2.setAwake(false);
		
		System.out.println(d2.toString());
		System.out.println("d2 Hash Code: " + d2.hashCode());
		System.out.println("d2 Equals d: " + d2.equals(d)); // is d2 the same as d?
		
		System.out.println();
		
		d2.copyright();
		// Example of inheritance
		// the information method is a default from the interface
		d2.information();		
	}
}