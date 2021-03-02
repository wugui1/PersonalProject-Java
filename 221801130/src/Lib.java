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
	
}
