import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10; // Maximum number of attempts per round
        int totalScore = 0; // Initialize total score
        
        System.out.println("Welcome to Guess the Number!");
        
        // Enclosing the game logic in a loop to allow multiple rounds
        while (true) {
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0; // Reset attempts for each round
            
            System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");
            
            // Loop for each attempt
            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Attempt " + attempts + "/" + maxAttempts + ". Enter your guess: ");
                int guess = scanner.nextInt();
    
                if (guess == randomNumber) {
                    int score = maxAttempts - attempts + 1; // Calculate score
                    totalScore += score; // Update total score
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts. Score: " + score);
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                
                // Providing a hint after the second failed attempt
                if (attempts == 2) {
                    if (randomNumber % 2 == 0) {
                        System.out.println("Hint: The number is divisible by 2.");
                    } else {
                        System.out.println("Hint: The number is not divisible by 2.");
                    }
                }
            }
            
            // If the user exceeds the maximum attempts
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
            }
            
            // Asking user if they want to play another round
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break; // Exit the loop if the user doesn't want to play another round
            }
        }
        
        // Display total score at the end of the game
        System.out.println("Total Score: " + totalScore);
        
        scanner.close();
    }
}
