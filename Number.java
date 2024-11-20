import java.util.Scanner;
import java.util.Random;

public class Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
       // Declaring variables
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5;
        int score = 0;
        int round = 1;

        System.out.println("Welcome to Guess the Number!");
       // Condition checking
        while (true) {
            System.out.println("\nRound " + round);
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            while (attempts < maxAttempts) {
                System.out.print("Guess a number between " + lowerBound + " and " + upperBound + ": ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1; // Award points based on attempts
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (attempts == maxAttempts)
            {
                System.out.println("You've reached the maximum number of attempts. The correct number was: " + randomNumber);
            }

            round++;

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\nGame Over! Your final score is: " + score);
        scanner.close();
    }
}