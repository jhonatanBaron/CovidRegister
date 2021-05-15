package com.uptc.prg2.CovidRegister.models;

import java.util.Date;

/*
 * 
 * @author CovidRegister
 * @class : clase que define un reporte el cual se compone de una fecha de
 *        creacion y un empleado con sus datos correspondientes.
 */
public class Report {

	private Date date;
	private EnumHealthState enumHealthState;
	private EnumSymptom symptom;
	private int temperature;

	public Report(Date date, EnumHealthState enumHealthState, EnumSymptom symptom, int temperature) {
		this.date = date;
		this.enumHealthState = enumHealthState;
		this.symptom = symptom;
		this.temperature = temperature;
	}

	public Date getDate() {
		return date;
	}

	public EnumSymptom getSymptom() {
		return symptom;
	}

	public Object[] toObjectVector() {
		return new Object[] { date, enumHealthState.toString(), symptom.toString(), temperature };
	}

	public Integer getTemp() {
		return temperature;
	}
}
