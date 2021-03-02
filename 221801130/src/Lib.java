import java.io.*;
import java.util.*;
public class Lib {

	public static int countChar(String text) {
        return text.length();
    }
	
	public static int countLines(String text) {
        int count = 0;
        String[] textArrays = text.split("\n|\r\n");
        for (String validLine : textArrays) {
            if (!validLine.replaceAll("\r|\n", "").trim().equals("")) {
                count++;
            }
        }
        return count;
    }
	
	public static int countWords(String text, Map<String, Integer> map) {
		int countWord=0;
		boolean isWord = true;
		String [] textArrays;
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
		return countWord;
	}
	
}