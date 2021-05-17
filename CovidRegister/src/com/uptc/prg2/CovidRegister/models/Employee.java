package com.uptc.prg2.CovidRegister.models;


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

	/////////// constructor///////////////
	
	public Employee(String name, String lastName, int identification, boolean vaccinated,
			EnumHealthState enumHealthState, EnumEmployeeType enumEmployeeType) {
		this.name = name;
		this.lastName = lastName;
		this.identification = identification;
		this.vaccinated = vaccinated;
		this.enumHealthState = enumHealthState;
		this.enumEmployeeType = enumEmployeeType;
	}
	///////////////// gets y sets ///////////////////

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public int getIdentification() {
		return identification;
	}

	public boolean isVaccinated() {
		return vaccinated;
	}

	public EnumHealthState getEnumHealthState() {
		return enumHealthState;
	}

	public EnumEmployeeType getEnumEmployeeType() {
		return enumEmployeeType;
	}

	public void setVaccinated(boolean vaccinated) {
		this.vaccinated = vaccinated;
	}

}
