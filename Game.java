import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		play();
	}
	
	static void play() {
		int randomNum = getRandomNumber();
		int lowerBound = 0;
		int higherBound = 100;
		int attemp = 0;
		int input = 0;
		boolean isNum = false;
		
		Scanner sc = new Scanner(System.in);

		while(true) {
			
			System.out.print("Enter the number between " + lowerBound + " and " + higherBound + ": ");
			input = sc.nextInt();
			
			attemp++;
			if(input == randomNum) {
				System.out.println("You guessed right, after " + attemp + " attemps, the number is " + randomNum);
				break;
			}
			else {
				if((randomNum - input) > 0) {
					lowerBound = input;
					System.out.println("Too low");
				}
				else {
					higherBound = input;
					System.out.println("Too high");
					
				}
			}
		}
		sc.close();
	}
	
	public static int getRandomNumber() {
		double randomDouble = Math.random();
		randomDouble = randomDouble * 100 + 1;
		return (int) randomDouble;
		// System.out.println(randomInt);
	}
	
	public static boolean isInt(String input) { 
	    try { 
	        Integer.parseInt(input);
	        return true;
	    }
	    catch(Exception e ) { 
	        return false; 
	    }
	} 
	
}


