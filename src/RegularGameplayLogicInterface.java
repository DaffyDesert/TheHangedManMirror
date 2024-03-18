import java.util.ArrayList;

public interface RegularGameplayLogicInterface {
	public void startGame();
	public boolean isGameOver();
	public boolean isGameWon();
	public boolean isValidLetterGuess(String guess);
	public boolean isValidWordGuess(String guess);
	public boolean hasGuessedLetterBefore(String guess);
	public boolean hasGuessedWordBefore(String guess);
	public boolean isCorrectLetterGuess(String guess);
	public boolean isCorrectWordGuess(String guess);
	public ArrayList<String> getGuessStatus();
	public ArrayList<String> getIncorrectLetterGuesses();
	public ArrayList<String> getGuessedLetters();
	public ArrayList<String> getGuessedWords();
	public int getNumIncorrectGuessesMade();
	public String getTargetWord();
}
