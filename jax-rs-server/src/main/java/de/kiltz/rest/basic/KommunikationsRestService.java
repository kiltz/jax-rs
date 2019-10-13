package de.kiltz.rest.basic;

import java.io.File;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Encoded;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("basic")
public class KommunikationsRestService {

	// Alternative zum PathParameter, wird mit ; abgetrennt
	@MatrixParam("info")
	@DefaultValue("Life")
	@Encoded
	private String info;


	/**
	 * Testmethode für Überprüfung der Kommunikation
	 * curl -i http://127.0.0.1:8080/rs/api/basic/ping?s=test -H "ACCEPT:text/plain"
	 * oder
	 * curl -i "http://127.0.0.1:8080/rs/api/basic/ping;info=dev?s=test" -H "ACCEPT:text/plain"
	 *
	 * @param txt der Query-Param
	 * @return der Query-Param und der Matix-Param
	 */
	@GET
	@Path("ping")
	@Produces("text/plain")
	public String pingPlain(@QueryParam("s") String txt) {
		txt = txt == null ? "NULL" : txt;
		return txt.toUpperCase()+ " "+ info;
	}
	
	/**
	 * Testmethode für Überprüfung der POST-Kommunikation Test mit: 
	 * curl -i http://localhost:8080/rs/api/basic/ping -d txt=test
	 * 
	 * @param txt ein Query-Param
	 * @return den Text mit dem Prefix "POST"
	 */
	@POST
	@Path("ping")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String pingPost(@FormParam("txt") String txt) {

		return "POST: " + txt;
	}


	/**
	 * Testmethode für Überprüfung der Kommunikation in HTML
	 * 
	 * @param txt ein Query-Param
	 * @return den übergebenen Text in Kleinbuchstaben als Überschrift.
	 */
	@GET
	@Path("ping")
	@Produces(MediaType.TEXT_HTML)
	public String pingHTML(@QueryParam("s") String txt) {
		return "<h2>" + txt.toLowerCase() + " " + info + "</h2>";
	}

	/**
	 * Kleines Formular.
	 * 
	 * @param x irgend ein Wert
	 * @param y irgend ein anderer Wert
	 * @return den Inhalt der Parameter
	 */
	@POST
	@Path("x-plus-y")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String pingForm(@FormParam("x") String x, @FormParam("y") String y) {

		return "Eingaben x: " + x + " y: " + y;
	}

	/**
	 * 
	 * @param image der Dateiname des Bildes
	 * @param ctx ServletContext um den Pfad zu den Bildern zu holen
	 * @return das Bild oder einen 404
	 */
	@GET
	@Path("images/{image}")
	@Produces("image/*")
	public Response getImage(@PathParam("image") String image, @Context ServletContext ctx) {
		
		File f = new File(ctx.getRealPath("/img/")+image);
		System.out.println(f.getAbsolutePath());
		if (!f.exists()) {
			throw new WebApplicationException(404);
		}

		String mt = new MimetypesFileTypeMap().getContentType(f);
		return Response.ok(f, mt).build();
	}

	/**
	 * curl -i http://127.0.0.1:8080/rs/api/basic/daten -H "ACCEPT:application/xml"
	 * oder
	 * curl -i http://127.0.0.1:8080/rs/api/basic/daten -H "ACCEPT:application/json"
	 *   
	 * @return Das Datenobjekt im JSON- oder XML-Format, je nach ACCEPT-Header.
	 */
	@GET
	@Path("daten")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public RootDatenTypen getDaten() {

		return new RootDatenTypen();
	}

	/**
	 * 
	 * @param obj Das Daten-Objekt
	 * @return Das Datenobjekt in XML
	 */
	@POST
	@Path("daten")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public RootDatenTypen getUndSetDatenInXML(RootDatenTypen obj) {
		System.out.println("Erhalte "+obj);
		obj.setZahl(obj.getZahl() * 2);
		return obj;
	}

}
