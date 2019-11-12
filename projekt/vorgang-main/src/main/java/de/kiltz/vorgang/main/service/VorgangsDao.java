package de.kiltz.vorgang.main.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import de.kiltz.vorgang.main.service.data.VorgangInfo;

/**
 * Inmemory-Dummy-Version eines DAOs ohne Interface, Entitys und Persistenz.
 *
 * Zur Vereinfachung werden keine konkurrierende Zugriffe und keine Massenanfragen angenommen.
 *
 * @author tz (F0290158)
 */
class VorgangsDao {
    private static VorgangsDao instance;
    private Map<Long, VorgangInfo> data;

    private VorgangsDao() {
    }

    // simpler Singelton für die gemeinsame Datenhaltung
    public static VorgangsDao getInstance() {
        if (instance == null) {
            instance = new VorgangsDao();
            instance.data = new HashMap<>();
        }
        return instance;
    }

    public VorgangInfo saveOrUpdate(VorgangInfo v) {
        if (v.getId() == null || data.get(v.getId()) == null) {
            v.setId(System.currentTimeMillis());
        }
        data.put(v.getId(), v);
        return v;
    }

    public void delete(Long id) {
        data.remove(id);
    }

    public VorgangInfo getById(Long id) {
        return data.get(id);
    }

    public List<VorgangInfo> findByName(String name) {
        return data.values().stream().filter(v -> v.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

}
