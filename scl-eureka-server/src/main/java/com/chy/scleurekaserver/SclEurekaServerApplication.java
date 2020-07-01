package com.chy.scleurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SclEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SclEurekaServerApplication.class, args);
    }

}
