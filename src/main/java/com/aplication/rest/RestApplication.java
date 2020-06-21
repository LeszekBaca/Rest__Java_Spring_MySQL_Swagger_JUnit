package com.aplication.rest;

import com.aplication.rest.configuration.RestApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@SpringBootApplication
public class RestApplication extends AbstractAnnotationConfigDispatcherServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RestApplication.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{RestApplicationConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
