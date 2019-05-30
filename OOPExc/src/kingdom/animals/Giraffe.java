package kingdom.animals;
/*
 * This class is using inheritance to share behaviors with other objects that implement or extend the AnimalAbstract class or AnimalInterface interface.
 */
public class Giraffe extends AnimalAbstract implements AnimalInterface{
	
	//herbivore is a private boolean and can't be accessed outside of the Lion class.
	private boolean herbivore = true;
	
	public Giraffe() {
		this.setLegs(4);
	}
	
	public void reach() {
		System.out.println("This guy has a long neck to reach high places");
	}
	
	public void move(int steps) {
		System.out.println("This Giraffe has moved " + steps +" steps.");
	}
	
	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Idk what sounds Giraffe's make...");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("*Eats some leaves*");
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
