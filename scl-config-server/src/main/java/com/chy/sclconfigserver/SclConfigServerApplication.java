package com.chy.sclconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SclConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SclConfigServerApplication.class, args);
    }

}
