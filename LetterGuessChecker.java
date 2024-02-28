
public class LetterGuessChecker {
	private String targetWord;
	
	LetterGuessChecker(String targetWord) {
		this.targetWord = targetWord;
	}
	
	boolean isValidEnglishCharacter(char letter) {
		return Character.isLetterOrDigit(letter);
	}
	
	boolean letterInWord(char letter) {
		
		Character.toLowerCase(letter);
		
		if(!isValidEnglishCharacter(letter)) {
			return false;
		}
		
		//Creates a temporary lower case version of word, keeps target word's integrity intact
		String targetWordLowerCase = targetWord.toLowerCase();
		
		//indexOf STL function returns -1 if the character is not found in the string
		return targetWordLowerCase.indexOf(letter) != -1;
	}
	
	void setWord(String targetWord) {
		this.targetWord = targetWord;
	}
	
	String getWord() {
		return this.targetWord;
	}
	
}
