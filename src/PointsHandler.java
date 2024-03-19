
public class PointsHandler implements PointsHandlerInterface{
	private int totalPoints;
	
	final int displayedPartsPointsMultiplier = 10;
	final int lettersGuessedPointsMultiplier = 15;
	final int wordGuessedPointsAmount = 50;
	
	public PointsHandler() {
		totalPoints = 0;
	}
	
	
	@Override
	public void calculatePoints(int numGuessesLeft, int numLettersGuessedCorrectly, boolean wasWordGuessed) {

		//Standardizes Input in Case of Miscalculation, Prevents Issues with Score Calculation if were to occur.
		if(numGuessesLeft < 0) {
			numGuessesLeft = 0;
		}
		
		if(numLettersGuessedCorrectly < 0) {
			numLettersGuessedCorrectly = 0;
		}
		
		int currPoints = (numGuessesLeft * displayedPartsPointsMultiplier) + (numLettersGuessedCorrectly * lettersGuessedPointsMultiplier);
		
		if(wasWordGuessed) {
			currPoints += wordGuessedPointsAmount;
		}
		
		this.totalPoints = currPoints;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}
}
