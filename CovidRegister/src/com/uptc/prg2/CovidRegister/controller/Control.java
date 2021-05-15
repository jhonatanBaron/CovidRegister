package com.uptc.prg2.CovidRegister.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import com.uptc.prg2.CovidRegister.models.Company;
import com.uptc.prg2.CovidRegister.models.Employee;
import com.uptc.prg2.CovidRegister.models.EnumEmployeeType;
import com.uptc.prg2.CovidRegister.models.EnumHealthState;
import com.uptc.prg2.CovidRegister.models.EnumSymptom;
import com.uptc.prg2.CovidRegister.models.Report;
import com.uptc.prg2.CovidRegister.persistence.utilities.Persistence;
import com.uptc.prg2.CovidRegister.persistence.utilities.UtilitiesFiles;
import com.uptc.prg2.CovidRegister.viewer.JFramePrincipal;

/*
 * 
 * @author CovidRegister
 *
 */

public class Control implements ActionListener {

	private JFramePrincipal jFramePrincipal;
	private String[] plainDataRecibed;
	private Persistence persistence;
	private Company manager;

	public Control() {
		manager = new Company();
		plainDataRecibed = new String[6];
		persistence = new Persistence();
		this.jFramePrincipal = new JFramePrincipal(this, plainDataRecibed);
		init();
	}

	private void init() {
		readFile();
	}

	private void readFile() {
		try {
			ArrayList<String> lines = persistence.readFile("resources/data.csv");
			for (String line : lines) {
				String aux[] = line.split(";");
				//Agrega un empleado
				manager.addEmployee(
						new Employee(aux[0], aux[1], Integer.parseInt(aux[2]), EnumEmployeeType.valueOf(aux[4])),EnumSymptom.valueOf(aux[6]));
				//Asigna si está vacunado el empleado
				
				//Agrega los reportes del empleado
				manager.addReport(Integer.parseInt(aux[2]), new Report(UtilitiesFiles.parseFecha(aux[5]),
						EnumHealthState.valueOf(aux[6]), EnumSymptom.valueOf(aux[7]), Integer.valueOf(aux[8])));
			}
		} catch (IOException e) {
			System.out.println("[FR] Archivo no encontrado");
		}
	}

	/*
	 * seleccion de accion
	 */
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
}