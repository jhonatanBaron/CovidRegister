package com.uptc.prg2.CovidRegister.model;

public class InformationCovid {
	private String Title;
	private String Text;

	public InformationCovid(String title, String text) {
		super();
		Title = title;
		Text = text;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

}
