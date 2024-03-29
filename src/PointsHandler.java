
public class PointsHandler implements PointsHandlerInterface{
	private int totalPoints;
	
	final int DISPLAYEDPARTSPOINTSMULTIPLIER = 10;
	final int LETTERSGUESSEDPOINTSMULTIPLIER = 15;
	final int WORDGUESSEDPOINTSAMOUNT = 50;
	
	private GameDifficulty currDifficulty;
	
	public PointsHandler(GameDifficulty difficulty) {
		totalPoints = 0;
		this.currDifficulty = difficulty;
	}
	
	private int scaleGamePointsByDifficulty(int currPoints) {
		if(this.currDifficulty.equals(GameDifficulty.MEDIUM)) {
			return (int)(currPoints * 1.5);
		}
		
		if(this.currDifficulty.equals(GameDifficulty.HARD)) {
			return (int)(currPoints * 2.0);
		}
			
		return currPoints;
	}
	
	@Override
	public void calculatePoints(int numGuessesLeft, int numLettersGuessedCorrectly, boolean wasWordGuessed) {

		//Standardizes Input in Case of Miscalculation, Prevents Issues with Score Calculation if were to occur.
		if(numGuessesLeft < 0) {numGuessesLeft = 0;}
		if(numLettersGuessedCorrectly < 0) {numLettersGuessedCorrectly = 0;}
		
		int currPoints = (numGuessesLeft * DISPLAYEDPARTSPOINTSMULTIPLIER) + (numLettersGuessedCorrectly * LETTERSGUESSEDPOINTSMULTIPLIER);
		
		if(wasWordGuessed) {
			currPoints += WORDGUESSEDPOINTSAMOUNT;
		}
		
		currPoints = scaleGamePointsByDifficulty(currPoints);
		
		this.totalPoints = currPoints;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}
	
	public void setGamePointsDifficulty(GameDifficulty difficulty) {
		this.currDifficulty = difficulty;
	}
}
