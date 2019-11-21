package de.kiltz.rest.provider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/providers")
public class ProviderRestService {

	/*
	 * curl -i http://127.0.0.1:8080/rs/api/providers -H "ACCEPT:application/json"
	 * curl -i http://127.0.0.1:8080/rs/api/providers -H "ACCEPT:application/tz-csv"
	 */
	@GET
    @Produces({MediaType.APPLICATION_JSON, "application/tz-csv"})
	public List<Info> getInfos() {
		List<Info> liste = new ArrayList<>();
		liste.add(new Info(1, LocalDate.now().minusDays(1), "Gestern"));
		liste.add(new Info(2, LocalDate.now().plusDays(1), "Morgen"));
		liste.add(new Info(3, LocalDate.now(), "Heute"));
		return liste;
		
	}
	
}
