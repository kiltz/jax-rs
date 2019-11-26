package de.kiltz.vorgang.rs;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.kiltz.vorgang.main.service.VorgangsException;
import de.kiltz.vorgang.main.service.VorgangsService;
import de.kiltz.vorgang.main.service.VorgangsServiceImpl;
import de.kiltz.vorgang.main.service.data.VorgangInfo;
import io.swagger.annotations.Api;

@Path("/v1/vorgaenge")
@Api("/v1/vorgaenge")
public class VorgangRestService {
	private VorgangsService service;

	public VorgangRestService() {
		service = new VorgangsServiceImpl();
	}
	
	public Page<VorgangInfo> getVorgaenge(int page, int size, String name) {
		List<VorgangInfo> liste = new ArrayList<>();
		// Todo: Liste füllen
		int totalElements = 200;
		return new Page<VorgangInfo>(liste, page, size, totalElements );
	}

	@GET
	@Path("{id}")
	public VorgangInfo getVorgang(@PathParam("id") long id) {
		VorgangInfo v = service.hole(id);
		if (v == null) {
			throw new NotFoundException();
		}
		return v;
	}

	@POST
	public Response postVorgang(VorgangInfo v) {
		try {
			v = service.neu(v);
		} catch (VorgangsException e) {
			Response resp = Response.status(Response.Status.BAD_REQUEST).type(MediaType.TEXT_PLAIN)
					.entity(e.getMessage()).build();
			throw new BadRequestException(resp);
		}

		return Response.created(URI.create("/v1/vorgaenge/" + v.getId())).build();

	}

	@PUT
	public void putVorgang(VorgangInfo v) {
		try {
			service.aktualisiere(v);
		} catch (VorgangsException e) {
			throw new BadRequestException(e);
		}
	}

	@DELETE
	public void deleteVorgang(long id) {
		service.loesche(id);
	}
}
