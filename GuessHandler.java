import java.util.ArrayList;
import java.util.Collections;

public class GuessHandler implements GuessHandlerInterface{
	private final int maxGuesses = 11;
	
	private String targetWord;
	private int numGuessesMade;
	
	private boolean hasGuessedCorrectWord;
	
	private GuessAnswerInterface guessLetterAnswer;
	private GuessAnswerInterface guessWordAnswer;
	
	private ArrayList<String> guessStatusList;
	private ArrayList<String> guessedLetters;
	private ArrayList<String> guessedWords;

	GuessHandler(String targetWord) {
		this.targetWord = targetWord;
		this.numGuessesMade = 0;
		this.hasGuessedCorrectWord = false;
		
		guessedLetters = new ArrayList<String>();
		guessLetterAnswer = new LetterGuessChecker(targetWord);
		guessStatusList = new ArrayList<String>(Collections.nCopies(targetWord.length(), ""));
	}
	
	public boolean hasGuessedEveryLetterInWord() {
		for(int i = 0; i < targetWord.length(); i++) {
			if(!guessedLetters.contains(String.valueOf(targetWord.charAt(i)))) {
				return false;
			}
		}
		return true;
	}
	
	public boolean hasGuessedCorrectWord() {
		return hasGuessedCorrectWord;
	}
	
	public boolean isOverGuessLimit() {
		return numGuessesMade >= maxGuesses;
	}
	
	public boolean targetWordGuessedSuccessfully() {
		if((hasGuessedEveryLetterInWord() || hasGuessedCorrectWord()) && !isOverGuessLimit()) {
			return true;
		}
		
		return false;
	}
	
	public boolean hasGuessedLetterBefore(String guess) {
		return guessedLetters.contains(guess);
	}
	
	public boolean isValidLetterGuess(String guess) {
		return guessLetterAnswer.isValidGuess(guess);
	}
	
	public boolean isValidWordGuess(String guess) {
		guessedWords.add(guess);
		updateGuessStatusList();
		numGuessesMade += 1;
		
		return hasGuessedCorrectWord = guessWordAnswer.isValidGuess(guess);
	}
	
	public boolean isCorrectLetterGuess(String guess) {
		guessedLetters.add(guess);
		updateGuessStatusList();
		numGuessesMade += 1;
		
		return guessLetterAnswer.isCorrectGuess(guess);
	}
	
	//Waiting on Word Guess to be Completed
	public boolean isCorrectWordGuess() {
		return false;
	}
	
	public void updateGuessStatusList() {
		for(int i = 0; i < targetWord.length(); i++) {
			
			String currentLetter = String.valueOf(targetWord.charAt(i));
			
			if(guessedLetters.contains(currentLetter)) {
				guessStatusList.set(i, currentLetter);
			}
			else {
				guessStatusList.set(i, "-");
			}
		}
	}
	
	public ArrayList<String> getGuessStatus() {		
		return guessStatusList;
	}
	
	public ArrayList<String> getGuessedLetters() {
		return guessedLetters;
	}
	
	public ArrayList<String> getGuessedWords() {
		return guessedWords;
	}
	
	public int getNumGuessesMade() {
		return numGuessesMade;
	}
}
