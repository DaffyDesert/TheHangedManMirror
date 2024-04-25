
public interface PointsHandlerInterface {
	public void calculatePoints(int numUndisplayedParts, int numLettersGuessedCorrectly, boolean wasWordGuessed, int hintPointDeduction);
	public int getTotalPoints();
	public void setTotalPoints(int totalPoints);
	public void setGamePointsDifficulty(GameDifficulty difficulty);
}
