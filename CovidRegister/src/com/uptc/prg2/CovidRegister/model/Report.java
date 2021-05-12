package com.uptc.prg2.CovidRegister.model;

import java.util.Date;

public class Report {
	
	private Date date;
	private Employee employee;

	public Report(Date date, Employee employee) {
		this.date = date;
		this.employee = employee;
	}

	public Date getDate() {
		return date;
	}

	public Employee getEmployee() {
		return employee;
	}
	
	public Object[] toObjectVector() {
		return new Object[] {date, employee.toObjectVector()};
	}

}
