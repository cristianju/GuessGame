/*GuessGame:
    The user chooses a natural number between 0 and 100
    and the computer generates a random number between 0 and 100.
    If the difference between the two numbers is less than 5,
    the user won. Otherwise, he lost. */

import java.util.*;
import java.util.concurrent.TimeUnit;

public class GuessGame {
	public static void main(String[] args) {

		System.out.println("The user chooses a natural number between 0 and 100,\r\n"
				+ "and the computer generates a random number between 0 and 100.\r\n"
				+ "If the difference between the two numbers is less than 5,\r\n"
				+ "the user won. Otherwise, he lost.\n\n");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a natural number between 0 si 100!");

		int n = readNum(s);
		attempts(s, n);
	}

	public static int readNum(Scanner s) {
		if (!s.hasNextInt()) {
			System.out.println("You must enter a number!");
			System.out.println("Enter the number: ");
			s.next();
			return readNum(s);
		}
		int n = s.nextInt();
		if (n <= 0 || n > 100) {
			System.out.println();
			System.out.println("\nIt has to be between 0 and 100!");
			System.out.print("Re-type the number: ");
			return readNum(s);
		}
		return n;
	}

	public static int dif(int n) {
		System.out.println("\nYour number is: " + n);
		Random rand = new Random();
		int m = rand.nextInt(101);
		System.out.println("Computer's number: " + m);
		int d = Math.abs(n - m);
		return d;
	}

	public static void attempts(Scanner s, int n) {
		// counting till the user win
		int p = 1;
		while (dif(n) > 5) {
			p++;
			System.out.println("The difference is greater than 5.");
			System.out.println("Try it again!");
			System.out.println("Enter the number:");
			n = readNum(s);
		}
		System.out.println("\nCongrats! You succeeded in " + p + " attempts!");
		endProgram();
	}
	
	public static void endProgram() {
		System.out.println("Program terminated.");
		
		// delaying 5 seconds before closing the program
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

}
