package de.kiltz.rest.provider;

import java.time.LocalDate;

public class Info {

	private int nr;
	private LocalDate datum;
	private String text;

	public Info() {
	}

	public Info(int nr, LocalDate datum, String text) {
		this.nr = nr;
		this.datum = datum;
		this.text = text;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
