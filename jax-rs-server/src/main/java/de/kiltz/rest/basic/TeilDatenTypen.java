package de.kiltz.rest.basic;

public class TeilDatenTypen {
	private String txt;
	private int zahl;
	private float gleitZahl;
	
	public TeilDatenTypen() {
		double d = Math.random();
		setTxt("Text: "+d);
		setZahl((int)(d*6+1));
		setGleitZahl((float)d);	
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

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("DatenObjekt2{");
		sb.append("txt='").append(txt).append('\'');
		sb.append(", zahl=").append(zahl);
		sb.append(", gleitZahl=").append(gleitZahl);
		sb.append('}');
		return sb.toString();
	}
}
