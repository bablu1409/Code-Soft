import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalGamesPlayed = 0;
        int totalGamesWon = 0;

        do {
            int randomNumber = getRandomNumber(MIN_NUMBER, MAX_NUMBER, random);
            int attempts = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ":");

            while (attempts < MAX_ATTEMPTS) {
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalGamesWon++;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            if (attempts >= MAX_ATTEMPTS) {
                System.out.println("You ran out of attempts. The number was " + randomNumber + ".");
            }

            totalGamesPlayed++;

            System.out.println("Do you want to play again? (y/n)");
        } while (scanner.next().equalsIgnoreCase("y"));

        scanner.close();

        System.out.println("Thank you for playing!");
        System.out.println("Games played: " + totalGamesPlayed);
        System.out.println("Games won: " + totalGamesWon);
    }

    private static int getRandomNumber(int min, int max, Random random) {
        return random.nextInt(max - min + 1) + min;
    }
}
