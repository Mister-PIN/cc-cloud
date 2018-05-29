package com.cc.servercentre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerCentreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerCentreApplication.class, args);
	}
}
