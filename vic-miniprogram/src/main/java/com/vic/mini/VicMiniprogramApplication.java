package com.vic.mini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.vic")
@EnableFeignClients(basePackages = "com.vic")
@EnableDiscoveryClient
@SpringBootApplication
public class VicMiniprogramApplication {

	public static void main(String[] args) {
		SpringApplication.run(VicMiniprogramApplication.class, args);
	}

}
