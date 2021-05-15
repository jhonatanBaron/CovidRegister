package com.uptc.prg2.CovidRegister.models;

import java.util.ArrayList;

/**
 * 
 * @author CovidRegister
 * @class : clase que define un empleado
 */
public class Employee {

	private String name;
	private String lastName;
	private int identification;
	private boolean vaccinated;
	private EnumHealthState enumHealthState;
	private EnumEmployeeType enumEmployeeType;
	private ArrayList<Report> reportList;

	/////////// constructor///////////////
	public Employee(String name, String lastName, int identification, EnumEmployeeType employeeType) {
		this.name = name;
		this.lastName = lastName;
		this.identification = identification;
		this.enumEmployeeType = employeeType;
	}

	///////////////// gets y sets ///////////////////

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdentification() {
		return identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public EnumEmployeeType getEnumEmployeeType() {
		return enumEmployeeType;
	}

	public void setEnumEmployeeType(EnumEmployeeType enumEmployeeType) {
		this.enumEmployeeType = enumEmployeeType;
	}

	public Object[] toObjectVector() {
		return new Object[] { name, lastName, identification, vaccinated, enumHealthState.toString(),
				enumEmployeeType.toString() };
	}

	public ArrayList<Report> getReport() {
		return reportList;
	}

	public EnumHealthState getHealthState() {
		return enumHealthState;
	}

	public boolean isVacinnated() {
		return vaccinated;
	}

	public void addReport(Report report) {
		reportList.add(report);
	}

	public void setVaccinated(boolean vaccinated) {
		this.vaccinated = vaccinated;
	}

}
