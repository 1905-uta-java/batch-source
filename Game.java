import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		play();
	}

	public static void play() {
		int randomNum = getRandomNumber();
		int lowerBound = 0;
		int upperBound = 100;
		int attemp = 0;
		int input = 0;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("Enter the number between " + lowerBound + " and " + upperBound + ": ");
			while (!sc.hasNextInt()) {
				if (!sc.hasNextInt()) {
					System.out.print("Please input a number only: ");
					sc.next();
				}
			}
			input = sc.nextInt();
			if (input < lowerBound || input > upperBound) {
				System.out.println(
						"Please input a number between relevant range (" + lowerBound + " - " + upperBound + ")");
			} else if ((randomNum - input) > 0) {
				lowerBound = input;
				System.out.println("Too low");
				attemp++;
			} else if ((randomNum - input) < 0) {
				upperBound = input;
				System.out.println("Too high");
				attemp++;
			} else if (input == randomNum) {
				attemp++;
				System.out.println("You guessed right, after " + attemp + " attemps, the number is " + randomNum);
				break;
			}
		}
		sc.close();
	}

	public static int getRandomNumber() {
		double randomDouble = Math.random();
		randomDouble = randomDouble * 100 + 1;
		return (int) randomDouble;
	}
}
