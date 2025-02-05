package com.mbs.clienteServices.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerAPI {

	// exemplo de api rest
	@RequestMapping(value = "/hello-api", method = RequestMethod.GET)	 
	public ResponseEntity<String> helloApi() throws Exception {		 
		System.out.println("Processando hello-api");
		 return ResponseEntity.ok("Hello API");
	}
}