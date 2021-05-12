package com.uptc.prg2.CovidRegister.model;

public enum EnumHealthState {
	
	HEALTHY("Sano"),
	INFECTED("Infectado"),
	VACCINATED("Vacunado"),
	NOT_VACCINATED("No vacunado");
	
    private final String name;
	
	private EnumHealthState(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
