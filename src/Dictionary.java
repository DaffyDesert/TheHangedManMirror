import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// Documentation up next
public class Dictionary implements DictionaryInterface {

	private List<String> WordList;
	private int WordCount;
	private String FileName;
	
	public Dictionary(String FileName) {
		this.FileName = FileName;
		this.WordCount = 0;
		this.WordList = new ArrayList<String>();
		
		populateWordList();
	}
	
	public boolean populateWordList() {
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(FileName));
			
			String str = fileReader.readLine();
			while ((str != null) && (str.length() != 0)) {
				
				if (str.length() >= 3)
					WordList.add(str.toLowerCase());
				
				str = fileReader.readLine();
			}
			
			fileReader.close();
			
			this.WordCount = WordList.size();
			
			return true;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String getWord() {
		Random rand1 = new Random();
		int seed2 = rand1.nextInt();
		Random rand2 = new Random(seed2);
		int seed3 = rand2.nextInt();
		Random rand3 = new Random(seed3);
		int index = rand3.nextInt(WordCount);
		
		return WordList.get(index);
	}
	
}
