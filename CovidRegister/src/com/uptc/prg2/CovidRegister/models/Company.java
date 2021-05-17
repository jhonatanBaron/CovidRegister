package com.uptc.prg2.CovidRegister.models;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 * @author CovidRegister
 *
 */
public class Company {

	private ArrayList<Double> stateCompany;
	private ArrayList<Report> reportList;

	public Company() {
		this.reportList = new ArrayList<>();
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
	public static Employee createEmployee(String name, String lastName, int identification, boolean vaccinated,
			EnumHealthState enumHealthState, EnumEmployeeType enumEmployeeType) {
		return new Employee(name, lastName, identification, vaccinated, enumHealthState, enumEmployeeType);
	}

	public static Report createReport(LocalDate date, EnumSymptom symptom, int temperature, Employee employee) {
		return new Report(date, symptom, temperature, employee);
	}

	public void addReport(Report report) {
		reportList.add(report);
	}

	// Retorna una fila para la tabla de empleados
	// no se para que es este metodo

	public ArrayList<Object[]> getEmployeesTable() {

		ArrayList<Object[]> aux = new ArrayList<>();

		for (Report report : reportList) {
			aux.add(report.toObjectVector());
		}
		return aux;
	}

	// reporte 1 ----> Muestra la temperatura para un empleado en una fecha
	// especifica

	public ArrayList<Object> temperatureVariationDate(LocalDate date, int identification) {

		ArrayList<Object> temp = new ArrayList<>();

		for (Report rep : reportList) {
			if (rep.getEmployee().getIdentification() == identification && rep.getDate().equals(date)) {
				temp.add(date);
				temp.add(rep.getTemperature());
			}
		}
		return temp;
	}

	// Muestra todas las temperaturas para un empleado

	public ArrayList<Integer> temperatureVariation(int identification) {

		ArrayList<Integer> temp = new ArrayList<>();

		for (Report rep : reportList) {
			if (rep.getEmployee().getIdentification() == identification) {
				temp.add(rep.getTemperature());
			}
		}
		return temp;
	}

	// reporte 2 ------> Retorna numero de cada sintoma en la empresa en una fecha
	// especifica

	public ArrayList<Integer> getNumberOfHealthStateReport(LocalDate date) {

		ArrayList<Integer> aux = new ArrayList<>();

		for (EnumHealthState healthState : EnumHealthState.values()) {
			int count = 0;
			for (Report report : reportList) {
				if (report.getDate() == date) {
					if (report.getEmployee().getEnumHealthState().equals(healthState)) {
						count++;
						break;
					}
				}
			}
			aux.add(count);
		}
		return aux;
	}

	// Retorna numero de cada sintoma en la empresa---
	// --- este es genreal sin tener en cuenta la fecha

	public ArrayList<Integer> getNumberOfSymptomsReport() {

		ArrayList<Integer> aux = new ArrayList<>();

		for (EnumSymptom symptom : EnumSymptom.values()) {
			int count = 0;
			for (Report report : reportList) {
				if (report.getSymptom().equals(symptom)) {
					count++;
					break;
				}
			}
			aux.add(count);
		}
		return aux;
	}
	
	// reporte 3 ------> lista de numero de empleados con sintomas en una fecha 
		// tipo de sintoma y el numero de empleados que cumplan con los parametros ingresados y tienen el sintoma
	
	public ArrayList<Object> symptomDate(LocalDate date) {

		ArrayList<Object> aux = new ArrayList<>();

		for (EnumSymptom symptom : EnumSymptom.values()) {
			int count = 0;
			for (Report report : reportList) {
				if (report.getDate().equals(date) && report.getSymptom().equals(symptom)) {
					count++;
					break;
				}
			}
			aux.add(symptom);
			aux.add(count);
		}
		return aux;
	}
	
	
	// reporte 4 ------> tipo de empleado y estado ---> retorna un array con 3 valores que son:
	// tipo de empleado, estado y el numero de empleados que cumplan con los parametros ingresados

	public ArrayList<Object> employeTypeStatus(EnumEmployeeType employeeType, EnumHealthState healthState) {

		ArrayList<Object> aux = new ArrayList<>();

		for (EnumEmployeeType type : EnumEmployeeType.values()) {
			for (EnumHealthState state : EnumHealthState.values()) {
				int count = 0;
				for (Report report : reportList) {
					if (report.getEmployee().getEnumEmployeeType().equals(employeeType) 
						&& report.getEmployee().getEnumHealthState().equals(healthState)) {
						count++;
						break;
					}
				}
				aux.add(type);
				aux.add(state);
				aux.add(count);
			}
		}
		return aux;
	}

	// reporte de nummero de empledos correspondiente a cada estado ---
	// calcula porcenajes para el grafico de pastel

	public ArrayList<Double> calculateState() {
		stateCompany = new ArrayList<>();
		stateCompany.add(calculateInfectedAverage());
		stateCompany.add(calculateVaccinatedAverage());
		stateCompany.add(calculateNoVaccinatedAverage());
		stateCompany.add(calculateNoInfectedAverage());
		return stateCompany;
	}

	private Double calculateNoInfectedAverage() {
		double count = 0;
		for (Report report : reportList) {
			if (report.getEmployee().getEnumHealthState().equals(EnumHealthState.HEALTHY)) {
				count++;
			}
		}
		return count / reportList.size();
	}

	private Double calculateNoVaccinatedAverage() {
		double count = 0;

		for (Report report : reportList) {
			if (!report.getEmployee().isVaccinated()) {
				count++;
			}
		}
		return count / reportList.size();
	}

	private Double calculateVaccinatedAverage() {
		double count = 0;

		for (Report report : reportList) {
			if (report.getEmployee().isVaccinated()) {
				count++;
			}
		}
		return count / reportList.size();
	}

	private Double calculateInfectedAverage() {
		double count = 0;
		for (Report report : reportList) {
			if (report.getEmployee().getEnumHealthState().equals(EnumHealthState.INFECTED)) {
				count++;
			}
		}
		return count / reportList.size();
	}

	public void setVaccinatedState(int id, boolean vaccinated) {
		for (Report report : reportList) {
			if (report.getEmployee().getIdentification() == id) {
				report.getEmployee().setVaccinated(vaccinated);
			}
		}
	}
}