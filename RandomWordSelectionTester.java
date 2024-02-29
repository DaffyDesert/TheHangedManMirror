
public class RandomWordSelectionTester {

	public static void main(String[] args) {
		Dictionary dict = new Dictionary("src/Words.txt");
		if (!dict.populateWordList()) {
			System.out.println("Error reading from dictionary file.");
			System.exit(1);
		}
		
		System.out.println("Generated word 1: " + dict.getWord());
		System.out.println("Generated word 2: " + dict.getWord());
		System.out.println("Generated word 3: " + dict.getWord());
	}
}
