package de.kiltz.rest.basic;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/basic")
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
	public String pingPlain(@QueryParam("s") String txt) {
		txt = txt == null ? "NULL" : txt;
		return txt.toUpperCase();
	}

}
