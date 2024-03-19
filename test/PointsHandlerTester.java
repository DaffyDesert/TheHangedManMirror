import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PointsHandlerTester {

	private PointsHandlerInterface pointsHandler;
	
	@BeforeEach
	void setUp() throws Exception {
		pointsHandler = new PointsHandler();
	}

	@Test
	void testRegularScoreCalculation() {
		int expectedPoints = 140;
		
		pointsHandler.calculatePoints(5, 6, false);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testRegularScoreCalculationCase2() {
		int expectedPoints = 230;
		
		pointsHandler.calculatePoints(9, 6, true);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testGuessedWordOnFirstGuess () {
		int expectedPoints = 160;
		
		pointsHandler.calculatePoints(11, 0, true);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testMinimumScoreCalculation() {
		int expectedPoints = 0;
		
		pointsHandler.calculatePoints(0, 0, false);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testRegularScoreCalculationWithWordGuessed() {
		int expectedPoints = 190;
		
		pointsHandler.calculatePoints(5, 6, true);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testScoreCalculationWithNoGuessesLeft() {
		int expectedPoints = 90;
		
		pointsHandler.calculatePoints(0, 6, false);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testScoreCalculationWithNoLettersGuessed() {
		int expectedPoints = 50;
		
		pointsHandler.calculatePoints(5, 0, false);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testScoreCalculationWithNegativeGuessesLeft() {
		int expectedPoints = 90;
		
		pointsHandler.calculatePoints(-10, 6, false);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testScoreCalculationWithNegativeLettersGuessed() {
		int expectedPoints = 50;
		
		pointsHandler.calculatePoints(5, -20, false);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}
	
	@Test
	void testScoreCalculationWithAllNegativeValuesGuessed() {
		int expectedPoints = 0;
		
		pointsHandler.calculatePoints(-20, -20, false);
		
		assertEquals(expectedPoints, pointsHandler.getTotalPoints());
	}

}
