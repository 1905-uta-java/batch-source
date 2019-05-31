package kingdom.animals;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bird bird = new Bird();
		Giraffe giraffe = new Giraffe();
		Lion simba = new Lion();
		
		System.out.println("Diets");
		simba.eat();
		giraffe.eat();
		bird.eat();
		System.out.println();
		
		System.out.println("Here we watch the lion cub take his first steps");
		simba.move(10);
		
		//a covariance example to watch a different behavior of the move method
		AnimalAbstract fred = new Giraffe();
		
		fred.move(12);
		
		//this print message is used to determine whether the AnimalAbstract fred is fundamentally equal to a giraffe
		System.out.println(fred.equals(giraffe));
		
		
	}

}
