package com.revature.animals;

/*
 * 
 * @author 			Allen Rankin
 * @description 	Super class for a warm blooded animal
 * 
 * */

public class WarmBlood implements AnimalInterface {
	 
	 // Example of encapsulation 
	 // We made the variables themselves private so they can only be accessed
	 // through a getter and changed through a setter. 
	 private int numLegs; 
	 private int topSpeed; 
	 private int age;
	 private boolean alive;
	 private String sciName; 
	 private String noise;
	
	 
	 // Example of Polymorphism and Method Overloading
	 // We have 2 methods with the same name but different arguments
	 // Which method is used will change depending on if 
	 // arguments are present in a method call,
	 
	 /*
	  * Empty constructors
	  * */
	 public WarmBlood() { 
		 super(); 
	 }
  
	 
	 /* 
	  * Constructor for WarmBlood
	  * @params numLegs		Number of legs the animal has
	  * 		topSpeed	The top speed animal can reach
	  * 		age			The age of the animal
	  * 		alive		Is the animal alive or not
	  * 		sciName		What's the scientific name of the animal?
	  * 		noise		What noise does the animal make?
	  * 
	  * */
	 public WarmBlood(int numLegs, int topSpeed, int age, boolean alive, String sciName, String noise) {
		 super(); 
		 this.numLegs = numLegs; 
		 this.topSpeed = topSpeed; 
		 this.age = age; 
		 this.alive = alive; 
		 this.sciName= sciName; 
		 this.noise = noise; 
    }
	
	 
	 /*
	  * Returns the value set to numLegs
	  * 
	  * @return numLegs - number of legs for the animals
	  * 
	  * */
	 public int getNumLegs() { 
		 return this.numLegs; 
	 }
	
	 /*
	  * Sets a value for numLegs
	  * 
	  * @params numLegs	- number of legs for the animals
	  * 
	  * */
	 public void setNumLegs(int numLegs) { 
		 this.numLegs = numLegs; 
	 }
	
	 
	 /*
	  * Returns the value set to topSpeed
	  * 
	  * @return topSpeed - how fast the animal can go
	  * 
	  * */
 	 public int getTopSpeed() { 
 		 return this.topSpeed; 
	 }
	
 	 /*
 	  * Sets a value for topSpeed
 	  * 
 	  * @param topSpeed - how fast the animal can go 
 	  * 
 	  * */
	 public void setTopSpeed(int topSpeed) { 
		 this.topSpeed = topSpeed; 
	 }
	
	 /*
	  * Returns the age of the animal
	  * 
	  * @return age - the age of the animal
	  * 
	  * */
	 public int getAge() {
		 return this.age;
	 }
	
	 
	 /*
	  * Sets the age of the animal
	  * 
	  * @param age - the age of the animal
	  * 
	  * */
	 public void setAge(int age) {
		 this.age = age;
	 }
	
	 
	 /*
	  * Returns the current situation of the animal
	  * 
	  * @return alive - boolean if the animal is alive or not 
	  * 
	  * */
	 public boolean getAlive() {
		 return this.alive;
	 }
	
	 
	 /*
	  * Sets the animals' life state (alive or dead, true or false)
	  * 
	  * @param alive - boolean if the animal is alive or not
	  * 
	  * */
	 public void setAlive(boolean alive) {
		 this.alive = alive;
	 }
	
	 
	 /*
	  * Returns the scientific name of the animal
	  * 
	  * @return sciName - scientific name of animal
	  * 
	  * */
	 public String getSciName() {
		 return this.sciName; 
	 }
	
	 
	 /*
	  * Sets the scientific name of the animal
	  * 
	  * @param sciName - scientific name of animal
	  * 
	  * */
	 public void setSciName(String sciName) { 
		 this.sciName = sciName; 
	 }
	
	 
	 /*
	  * Returns the noise the animal makes
	  * 
	  * @return noise - noise the animal makes
	  * 
	  * */
	 public String getNoise() { 
		 return noise; 
	 }
	
	 
	 /*
	  * Sets the noise the animal makes
	  * 
	  * @param noise - noise the animal makes
	  * 
	  * */
	 public void setNoise(String noise) { 
		 this.noise = noise; 
	 }	

	 
	 
	 // Example of abstraction.
	 // Empty method required from the interface, so we made it a println call
	 
	 /*
	  * From AnimalInterface, sheds some light on the governmental situation of animals and copyrighting
	  * 
	  * */
	 @Override
	 public void copyright() {
		 // TODO Auto-generated method stub
		 System.out.println("Only humans can own copyright, according to the law");
	 }
	
	 
	 /*
	  * Overriding the default toString so it'll fit nicer with other animals when they call toString
	  * 
	  * */
	 @Override
	 public String toString() {
		 return "numLegs=" + getNumLegs() + ", topSpeed=" + getTopSpeed() + ", age=" + getAge() + 
				 ", alive=" + getAlive() + ", sciName=" + getSciName() + ", noise=" + getNoise();
	 }

	 
	 /*
	  * Override from the default hashCode, allows us to manually manipulate an object's hash
	  * 
	  * @return result - hashed number of object 
	  * 
	  * */
	 @Override
	 public int hashCode() {
		 final int prime = 31;
		 int result = 1;
		 result = prime * result + age;
		 result = prime * result + (alive ? 1231 : 1237);
		 result = prime * result + ((noise == null) ? 0 : noise.hashCode());
		 result = prime * result + numLegs;
		 result = prime * result + ((sciName == null) ? 0 : sciName.hashCode());
		 result = prime * result + topSpeed;
		 return result;
	 }
	
	 /*
	  * Override from default equals, now we can manually check different field values between 2 objects
	  * 
	  * @return boolean - if the objects are the same or not 
	  * 
	  * */
	 @Override
	 public boolean equals(Object obj) {
		 if (this == obj)
			 return true;
		 if (obj == null)
			 return false;
		 if (getClass() != obj.getClass())
			 return false;
		 WarmBlood other = (WarmBlood) obj;
		 if (age != other.age)
			 return false;
		 if (alive != other.alive)
			 return false;
		 if (noise == null) {
			 if (other.noise != null)
				 return false;
		 } else if (!noise.equals(other.noise))
			 return false;
		 if (numLegs != other.numLegs)
			 return false;
		 if (sciName == null) {
			 if (other.sciName != null)
				return false;
		 } else if (!sciName.equals(other.sciName))
			 return false;
		 if (topSpeed != other.topSpeed)
			 return false;
		 return true;
	}

}
