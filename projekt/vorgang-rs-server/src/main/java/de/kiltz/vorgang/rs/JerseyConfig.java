package de.kiltz.vorgang.rs;

import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;

/**
 * @author tz
 */
@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    private static final Logger LOG = Logger.getLogger(JerseyConfig.class.getName());

    public JerseyConfig() {

        BeanConfig swaggerConfig = new BeanConfig();
        swaggerConfig.setBasePath("/api");
        SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);

        packages(getClass().getPackage().getName(),
                ApiListingResource.class.getPackage().getName());

    }
}
