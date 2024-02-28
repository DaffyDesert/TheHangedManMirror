
public class LetterGuessChecker implements GuessAnswer {
	private String targetWord;
	
	LetterGuessChecker(String targetWord) {
		this.targetWord = targetWord;
	}
	
	private boolean isValidEnglishCharacter(char letter) {
		return Character.isLetterOrDigit(letter);
	}
	
	private boolean isLetterInput(String word) {
		return word.length() == 1;
	}
	
	@Override
	public boolean isValidGuess(String guess) {
		if(isLetterInput(guess) && isValidEnglishCharacter(guess.charAt(0))) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean isCorrectGuess(String guess) {
		
		if(!isValidGuess(guess)) {
			return false;
		}
		
		//Converts the input string to a lower case character
		char letter = Character.toLowerCase(guess.charAt(0));
		
		//Creates a temporary lower case version of word, keeps target word's integrity intact
		String targetWordLowerCase = targetWord.toLowerCase();
		
		//indexOf STL function returns -1 if the character is not found in the string
		return targetWordLowerCase.indexOf(letter) != -1;
	}
	
	public void setWord(String targetWord) {
		this.targetWord = targetWord;
	}
	
	public String getWord() {
		return this.targetWord;
	}
}
