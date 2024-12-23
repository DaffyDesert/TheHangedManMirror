import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PointsHandlerTester {

	private PointsHandlerInterface pointsHandler;
	
	@BeforeEach
	void setUp() throws Exception {
		pointsHandler = new PointsHandler(GameDifficulty.EASY);
	}

	@Test
	void testRegularScoreCalculation() {
		int expectedPoints = 140;
		
		pointsHandler.calculatePoints(5, 6, false, 0);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testRegularScoreCalculationCase2() {
		int expectedPoints = 230;
		
		pointsHandler.calculatePoints(9, 6, true, 0);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testGuessedWordOnFirstGuess () {
		int expectedPoints = 160;
		
		pointsHandler.calculatePoints(11, 0, true, 0);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testMinimumScoreCalculation() {
		int expectedPoints = 0;
		
		pointsHandler.calculatePoints(0, 0, false, 0);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testRegularScoreCalculationWithWordGuessed() {
		int expectedPoints = 190;
		
		pointsHandler.calculatePoints(5, 6, true, 0);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testScoreCalculationWithNoGuessesLeft() {
		int expectedPoints = 90;
		
		pointsHandler.calculatePoints(0, 6, false, 0);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testScoreCalculationWithNoLettersGuessed() {
		int expectedPoints = 50;
		
		pointsHandler.calculatePoints(5, 0, false, 0);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testScoreCalculationWithNegativeGuessesLeft() {
		int expectedPoints = 90;
		
		pointsHandler.calculatePoints(-10, 6, false, 0);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testScoreCalculationWithNegativeLettersGuessed() {
		int expectedPoints = 50;
		
		pointsHandler.calculatePoints(5, -20, false, 0);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testScoreCalculationWithAllNegativeValuesGuessed() {
		int expectedPoints = 0;
		
		pointsHandler.calculatePoints(-20, -20, false, 0);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testScoreCalculationOnNoneDifficulty() {
		int expectedPoints = 190;
		pointsHandler.setGamePointsDifficulty(GameDifficulty.NONE);
		
		pointsHandler.calculatePoints(5, 6, true, 0);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testScoreCalculationOnAllDifficulty() {
		int expectedPoints = 190;
		pointsHandler.setGamePointsDifficulty(GameDifficulty.ALL);
		
		pointsHandler.calculatePoints(5, 6, true, 0);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testScoreCalculationOnEasyDifficulty() {
		int expectedPoints = 190;
		pointsHandler.setGamePointsDifficulty(GameDifficulty.EASY);
		
		pointsHandler.calculatePoints(5, 6, true, 0);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testScoreCalculationOnMediumDifficulty() {
		int expectedPoints = 285;
		pointsHandler.setGamePointsDifficulty(GameDifficulty.MEDIUM);
		
		pointsHandler.calculatePoints(5, 6, true, 0);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testScoreCalculationOnHardDifficulty() {
		int expectedPoints = 380;
		pointsHandler.setGamePointsDifficulty(GameDifficulty.HARD);
		
		pointsHandler.calculatePoints(5, 6, true, 0);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}

}
