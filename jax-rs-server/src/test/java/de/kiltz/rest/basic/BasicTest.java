package de.kiltz.rest.basic;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class BasicTest {
    private static final String URL = "http://localhost:8081/rs/api/basic/";
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
    public void testPing() {
        String query = "Test";
        String matrix = "JUnit";
        WebTarget target = client.target(URL).path("ping").matrixParam("info", matrix).queryParam("s", query);
        String resp = target.request().accept(MediaType.TEXT_PLAIN).get(String.class);
        Assert.assertEquals(query.toUpperCase()+" "+matrix, resp);

    }

    @Test
    public void testDaten() {
        WebTarget target = client.target(URL).path("daten");
        RootDatenTypen resp = target.request().accept(MediaType.APPLICATION_JSON_TYPE).get(RootDatenTypen.class);

        Assert.assertNotNull(resp);
        Assert.assertNotNull(resp.getDatum());
        Assert.assertNotNull(resp.getKomplexeListe());

        RootDatenTypen resp2 = target.request().accept(MediaType.APPLICATION_XML_TYPE)
                .post(Entity.entity(resp, MediaType.APPLICATION_XML_TYPE), RootDatenTypen.class);
        Assert.assertEquals(resp.getZahl() * 2 , resp2.getZahl());

    }
}
