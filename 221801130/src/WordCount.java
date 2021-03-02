import java.io.*;
import java.util.*;

public class WordCount {
	private static int countChar = 0;
	private static int countWord = 0;
	private static int countLine = 0;
	private static Map<String,Integer> map;
	private String text;
	
	public WordCount(String fileName) throws IOException {
		map = new HashMap<String, Integer>();
        text = readFile(fileName);
        countChar = Lib.countChar(text);
        countWord = Lib.countLines(text);
        countLine = Lib.countWords(text, map);
    }

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String path = input.next();
		String outPutPath = input.next();
		WordCount wordCount = new WordCount(path);
		writeFile(outPutPath);
		    
	   
	}
	
	public static String readFile(String path) throws IOException {
		BufferedReader br = null;
		StringBuffer textBuffer = new StringBuffer();
		String content = null;
		int s;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			while ((s = br.read()) != -1)         
				textBuffer.append((char)s);			
			content = textBuffer.toString();
		} catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	    	br.close();
	    }
		return content;
	}

	public static void writeFile(String Path) throws IOException {
	    List<Map.Entry<String,Integer>> lstEntry = new ArrayList<>(map.entrySet());
	    lstEntry=Lib.getSortedList(map);
		 Iterator<Map.Entry<String,Integer>> iter = lstEntry.iterator();
		 int num = 0;
		 BufferedWriter writer = new BufferedWriter(new FileWriter(Path));
		 StringBuilder str = new StringBuilder("characters: " + countChar + '\n' + "words: " + countWord + '\n'
	                + "lines: " + countLine + '\n');
	     while (iter.hasNext()) {
	    	 Map.Entry<String,Integer> m = (Map.Entry<String,Integer>) iter.next();
	         str.append(m.getKey()).append(": ").append(m.getValue()).append("\n");
	         num ++;
	         if (num == 10)
	        	 break;
	     }
	     writer.write(str.toString());
	     writer.close();
	}
	
}