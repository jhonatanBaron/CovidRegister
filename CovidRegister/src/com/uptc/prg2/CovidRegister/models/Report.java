package com.uptc.prg2.CovidRegister.models;

import java.time.LocalDate;
import java.util.Date;

/*
 * 
 * @author CovidRegister
 * @class : clase que define un reporte el cual se compone de una fecha de
 *        creacion y un empleado con sus datos correspondientes.
 */
public class Report {

	private LocalDate date;
	private EnumSymptom symptom;
	private int temperature;
	private Employee employee;

	public Report(LocalDate date, EnumSymptom symptom, 
			int temperature, Employee employee) {
		this.date = date;
		this.symptom = symptom;
		this.temperature = temperature;
		this.employee = employee;
	}

	public LocalDate getDate() {
		return date;
	}

	public EnumSymptom getSymptom() {
		return symptom;
	}

	public int getTemperature() {
		return temperature;
	}

	public Employee getEmployee() {
		return employee;
	}
	
	public Object[] toObjectVector() {
		return new Object [] {date, symptom, temperature, 
				employee.getName(), employee.getLastName(),  employee.getIdentification(),
				employee.isVaccinated(), employee.getEnumHealthState(), employee.getEnumEmployeeType()};
	}
}
