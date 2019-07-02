package calculator;

public class Calcumaboober {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		
		System.out.println(c.add(1, 2));
		System.out.println(c.subtract(4, 1));
		System.out.println(c.multiply(3, 3));
		System.out.println(c.division(6, 2));
		System.out.println(c.division(6, 0));

	}

}
