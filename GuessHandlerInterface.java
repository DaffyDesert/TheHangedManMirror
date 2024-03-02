import java.util.ArrayList;

public interface GuessHandlerInterface {
	public boolean hasGuessedEveryLetterInWord();
	public boolean hasGuessedCorrectWord();
	public boolean isAtGuessLimit();
	public boolean targetWordGuessedSuccessfully();
	public boolean hasGuessedLetterBefore(String guess);
	public boolean hasGuessedWordBefore(String guess);
	public boolean isValidLetterGuess(String guess);
	public boolean isValidWordGuess(String guess);
	public boolean isCorrectLetterGuess(String guess);
	public boolean isCorrectWordGuess(String guess);
	public ArrayList<String> getGuessStatus();
	public ArrayList<String> getIncorrectLetterGuesses();
	public ArrayList<String> getGuessedLetters();
	public ArrayList<String> getGuessedWords();
	public int numIncorrectGuessesMade();
}
