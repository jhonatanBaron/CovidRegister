package com.uptc.prg2.CovidRegister.persistence.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * 
 * @author CovidRegister
 * @class clase para manejar la parte de persistencia
 */
public class Persistence {

	/*
	 * 
	 * @param nameFile : ruta del File a leer
	 * 
	 * @return : lista con las palabras leidas
	 * 
	 * @throws IOException
	 */
	public ArrayList<String> readFile(String nameFile) throws IOException {
		ArrayList<String> linesRead = new ArrayList<>();
		FileReader fileReader = new FileReader(nameFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String lineRead;

		while ((lineRead = bufferedReader.readLine()) != null) {
			linesRead.add(lineRead);
		}
		bufferedReader.close();
		return linesRead;
	}

	/*
	 * 
	 * @param nameFile : ruta del File a escribir
	 * 
	 * @param datas : lista de palabras que se quieren escribir en el File
	 */
	public void writeFile(String nameFile, ArrayList<String> datas) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(nameFile);
			for (String line : datas) {
				fileWriter.write(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
