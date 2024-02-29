import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LetterGuessCheckerTester {

	GuessAnswerInterface guessChecker;
	
	@BeforeEach
	void beforeEach() {
		String targetWord = "The Hanged Man";
		guessChecker = new LetterGuessChecker(targetWord);
	}
	
	@Test
	void testValidLetterLowerCase() {
		String guessedLetter = "a";
		
		Boolean isValid = guessChecker.isValidGuess(guessedLetter);
		
		assertEquals(isValid, true);
	}
	
	@Test
	void testValidLetterUpperCase() {
		String guessedLetter = "C";
		
		Boolean isValid = guessChecker.isValidGuess(guessedLetter);
		
		assertEquals(isValid, true);
	}
	
	@Test
	void testValidLetterNumber() {
		String guessedLetter = "9";
		
		Boolean isValid = guessChecker.isValidGuess(guessedLetter);
		
		assertEquals(isValid, true);
	}
	
	@Test
	void testValidLetterSpecialSymbol() {
		String guessedLetter = "!";
		
		Boolean isValid = guessChecker.isValidGuess(guessedLetter);
		
		assertEquals(isValid, false);
	}
	
	@Test
	void testSingleLetterProvided() {
		String guessedLetter = "A";
		
		Boolean isValid = guessChecker.isValidGuess(guessedLetter);
		
		assertEquals(isValid, true);
	}
	
	@Test
	void testOverOneLetterProvided() {
		String guessedLetter = "ABC";
		
		Boolean isValid = guessChecker.isValidGuess(guessedLetter);
		
		assertEquals(isValid, false);
	}
	
	@Test
	void testEmptyLetterProvided() {
		String guessedLetter = "";
		
		Boolean isValid = guessChecker.isValidGuess(guessedLetter);
		
		assertEquals(isValid, false);
	}
	
	@Test
	void testValidGuessInDifferentAlphabet() {
		String guessedLetterOne = "щ";
		String guessedLetterTwo = "戈";
		
		Boolean isValidOne = guessChecker.isValidGuess(guessedLetterOne);
		Boolean isValidTwo = guessChecker.isValidGuess(guessedLetterTwo);
		
		assertEquals(isValidOne, true);
		assertEquals(isValidTwo, true);
	}
	
	@Test
	void testLetterInWord() {
		String guessedLetter = "a";
		
		Boolean inWord = guessChecker.isCorrectGuess(guessedLetter);
		
		assertEquals(inWord, true);
	}
	
	@Test
	void testLetterInWordIgnoreLowerCase() {
		String guessedLetter = "E";
		
		Boolean firstIsInWord = guessChecker.isCorrectGuess(guessedLetter);
		
		assertEquals(firstIsInWord, true);
	}
	
	@Test
	void testLetterInWordIgnoreUpperCase() {
		String guessedLetter = "h";
		
		Boolean firstIsInWord = guessChecker.isCorrectGuess(guessedLetter);
		
		assertEquals(firstIsInWord, true);
	}
	
	@Test
	void testLetterInWordInvalid() {
		String guessedLetter = "!";
		
		Boolean inWord = guessChecker.isCorrectGuess(guessedLetter);
		
		assertEquals(inWord, false);
	}
	
	@Test
	void testLetterInWordDifferentAlphabet() {
		String guessedLetterOne = "щ";
		String guessedLetterTwo = "戈";
		
		Boolean inWordOne = guessChecker.isCorrectGuess(guessedLetterOne);
		Boolean inWordTwo = guessChecker.isCorrectGuess(guessedLetterTwo);
		
		assertEquals(inWordOne, false);
		assertEquals(inWordTwo, false);
	}
	
	@Test
	void testSetWord() {
		String targetWord = "Updated Word";
		
		guessChecker.setTargetWord(targetWord);
				
		assertEquals(guessChecker.getTargetWord(), targetWord);
	}
	
	@Test
	void testGetWord() {
		String targetWord = guessChecker.getTargetWord();
				
		assertEquals(targetWord, "The Hanged Man");
	}
}
