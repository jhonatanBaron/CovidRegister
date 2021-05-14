package com.uptc.prg2.CovidRegister.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author CovidRegister
 *
 */
public class Company {

	private ArrayList<Report> reportList;

	public Company() {
		reportList = new ArrayList<>();
	}

	/*
	 * metodo para crear empleado
	 * 
	 * @param name : Nombre del empleado
	 * 
	 * @param identification : identificacion del empleado
	 * 
	 * @param enumHealthState : estado de salud del empleado
	 * 
	 * @param symptom : sintomas de la enfermedad del empleado
	 * 
	 * @param temperature : temperatura del empleado
	 * 
	 * @param enumEmployeeType : tipo de empleado en la empresa
	 * 
	 * @return : un empleado
	 */
	public static Employee createEmployee(String name, int identification, EnumHealthState enumHealthState,
			EnumSymptom symptom, double temperature, EnumEmployeeType enumEmployeeType) {
		return new Employee(name, identification, enumHealthState, symptom, temperature, enumEmployeeType);
	}

	/*
	 * metodo para crear reporte utilizando el metodo de crear empleado
	 * 
	 * @param date : fecha en la que se crea el reporte
	 * 
	 * @param name :nombre del empleado
	 * 
	 * @param identification : identificacion del empleado
	 * 
	 * @param enumHealthState : estado de salud del empleado
	 * 
	 * @param symptom : sintomas de enfermedad
	 * 
	 * @param temperature : temperatura del empleado
	 * 
	 * @param enumEmployeeType : tipo de empelado
	 * 
	 * @return : un reporte con empleado y fecha
	 */
	public static Report createReport(Date date, String name, int identification, EnumHealthState enumHealthState,
			EnumSymptom symptom, double temperature, EnumEmployeeType enumEmployeeType) {
		return new Report(date,
				createEmployee(name, identification, enumHealthState, symptom, temperature, enumEmployeeType));
	}

	/*
	 * metodo para agregar un reporte
	 * 
	 * @param report : reporte a insertar con fecha y datos del emppleado
	 */
	public void addReport(Report report) {
		reportList.add(report);
	}

	/*
	 * metodo para eliminar un reporte de un empleado por identificacion en una
	 * fecha ingresada se puede usar solo fecha o id es solo cambiarlo
	 * 
	 * @param dateReport
	 * 
	 * @param identification
	 */
	public void deleteReport(Date dateReport, int identification) {
		for (Report report : reportList) {
			if (report.getDate() == dateReport && report.getEmployee().getIdentification() == identification)
				reportList.remove(report);
		}
	}

	/*
	 * metodo para buscar perosna con identificacion ingresada
	 * 
	 * @param identification : id de la persona
	 * 
	 * @return : reporte con la persona con id dado
	 */
	public Report searchIdentification(int identification) {
		Report selectedObject = null;
		for (Report report : reportList) {
			if (report.getEmployee().getIdentification() == identification) {
				selectedObject = report;
			}
		}
		return selectedObject;
	}
}