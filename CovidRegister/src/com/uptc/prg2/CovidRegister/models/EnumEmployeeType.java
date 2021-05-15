package com.uptc.prg2.CovidRegister.models;

/**
 * 
 * @author CovidRegister
 * @enum : enumerado que maneja los tipos de empleado
 */
public enum EnumEmployeeType {

	BOSS("Jefe"), OFFICE_WORKER("oficinista"), SAFETY("Seguridad"), SERVICES("Servicios");

	private final String name;

	private EnumEmployeeType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
