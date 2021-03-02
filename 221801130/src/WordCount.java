import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class a {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String path =input.next();
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}