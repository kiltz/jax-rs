package de.kiltz.rest.basic;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * @author tz
 */
@Ignore
public class HttpAuthTest {
    private static final String URL = "http://localhost:8080/api/context/security-context";
    private static Client clientNoAuth;
    private static Client clientAuth;

    @BeforeClass
    public static void init() {
        clientNoAuth = ClientBuilder.newClient().register(new JacksonJsonProvider());

        clientAuth = ClientBuilder.newClient().register(new JacksonJsonProvider());
        clientAuth.register(HttpAuthenticationFeature.basic("Ben", "g@nzGeheim1"));

    }

    @AfterClass
    public static void beende() {
        clientNoAuth.close();
        clientAuth.close();
    }

    @Test
    public void testNoHttpAuth() {
        WebTarget target = clientNoAuth.target(URL);
        try {
            String resp = target.request().accept(MediaType.TEXT_PLAIN).get(String.class);
            Assert.fail("Sollte eine Ex werfen");
        } catch (NotAuthorizedException e) {
            // ok!
        }
    }

    @Test
    public void testHttpAuth() {
        WebTarget target = clientAuth.target(URL);
        try {
            String resp = target.request().accept(MediaType.TEXT_PLAIN).get(String.class);
            Assert.assertTrue(resp.contains("Ben"));
        } catch (NotAuthorizedException e) {
            Assert.fail("Sollte keine Ex werfen");
        }
    }

}
