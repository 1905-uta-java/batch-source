package kingdom.animals;
/*
 * This class is using inheritance to share behaviors with other objects that implement or extend the AnimalAbstract class or AnimalInterface interface.
 */
public class Bird extends AnimalAbstract implements AnimalInterface{
	
	//omnivore is a private boolean and can't be accessed outside of the Lion class.
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
