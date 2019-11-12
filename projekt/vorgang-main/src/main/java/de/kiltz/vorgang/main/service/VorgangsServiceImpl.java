package de.kiltz.vorgang.main.service;

import java.util.List;

import de.kiltz.vorgang.main.service.data.VorgangInfo;

/**
 * @author tz (F0290158)
 */
public class VorgangsServiceImpl implements VorgangsService {
    private VorgangsDao dao;

    public VorgangsServiceImpl() {
        dao = VorgangsDao.getInstance();
    }

    @Override
    public VorgangInfo neu(VorgangInfo v) throws VorgangsException {
        validiere(v);
        return dao.saveOrUpdate(v);
    }

    @Override
    public void aktualisiere(VorgangInfo v) throws VorgangsException {
        validiere(v);
        dao.saveOrUpdate(v);
    }

    @Override
    public void loesche(Long id) {
        dao.delete(id);
    }

    @Override
    public VorgangInfo hole(Long id) {
        return dao.getById(id);
    }

    @Override
    public List<VorgangInfo> suche(String name) {
        return dao.findByName(name);
    }

    private void validiere(VorgangInfo v) throws VorgangsException {
        if (v.getName() == null || v.getName().isEmpty()) {
            throw new VorgangsException("Der Name ist ein Pflichtfeld");
        }
        /// etc.
    }
}
