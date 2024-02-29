import java.util.ArrayList;
import java.util.Scanner;

public class testGameLogic {

	public static void main(String[] args) {
		RegularGameplayLogic gameLogic = new RegularGameplayLogic();
		Scanner s = new Scanner(System.in);
		
		gameLogic.startGame();
		
		while(!gameLogic.isGameOver()) {			
			String guess;
			
			System.out.print("Make Guess: ");
			guess = s.next();
			
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
			
			System.out.println("Num Guesses: " + gameLogic.getNumGuessesMade());
			
			ArrayList<String> guessesString = gameLogic.getGuessStatus();
			
			System.out.print("Word Status: ");
			for(int i = 0; i < guessesString.size(); i++) {
				if(guessesString.get(i) != "") {
					System.out.print(guessesString.get(i));
				}
				else {
					System.out.print("-");
				}
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
	}
}
