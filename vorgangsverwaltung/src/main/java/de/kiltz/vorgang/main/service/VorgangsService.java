package de.kiltz.vorgang.main.service;

import java.util.List;

import de.kiltz.vorgang.main.data.VorgangInfo;

public interface VorgangsService {

    VorgangInfo neu(VorgangInfo v) throws VorgangsException;

    void aktualisiere(VorgangInfo v) throws VorgangsException;

    void loesche(Long id);

    VorgangInfo hole(Long id);

    List<VorgangInfo> suche(String name);

}