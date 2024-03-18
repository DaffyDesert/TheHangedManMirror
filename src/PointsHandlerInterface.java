
public interface PointsHandlerInterface {
	public void calculatePoints(int numUndisplayedParts, int numLettersGuessedCorrectly, boolean wasWordGuessed);
	public int getTotalPoints();
	public void setTotalPoints(int totalPoints);
}
