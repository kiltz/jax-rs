package de.kiltz.rest.basic;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

// @Ignore
public class DateiTest {
    private static final String URL = "http://localhost:8088/rs/api/datei/";
    private static Client client;

    @BeforeClass
    public static void init() {
        client = ClientBuilder.newClient().register(new JacksonJsonProvider());

    }

    @AfterClass
    public static void beende() {
        client.close();
    }

    @Test
    public void testSuche() throws IOException {
        WebTarget target = client.target(URL).queryParam("laenge", "50").queryParam("typ", "txt");
        Response resp = target.request().accept(MediaType.APPLICATION_OCTET_STREAM).get();
        InputStream in = resp.readEntity(InputStream.class);

        String txt = new BufferedReader(new InputStreamReader(in)).lines().parallel().collect(Collectors.joining("\n"));
        in.close();

        System.out.println(txt);
    }

    @Test
    public void testPost() {
        WebTarget target = client.target(URL);
        InputStream in = getInput();
        Response resp = target.request().post(Entity.entity(in, MediaType.MULTIPART_FORM_DATA));
        System.out.println(resp.getStatus());
    }

    private InputStream getInput() {

        return new ByteArrayInputStream("In den Betten der Hutmacher...".getBytes());
    }
}
