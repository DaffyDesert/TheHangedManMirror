import java.util.ArrayList;

public class RegularGameplayLogic implements RegularGameplayLogicInterface {
	private final String fileName = "Words.txt";
	private String targetWord;
	
	private DictionaryInterface dictionary;
	private GuessHandlerInterface guessHandler;
	
	RegularGameplayLogic() {	
		dictionary = new Dictionary(fileName);
	}
	
	/**
	 * Begins a new round of HangMan, and initializes the necessary materials
	 * Must be called to begin a new round
	 */
	public void startGame() {
		targetWord = dictionary.getWord();	
		guessHandler = new GuessHandler(targetWord);
	}
	
	//Determines if the Game is Over, Returns a Boolean on the game's condition
	public boolean isGameOver() {
		if(guessHandler.targetWordGuessedSuccessfully() || guessHandler.isAtGuessLimit()) {
			return true;
		}
		
		return false;
	}
	
	//Determines if the Game is Won, Returns a Boolean on the game's condition
	public boolean isGameWon() {
		return guessHandler.targetWordGuessedSuccessfully();
	}
	
	/*
	 * Determines if the letter guess provided is a valid letter character
	 * Excludes Numbers and Special Characters
	 * Used for User Validation Input for Letters
	 */
	public boolean isValidLetterGuess(String guess) {
		return guessHandler.isValidLetterGuess(guess);
	}
	
	/*
	 * Determines if the word guess provided is a word containing all valid letter character
	 * Excludes Numbers and Special Characters
	 * Used for User Validation Input for Words
	 */
	public boolean isValidWordGuess(String guess) {
		return guessHandler.isValidWordGuess(guess);
	}
	
	/*
	 * Determines if the letter guess provided has already been guessed by the user
	 * Returns a boolean on the status of the letter's guess state
	 * Used for User Validation Input for Letters
	 */
	public boolean hasGuessedLetterBefore(String guess) {
		return guessHandler.hasGuessedLetterBefore(guess);
	}
	
	/*
	 * Determines if the word guess provided has already been guessed by the user
	 * Returns a boolean on the status of the word's guess state
	 * Used for User Validation Input for Words
	 */
	public boolean hasGuessedWordBefore(String guess) {
		return guessHandler.hasGuessedWordBefore(guess);
	}
	
	/*
	 * Determines if the letter guess provided is contained within the target word
	 * Returns a boolean on the status of the letter's guess state
	 * Used to determine correctness of User Letter Guess Inputs
	 */
	public boolean isCorrectLetterGuess(String guess) {
		return guessHandler.isCorrectLetterGuess(guess);
	}
	
	/*
	 * Determines if the word guess provided is equal to the target word
	 * Returns a boolean on the status of the word's guess state
	 * Used to determine correctness of User Word Guess Inputs
	 */
	public boolean isCorrectWordGuess(String guess) {
		return guessHandler.isCorrectWordGuess(guess);
	}
	
	/**
	 * Returns the current guess state of the game
	 * Provides an ArrayList with all guessed letters in the appropriate indexes
	 * Includes empty strings in non-guessed locations, and guessed characters in guessed locations
	 * Example:
	 * 		TargetWord = "Games"
	 * 		Guesses = "G", "a", "s"
	 * 		Returned ArrayList = {"G", "a", "", "", "s"}
	 */
	public ArrayList<String> getGuessStatus() {
		return guessHandler.getGuessStatus();
	}
	
	/**
	 * Returns an ArrayList of incorrect letter guesses made by the user
	 * Characters are in the order that they were guessed
	 */
	public ArrayList<String> getIncorrectLetterGuesses() {
		return guessHandler.getIncorrectLetterGuesses();
	}
	
	/**
	 * Returns an ArrayList of all letter guesses made by the user
	 * Characters are in the order that they were guessed
	 */
	public ArrayList<String> getGuessedLetters() {
		return guessHandler.getGuessedLetters();
	}
	
	/**
	 * Returns an ArrayList of all word guesses made by the user
	 * Words are in the order that they were guessed
	 */
	public ArrayList<String> getGuessedWords() {
		return guessHandler.getGuessedWords();
	}
	
	//Returns the number of guessed made by the user so far
	public int getNumGuessesMade() {
		return guessHandler.getNumGuessesMade();
	}
	
	//Returns the target word chosen by the Game from the Dictionary
	public String getTargetWord() {
		return targetWord;
	}
}