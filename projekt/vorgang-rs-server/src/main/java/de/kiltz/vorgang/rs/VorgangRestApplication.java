package de.kiltz.vorgang.rs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class VorgangRestApplication {
	private static final Logger LOG = Logger.getLogger(VorgangRestApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(VorgangRestApplication.class, args);
	}

	/**
	 * http://localhost:8080/swagger-ui.html
	 *
	 */
	@Bean
	public Docket api() {
		LOG.info("Erzeuge Swagger-Config...");
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("de.kiltz.vorgang.rs"))
				.paths(PathSelectors.any())
				.build()
				.enable(true)
				.apiInfo(apiInfo());
	}
	public ApiInfo apiInfo() {
		StringVendorExtension vendorExtension = new StringVendorExtension("", "");
		Collection<VendorExtension> vendorExtensions = new ArrayList<>();
		vendorExtensions.add(vendorExtension);

		Contact contactInfo = new Contact("DataPort", "www.dataport.de",
				"info@dataport.de");

		return new ApiInfo(
				"Vorgangsverwaltung",
				"Beispielprojekt für Rest-API",
				"1.0",
				"Demo",
				contactInfo,
				"WTF PL",
				"http://www.wtfpl.net/",
				vendorExtensions);
	}
}
