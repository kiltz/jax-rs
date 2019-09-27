package de.kiltz.rest.v1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author tz
 */

@Path("/v1/test")
@Api("/v1/test")
public class TestRestService {

    /**
     * Testmethode für Überprüfung der Registrierung
     * curl -i http://127.0.0.1:8080/rs/api/test/pong?s=TESTING -H "ACCEPT:text/plain"
     *
     * @param txt
     * @return
     */
    @GET
    @Path("pong")
    @Produces("text/plain")
    @ApiOperation(value = "Kommunikationstest", produces = "text/plain")
    public String pingPlain(@QueryParam("s") String txt) {
        txt = txt == null ? "NULL" : txt;
        return txt.toLowerCase();
    }
}
