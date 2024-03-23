public class WordGeneratorTester {
    public static void main(String[] args) {
		WordGenerator wordGenerator = new WordGenerator();
		
        System.out.println("Generated word of Any Difficulty: " + wordGenerator.getWord(GameDifficulty.ALL));
		System.out.println("Generated word  of Easy Difficulty: " + wordGenerator.getWord(GameDifficulty.EASY));
		System.out.println("Generated word  of Medium Difficulty: " + wordGenerator.getWord(GameDifficulty.MEDIUM));
		System.out.println("Generated word  of Hard Difficulty: " + wordGenerator.getWord(GameDifficulty.HARD));
	}


}
