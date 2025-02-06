package com.mbs.apigw.comunicacao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "HelloController", url = "http://localhost:9002/")
public interface HelloController {

	@RequestMapping(value = "/hello-api", method = RequestMethod.GET)	 
	public ResponseEntity<String> helloApi() throws Exception;	
	
}

