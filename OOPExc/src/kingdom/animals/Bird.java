package kingdom.animals;
/*
 * This class is using inheritance to share behaviors with other objects that implement or extend the AnimalAbstract class or AnimalInterface interface.
 */
public class Bird extends AnimalAbstract implements AnimalInterface{
	
	//an example of encapsulation through the variable omnivore as a private boolean and can't be accessed outside of the Bird class
	private boolean omnivore = true;

	public Bird() {
		this.setLegs(2);
	}
	
	public void fly() {
		System.out.println("Redbull gives you wiiings");
	}
	
	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Chirp!");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("*Eats seeds or worms*");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (omnivore ? 1231 : 1237);
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
		Bird other = (Bird) obj;
		if (omnivore != other.omnivore)
			return false;
		return true;
	}

}
