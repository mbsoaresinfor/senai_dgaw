package com.mbs.apigw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiGwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGwApplication.class, args);
	}

}
