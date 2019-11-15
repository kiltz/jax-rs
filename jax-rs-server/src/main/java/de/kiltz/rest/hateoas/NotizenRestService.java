package de.kiltz.rest.hateoas;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import io.swagger.annotations.Api;

@Path("/notizen")
@Api("notizen")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NotizenRestService {

    @GET
    public Response getNotizen(@QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("size") @DefaultValue("10") int size, @Context UriInfo uriInfo) {

        List<Notiz> notizen = new ArrayList<>();
        for (int i = page * size; i < (page + 1) * size; ++i) {
            notizen.add(new Notiz(i + 1L, "Titel " + (i + 1), "Inhalt..."));
        }

        List<Link> links = new ArrayList<>();

        if (page < 10) {
            links.add(
                    Link.fromUri(getUri(uriInfo, page + 1, size)).rel("next").type(MediaType.APPLICATION_JSON).build());
        }
        if (page > 1) {
            links.add(Link.fromUri(getUri(uriInfo, page - 1, size)).rel("previous").type(MediaType.APPLICATION_JSON)
                    .build());
        }

        Response response = Response.ok(notizen).links(links.stream().toArray(Link[]::new)).build();
        return response;
    }

    @Path("{id}")
    @GET
    public Response getNotiz(@PathParam("id") Long id) {
        Notiz n = new Notiz(id, "Titel Nr. " + id, "Lalala");
        // ...

        return Response.ok(n).build();
    }

    private URI getUri(UriInfo uriInfo, int page, int size) {
        URI uri = UriBuilder.fromUri(uriInfo.getAbsolutePath()).queryParam("page", page).queryParam("size", size)
                .build();

        return uri;
    }

}
