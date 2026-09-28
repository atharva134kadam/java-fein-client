package com.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.car.client")
public class carApplication{
	public static void main(String[] args) {
		SpringApplication.run(carApplication.class,	 args);
	}
}