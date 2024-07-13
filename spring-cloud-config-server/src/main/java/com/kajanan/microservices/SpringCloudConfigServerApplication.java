package com.kajanan.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableConfigServer
@SpringBootApplication
@ComponentScan(basePackages = "com.kajanan")
public class SpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
	}

}
