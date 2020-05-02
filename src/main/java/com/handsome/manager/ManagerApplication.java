package com.handsome.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManagerApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ManagerApplication.class.getName());
        logger.info("application begin to start");
        SpringApplication.run(ManagerApplication.class, args);
    }

}
