package de.kiltz.rest.v1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author tz
 */

@Path("/v1/basic")
@Api("/v1/basic")
public class KommunikationsRestService {

    /**
     * Testmethode für Überprüfung der Kommunikation
     * curl -i http://127.0.0.1:8080/rs/api/basic/ping?s=test -H "ACCEPT:text/plain"
     *
     * @param txt
     * @return
     */
    @GET
    @Path("ping")
    @Produces("text/plain")
    @ApiOperation(value = "Kommunikationstest", produces = "text/plain")
    public String pingPlain(@QueryParam("s") String txt) {
        txt = txt == null ? "NULL" : txt;
        return txt.toUpperCase();
    }

    @GET
    @Path("suche")
    @Produces("text/plain")
    @ApiOperation(value = "Such-Beispiel", produces = "text/plain")
    public String suche(@ApiParam(
            value = "Suchbegriff für die Volltextsuche.",
            required = true)
                        @QueryParam("s") String suchBegriff,
                        @ApiParam(
                                value = "Umgebung in der gesucht werden soll.",
                                required = true, allowableValues = "Lokal, Global", defaultValue = "Lokal")
                        @QueryParam("umgebung") String umgebung) {
        return String.format("suche nach %s in der Umgebung %s", suchBegriff, umgebung);
    }
}
