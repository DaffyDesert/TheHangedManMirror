import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArcadeGameplayLogicTester {

	private GameplayLogicInterface gameplayLogic;
	
	@BeforeEach
	void setUp() throws Exception {
		gameplayLogic = new ArcadeGameplayLogic();
	}
	
	@Test
	void testDefaultScore() {		
		int providedScore = gameplayLogic.getGamePoints();
		
		assertEquals(providedScore, 0);
	}

	@Test
	void testCorrectPointsCalculatedOneRound() {
		gameplayLogic.startGame(GameDifficulty.EASY);
		String word = gameplayLogic.getTargetWord();
		gameplayLogic.isCorrectWordGuess(word);
		gameplayLogic.calculateGamePoints();
		
		int score = gameplayLogic.getGamePoints();
		
		assertEquals(score, 160);
		
	}

	@Test
	void testCorrectPointsCalculatedTwoRounds() {
		
		String currWord;
		
		gameplayLogic.startGame(GameDifficulty.EASY);
		currWord = gameplayLogic.getTargetWord();
		gameplayLogic.isCorrectWordGuess(currWord);
		gameplayLogic.calculateGamePoints();
		
		gameplayLogic.startGame(GameDifficulty.HARD);
		currWord = gameplayLogic.getTargetWord();
		gameplayLogic.isCorrectWordGuess(currWord);
		gameplayLogic.calculateGamePoints();
		
		int score = gameplayLogic.getGamePoints();
		
		assertEquals(score, 480);
	}
	
	@Test
	void testCorrectPointsCalculatedMultipleRounds() {
		
		String currWord;
		
		gameplayLogic.startGame(GameDifficulty.EASY);
		currWord = gameplayLogic.getTargetWord();
		gameplayLogic.isCorrectWordGuess(currWord);
		gameplayLogic.calculateGamePoints();
		
		gameplayLogic.startGame(GameDifficulty.MEDIUM);
		currWord = gameplayLogic.getTargetWord();
		gameplayLogic.isCorrectWordGuess(currWord);
		gameplayLogic.calculateGamePoints();
		
		gameplayLogic.startGame(GameDifficulty.HARD);
		currWord = gameplayLogic.getTargetWord();
		gameplayLogic.isCorrectWordGuess(currWord);
		gameplayLogic.calculateGamePoints();
		
		int score = gameplayLogic.getGamePoints();
		
		assertEquals(score, 720);
	}
}
