import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        // Step 1: Generate a random number between 1 and 100
        int number = (int) (Math.random() * 100) + 1;

        // Step 2: Initialize variables
        Scanner sc = new Scanner(System.in);
        int guess = 0;
        int attempts = 0;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I have picked a number between 1 and 100. Can you guess it?");

        // Step 3: Loop until the correct guess
        do {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt(); // Read user's guess
            attempts++;

            // Step 4: Provide feedback
            if (guess < number) {
                System.out.println("Too low! Try again.");
            } else if (guess > number) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
            }
        } while (guess != number);

        // Close the scanner
        sc.close();
    }
}
