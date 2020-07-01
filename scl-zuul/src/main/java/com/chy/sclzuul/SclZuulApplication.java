package com.chy.sclzuul;

import com.chy.sclzuul.config.PreRequestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableHystrix
@EnableZuulProxy
@EnableFeignClients
@SpringBootApplication
public class SclZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SclZuulApplication.class, args);
    }

    @Bean
    public PreRequestFilter preRequestFilter() {
        return new PreRequestFilter();
    }

}
