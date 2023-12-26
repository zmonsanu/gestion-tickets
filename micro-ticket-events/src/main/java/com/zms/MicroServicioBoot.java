package com.zms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.zms")
public class MicroServicioBoot {
    public static void main(String[] args) {

        SpringApplication.run(MicroServicioBoot.class, args);
        System.out.println("Servicio EVENTS ON!!");
    }
}
