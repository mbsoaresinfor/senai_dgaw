package com.mbs.apigw.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.apigw.comunicacao.HelloController;

@RestController
public class HelloControllerAPI {

		@Autowired
		private AmqpTemplate rabbitTemplate;
		
		@Value("${exchange}")
		private String exchange;
	
		@Autowired
		private HelloController helloController;
	
		// exemplo de chamada de um Api Gw para outro servico
		@RequestMapping(value = "/hello-api", method = RequestMethod.GET)	 
		public ResponseEntity<String> helloApi() throws Exception {		 
			System.out.println("Processando hello-api, chamando helloControllerAPI no micro servico de vendasSErvice");
		    return helloController.helloApi();			 
		}
		
		@RequestMapping(value = "/teste_mensagem", method = RequestMethod.GET)	
		public void teste(){
		rabbitTemplate.convertAndSend("", exchange, "teste_mensagem");
	}
}
