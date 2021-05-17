package com.uptc.prg2.CovidRegister.testPersistence;

import java.io.IOException;

import com.uptc.prg2.CovidRegister.persistence.utilities.Persistence;

public class TestRead {
	private Persistence persistence;
	
	public TestRead() {
		// TODO Auto-generated constructor stub
	
	}
public static void main(String[] args) {
	Persistence persistence = new Persistence();
	try {
		persistence.readFile("C:\\Users\\ASUS\\git\\CovidRegister\\CovidRegister\\resources\\files\\in\\data.txt");
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("leido");
}
}
