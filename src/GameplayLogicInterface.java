import java.util.ArrayList;

public interface GameplayLogicInterface {
	public void startGame(GameDifficulty difficulty);
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
	public int getMaxGuesses();
	public void calculateGamePoints();
	public int getGamePoints();
	public GameDifficulty getGameDifficulty();
	public void addGuessToHintGen(char letter);
	public char generateHint();
}
