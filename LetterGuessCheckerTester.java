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
		char guessedLetter = 'a';
		
		Boolean isValid = letterChecker.isValidEnglishCharacter(guessedLetter);
		
		assertEquals(isValid, true);
	}
	
	@Test
	void testValidLetterUpperCase() {
		char guessedLetter = 'C';
		
		Boolean isValid = letterChecker.isValidEnglishCharacter(guessedLetter);
		
		assertEquals(isValid, true);
	}
	
	@Test
	void testValidLetterNumber() {
		char guessedLetter = '9';
		
		Boolean isValid = letterChecker.isValidEnglishCharacter(guessedLetter);
		
		assertEquals(isValid, true);
	}
	
	@Test
	void testValidLetterSpecialSymbol() {
		char guessedLetter = '!';
		
		Boolean isValid = letterChecker.isValidEnglishCharacter(guessedLetter);
		
		assertEquals(isValid, false);
	}
	
	@Test
	void testLetterInWord() {
		char guessedLetter = 'a';
		
		Boolean inWord = letterChecker.letterInWord(guessedLetter);
		
		assertEquals(inWord, true);
	}
	
	@Test
	void testLetterInWordIgnoreCase() {
		char guessedLetter = 'h';
		char secondGuessedLetter = 'm';
		
		Boolean firstIsInWord = letterChecker.letterInWord(guessedLetter);
		Boolean secondIsInWord = letterChecker.letterInWord(secondGuessedLetter);
		
		assertEquals(firstIsInWord, true);
		assertEquals(secondIsInWord, true);
	}
	
	@Test
	void testLetterInWordInvalid() {
		char guessedLetter = '!';
		
		Boolean inWord = letterChecker.letterInWord(guessedLetter);
		
		assertEquals(inWord, false);
	}
	
	@Test
	void testLetterInWordDifferentAlphabet() {
		char guessedLetter = 'щ';
		
		Boolean inWord = letterChecker.letterInWord(guessedLetter);
		
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
