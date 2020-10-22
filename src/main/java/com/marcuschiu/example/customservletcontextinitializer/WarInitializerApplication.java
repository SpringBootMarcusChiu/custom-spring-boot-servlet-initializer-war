package com.marcuschiu.example.customservletcontextinitializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBootServletInitializer is an extension of WebApplicationInitializer
 * which runs a SpringApplication from a traditional WAR archive deployed on
 * a web container. This class binds Servlet, Filter and ServletContextInitializer
 * beans from the application context to the server
 *
 * Extending the SpringBootServletInitializer class also allows us to configure
 * our application when it's run by the servlet container, by overriding the
 * configure() method
 *
 * Now:
 * - if we package our application as a WAR, we'll be able to deploy it on
 * any web container in a traditional way, which will also execute the logic
 * we added in the configure() method.
 * - if we want to package it as a JAR file, then we'll need to add the same logic
 * to the main() method so that the embedded container can pick it up as well
 */
@SpringBootApplication
public class WarInitializerApplication extends SpringBootServletInitializer {

    /**
     * this method uses SpringApplicationBuilder to simply register our class as
     * a configuration class of the application
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WarInitializerApplication.class);
    }

    public static void main(String[] args) {
//        SpringApplication sa = new SpringApplication(WarInitializerApplication.class);
//        sa.run(args);
        SpringApplication.run(WarInitializerApplication.class, args);
    }

    @RestController
    public static class WarInitializerController {
        @GetMapping("/")
        public String handler() {
            return "hello world";
        }
    }
}
