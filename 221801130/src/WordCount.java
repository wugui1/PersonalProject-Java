import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WordCount {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String path = input.next();
		int countChar = 0;
		int countWord = 0;
		String s;
		StringBuffer textBuffer = new StringBuffer();
		String text;
		String [] textArrays;
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			while ((s = br.readLine()) != null) {		         
		        textBuffer.append(s);
		        textBuffer.append(" ");
				countChar += s.length();	 
			}
			text = textBuffer.toString();
			text = text.toLowerCase();
			text = text.replaceAll("[^A-Za-z0-9]", " ");
			textArrays = text.split("\\s+");
			countWord = textArrays.length;
			for (int i = 0;i < textArrays.length;i ++) {
				if(textArrays[i].length() >= 4) {
					for (int j = 0;j < 4;j ++) {
						if(!Character.isLetter(textArrays[i].charAt(j))) {
							countWord--;
							break;
						}
					}
				}
			}
	                
	            {
			}
			System.out.println(countChar);
			System.out.println(countWord);
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}

