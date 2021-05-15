package com.uptc.prg2.CovidRegister.models;

import java.util.ArrayList;

/**
 * 
 * @author CovidRegister
 *
 */
public class Company {

	private ArrayList<Double> stateCompany;
	private ArrayList<Employee> employeeList;

	public Company() {
		this.employeeList = new ArrayList<>();
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
	public static Employee createEmployee(String name, String lastName, int identification,
			EnumEmployeeType enumEmployeeType) {
		return new Employee(name, lastName, identification, enumEmployeeType);
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

	public void addEmployee(Employee employee, EnumSymptom enumHealthState) {
		if (employeeList.isEmpty() && enumHealthState.equals(EnumSymptom.NONE)) {
			employeeList.add(employee);
		} else {
			for (Employee emp : employeeList) {
				if ((emp.getIdentification() != employee.getIdentification())
						&& enumHealthState.equals(EnumSymptom.NONE)) {
					employeeList.add(employee);
				}
			}
		}
	}

	// Retorna numero de cada sintoma en la empresa
	public ArrayList<Integer> getNumberOfSymptoms() {
		ArrayList<Integer> aux = new ArrayList<>();
		for (EnumSymptom symptom : EnumSymptom.values()) {
			int count = 0;
			for (Employee employee : employeeList) {
				for (Report report : employee.getReport()) {
					if (report.getSymptom().equals(symptom)) {
						count++;
						break;
					}
				}
			}
			aux.add(count);
		}
		return aux;
	}

	// Retorna una fila para la tabla de empleados
	public ArrayList<Object[]> getEmployeesTable() {
		ArrayList<Object[]> aux = new ArrayList<>();
		for (Employee employee : employeeList) {
			aux.add(employee.toObjectVector());
		}
		return aux;
	}

	// Muestra todas las temperaturas para un empleado
	public ArrayList<Integer> temperatureVariation(Employee employee) {
		ArrayList<Integer> temp = new ArrayList<>();
		for (Employee emp : employeeList) {
			if (emp.getIdentification() == employee.getIdentification()) {
				for (Report report : emp.getReport()) {
					temp.add(report.getTemp());
				}
			}
		}
		return temp;
	}

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
		for (Employee employee : employeeList) {
			if (!employee.getHealthState().equals(EnumHealthState.INFECTED)) {
				count++;
			}
		}
		return count / employeeList.size();
	}

	private Double calculateNoVaccinatedAverage() {
		double count = 0;
		for (Employee employee : employeeList) {
			if (!employee.isVacinnated()) {
				count++;
			}
		}
		return count / employeeList.size();
	}

	private Double calculateVaccinatedAverage() {
		double count = 0;
		for (Employee employee : employeeList) {
			if (employee.isVacinnated()) {
				count++;
			}
		}
		return count / employeeList.size();
	}

	private Double calculateInfectedAverage() {
		double count = 0;
		for (Employee employee : employeeList) {
			if (employee.getHealthState().equals(EnumHealthState.INFECTED)) {
				count++;
			}
		}
		return count / employeeList.size();
	}

	public void addReport(int id, Report report) {
		for (Employee employee : employeeList) {
			if (employee.getIdentification() == id) {
				employee.addReport(report);
			}
		}
	}

	public void setVaccinatedState(int id, boolean vaccinated) {
		for (Employee employee : employeeList) {
			if (employee.getIdentification() == id) {
				employee.setVaccinated(vaccinated);
			}
		}
	}
}