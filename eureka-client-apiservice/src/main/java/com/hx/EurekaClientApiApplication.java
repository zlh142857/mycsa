package com.hx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApiApplication.class, args);
    }
}
