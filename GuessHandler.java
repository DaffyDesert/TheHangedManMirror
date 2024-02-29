import java.util.ArrayList;
import java.util.Collections;

public class GuessHandler implements GuessHandlerInterface{
	private final int maxGuesses = 11;
	
	private String targetWord;
	private int numGuessesMade;
	private boolean hasGuessedCorrectWord;
	
	private GuessAnswerInterface guessLetterAnswer;
	private GuessAnswerInterface guessWordAnswer;
	
	private ArrayList<String> guessedLetters;
	private ArrayList<String> guessedWords;

	GuessHandler(String targetWord) {
		this.targetWord = targetWord;
		this.numGuessesMade = 0;
		this.hasGuessedCorrectWord = false;
		
		guessedLetters = new ArrayList<String>();
		guessedWords = new ArrayList<String>();
		
		guessLetterAnswer = new LetterGuessChecker(targetWord);
		guessWordAnswer = new WordGuessChecker(targetWord);
	}
	
	@Override
	public boolean hasGuessedEveryLetterInWord() {
		for(int i = 0; i < targetWord.length(); i++) {
			if(!guessedLetters.contains(String.valueOf(targetWord.charAt(i)))) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean hasGuessedCorrectWord() {
		return hasGuessedCorrectWord;
	}
	
	@Override
	public boolean isAtGuessLimit() {
		return numGuessesMade >= maxGuesses;
	}
	
	@Override
	public boolean targetWordGuessedSuccessfully() {
		if(hasGuessedEveryLetterInWord() || hasGuessedCorrectWord()) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean hasGuessedLetterBefore(String guess) {
		return guessedLetters.contains(guess);
	}
	
	@Override
	public boolean hasGuessedWordBefore(String guess) {
		return guessedWords.contains(guess);
	}
	
	
	@Override
	public boolean isValidLetterGuess(String guess) {
		return guessLetterAnswer.isValidGuess(guess);
	}
	
	@Override
	public boolean isValidWordGuess(String guess) {		
		return guessWordAnswer.isValidGuess(guess);
	}
	
	@Override
	public boolean isCorrectLetterGuess(String guess) {
		guessedLetters.add(guess);
		numGuessesMade += 1;
		
		return guessLetterAnswer.isCorrectGuess(guess);
	}
	
	@Override
	public boolean isCorrectWordGuess(String guess) {
		guessedWords.add(guess);
		numGuessesMade += 1;
		
		hasGuessedCorrectWord = guessWordAnswer.isCorrectGuess(guess);
		return hasGuessedCorrectWord;
	}

	@Override
	public ArrayList<String> getGuessStatus() {
		ArrayList<String> guessStatusList = new ArrayList<String>(Collections.nCopies(targetWord.length(), "-"));
		
		for(int i = 0; i < targetWord.length(); i++) {
			String currentLetter = String.valueOf(targetWord.charAt(i));
			
			if(!hasGuessedCorrectWord) {
				if(guessedLetters.contains(currentLetter)) {
					guessStatusList.set(i, currentLetter);
				}
			}
			else {
				guessStatusList.set(i, currentLetter);
			}
		}
		
		return guessStatusList;
	}
	
	@Override
	public ArrayList<String> getIncorrectLetterGuesses() {
		ArrayList<String> incorrectLetterGuesses = new ArrayList<String>();
		
		for(int i = 0; i < guessedLetters.size(); i++) {
			String guessedLetter = guessedLetters.get(i);
			if(!targetWord.contains(guessedLetter)) {
				incorrectLetterGuesses.add(guessedLetter);
			}
		}
		
		return incorrectLetterGuesses;
	}
	
	@Override
	public ArrayList<String> getGuessedLetters() {
		return guessedLetters;
	}
	
	@Override
	public ArrayList<String> getGuessedWords() {
		return guessedWords;
	}
	
	@Override
	public int getNumGuessesMade() {
		return numGuessesMade;
	}
}
