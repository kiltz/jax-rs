package de.kiltz.rest.basic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.bind.annotation.JsonbDateFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RootDatenTypen {
    private String txt;
    private int zahl;
    private float gleitZahl;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @JsonbDateFormat(value = "dd.MM.yyyy")
    private LocalDate datum;
    private List<String> liste;
    private Map<Integer, String> mappe;
    private List<TeilDatenTypen> komplexeListe;

    public RootDatenTypen() {
        double d = Math.random();
        setTxt("Text 4: " + d);
        setZahl((int) (d * 6 + 1));
        setGleitZahl((float) d);
        datum = LocalDate.now();
        liste = new ArrayList<>();
        liste.add("Eins");
        liste.add("Zwei");
        liste.add("Drei");

        mappe = new HashMap<>();
        mappe.put(1, "Jan");
        mappe.put(2, "Feb");
        mappe.put(3, "Mar");
        mappe.put(4, "Apr");

        komplexeListe = new ArrayList<>();
        komplexeListe.add(new TeilDatenTypen());
        komplexeListe.add(new TeilDatenTypen());
        komplexeListe.add(new TeilDatenTypen());
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

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
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

    public List<TeilDatenTypen> getKomplexeListe() {
        return komplexeListe;
    }

    public void setKomplexeListe(List<TeilDatenTypen> komplexeListe) {
        this.komplexeListe = komplexeListe;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DatenObjekt{");
        sb.append("txt='").append(txt).append('\'');
        sb.append(", zahl=").append(zahl);
        sb.append(", gleitZahl=").append(gleitZahl);
        sb.append(", datum=").append(datum);
        sb.append(", liste=").append(liste);
        sb.append(", mappe=").append(mappe);
        sb.append(", komplexeListe=").append(komplexeListe);
        sb.append('}');
        return sb.toString();
    }

}
