import java.util.ArrayList;

public class RegularGameplayLogic {
	private final String fileName = "Words.txt";
	private String targetWord;
	
	private DictionaryInterface dictionary;
	private GuessHandlerInterface guessHandler;
	
	RegularGameplayLogic() {	
		dictionary = new Dictionary(fileName);
	}
	
	public void startGame() {
		targetWord = dictionary.getWord();	
		guessHandler = new GuessHandler(targetWord);
	}
	
	public boolean isGameOver() {
		if(guessHandler.targetWordGuessedSuccessfully() || guessHandler.isAtGuessLimit()) {
			return true;
		}
		
		return false;
	}
	
	public boolean isGameWon() {
		return guessHandler.targetWordGuessedSuccessfully();
	}
	
	public boolean isValidLetterGuess(String guess) {
		return guessHandler.isValidLetterGuess(guess);
	}
	
	public boolean isValidWordGuess(String guess) {
		return guessHandler.isValidWordGuess(guess);
	}
	
	public boolean hasGuessedLetterBefore(String guess) {
		return guessHandler.hasGuessedLetterBefore(guess);
	}
	
	public boolean isCorrectLetterGuess(String guess) {
		return guessHandler.isCorrectLetterGuess(guess);
	}
	
	public ArrayList<String> getGuessStatus() {
		return guessHandler.getGuessStatus();
	}
	
	public ArrayList<String> getGuessedLetters() {
		return guessHandler.getGuessedLetters();
	}
	
	public ArrayList<String> getGuessedWords() {
		return guessHandler.getGuessedWords();
	}
	
	public int getNumGuessesMade() {
		return guessHandler.getNumGuessesMade();
	}
	
	public String getTargetWord() {
		return targetWord;
	}
}
