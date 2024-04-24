
public class ArcadeGameplayLogic extends RegularGameplayLogic {
	private int totalScore;
	
	ArcadeGameplayLogic() {
		super();
		this.totalScore = 0;
	}
	
	@Override
	public void calculateGamePoints() {
		super.calculateGamePoints();
		totalScore += super.getGamePoints();
	}
	
	@Override
	public int getGamePoints() {
		return totalScore;
	}
}
