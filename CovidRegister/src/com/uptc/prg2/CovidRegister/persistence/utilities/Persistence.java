package com.uptc.prg2.CovidRegister.persistence.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.uptc.prg2.CovidRegister.models.Employee;
import com.uptc.prg2.CovidRegister.models.Report;

/*
 * 
 * @author CovidRegister
 * @class clase para manejar la parte de persistencia
 *
 *
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
	/**
	 * 
	 * @param nameFile : ruta del archivo
	 * @param report : el reporte :v
	 * @throws IOException : laexcepcion :v 
	 */
	
	public void WriteReportRow(String nameFile, Report report) throws IOException {
		FileWriter fileWriter = new FileWriter(nameFile);
		Employee employee = report.getEmployee();
		fileWriter.write(employee.getName() + "," + employee.getLastName() + "," + employee.getIdentification() + ","
				+ employee.getEnumHealthState() + "," + report.getSymptom() + employee.getEnumEmployeeType()
				+ report.getDate());
		fileWriter.close();
	}
	
}
