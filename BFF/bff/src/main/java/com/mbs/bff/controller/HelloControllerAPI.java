package com.mbs.bff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.bff.comunicacao.HelloController;

@RestController
public class HelloControllerAPI {

	
		@Autowired
		private HelloController helloController;
	
		// exemplo de chamada de um BFF para outro servico
		@RequestMapping(value = "/hello-api", method = RequestMethod.GET)	 
		public ResponseEntity<String> helloApi() throws Exception {		 
			System.out.println("Processando hello-api, chamando helloControllerAPI no micro servico de vendasSErvice");
		    return helloController.helloApi();			 
		}
}
