import java.util.ArrayList;
import java.util.Collections;

public class GuessHandler implements GuessHandlerInterface{
	private final int maxGuesses = 11;
	
	private String targetWord;
	private int numIncorrectGuessesMade;
	private boolean hasGuessedCorrectWord;
	
	private GuessAnswerInterface guessLetterAnswer;
	private GuessAnswerInterface guessWordAnswer;
	
	private ArrayList<String> guessedLetters;
	private ArrayList<String> guessedWords;

	GuessHandler(String targetWord) {
		this.targetWord = targetWord;
		this.numIncorrectGuessesMade = 0;
		this.hasGuessedCorrectWord = false;
		
		guessedLetters = new ArrayList<String>();
		guessedWords = new ArrayList<String>();
		
		guessLetterAnswer = new LetterGuessChecker(targetWord);
		guessWordAnswer = new WordGuessChecker(targetWord);
	}
	
	
	public boolean hasGuessedEveryLetterInWord() {
		for(int i = 0; i < targetWord.length(); i++) {
			if(!guessedLetters.contains(String.valueOf(targetWord.charAt(i)).toUpperCase())) {
				return false;
			}
		}
		return true;
	}
	
	
	public boolean hasGuessedCorrectWord() {
		return hasGuessedCorrectWord;
	}
	
	
	public boolean isAtGuessLimit() {
		return numIncorrectGuessesMade >= maxGuesses;
	}
	
	
	public boolean targetWordGuessedSuccessfully() {
		if(hasGuessedEveryLetterInWord() || hasGuessedCorrectWord()) {
			return true;
		}
		
		return false;
	}
	
	
	public boolean hasGuessedLetterBefore(String guess) {
		for(int i = 0; i < guessedLetters.size(); i++) {
			if(guessedLetters.get(i).equalsIgnoreCase(guess)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public boolean hasGuessedWordBefore(String guess) {
		for(int i = 0; i < guessedWords.size(); i++) {
			if(guessedWords.get(i).equalsIgnoreCase(guess)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
	public boolean isValidLetterGuess(String guess) {
		return guessLetterAnswer.isValidGuess(guess);
	}
	
	
	public boolean isValidWordGuess(String guess) {		
		return guessWordAnswer.isValidGuess(guess);
	}
	
	
	public boolean isCorrectLetterGuess(String guess) {
		guessedLetters.add(guess.toUpperCase());
		
		if(!guessLetterAnswer.isCorrectGuess(guess)) {
			numIncorrectGuessesMade += 1;
			return false;
		}
		
		return true;
	}
	
	
	public boolean isCorrectWordGuess(String guess) {
		guessedWords.add(guess.toUpperCase());
		hasGuessedCorrectWord = guessWordAnswer.isCorrectGuess(guess);
		
		if(!hasGuessedCorrectWord) {
			numIncorrectGuessesMade += 1;
			return false;
		}
		
		return true;
	}

	
	public ArrayList<String> getGuessStatus() {
		ArrayList<String> guessStatusList = new ArrayList<String>(Collections.nCopies(targetWord.length(), ""));
		
		for(int i = 0; i < targetWord.length(); i++) {
			String currentLetter = String.valueOf(targetWord.charAt(i));
			
			if(!hasGuessedCorrectWord) {
				if(hasGuessedLetterBefore(currentLetter)) {
					guessStatusList.set(i, currentLetter);
				}
			}
			else {
				guessStatusList.set(i, currentLetter);
			}
		}
		
		return guessStatusList;
	}
	
	
	public ArrayList<String> getIncorrectLetterGuesses() {
		ArrayList<String> incorrectLetterGuesses = new ArrayList<String>();
		
		for(int i = 0; i < guessedLetters.size(); i++) {
			String guessedLetter = guessedLetters.get(i);
			if(!targetWord.toUpperCase().contains(guessedLetter)) {
				incorrectLetterGuesses.add(guessedLetter);
			}
		}
		
		return incorrectLetterGuesses;
	}
	
	
	public ArrayList<String> getGuessedLetters() {
		return guessedLetters;
	}
	
	
	public ArrayList<String> getGuessedWords() {
		return guessedWords;
	}
	
	
	public int numIncorrectGuessesMade() {
		return numIncorrectGuessesMade;
	}

	public int getMaxGuesses() {
		return maxGuesses;
	}
}
