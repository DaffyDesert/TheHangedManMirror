
public class WordGenerator {
	
	private final String fileName = "res/Words.txt";
	private Dictionary dictionary;
	private GameDifficulty currentDifficulty;
	
	public WordGenerator() {
		this.dictionary = new Dictionary(fileName);
		this.currentDifficulty = GameDifficulty.NONE;
	}
	
	private boolean IsEasy(String word) {
		
	}
	
	private boolean IsMedium(String word) {
		
	}
	
	private boolean IsHard(String word) {
		
	}
	
	public String GetWord(GameDifficulty difficulty) {
		/*
		 * Sets the currentDifficulty to difficulty
		 * Loop
		 * 	Get a word from dictionary.GetWord
		 * 	Check if the difficulty is all
		 * 		If so, return the word.
		 * 	Check if the difficulty is easy and if the word satisfies that criteria
		 * 		If so, return it.
		 * 	Check if the difficulty is medium and if the word satisfies that criteria
		 * 		If so, return it.
		 * 	Check if the difficulty is hard and if the word satisfies that criteria
		 * 		If so, return it.
		 * End Loop
		 */
	}
	
	public String GetNextWord() {
		// Call GetWord using currentDifficulty as parameter unless currentDifficulty is none.
	}
	
	public GameDifficulty GetWordDifficulty(String word) {
		/*
		 * Pass the word into the criteria checking functions.
		 * Return the corresponding difficulty is is true.
		 * 
		 */
	}
	
	public GameDifficulty GetCurrentDifficulty() {
		return currentDifficulty;
	}
}
