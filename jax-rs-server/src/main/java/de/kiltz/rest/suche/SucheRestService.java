package de.kiltz.rest.suche;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;

@Path("suche")
@Api("suche")
public class SucheRestService {

	/**
	 * @param p
	 * @return
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String suche(@QueryParam("q") SuchParameter p) {
		p = p == null ? new SuchParameter() : p;
		return p.toString();
	}
	
}
