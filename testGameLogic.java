import java.util.ArrayList;
import java.util.Scanner;

public class testGameLogic {

	public static void main(String[] args) {
		RegularGameplayLogic gameLogic = new RegularGameplayLogic();
		Scanner s = new Scanner(System.in);
		
		gameLogic.startGame();
		
		System.out.println("FOR TESTING PURPOSES: WORD = " + gameLogic.getTargetWord());
		
		while(!gameLogic.isGameOver()) {			

			String guessType = "";
			System.out.print("Word or Letter Guess? (w or l): ");
			guessType = s.next();
			
			while(!guessType.equals("w") && !guessType.equals("l")) {
				System.out.print("Incorrect Input! Word or Letter Guess? (w or l): ");
				guessType = s.next();
			}
			System.out.println();

			String guess;
			System.out.print("Make Guess: ");
			guess = s.next();
			
			if(guessType.equals("l")) {
				while(!gameLogic.isValidLetterGuess(guess)) {
					System.out.println("Invalid Input! Make Guess: ");
					guess = s.next();
				}
				
				while(gameLogic.hasGuessedLetterBefore(guess)) {
					System.out.println("Already Guessed! Make Guess: ");
					guess = s.next();
				}
				
				if(!gameLogic.isCorrectLetterGuess(guess)) {
					System.out.println("Incorrect Guess!");
				}
				else {
					System.out.println("Correct Guess!");
				}
			}
			else {
				while(!gameLogic.isValidWordGuess(guess)) {
					System.out.println("Invalid Input! Make Guess: ");
					guess = s.next();
				}
				
				while(gameLogic.hasGuessedWordBefore(guess)) {
					System.out.println("Already Guessed! Make Guess: ");
					guess = s.next();
				}
				
				if(!gameLogic.isCorrectWordGuess(guess)) {
					System.out.println("Incorrect Guess!");
				}
				else {
					System.out.println("Correct Guess!");
				}
			}
			
			System.out.println("Num Guesses: " + gameLogic.getNumGuessesMade());
			
			ArrayList<String> guessesString = gameLogic.getGuessStatus();
			
			System.out.print("Word Status: ");
			for(int i = 0; i < guessesString.size(); i++) {
				System.out.print(guessesString.get(i));
			}
			
			System.out.println();
		}
		
		if(gameLogic.isGameWon()) {
			System.out.println("You Win!");
		}
		else {
			System.out.println("You Lost :(");
		}
		
		System.out.println("Word was: " + gameLogic.getTargetWord());
		
		s.close();
	}
}
