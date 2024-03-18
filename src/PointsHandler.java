
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
		
		System.out.println(numGuessesLeft);
		System.out.println(numLettersGuessedCorrectly);
		System.out.println(wasWordGuessed);
		
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
