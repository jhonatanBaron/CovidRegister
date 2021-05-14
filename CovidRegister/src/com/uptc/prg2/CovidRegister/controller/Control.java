package com.uptc.prg2.CovidRegister.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import com.uptc.prg2.CovidRegister.persistence.utilities.TextFileManager;
import com.uptc.prg2.CovidRegister.persistence.utilities.UtilitiesFiles;
import com.uptc.prg2.CovidRegister.viewer.JFramePrincipal;

public class Control implements ActionListener{

	private JFramePrincipal jFramePrincipal;
	private TextFileManager planeLecture;
	private String[] plainDataRecibed;

	public Control() throws IOException {
		planeLecture= new TextFileManager();
		plainDataRecibed= new String[6];
		this.plainDataSepartor();
		this.jFramePrincipal = new JFramePrincipal(this,plainDataRecibed);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Command.valueOf(e.getActionCommand())) {
		case SPANISH:
			System.out.println("español");
			break;
		case ENGLISH:
			System.out.println("ingles");
			break;
		case ADD_REGISTER:
			jFramePrincipal.dialogVisibilitiAddDialog(true);
			break;

		case INFORMATION:
			jFramePrincipal.dialogVisibilitiInfoDialog(true);
			break;

		case COMPANY_STATUS:
			System.out.println("reporte 1");
			break;

		case TEMPERATURE_REPORT:
			System.out.println("reporte 2");
			break;

		case STATUS_PER_MONTH:
			System.out.println("reporte 3");
			break;

		case SYMPTOM:
			System.out.println("reporte 4");
			break;

		case TYPE_EMPLOYEE_PER_STATUS:
			System.out.println("reporte 5");
			break;
		case BUTTON_ADD_ACCEPT:
			break;
		case BUTTON_ADD_CANCEL:
			break;
		case BUTTON_ADD_CLEAN_FIELDS:
			break;
		default:
			break;

		}
	}
	
	private void plainDataSepartor() throws IOException {
		ArrayList<String> stringList = planeLecture.readFile();
		for (String string :stringList) {
			String[] aux = UtilitiesFiles.splitLine( string );			
			plainDataRecibed=aux;
		}
	}
}