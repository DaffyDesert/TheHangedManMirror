
public class LetterGuessChecker implements GuessAnswerInterface {
	private String targetWord;
	
	LetterGuessChecker(String targetWord) {
		this.targetWord = targetWord;
	}
	
	private boolean isValidEnglishCharacter(char letter) {
		return Character.isLetterOrDigit(letter);
	}
	
	private boolean isLetterInput(String guess) {
		//Determines if guess provided is a single character
		return guess.length() == 1;
	}
	
	@Override
	public boolean isValidGuess(String guess) {
		return isLetterInput(guess) && isValidEnglishCharacter(guess.charAt(0));
	}
	
	@Override
	public boolean isCorrectGuess(String guess) {
		
		if(!isValidGuess(guess)) {
			return false;
		}
		
		//Converts the input string to a lower case character
		char letter = Character.toLowerCase(guess.charAt(0));
		
		//indexOf STL function returns -1 if the character is not found in the lower-case string
		return targetWord.toLowerCase().indexOf(letter) != -1;
	}
	
	@Override
	public void setTargetWord(String targetWord) {
		this.targetWord = targetWord;
	}
	
	@Override
	public String getTargetWord() {
		return this.targetWord;
	}
}
