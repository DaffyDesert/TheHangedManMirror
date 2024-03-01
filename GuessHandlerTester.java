import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GuessHandlerTester {

	String targetWord;
	GuessHandlerInterface guessHandler;
	
	@BeforeEach
	void beforeEach() throws Exception {
		this.targetWord = "The Man";
		guessHandler = new GuessHandler(targetWord);
	}

	@Test
	void testHasGuessedEveryLetterInWord() {
		for(int i = 0; i < targetWord.length(); i++) {
			guessHandler.isCorrectLetterGuess(String.valueOf(targetWord.charAt(i)));
		}
		
		boolean hasGuessedAll = guessHandler.hasGuessedEveryLetterInWord();
		
		assertEquals(hasGuessedAll, true);
	}
	
	@Test
	void testHasNotGuessedEveryLetterInWord() {
		guessHandler.isCorrectLetterGuess("m");
		guessHandler.isCorrectLetterGuess("t");
		guessHandler.isCorrectLetterGuess("e");
		
		boolean hasGuessedAll = guessHandler.hasGuessedEveryLetterInWord();
		
		assertEquals(hasGuessedAll, false);
	}
	
	@Test
	void testHasGuessedCorrectWord() {
		guessHandler.isCorrectWordGuess("The Man");
		
		boolean hasGuessedWord = guessHandler.hasGuessedCorrectWord();
		
		assertEquals(hasGuessedWord, true);
	}
	
	@Test
	void testHasGuessedCorrectWordIgnoreCase() {
		guessHandler.isCorrectWordGuess("the man");
		
		boolean hasGuessedWord = guessHandler.hasGuessedCorrectWord();
		
		assertEquals(hasGuessedWord, true);
	}
	
	@Test
	void testHasNotGuessedCorrectWordIgnoreCase() {
		guessHandler.isCorrectWordGuess("man");
		
		boolean hasGuessedWord = guessHandler.hasGuessedCorrectWord();
		
		assertEquals(hasGuessedWord, false);
	}
	
	@Test
	void testIsAtGuessLimit() {
		for(int i = 0; i < 11; i++) {
			guessHandler.isCorrectLetterGuess("a");
		}
		
		boolean isAtLimit = guessHandler.isAtGuessLimit();
		
		assertEquals(isAtLimit, true);
	}

	@Test
	void testIsNotAtGuessLimit() {
		guessHandler.isCorrectLetterGuess(String.valueOf("t"));
		guessHandler.isCorrectLetterGuess(String.valueOf("h"));
		guessHandler.isCorrectLetterGuess(String.valueOf("e"));
		
		boolean isAtLimit = guessHandler.isAtGuessLimit();
		
		assertEquals(isAtLimit, false);
	}
	
	@Test
	void testTargetWordGuessedSuccessfullyByLetter() {
		for(int i = 0; i < targetWord.length(); i++) {
			guessHandler.isCorrectLetterGuess(String.valueOf(targetWord.charAt(i)));
		}
		
		boolean hasGuessedSuccessfully = guessHandler.targetWordGuessedSuccessfully();
		
		assertEquals(hasGuessedSuccessfully, true);
	}
	
	@Test
	void testTargetWordGuessedSuccessfullyByWord() {
		guessHandler.isCorrectWordGuess("The Man");
		
		boolean hasGuessedSuccessfully = guessHandler.targetWordGuessedSuccessfully();
		
		assertEquals(hasGuessedSuccessfully, true);
	}
	
	@Test
	void testHasGuessedLetterBefore() {
		guessHandler.isCorrectLetterGuess("a");
		
		boolean hasGuessedBefore = guessHandler.hasGuessedLetterBefore("a");
		
		assertEquals(hasGuessedBefore, true);
	}
	
	@Test
	void testHasGuessedLetterBeforeIgnoreCase() {
		guessHandler.isCorrectLetterGuess("a");
		
		boolean hasGuessedBefore = guessHandler.hasGuessedLetterBefore("A");
		
		assertEquals(hasGuessedBefore, true);
	}
	
	@Test
	void testHasNotGuessedLetterBeforeIgnoreCase() {
		guessHandler.isCorrectLetterGuess("a");
		
		boolean hasGuessedBefore = guessHandler.hasGuessedLetterBefore("b");
		
		assertEquals(hasGuessedBefore, false);
	}
	
	@Test
	void testHasGuessedWordBefore() {
		guessHandler.isCorrectWordGuess("abc");
		
		boolean hasGuessedBefore = guessHandler.hasGuessedWordBefore("abc");
		
		assertEquals(hasGuessedBefore, true);
	}
	
	@Test
	void testHasGuessedWordBeforeIgnoreCase() {
		guessHandler.isCorrectWordGuess("abc");
		
		boolean hasGuessedBefore = guessHandler.hasGuessedWordBefore("AbC");
		
		assertEquals(hasGuessedBefore, true);
	}
	
	@Test
	void testHasNotGuessedWordBeforeIgnoreCase() {
		guessHandler.isCorrectWordGuess("abc");
		
		boolean hasGuessedBefore = guessHandler.hasGuessedWordBefore("bcd");
		
		assertEquals(hasGuessedBefore, false);
	}
	
	@Test
	void testIsCorrectLetterGuessEffects() {
		int numGuesses = guessHandler.getNumGuessesMade();
		
		guessHandler.isCorrectLetterGuess("a");
		
		assertEquals(numGuesses + 1, guessHandler.getNumGuessesMade());
		assertEquals(guessHandler.hasGuessedLetterBefore("a"), true);
	}
	
	@Test
	void testIsNotCorrectLetterGuessEffects() {
		int numGuesses = guessHandler.getNumGuessesMade();
		
		guessHandler.isCorrectLetterGuess("z");
		
		assertEquals(numGuesses + 1, guessHandler.getNumGuessesMade());
		assertEquals(guessHandler.hasGuessedLetterBefore("z"), true);
	}
	
	@Test
	void testIsCorrectWordGuessEffects() {
		int numGuesses = guessHandler.getNumGuessesMade();
		
		guessHandler.isCorrectWordGuess("The Man");
		
		assertEquals(numGuesses + 1, guessHandler.getNumGuessesMade());
		assertEquals(guessHandler.hasGuessedWordBefore("The Man"), true);
	}
	
	@Test
	void testIsNotCorrectWordGuessEffects() {
		int numGuesses = guessHandler.getNumGuessesMade();
		
		guessHandler.isCorrectWordGuess("Not The Man");
		
		assertEquals(numGuesses + 1, guessHandler.getNumGuessesMade());
		assertEquals(guessHandler.hasGuessedWordBefore("Not The Man"), true);
	}
	
	@Test
	void testGetGuessStatus() {
		ArrayList<String> expectedStatus = new ArrayList<String>(Arrays.asList("T","h","","","M","","n"));
		
		guessHandler.isCorrectLetterGuess("T");
		guessHandler.isCorrectLetterGuess("h");
		guessHandler.isCorrectLetterGuess("M");
		guessHandler.isCorrectLetterGuess("n");
		
		ArrayList<String> providedStatus = guessHandler.getGuessStatus();
		
		assertEquals(expectedStatus, providedStatus);
	}
	
	@Test
	void testGetGuessStatusIgnoreCase() {
		ArrayList<String> expectedStatus = new ArrayList<String>(Arrays.asList("T","h","","","M","","n"));
		
		guessHandler.isCorrectLetterGuess("t");
		guessHandler.isCorrectLetterGuess("h");
		guessHandler.isCorrectLetterGuess("m");
		guessHandler.isCorrectLetterGuess("n");
		
		ArrayList<String> providedStatus = guessHandler.getGuessStatus();
		
		assertEquals(expectedStatus, providedStatus);
	}
	
	@Test
	void testGetIncorrectLetterGuesses() {
		ArrayList<String> expectedStatus = new ArrayList<String>(Arrays.asList("Z", "X", "Y", "R"));
		
		guessHandler.isCorrectLetterGuess("T");
		guessHandler.isCorrectLetterGuess("H");
		guessHandler.isCorrectLetterGuess("Z");
		guessHandler.isCorrectLetterGuess("X");
		guessHandler.isCorrectLetterGuess("Y");
		guessHandler.isCorrectLetterGuess("R");
		
		ArrayList<String> providedStatus = guessHandler.getIncorrectLetterGuesses();
		
		assertEquals(expectedStatus, providedStatus);
	}
	
	@Test
	void testGetIncorrectLetterGuessesIgnoreCase() {
		ArrayList<String> expectedStatus = new ArrayList<String>(Arrays.asList("Z", "X", "Y", "R"));
		
		guessHandler.isCorrectLetterGuess("t");
		guessHandler.isCorrectLetterGuess("H");
		guessHandler.isCorrectLetterGuess("z");
		guessHandler.isCorrectLetterGuess("X");
		guessHandler.isCorrectLetterGuess("y");
		guessHandler.isCorrectLetterGuess("R");
		
		ArrayList<String> providedStatus = guessHandler.getIncorrectLetterGuesses();
		
		assertEquals(expectedStatus, providedStatus);
	}
	
	@Test
	void testGetGuessedLetters() {
		ArrayList<String> expectedStatus = new ArrayList<String>(Arrays.asList("T", "H", "E", "R"));
		
		guessHandler.isCorrectLetterGuess("T");
		guessHandler.isCorrectLetterGuess("H");
		guessHandler.isCorrectLetterGuess("E");
		guessHandler.isCorrectLetterGuess("R");
		
		ArrayList<String> providedStatus = guessHandler.getGuessedLetters();
		
		assertEquals(expectedStatus, providedStatus);
	}
	
	@Test
	void testGetGuessedLettersIgnoreCase() {
		ArrayList<String> expectedStatus = new ArrayList<String>(Arrays.asList("T", "H", "E", "R"));
		
		guessHandler.isCorrectLetterGuess("T");
		guessHandler.isCorrectLetterGuess("h");
		guessHandler.isCorrectLetterGuess("E");
		guessHandler.isCorrectLetterGuess("r");
		
		ArrayList<String> providedStatus = guessHandler.getGuessedLetters();
		
		assertEquals(expectedStatus, providedStatus);
	}
	
	@Test
	void testGetGuessedWords() {
		ArrayList<String> expectedStatus = new ArrayList<String>(Arrays.asList("THE", "COLD", "DAY", "NEARS"));
		
		guessHandler.isCorrectWordGuess("THE");
		guessHandler.isCorrectWordGuess("COLD");
		guessHandler.isCorrectWordGuess("DAY");
		guessHandler.isCorrectWordGuess("NEARS");
		
		ArrayList<String> providedStatus = guessHandler.getGuessedWords();
		
		assertEquals(expectedStatus, providedStatus);
	}
	
	@Test
	void testGetGuessedWordsIgnoreCase() {
		ArrayList<String> expectedStatus = new ArrayList<String>(Arrays.asList("THE", "COLD", "DAY", "NEARS"));
		
		guessHandler.isCorrectWordGuess("The");
		guessHandler.isCorrectWordGuess("Cold");
		guessHandler.isCorrectWordGuess("Day");
		guessHandler.isCorrectWordGuess("Nears");
		
		ArrayList<String> providedStatus = guessHandler.getGuessedWords();
		
		assertEquals(expectedStatus, providedStatus);
	}
}
