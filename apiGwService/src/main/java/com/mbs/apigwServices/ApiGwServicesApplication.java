package com.mbs.apigwServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiGwServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGwServicesApplication.class, args);
	}

}
