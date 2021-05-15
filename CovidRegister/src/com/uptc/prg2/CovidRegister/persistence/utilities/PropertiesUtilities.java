package com.uptc.prg2.CovidRegister.persistence.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/*
 * 
 * @author ASUS
 *
 */
public class PropertiesUtilities {

	/*
	 * 
	 * @param pathFile : ruta del File
	 * @return : un File properties
	 * @throws IOException
	 */
	public static Properties generateProperties(
			String pathFile) throws IOException {
		Properties properties = new Properties();
		InputStream input = new FileInputStream(pathFile);
		properties.load(input);
		return properties;
	}
/*
 * 
 * @param properties: parametro tipo properties
 * @param pathFile : ruta del file a escribir
 * @throws IOException
 */
	public static void saveProperties(Properties properties,
			String pathFile) throws IOException {
		FileOutputStream output = new FileOutputStream(
				pathFile);
		properties.store(output, null);
		output.close();
	}
}
