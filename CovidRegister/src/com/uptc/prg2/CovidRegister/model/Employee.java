package com.uptc.prg2.CovidRegister.model;

public class Employee {

	private String name;
	private int identification;
	private EnumHealthState enumHealthState;
	private EnumPoisiton enumPosition;
	private EnumSymptom symptom;
	private double temperature;
	private EnumEmployeetype enumEmployeeType;

	/////////// constructor///////////////
	public Employee(String name, int identification, EnumHealthState enumHealthState, EnumPoisiton enumPosition,
			EnumSymptom symptom, double temperature, EnumEmployeetype enumEmployeeType) {
		super();
		this.name = name;
		this.identification = identification;
		this.enumHealthState = enumHealthState;
		this.enumPosition = enumPosition;
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

	public EnumPoisiton getEnumPosition() {
		return enumPosition;
	}

	public void setEnumPosition(EnumPoisiton enumPosition) {
		this.enumPosition = enumPosition;
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

	public EnumEmployeetype getEnumEmployeeType() {
		return enumEmployeeType;
	}

	public void setEnumEmployeeType(EnumEmployeetype enumEmployeeType) {
		this.enumEmployeeType = enumEmployeeType;
	}

}
