package de.kiltz.rest.basic;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import de.kiltz.rest.suche.SuchParameter;

// @Ignore
public class SucheTest {
    private static final String URL = "http://localhost:8088/rs/api/suche/";
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
    public void testSuche() throws UnsupportedEncodingException {
        SuchParameter p = new SuchParameter();
        p.setName("Kiltz");
        p.setVorname("Friedrich");
        p.setMindestUmsatz(500);
        WebTarget target = client.target(URL).queryParam("q", URLEncoder.encode(p.toString(), "UTF-8"));
        String resp = target.request().accept(MediaType.TEXT_PLAIN).get(String.class);
        System.out.println(resp);
    }

}
