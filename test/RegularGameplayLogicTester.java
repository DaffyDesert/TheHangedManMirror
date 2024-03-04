import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegularGameplayLogicTester {

	RegularGameplayLogicInterface gameplayLogic;
	
	@BeforeEach
	void beforeEach() {
		gameplayLogic = new RegularGameplayLogic();
		gameplayLogic.startGame();
	}

	@Test
	void testStartGame() {
		gameplayLogic.startGame();
		
		String targetWord = gameplayLogic.getTargetWord();
		
		assert(targetWord != "");
	}
	
	@Test
	void testIsGameOverByLetter() {
		String targetWord = gameplayLogic.getTargetWord();
		
		for(int i = 0; i < targetWord.length(); i++) {
			gameplayLogic.isCorrectLetterGuess(String.valueOf(targetWord.charAt(i)));
		}
		
		
		boolean isGameOver = gameplayLogic.isGameOver();
		
		assertEquals(isGameOver, true);
	}
	
	@Test
	void testIsGameOverByWord() {
		String targetWord = gameplayLogic.getTargetWord();
		
		gameplayLogic.isCorrectWordGuess(targetWord);
		
		boolean isGameOver = gameplayLogic.isGameOver();
		
		assertEquals(isGameOver, true);
	}
	
	@Test
	void testIsGameOverByGuessLimit() {	
		for(int i = 0; i < 11; i++) {
			gameplayLogic.isCorrectLetterGuess("");
		}
		
		boolean isGameWon = gameplayLogic.isGameWon();
		
		assertEquals(isGameWon, false);
	}
	
	@Test
	void testIsGameWonByLetter() {
		String targetWord = gameplayLogic.getTargetWord();
		
		for(int i = 0; i < targetWord.length(); i++) {
			gameplayLogic.isCorrectLetterGuess(String.valueOf(targetWord.charAt(i)));
		}
		
		boolean isGameWon = gameplayLogic.isGameWon();
		
		assertEquals(isGameWon, true);
	}
	
	@Test
	void testIsGameWonByWord() {
		String targetWord = gameplayLogic.getTargetWord();
		
		gameplayLogic.isCorrectWordGuess(targetWord);
		
		boolean isGameWon = gameplayLogic.isGameWon();
		
		assertEquals(isGameWon, true);
	}
	
	@Test
	void testIsNotGameWonByLetter() {		
		gameplayLogic.isCorrectLetterGuess("W");
		
		boolean isGameWon = gameplayLogic.isGameWon();
		
		assertEquals(isGameWon, false);
	}
	
	@Test
	void testIsNotGameWonByWord() {
		String targetWord = "!";
		
		gameplayLogic.isCorrectWordGuess(targetWord);
		
		boolean isGameWon = gameplayLogic.isGameWon();
		
		assertEquals(isGameWon, false);
	}
}
