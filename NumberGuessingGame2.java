import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 5;
        int score = 100; // Initial score

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ". Guess it!");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Enter your guess (Attempt " + attempt + "/" + maxAttempts + "): ");
            int userGuess = scanner.nextInt();

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                System.out.println("Your score: " + score);
                break;
            } else {
                System.out.println("Wrong guess!");

                if (userGuess < targetNumber) {
                    System.out.println("The target number is higher.");
                } else {
                    System.out.println("The target number is lower.");
                }

                // Update score based on the difference between the guess and the target
                int scorePenalty = Math.abs(targetNumber - userGuess) * 10;
                score = Math.max(0, score - scorePenalty);

                if (attempt == maxAttempts) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
                    System.out.println("Your final score: " + score);
                }
            }
        }

        scanner.close();
    }
}
