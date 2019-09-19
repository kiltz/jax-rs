package de.kiltz.rest.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DatenObjekt {
	private String txt;
	private int zahl;
	private float gleitZahl;
	private Date datum;
	private List<String> liste;
	private Map<Integer, String> mappe;
	private List<de.kiltz.semi.rest.basic.DatenObjekt2> komplexeListe;
	
	public DatenObjekt() {
		double d = Math.random();
		setTxt("Text: "+d);
		setZahl((int)(d*6+1));
		setGleitZahl((float)d);	
		datum = new Date();
		liste = new ArrayList<String>();
		liste.add("Eins");
		liste.add("Zwei");
		liste.add("Drei");
		
		mappe = new HashMap<Integer, String>();
		mappe.put(1, "Jan");
		mappe.put(2, "Feb");
		mappe.put(3, "Mar");
		mappe.put(4, "Apr");
		
		komplexeListe = new ArrayList<de.kiltz.semi.rest.basic.DatenObjekt2>();
		komplexeListe.add(new de.kiltz.semi.rest.basic.DatenObjekt2());
		komplexeListe.add(new de.kiltz.semi.rest.basic.DatenObjekt2());
		komplexeListe.add(new de.kiltz.semi.rest.basic.DatenObjekt2());
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public int getZahl() {
		return zahl;
	}
	public void setZahl(int zahl) {
		this.zahl = zahl;
	}
	public float getGleitZahl() {
		return gleitZahl;
	}
	public void setGleitZahl(float gleitZahl) {
		this.gleitZahl = gleitZahl;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public List<String> getListe() {
		return liste;
	}
	public void setListe(List<String> liste) {
		this.liste = liste;
	}
	public Map<Integer, String> getMappe() {
		return mappe;
	}
	public void setMappe(Map<Integer, String> mappe) {
		this.mappe = mappe;
	}
	public List<de.kiltz.semi.rest.basic.DatenObjekt2> getKomplexeListe() {
		return komplexeListe;
	}
	public void setKomplexeListe(List<de.kiltz.semi.rest.basic.DatenObjekt2> komplexeListe) {
		this.komplexeListe = komplexeListe;
	}
	
	
}
