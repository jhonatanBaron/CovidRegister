package com.uptc.prg2.CovidRegister.persistence.utilities;

import java.io.IOException;
import java.util.Properties;
/*
 * 
 * @author 	CovidRegister
 *
 */

public class HandlerLanguage {
	public String fileName;
	public static String language = "undefined";
	public static Properties languageProperties;
	public HandlerLanguage(String fileName){
		this.fileName = fileName;
	}
	/*
	 * 
	 * @throws IOException
	 */
	public void loadLanguage() throws IOException{		
		Properties handlerproperties = PropertiesUtilities.generateProperties(fileName);
		language = handlerproperties.getProperty("Language");
		
		languageProperties = PropertiesUtilities.generateProperties(language);
	}
	
	/*
	 * 
	 * @throws IOException
	 */
	public void saveLanguage() throws IOException{
		Properties handlerproperties = PropertiesUtilities.generateProperties(fileName);
		handlerproperties.setProperty("Language", language);
		PropertiesUtilities.saveProperties( handlerproperties, fileName);
	}	
}