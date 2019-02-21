package com.github.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.github.manage.repository.manage")
@EnableCaching
@EnableAsync
public class VicManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(VicManageApplication.class, args);
	}

}

