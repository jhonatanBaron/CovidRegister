package com.uptc.prg2.CovidRegister.model;
import java.util.ArrayList;
import java.util.Date;

public class Company {
	
	private ArrayList<Report> reportList;
	
	public Company() {
		reportList = new ArrayList<>();
	}

	/*
	 * metodo para crear empleado
	 */
	public static Employee createEmployee(String name, int identification, EnumHealthState enumHealthState,
			EnumSymptom symptom, double temperature, EnumEmployeeType enumEmployeeType) {
		return new Employee(name, identification, enumHealthState,
				symptom, temperature, enumEmployeeType);
	}
	
	/*
	 * metodo para crear reporte utilizando el metodo de crear empleado
	 */
	public static Report createReport(Date date,String name, int identification, EnumHealthState enumHealthState,
			EnumSymptom symptom, double temperature, EnumEmployeeType enumEmployeeType) {
		return new Report(date, createEmployee(name, identification, enumHealthState, symptom, temperature, enumEmployeeType));
	}
	
	public void addReport(Report report) {
		reportList.add(report);
	}

	/*
	 * metodo para eliminar un reporte de un empleado por identificacion en una fecha ingresada
	 * se puede usar solo fecha o id es solo cambiarlo
	 */
	public void deleteReport(Date dateReport, int identification) {
		for (Report report : reportList) {
			if (report.getDate() == dateReport && report.getEmployee().getIdentification() == identification)
				reportList.remove(report);
		}
	}
	
	public Report searcIdentification(int identification) {
		Report selectedObject = null;
		for (Report report : reportList) {
			if (report.getEmployee().getIdentification() == identification) {
				selectedObject = report;
			}
		}
		return selectedObject;
	}
}