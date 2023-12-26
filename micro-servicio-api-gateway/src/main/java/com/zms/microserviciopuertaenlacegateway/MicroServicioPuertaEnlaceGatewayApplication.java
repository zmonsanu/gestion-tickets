package com.zms.microserviciopuertaenlacegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroServicioPuertaEnlaceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicioPuertaEnlaceGatewayApplication.class, args);
	}

}
