package com.mbs.apigw;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableRabbit
@SpringBootApplication
@EnableFeignClients
public class ApiGwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGwApplication.class, args);
	}

}
