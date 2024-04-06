package com.myexamples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWriter {
	
	
	public static void main(String arg[]) {
		String inputeFile = "inputFile.txt";
		String outputFile = "outputFile.txt";
		FileReadWriter fileReadWriter = new FileReadWriter();
		fileReadWriter.readWriteFile(inputeFile,outputFile);
	}

	private void readWriteFile(String inputeFileName, String outputFileName) {
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(inputeFileName).getFile());
			File outputFile = new File(classLoader.getResource(outputFileName).getFile());
			FileReader fr = new FileReader(file);
			FileWriter fw = new FileWriter(outputFile);
			String str = "";
			
			int i;
			while ((i = fr.read()) != -1) {
				 
                str += (char)i;
            }
			
			System.out.println(str);
			StringBuilder stringBuilder = new StringBuilder(str);
			StringBuilder reverseString = stringBuilder.reverse();
			System.out.println(reverseString.toString());
			fw.write(str);
			fr.close();
            fw.close();
 
            
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 
	}

}
