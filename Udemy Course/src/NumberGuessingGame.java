import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        // Create a Random object to generate random numbers
        Random random = new Random();
        
        // Generate a random number between 0 and 15
        int targetNumber = random.nextInt(16); // 16 is exclusive, so it generates 0-15
        
        // Set the number of chances
        int chances = 5;
        
        // Scanner to read user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 0 and 15.");
        System.out.println("You have " + chances + " chances to guess it correctly.");
        
        // Loop for 5 chances
        while (chances > 0) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt(); // Read the user input
            
            // Check if the guess is correct
            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the number correctly.");
                break;
            } else if (userGuess < targetNumber) 
            {
                System.out.println("Too low! Try again.");
            } 
            else if(targetNumber-2 == userGuess || targetNumber-1 == userGuess)
            {
                System.out.println("So Close! Try again.");
            }
            else if(targetNumber+2 == userGuess || targetNumber+1 == userGuess)
            {
                System.out.println("So Close! Try again.");
            }
            else
            {
                System.out.println("Too high! Try again.");
            }
            
            // Decrease the number of chances left
            chances--;
            System.out.println("You have " + chances + " chances left.");
            
            // If no chances are left, the game ends
            if (chances == 0) {
                System.out.println("Sorry, you've run out of chances. The correct number was: " + targetNumber);
            }
        }
        
        // Close the scanner object to avoid resource leak
        scanner.close();
    }
}
