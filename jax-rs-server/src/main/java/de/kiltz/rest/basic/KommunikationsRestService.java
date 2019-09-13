package de.kiltz.rest.basic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tz
 */

@RestController
@RequestMapping(path = "rs/api/basic")
public class KommunikationsRestService {

    /**
     * Testmethode für Überprüfung der Kommunikation
     * curl -i http://127.0.0.1:8080/rs/api/basic/ping?s=test -H "ACCEPT:text/plain"
     *
     * Jax-RS:
     *    @GET
     *    @Path("ping")
     *    @Produces("text/plain")
     *
     *    mit @QueryParam("s")
     *
     * @param txt
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "ping", produces = "text/plain")
    public String pingPlain(@RequestParam("s") String txt) {
        txt = txt == null ? "NULL" : txt;
        return txt.toUpperCase();
    }
}
