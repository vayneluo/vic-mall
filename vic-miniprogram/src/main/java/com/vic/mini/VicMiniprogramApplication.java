package com.vic.mini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class VicMiniprogramApplication {

	public static void main(String[] args) {
		SpringApplication.run(VicMiniprogramApplication.class, args);
	}

}
