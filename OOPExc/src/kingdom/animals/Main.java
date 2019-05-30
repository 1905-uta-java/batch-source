package kingdom.animals;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bird bird = new Bird();
		Giraffe giraffe = new Giraffe();
		Lion simba = new Lion();
		
		simba.eat();
		giraffe.eat();
		bird.eat();
		
	
		
		simba.move(10);
		
		//a covariance example
		AnimalAbstract fred = new Giraffe();
		
		fred.move(12);
		
		
		
	}

}
