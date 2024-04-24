
public class WordGenerator {
	
	private final String fileName = "res/Words.txt";
	private Dictionary dictionary;
	private GameDifficulty currentDifficulty;
	private int MINWORD_LENGTH = 6;
	private int MINHARD_WORDLENGTH = 7;
	private int MAXMED_WORDLENGTH = 8;

	// Constructor
	public WordGenerator() {
		this.dictionary = new Dictionary(fileName);
		this.currentDifficulty = GameDifficulty.NONE;
	}
	
	// Determines whether the given word meets the criteria for the easy difficulty
	// Easy criteria: Word must be less than 6 characters long
	private boolean isEasy(String word) {
		if(word.length() <= MINWORD_LENGTH) {
			return true;
		}
		return false;
	}
	
	// Determines whether the given word meets the criteria for the medium difficulty
	// Medium criteria: Word must be 6 - 8 characters long (inclusive) && have at least one character
	// which appears more than once
	private boolean isMedium(String word) {
		
		
		if(word.length() >= MINWORD_LENGTH && word.length() <= MAXMED_WORDLENGTH) {
			return hasRepeatChars(word);
		}
		return false;
	}
	
	// Determines whether the given word meets the criteria for the hard difficulty
	// Hard criteria: Word must be 7 characters or longer && no character in the word should appear more than once
	private boolean isHard(String word) {
		if(word.length() >= MINHARD_WORDLENGTH) {
			if(!hasRepeatChars(word)) {
				return true;
			}
		}
		return false;
	}
	
	//Determines Whether the given word contains repeating characters by comparing the full length of the string -Wil
	//to the number of distinct characters. -Wil
	private boolean hasRepeatChars(String word) {
		if(word.length() != word.chars().distinct().count()) {
			return true;
		}
		return false;
	}

	public String getWord(GameDifficulty difficulty) {
		this.currentDifficulty = difficulty;
		boolean loop = true;
		
		String word = "";
		while (loop) {
			word  = dictionary.getWord();
			if (difficulty == GameDifficulty.ALL || difficulty == GameDifficulty.ARCADE) return word;
			
			if (difficulty == GameDifficulty.EASY) {
				if (isEasy(word)) {
					loop = false;
				}
				else continue;
			}
			else if (difficulty == GameDifficulty.MEDIUM) {
				if (isMedium(word)) {
					loop = false;
				}
				else continue;
			}
			else if (difficulty == GameDifficulty.HARD) {
				if (isHard(word)) {
					loop = false;
				}
				else continue;
			}
		}
		
		return word;
	}
	
	public String getNextWord() {
		if (currentDifficulty == GameDifficulty.NONE) {
			System.out.println("Error in WordGenerator.java, cannot call " + 
					"WordGenerator.getNextWord() before calling WordGenerator.getWord(GameDifficulty)." + 
					" this.currentDifficulty not set! WordGenerator.getNextWord() returning null");
			return null;
		}
		
		return getWord(currentDifficulty);
	}
	
	public GameDifficulty getWordDifficulty(String word) {
		if (isEasy(word)) return GameDifficulty.EASY;
		else if (isMedium(word)) return GameDifficulty.MEDIUM;
		else return GameDifficulty.HARD;
	}
	
	public GameDifficulty getCurrentDifficulty() {
		return currentDifficulty;
	}
}
