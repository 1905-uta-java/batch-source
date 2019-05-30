package kingdom.animals;
/*
 * This class is using inheritance to share behaviors with other objects that implement or extend the AnimalAbstract class or AnimalInterface interface.
 */
public class Lion extends AnimalAbstract implements AnimalInterface{

	//carnivore is a private boolean and can't be accessed outside of the Lion class.
	private boolean carnivore = true;
	
	public Lion() {
		this.setLegs(4);
	}
	
	public void nap() {
		System.out.println("This kitty is catching some Zzzz");
	}
	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("RAWR!");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
			System.out.println("*Eats fresh meat*");
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
