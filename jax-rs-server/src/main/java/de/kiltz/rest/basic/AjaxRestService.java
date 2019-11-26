package de.kiltz.rest.basic;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;



@Path("ajax")
@Api("ajax")
public class AjaxRestService {

	private static int anzahl = 0;
	
	@GET
	@Path("meldungen")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMeldungen() {
		if (++anzahl == 5) {
			anzahl = 0;
			throw new NotFoundException("mag nicht!");
		}
		return String.format("%d. Aufruf: Freier Speicher: %,d", anzahl, Runtime.getRuntime().freeMemory());
	}
}
