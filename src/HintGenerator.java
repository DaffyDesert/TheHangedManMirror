import java.util.Random;
import java.util.List;
import java.util.ArrayList;

// Generates hints in gameplay
public class HintGenerator implements HintInterface {

	// The number of points lost per each hint use
	private final int POINTS_PER_LETTER_GUESS = 15;
	
	private String word;        		// The current word being guessed
	private char hintChar;      		// The last hint generated by the generator
	private int lastDeduction;  		// The point deduction caused by the last hint
	private int totalDeduction;         // The total point deduction from hints 
										// guessed on the current word
	private List<Character> usedHints;  // The list of all letters already used from hints
	
	// Generates a default HintGenerator
	public HintGenerator() {
		this.word = "";
		this.hintChar = '\0';
		this.lastDeduction = 0;
		this.totalDeduction = 0;
		this.usedHints = new ArrayList<Character>();
	}
	
	// Generates a HintGenerator with the given word
	public HintGenerator(String word) {
		this.word = word;
		this.hintChar = '\0';
		this.lastDeduction = 0;
		this.totalDeduction = 0;
		this.usedHints = new ArrayList<Character>();
	}
	
	// Changes the word being guessed
	@Override
	public void changeWord(String word) {
		this.word = word;
		this.hintChar = '\0';
		this.lastDeduction = 0;
		this.totalDeduction = 0;
		this.usedHints = new ArrayList<Character>();
	}

	// Generates a random hint letter, moves to calculating the deduction it caused
	@Override
	public void generateHint() {
		do {
			Random rand1 = new Random();
			int seed2 = rand1.nextInt();
			Random rand2 = new Random(seed2);
			int seed3 = rand2.nextInt();
			Random rand3 = new Random(seed3);
			int index = rand3.nextInt(word.length());
			
			this.hintChar = word.charAt(index);
		} while (usedHints.contains(hintChar));
		
		calculateDeduction();
	}
	
	// Counts the number of occurrences of the hint char in the word, calculates point deduction
	// based on that
	@Override
	public void calculateDeduction() {
		this.lastDeduction = POINTS_PER_LETTER_GUESS;
	}

	// Adds the temporary last deduction value to the total deductions, returns the hint char
	// This is done NOW rather than later so if the code calls generateHint() twice without
	// retrieving the hint, it doesn't ramp up the point deductions
	@Override
	public char getHint() {
		this.totalDeduction += lastDeduction;
		this.lastDeduction = 0;
		this.usedHints.add(hintChar);
		return hintChar;
	}

	// Returns the total calculated point deduction
	@Override
	public int getPointDeduction() {
		return totalDeduction;
	}

	// Adds a user's correct guess to the usedHints array so it doesn't generate a duplicate
	@Override
	public void addUsedChar(char letter) {
		usedHints.add(letter);
	}

}
