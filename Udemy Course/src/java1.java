import java.util.Scanner;

public class java1 
{
    public static void main(String[] args) 
    {
        // Step 1: Define mappings for letters and Morse codes
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Scanner sc = new Scanner(System.in);

        // Step 2: Ask the user for input
        System.out.println("Choose an option:");
        System.out.println("1. Convert String to Morse Code");
        System.out.println("2. Convert Morse Code to String");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline

        if (choice == 1) {
            // String to Morse Code Conversion
            System.out.print("Enter a string: ");
            String input = sc.nextLine().toUpperCase();
            StringBuilder morseOutput = new StringBuilder();

            for (int i = 0; i < input.length(); i++)
            {
                char c = input.charAt(i); 
                if (c == ' ') {
                    morseOutput.append(" / "); // Add a slash for spaces
                } else {
                    for (int j = 0; j < letters.length; j++) {
                        if (String.valueOf(c).equals(letters[j])) {
                            morseOutput.append(morse[j]).append(" ");
                            break;
                        }
                    }
                }
            }

            System.out.println("Morse Code: " + morseOutput.toString().trim());

        } else if (choice == 2) 
        {
            // Morse Code to String Conversion
            System.out.print("Enter Morse code (use space between letters and '/' for spaces): ");
            String input = sc.nextLine();
            StringBuilder stringOutput = new StringBuilder();
            String[] morseWords = input.split(" / "); // Split into words

            for (String word : morseWords) {
                String[] morseLetters = word.split(" "); // Split into individual Morse codes
                for (String m : morseLetters) {
                    for (int i = 0; i < morse.length; i++) {
                        if (m.equals(morse[i])) {
                            stringOutput.append(letters[i]);
                            break;
                        }
                    }
                }
                stringOutput.append(" "); // Add a space after each word
            }

            System.out.println("String: " + stringOutput.toString().trim());
        } else {
            System.out.println("Invalid choice!");
        }

        sc.close(); 
    }
}
