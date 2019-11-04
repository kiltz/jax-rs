package de.kiltz.rest.suche;

import java.io.IOException;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SuchParameter {

	private String name;
	private String vorname;
	private int mindestUmsatz;



	public static SuchParameter fromString(String s) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(s, SuchParameter.class);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public int getMindestUmsatz() {
		return mindestUmsatz;
	}
	public void setMindestUmsatz(int mindestUmsatz) {
		this.mindestUmsatz = mindestUmsatz;
	}

	public static void main(String[] args) {
		SuchParameter p = new SuchParameter();
		p.setName("Nachname");
		p.setVorname("Vorname");
		System.out.println(p);
	}
	
}
