package com.uptc.prg2.CovidRegister.model;

/**
 * 
 * @author CovidRegister
 * @class : clase que define un empleado
 */
public class Employee {

	private String name;
	private int identification;
	private EnumHealthState enumHealthState;
	private EnumSymptom symptom;
	private double temperature;
	private EnumEmployeeType enumEmployeeType;

	/////////// constructor///////////////
	public Employee(String name, int identification, EnumHealthState enumHealthState, EnumSymptom symptom,
			double temperature, EnumEmployeeType enumEmployeeType) {
		this.name = name;
		this.identification = identification;
		this.enumHealthState = enumHealthState;
		this.symptom = symptom;
		this.temperature = temperature;
		this.enumEmployeeType = enumEmployeeType;
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

	public EnumHealthState getEnumHealthState() {
		return enumHealthState;
	}

	public void setEnumHealthState(EnumHealthState enumHealthState) {
		this.enumHealthState = enumHealthState;
	}

	public EnumSymptom getSymptom() {
		return symptom;
	}

	public void setSymptom(EnumSymptom symptom) {
		this.symptom = symptom;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public EnumEmployeeType getEnumEmployeeType() {
		return enumEmployeeType;
	}

	public void setEnumEmployeeType(EnumEmployeeType enumEmployeeType) {
		this.enumEmployeeType = enumEmployeeType;
	}

	public Object[] toObjectVector() {
		return new Object[] { name, identification, enumHealthState.toString(), symptom.toString(), temperature,
				enumEmployeeType.toString() };
	}

}
