import java.util.Random;

// Generates hints in gameplay
public class HintGenerator implements HintInterface {

	// The number of points lost per each hint use
	private final int POINTS_PER_LETTER_GUESS = 15;
	
	private String word;        // The current word being guessed
	private char hintChar;      // The last hint generated by the generator
	private int lastDeduction;  // The point deduction caused by the last hint
	private int totalDeduction; // The total point deduction from hints guessed on the current word
	
	// Generates a default HintGenerator
	public HintGenerator() {
		this.word = "";
		this.hintChar = '\0';
		this.lastDeduction = 0;
		this.totalDeduction = 0;
	}
	
	// Generates a HintGenerator with the given word
	public HintGenerator(String word) {
		this.word = word;
		this.hintChar = '\0';
		this.lastDeduction = 0;
		this.totalDeduction = 0;
	}
	
	// Changes the word being guessed
	@Override
	public void changeWord(String word) {
		this.word = word;
		this.hintChar = '\0';
		this.lastDeduction = 0;
		this.totalDeduction = 0;
	}

	// Generates a random hint letter, moves to calculating the deduction it caused
	@Override
	public void generateHint() {
		Random rand1 = new Random();
		int seed2 = rand1.nextInt();
		Random rand2 = new Random(seed2);
		int seed3 = rand2.nextInt();
		Random rand3 = new Random(seed3);
		int index = rand3.nextInt(word.length());
		
		this.hintChar = word.charAt(index);
		calculateDeduction();
	}
	
	// Counts the number of occurrences of the hint char in the word, calculates point deduction
	// based on that
	@Override
	public void calculateDeduction() {
		int numOccurrences = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == hintChar) numOccurrences++;
		}
		
		this.lastDeduction = numOccurrences * POINTS_PER_LETTER_GUESS;
	}

	// Adds the temporary last deduction value to the total deductions, returns the hint char
	// This is done NOW rather than later so if the code calls generateHint() twice without
	// retrieving the hint, it doesn't ramp up the point deductions
	@Override
	public char getHint() {
		this.totalDeduction += lastDeduction;
		lastDeduction = 0;
		return hintChar;
	}

	// Returns the total calculated point deduction
	@Override
	public int getPointDeduction() {
		return totalDeduction;
	}

}
