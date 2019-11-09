package de.kiltz.rest.datei;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import io.swagger.annotations.Api;

@Path("datei")
@Api("/datei")
public class DateiRestService {

	@GET
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getDatei(@QueryParam("laenge") int laenge, @QueryParam("typ") String typ) throws IOException {
		if ("txt".equals(typ)) {
			System.out.println("Textdatei");
			return realeDatei(laenge);
		}
		if ("zip".equals(typ)) {
			return gezippteDateien(laenge);
		} else {
			return virtuelleDatei(laenge);
		}
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void postDatei(InputStream in) throws IOException {
		java.nio.file.Path datei = erstelleTmpPfad().resolve("upload.txt");
		Files.deleteIfExists(datei);
		System.out.println(datei);
		Files.copy(in, datei);

	}

	private Response gezippteDateien(int laenge) throws IOException {
		java.nio.file.Path zipDatei = erstelleTmpPfad().resolve("test.zip");
		erstelleZip(zipDatei, laenge);

		StreamingOutput stream = output -> Files.copy(zipDatei, output);
		return Response.ok(stream).header("Content-Disposition", "attachment; filename=ergebnis.zip").build();
	}

	private Response realeDatei(int laenge) throws IOException {
		// Datei anlegen
		java.nio.file.Path datei = erstelleTmpPfad().resolve("test.txt");
		legeDateiAn(datei, laenge);

		// Datei einlesen
		StreamingOutput stream = output -> Files.copy(datei, output);
		return Response.ok(stream).header("Content-Disposition", "attachment; filename=ergebnis.txt").build();
	}

	private Response virtuelleDatei(int laenge) {
		String text = machText(laenge);
		StreamingOutput stream = output -> output.write(text.toString().getBytes());
		return Response.ok(stream).header("Content-Disposition", "attachment; filename=ergebnis.txt").build();
	}

	private String machText(int laenge) {
		StringBuilder txt = new StringBuilder();
		for (int i = 0; i <= laenge; ++i) {
			txt.append(String.format("%d x %d = %d ", i, i, i * i));
		}
		return txt.toString();

	}

	private java.nio.file.Path erstelleTmpPfad() throws IOException {
		java.nio.file.Path p = Paths.get(System.getProperty("java.io.tmpdir"), "jax-rs");
		if (!Files.isDirectory(p)) {
			Files.createDirectory(p);
		}
		return p;
	}

	private void legeDateiAn(java.nio.file.Path datei, int laenge) throws IOException {
		String text = machText(laenge);
		System.out.println("Lege Datei " + datei + " an...");
		Files.write(datei, text.getBytes());

	}

	private void erstelleZip(java.nio.file.Path zipDatei, int laenge) throws IOException {
		java.nio.file.Path datei1 = erstelleTmpPfad().resolve("test1.txt");
		legeDateiAn(datei1, laenge);
		java.nio.file.Path datei2 = erstelleTmpPfad().resolve("test2.txt");
		legeDateiAn(datei2, laenge * 2);

		try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipDatei.toFile()))) {
			zos.putNextEntry(new ZipEntry("test1.txt"));
			zos.write(Files.readAllBytes(datei1));
			zos.closeEntry();
			zos.putNextEntry(new ZipEntry("test2.txt"));
			zos.write(Files.readAllBytes(datei2));
			zos.closeEntry();
			zos.close();
		}

	}
}
