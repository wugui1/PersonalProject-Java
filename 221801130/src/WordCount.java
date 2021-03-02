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
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			while (br.read() != -1) {
		        String s = br.readLine();
				countChar += s.length();	 
			}
			System.out.println(countChar);
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}