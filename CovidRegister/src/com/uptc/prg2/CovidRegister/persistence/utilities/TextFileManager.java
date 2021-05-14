package com.uptc.prg2.CovidRegister.persistence.utilities;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * 
 * @author CovidRegister
 *
 */
public class TextFileManager {
	

	public ArrayList<String> readFile() throws IOException{
		String nameFile = "resources/files/in/CovidMessage.txt";
		ArrayList<String> linesRead = new ArrayList<>();
		FileReader fileReader  = new FileReader( nameFile );
		BufferedReader bufferedReader = new BufferedReader( fileReader ); 
		String lineRead;
	 	while( (lineRead = bufferedReader.readLine() ) != null ){
	 		linesRead.add( lineRead );
	 	}
	 	bufferedReader.close(); 
		return linesRead;
	}
	
	public void writeFile( String nameFile, ArrayList<String> datas ) {
		FileWriter fileWriter ;
		try {
			fileWriter = new FileWriter( nameFile );
			for (String line : datas) {
				fileWriter.write( line +  "\n" );
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fileWriter= new FileWriter(nameFile);
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
