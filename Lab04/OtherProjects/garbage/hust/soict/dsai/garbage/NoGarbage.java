package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filename = "D:\\HP toán và khoa học\\Applied Statistics and Experimental Design\\group project\\test.txt";
		byte[] inputBytes = {0};
		long startTime, endTime;
				
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		
		StringBuilder outputStringBuilder = new StringBuilder();
		for (byte b: inputBytes) {
			outputStringBuilder.append((char)b);
		}
		endTime = System.currentTimeMillis();
		System.out.println(outputStringBuilder.substring(0, 200));
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("StringBuilder: " + (endTime - startTime));
		
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		
		StringBuffer outputStringBuffer = new StringBuffer();
		for (byte b: inputBytes) {
			outputStringBuffer.append((char)b);
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer: " + (endTime - startTime));
	}
}
