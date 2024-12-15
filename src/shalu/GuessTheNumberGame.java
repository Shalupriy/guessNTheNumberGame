package shalu;



	
		import java.util.*;
		import java.time.Duration;
		import java.time.Instant;

		public class GuessTheNumberGame {

		    // Generates a random 4-digit number with unique digits
		    private static String generateUniqueNumber() {
		        List<Integer> digits = new ArrayList<>();
		        for (int i = 0; i <= 9; i++) {
		            digits.add(i);
		        }
		        Collections.shuffle(digits); 
		        StringBuilder number = new StringBuilder();
		        for (int i = 0; i < 4; i++) {
		            number.append(digits.get(i));
		        }
		        return number.toString();
		    }

		    // Main game logic
		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);

		        System.out.println("Welcome to the Guess the Number game!");
		        System.out.print("Enter your name to start the game: ");
		        String playerName = scanner.nextLine();

		        String secretNumber = generateUniqueNumber();
		        System.out.println("The computer has selected a unique 4-digit number. Try to guess it!");

		        Instant startTime = Instant.now();
		        int attempts = 0;

		        while (true) {
		            System.out.print("Enter your 4-digit guess: ");
		            String userGuess = scanner.nextLine();

		            // Validate input
		            if (userGuess.length() != 4 || !userGuess.matches("\\d+") || userGuess.chars().distinct().count() != 4) {
		                System.out.println("Invalid input! Enter a 4-digit number with unique digits.");
		                continue;
		            }

		            attempts++;
		            int plus = 0, minus = 0;

		            // Compare user guess with secret number
		            for (int i = 0; i < 4; i++) {
		                if (userGuess.charAt(i) == secretNumber.charAt(i)) {
		                    plus++;
		                } else if (secretNumber.indexOf(userGuess.charAt(i)) != -1) {
		                    minus++;
		                }
		            }

		            // Provide feedback
		            System.out.println("Feedback: " + "+".repeat(plus) + "-".repeat(minus));

		            // Check if the user guessed the number
		            if (plus == 4) {
		                Instant endTime = Instant.now();
		                long timeTaken = Duration.between(startTime, endTime).toSeconds();
		                System.out.println("Congratulations " + playerName + "! You guessed the number " + secretNumber + ".");
		                System.out.println("It took you " + timeTaken + " seconds and " + attempts + " attempts.");
		                break;
		            }
		        }

		        scanner.close();
		    }

	}


