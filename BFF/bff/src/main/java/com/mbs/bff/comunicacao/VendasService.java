package com.mbs.bff.comunicacao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mbs.bff.entidades.Venda;



@FeignClient(value = "VendasController", url = "http://localhost:9002/")
public interface VendasService {
	
	@RequestMapping(value = "/v1/vendas", method = RequestMethod.POST)	
	public ResponseEntity<Void> salvarVenda(@RequestBody Venda venda);	
	
	@RequestMapping(value = "/v1/vendas/revisao",method = RequestMethod.GET)
	public ResponseEntity<Void> revisao() ;
		
	

}
