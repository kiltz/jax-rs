package de.kiltz.rest.hateoas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Notiz {

    private Long id;
    private String titel;
    private String inhalt;

    public Notiz() {

    }

    public Notiz(String titel, String inhalt) {
        super();
        this.titel = titel;
        this.inhalt = inhalt;
    }

    public Notiz(Long id, String titel, String inhalt) {
        super();
        this.id = id;
        this.titel = titel;
        this.inhalt = inhalt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getInhalt() {
        return inhalt;
    }

    public void setInhalt(String inhalt) {
        this.inhalt = inhalt;
    }

}
