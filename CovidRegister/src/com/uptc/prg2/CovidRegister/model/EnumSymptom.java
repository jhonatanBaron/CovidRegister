package com.uptc.prg2.CovidRegister.model;

public enum EnumSymptom {

	DRY_COUGH("Tos seca"),
	TIREDNESS("Cansancio"),
	HEADACHE("Dolor de cabeza "),
	LOSS_OF_SMELL("Pérdida del olfato"),
	LOSS_OF_TASTE("Pérdida del gusto"),
	DIFFICULTY_BREATHING("Dificultad para respirar");
	
    private final String name;
	
	private EnumSymptom(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
