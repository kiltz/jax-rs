package de.kiltz.rest.suche;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("suche")
public class SucheRestService {

	@GET
	@Produces("text/plain")
	public String suche(@QueryParam("q") SuchParameter p) {
		return p.toString();
	}
	
}
