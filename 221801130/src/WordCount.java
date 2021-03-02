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
		int countChar = 0;
		int countWord = 0;
		int countLine = 0;
		int num=0;
		boolean isWord = true;
		String s;
		StringBuffer textBuffer = new StringBuffer();
		String text;
		String [] textArrays;
		Map<String,Integer> map = new HashMap<String, Integer>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			while ((s = br.readLine()) != null) {		         
		        textBuffer.append(s);
		        textBuffer.append(" ");
				countChar += s.length();
				countLine++;
			}
			text = textBuffer.toString();
			text = text.toLowerCase();
			text = text.replaceAll("[^A-Za-z0-9]", " ");
			textArrays = text.split("\\s+");
			countWord = textArrays.length;
			for (int i = 0;i < textArrays.length;i ++) {
				if(textArrays[i].length() < 4) {
					countWord--;
				
				} else {
					isWord=true;
					for (int j = 0;j < 4;j ++) {
						if(!Character.isLetter(textArrays[i].charAt(j))) {
							countWord--;
							isWord=false;
							break;
						}
					}
					if (isWord == true) {
						int count=0;
						if (map.get(textArrays[i]) == null) {
							count=1;
						} else {
							count = map.get(textArrays[i]).intValue() + 1;
						}
						map.put(textArrays[i],count);	
					}
				}
			}
			List<Map.Entry<String,Integer>> lstEntry = new ArrayList<>(map.entrySet());
			System.out.println(countChar);
			System.out.println(countWord);
			System.out.println(countLine);
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
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}

