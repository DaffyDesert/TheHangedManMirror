/**
 * File Name: WordGuess.java
 * Purpose:
 *  The purpose of the WordGues class file is to
 *  handle the logic required for the user to be able to guess what
 *  the entire word is in a game of hangman, instead of attempting to guess
 *  a single letter.
 */

 public class WordGuessChecker implements GuessAnswerInterface {

	 private String targetWord;
    
	 public WordGuessChecker(String targetWord) {
		 this.targetWord = targetWord;
	 }

	@Override
	public boolean isValidGuess(String guess) {
		
		if(guess == "") {
			return false;
		}
		
		for(int i = 0; i < guess.length(); i++) {
			char letter = guess.charAt(i);
			if(!Character.isAlphabetic(letter)) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean isCorrectGuess(String guess) {
		return guess.equals(targetWord);
	}

	@Override
	public void setTargetWord(String targetWord) {
		this.targetWord = targetWord;
	}

	@Override
	public String getTargetWord() {
		return targetWord;
	}
 }