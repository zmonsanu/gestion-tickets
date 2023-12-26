package com.zms.microservicioconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroServicioConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicioConfigServerApplication.class, args);
	}

}
