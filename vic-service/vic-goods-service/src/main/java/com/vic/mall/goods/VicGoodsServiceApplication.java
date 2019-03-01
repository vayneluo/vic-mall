package com.vic.mall.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class VicGoodsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VicGoodsServiceApplication.class, args);
	}

}
