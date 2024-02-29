
public interface GuessAnswerInterface {
	public boolean isValidGuess(String guess);
	public boolean isCorrectGuess(String guess);
	public void setTargetWord(String targetWord);
	public String getTargetWord();
}
