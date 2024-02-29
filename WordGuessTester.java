import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordGuessTester {

	private GuessAnswerInterface guessChecker;
	
	@BeforeEach
	void beforeEach() {
		String targetWord = "The Hanged Man";
		guessChecker = new WordGuess(targetWord);
	}
	
	@Test
	void testValidWordLowerCase() {
		String guessedWord = "a";
		
		Boolean isValid = guessChecker.isValidGuess(guessedWord);
		
		assertEquals(isValid, true);
	}
	
	@Test
	void testValidWordUpperCase() {
		String guessedWord = "C";
		
		Boolean isValid = guessChecker.isValidGuess(guessedWord);
		
		assertEquals(isValid, true);
	}
	
	@Test
	void testValidWordNumber() {
		String guessedWord = "9";
		
		Boolean isValid = guessChecker.isValidGuess(guessedWord);
		
		assertEquals(isValid, false);
	}
	
	@Test
	void testValidWordSpecialSymbol() {
		String guessedWord = "!";
		
		Boolean isValid = guessChecker.isValidGuess(guessedWord);
		
		assertEquals(isValid, false);
	}
	
	@Test
	void testSingleWordProvided() {
		String guessedWord = "A";
		
		Boolean isValid = guessChecker.isValidGuess(guessedWord);
		
		assertEquals(isValid, true);
	}
	
	@Test
	void testOverOneWordProvided() {
		String guessedWord = "ABC";
		
		Boolean isValid = guessChecker.isValidGuess(guessedWord);
		
		assertEquals(isValid, true);
	}
	
	@Test
	void testEmptyWordProvided() {
		String guessedWord = "";
		
		Boolean isValid = guessChecker.isValidGuess(guessedWord);
		
		assertEquals(isValid, false);
	}
	
	@Test
	void testSpaceProvided() {
		String guessedWord = " ";
		
		Boolean isValid = guessChecker.isValidGuess(guessedWord);
		
		assertEquals(isValid, false);
	}
	
	@Test
	void testMultipleSpacesProvided() {
		String guessedWord = "    ";
		
		Boolean isValid = guessChecker.isValidGuess(guessedWord);
		
		assertEquals(isValid, false);
	}
	
	@Test
	void testValidGuessInDifferentAlphabet() {
		String guessedWordOne = "щ";
		String guessedWordTwo = "戈";
		
		Boolean isValidOne = guessChecker.isValidGuess(guessedWordOne);
		Boolean isValidTwo = guessChecker.isValidGuess(guessedWordTwo);
		
		assertEquals(isValidOne, true);
		assertEquals(isValidTwo, true);
	}
	
	@Test
	void testIsCorrectGuess() {
		String guessedWord = "The Hanged Man";
		
		Boolean isCorrect = guessChecker.isCorrectGuess(guessedWord);
		
		assertEquals(isCorrect, true);
	}
	
	@Test
	void testIsIncorrectGuess() {
		String guessedWord = "This is a Test";
		
		Boolean isCorrect = guessChecker.isCorrectGuess(guessedWord);
		
		assertEquals(isCorrect, false);
	}
	
	@Test
	void testIsIncorrectGuessSimilar() {
		String guessedWord = "The Hanging Man";
		
		Boolean isCorrect = guessChecker.isCorrectGuess(guessedWord);
		
		assertEquals(isCorrect, false);
	}
	
	@Test
	void testIsIncorrectGuessEmpty() {
		String guessedWord = "";
		
		Boolean isCorrect = guessChecker.isCorrectGuess(guessedWord);
		
		assertEquals(isCorrect, false);
	}
	
	@Test
	void testIsIncorrectGuessWithSpace() {
		String guessedWord = " ";
		
		Boolean isCorrect = guessChecker.isCorrectGuess(guessedWord);
		
		assertEquals(isCorrect, false);
	}
}
