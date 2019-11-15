package de.kiltz.rest.infos;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Providers;

import io.swagger.annotations.Api;

@Path("/context")
@Api("context")
public class ContextRestService {
    @GET
    @Path("uri-info")
    @Produces("text/plain")
    public String getUriInfo(@Context UriInfo info) {
        StringBuilder txt = new StringBuilder("UriInfo:\n----------\n");
        txt.append("Path: " + info.getPath());
        txt.append("\nAbsolutePath(): " + info.getAbsolutePath());
        txt.append("\nBaseUri(): " + info.getBaseUri());

        for (Map.Entry<String, List<String>> e : info.getQueryParameters().entrySet()) {
            txt.append("\n" + e.getKey() + ": " + e.getValue());
        }

        return txt.toString();
    }

    @GET
    @Path("http-headers")
    @Produces("text/plain")
    public String getHttpHeaders(@Context HttpHeaders info) {
        StringBuilder txt = new StringBuilder("Headers:\n----------\n");
        for (Map.Entry<String, List<String>> e : info.getRequestHeaders().entrySet()) {
            txt.append("\n" + e.getKey() + ": " + e.getValue());
        }

        return txt.toString();
    }

    @GET
    @Path("request")
    @Produces("text/plain")
    public String getRequest(@Context Request info) {
        StringBuilder txt = new StringBuilder("Request:\n----------\n");
        txt.append("Method: " + info.getMethod());

        return txt.toString();
    }

    /**
     * Für Sicherheit mit Spring s. z.B. 
     * https://o7planning.org/de/11649/sichere-spring-boot-restful-service-mit-basic-authentication
     * oder
     * http://codeboarding.com/2017/10/05/restful-https-web-services-with-spring-boot-jersey-using-basic-authentication/
     * 
     * @param info
     * @return
     */
    @GET
    @Path("security-context")
    @Produces("text/plain")
    public String getSecurityContext(@Context SecurityContext info) {
        StringBuilder txt = new StringBuilder("SecurityContext:\n----------\n");
        txt.append("UserPrincipal: ");
        txt.append(info.getUserPrincipal() == null ? "Keiner" : info.getUserPrincipal().getName());

        return txt.toString();
    }

    @GET
    @Path("providers")
    @Produces("text/plain")
    public String getProviders(@Context Providers info) {
        StringBuilder txt = new StringBuilder("Providers:\n----------\n");
        txt.append("Providers: " + info.toString());

        return txt.toString();
    }

    @GET
    @Path("http-request")
    @Produces("text/plain")
    public String getHttpRequest(@Context HttpServletRequest req) {
        StringBuilder txt = new StringBuilder("HttpServletRequest:\n----------\n");
        if (req != null) {
            txt.append("ContextPath: " + req.getContextPath());
            txt.append("\nRemoteAddr: " + req.getRemoteAddr());
        } else {
            txt.append("HttpServletRequest ist null ");
        }

        return txt.toString();
    }

}
