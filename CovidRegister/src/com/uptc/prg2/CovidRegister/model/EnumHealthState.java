package com.uptc.prg2.CovidRegister.model;

/**
 * 
 * @author CovidRegister
 * @enum : enumerado que maneja los estados de salud.
 */
public enum EnumHealthState {

	HEALTHY("Sano"), INFECTED("Infectado"), VACCINATED("Vacunado"), NOT_VACCINATED("No vacunado");

	private final String name;

	private EnumHealthState(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
