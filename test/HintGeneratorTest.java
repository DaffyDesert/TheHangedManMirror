import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HintGeneratorTest {

	public static int getDistinctChars(String word) {
		HashSet<Character> hs = new HashSet<Character>();
		
		for (int i = 0; i < word.length(); i++) {
			hs.add(word.charAt(i));
		}
		
		return hs.size();
	}
	
	public static void main(String[] args) {
		WordGenerator dictionary;
		HintGenerator hints;
		List<String> words;
		String word1;
		String word2;
		String word3;
		
		System.out.println("Generating test criteria...");
		
		dictionary = new WordGenerator();
		words = new ArrayList<String>();
		word1 = "bagel";
		word2 = "cereal";
		word3 = dictionary.getWord(GameDifficulty.ALL);
		words.add(word1); words.add(word2); words.add(word3);
		
		System.out.println("Testing the Hint Generator class...");
		
		for (String word : words) {
			System.out.println("Word: " + word + "");
			hints = new HintGenerator(word);
			hints.generateHint();
			
			System.out.println("First random hint: " + hints.getHint());
			System.out.println("First deduction: " + hints.getPointDeduction());
			System.out.println("Resetting Hint Generator...");
			
			hints = new HintGenerator(word);
			
			System.out.println("Guessing letter a...");
			
			hints.addUsedChar('a');
			
			int uniqueLetterCount = getDistinctChars(word);
			
			for (int i = 0; i < uniqueLetterCount - 1; i++) {
				System.out.println("Checking hints for a...");
				hints.generateHint();
				System.out.println("Hint " + String.valueOf(i + 1) + ": " + hints.getHint());
			}
			System.out.println("Total deduction: " + hints.getPointDeduction());
			
			System.out.println("Resetting Hint Generator...");
			
			hints = new HintGenerator(word);
			for (int i = 0; i < uniqueLetterCount; i++) {
				System.out.println("Generating all hints");
				hints.generateHint();
				System.out.println("Hint " + String.valueOf(i + 1) + ": " + hints.getHint());
			}
			System.out.println("Total deduction: " + hints.getPointDeduction());
			System.out.println();
		}
	}

}
