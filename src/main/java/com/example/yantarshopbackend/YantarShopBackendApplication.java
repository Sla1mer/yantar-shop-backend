package com.example.yantarshopbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class YantarShopBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(YantarShopBackendApplication.class, args);
	}

}
