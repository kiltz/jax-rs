package de.kiltz.rest.swagger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author tz
 */
public class SwaggerBootstrap extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
/*
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("de.kiltz.rest");
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true);

 */
    }
}
