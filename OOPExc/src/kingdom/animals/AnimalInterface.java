package kingdom.animals;
/*
 * this interface supports abstraction and polymporhism by making sure that ALL classes implementing this interface will have the below methods. Thus supporting method overriding and abstraction
 * implementation details. Because makeSound() and eat() are in this interface, we know anything that implements this interface will also have these methods.
 */
public interface AnimalInterface {
	
	public void makeSound();
	
	public void eat();
	

}