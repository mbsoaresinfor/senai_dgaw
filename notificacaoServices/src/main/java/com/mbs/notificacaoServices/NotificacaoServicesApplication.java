package com.mbs.notificacaoServices;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class NotificacaoServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificacaoServicesApplication.class, args);
	}

}
