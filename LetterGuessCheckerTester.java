import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LetterGuessCheckerTester {

	LetterGuessChecker letterChecker;
	
	@BeforeEach
	void beforeEach() {
		String targetWord = "The Hanged Man";
		letterChecker = new LetterGuessChecker(targetWord);
	}
	
	@Test
	void testValidLetterLowerCase() {
		String guessedLetter = "a";
		
		Boolean isValid = letterChecker.isValidGuess(guessedLetter);
		
		assertEquals(isValid, true);
	}
	
	@Test
	void testValidLetterUpperCase() {
		String guessedLetter = "C";
		
		Boolean isValid = letterChecker.isValidGuess(guessedLetter);
		
		assertEquals(isValid, true);
	}
	
	@Test
	void testValidLetterNumber() {
		String guessedLetter = "9";
		
		Boolean isValid = letterChecker.isValidGuess(guessedLetter);
		
		assertEquals(isValid, true);
	}
	
	@Test
	void testValidLetterSpecialSymbol() {
		String guessedLetter = "!";
		
		Boolean isValid = letterChecker.isValidGuess(guessedLetter);
		
		assertEquals(isValid, false);
	}
	
	@Test
	void testSingleLetterProvided() {
		String guessedLetter = "A";
		
		Boolean isValid = letterChecker.isValidGuess(guessedLetter);
		
		assertEquals(isValid, true);
	}
	
	@Test
	void testOverOneLetterProvided() {
		String guessedLetter = "ABC";
		
		Boolean isValid = letterChecker.isValidGuess(guessedLetter);
		
		assertEquals(isValid, false);
	}
	
	@Test
	void testEmptyLetterProvided() {
		String guessedLetter = "";
		
		Boolean isValid = letterChecker.isValidGuess(guessedLetter);
		
		assertEquals(isValid, false);
	}
	
	@Test
	void testValidGuessInDifferentAlphabet() {
		String guessedLetter = "щ";
		
		Boolean inWord = letterChecker.isValidGuess(guessedLetter);
		
		assertEquals(inWord, true);
	}
	
	@Test
	void testLetterInWord() {
		String guessedLetter = "a";
		
		Boolean inWord = letterChecker.isCorrectGuess(guessedLetter);
		
		assertEquals(inWord, true);
	}
	
	@Test
	void testLetterInWordIgnoreLowerCase() {
		String guessedLetter = "E";
		
		Boolean firstIsInWord = letterChecker.isCorrectGuess(guessedLetter);
		
		assertEquals(firstIsInWord, true);
	}
	
	@Test
	void testLetterInWordIgnoreUpperCase() {
		String guessedLetter = "h";
		
		Boolean firstIsInWord = letterChecker.isCorrectGuess(guessedLetter);
		
		assertEquals(firstIsInWord, true);
	}
	
	@Test
	void testLetterInWordInvalid() {
		String guessedLetter = "!";
		
		Boolean inWord = letterChecker.isCorrectGuess(guessedLetter);
		
		assertEquals(inWord, false);
	}
	
	@Test
	void testLetterInWordDifferentAlphabet() {
		String guessedLetter = "щ";
		
		Boolean inWord = letterChecker.isCorrectGuess(guessedLetter);
		
		assertEquals(inWord, false);
	}
	
	@Test
	void testSetWord() {
		String targetWord = "Updated Word";
		
		letterChecker.setWord(targetWord);
				
		assertEquals(letterChecker.getWord(), targetWord);
	}
	
	@Test
	void testGetWord() {
		String targetWord = letterChecker.getWord();
				
		assertEquals(targetWord, "The Hanged Man");
	}
}
