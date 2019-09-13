package de.kiltz.rest.basic;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * @author tz
 */
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(KommunikationsRestService.class);
    }
}
