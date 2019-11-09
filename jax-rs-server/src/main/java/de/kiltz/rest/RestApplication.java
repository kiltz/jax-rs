package de.kiltz.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("/api")
public class RestApplication extends Application {
	// scannt WEB-INF/classes und WEB-INF/lib

	public RestApplication() {
		// Swagger-Config
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/rs/api");
		beanConfig.setResourcePackage(RestApplication.class.getPackage().getName());
		beanConfig.setScan(true);
	}

}
