package com.handsome.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ManagerApplication  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ManagerApplication.class);
    }
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ManagerApplication.class.getName());
        logger.info("application begin to start");
        SpringApplication.run(ManagerApplication.class, args);
    }

}
