package com.hx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientScheduleApplication.class, args);
    }
}
