package com.mbs.apigw.comunicacao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mbs.apigw.entidades.Venda;



@FeignClient(value = "VendasService",
url = "http://localhost:9002/")
public interface VendasServiceRoteamento {

	@RequestMapping(value = "/v1/venda",
			method = RequestMethod.POST)
	public ResponseEntity<String> 
	salvar(@RequestBody Venda venda);
}
