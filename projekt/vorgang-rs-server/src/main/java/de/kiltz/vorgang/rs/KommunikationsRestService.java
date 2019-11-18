package de.kiltz.vorgang.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("info")
public class KommunikationsRestService {

    /**
     * Testmethode für Überprüfung der Kommunikation curl -i http://127.0.0.1:8080/vorgang/api/info?key=user.name -H
     * "ACCEPT:text/plain"
     *
     * @param key
     * @return
     */
    @GET
    @Produces("text/plain")
    public String getProperty(@QueryParam("key") String key) {
        key = key == null ? "unbekannt" : key;
        return System.getProperty(key);
    }

}
