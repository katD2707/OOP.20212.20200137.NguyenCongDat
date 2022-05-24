package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filename = "D:\\HP toán và khoa học\\Applied Statistics and Experimental Design\\group project\\test.txt";
		byte[] inputBytes = {0};
		long startTime, endTime;
		
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		
		String outputString = "";
		for (byte b: inputBytes) {
			outputString +=  (char)b;
		}
		endTime = System.currentTimeMillis();
		System.out.println(outputString.substring(0, 200));
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Plus operator: " + (endTime - startTime));
		
	}

}
