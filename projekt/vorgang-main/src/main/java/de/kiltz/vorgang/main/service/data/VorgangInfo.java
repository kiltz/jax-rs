package de.kiltz.vorgang.main.service.data;

import java.time.LocalDateTime;

/**
 * @author tz (F0290158)
 */
public class VorgangInfo {

    private Long id;
    private String name;
    private String beschreibung;
    private LocalDateTime erstelltAm;
    private String erstelltVon;
    private LocalDateTime letzteAenderung;
    private String letzteAenderungVon;
    private Status status;

    public VorgangInfo() {
    }

    public VorgangInfo(String name, String beschreibung, String erstelltVon) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.erstelltVon = erstelltVon;
        erstelltAm = LocalDateTime.now();
        status = Status.NEU;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public LocalDateTime getErstelltAm() {
        return erstelltAm;
    }

    public void setErstelltAm(LocalDateTime erstelltAm) {
        this.erstelltAm = erstelltAm;
    }

    public String getErstelltVon() {
        return erstelltVon;
    }

    public void setErstelltVon(String erstelltVon) {
        this.erstelltVon = erstelltVon;
    }

    public LocalDateTime getLetzteAenderung() {
        return letzteAenderung;
    }

    public void setLetzteAenderung(LocalDateTime letzteAenderung) {
        this.letzteAenderung = letzteAenderung;
    }

    public String getLetzteAenderungVon() {
        return letzteAenderungVon;
    }

    public void setLetzteAenderungVon(String letzteAenderungVon) {
        this.letzteAenderungVon = letzteAenderungVon;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
