package de.kiltz.vorgang.main.service;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.kiltz.vorgang.main.service.data.VorgangInfo;

/**
 * @author tz (F0290158)
 */
public class VorgangsServiceTest {
    private static VorgangsService service;

    @BeforeClass
    public static void init() {
        service = new VorgangsServiceImpl();
    }

    @Test
    public void testCRUD() {
        VorgangInfo v = new VorgangInfo("Erster Vorgang", "Ein kleiner TestVorgang ohne größere Beduetung", "tz");

        try {
            Assert.assertNull(v.getId());
            v = service.neu(v);
            Assert.assertNotNull(v.getId());
        } catch (VorgangsException e) {
            Assert.fail("Böse Ex!");
        }
        v.setName("Zweiter Vorgang");
        try {
            service.aktualisiere(v);
        } catch (VorgangsException e) {
            Assert.fail("Böse Ex!");
        }

        v = service.hole(v.getId());
        Assert.assertEquals("Zweiter Vorgang", v.getName());

        List<VorgangInfo> liste = service.suche("vorgang");
        Assert.assertFalse(liste.isEmpty());
    }
}
