import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
	
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String path = input.next();
		BufferedReader br = null;
		int countChar = 0;
		int countWord = 0;
		int countLine = 0;
		int num=0;
		int s;
		StringBuffer textBuffer = new StringBuffer();
		String text;
		Map<String,Integer> map = new HashMap<String, Integer>();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			while ((s = br.read()) != -1)         
				textBuffer.append((char)s);			
			text = textBuffer.toString();
			countChar=Lib.countChar(text);
			countLine=Lib.countLines(text);
			countWord=Lib.countWords(text, map);
			System.out.println(countChar);
			System.out.println(countWord);
			System.out.println(countLine);
			List<Map.Entry<String,Integer>> lstEntry = new ArrayList<>(map.entrySet());
			Collections.sort(lstEntry,((o1, o2) -> {
				if (o1.getValue().equals(o2.getValue()))
                    return o1.getKey().compareTo(o2.getKey());
				else
					return o2.getValue().compareTo(o1.getValue());
		    }));
		    Iterator<Map.Entry<String,Integer>> iter = lstEntry.iterator();
		     while (iter.hasNext()) {
		    	 Map.Entry<String,Integer> m = (Map.Entry<String,Integer>) iter.next();
		         System.out.println(m.getKey() + ":" + m.getValue());
		         num ++;
		         if (num == 10)
		        	 break;
		     }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	    	br.close();
	    	input.close();
	    }
	}
	
}