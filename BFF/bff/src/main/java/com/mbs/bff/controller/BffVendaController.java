package com.mbs.bff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.bff.comunicacao.VendasService;
import com.mbs.bff.entidades.Venda;

@RestController
public class BffVendaController {
	
	@Autowired
	private VendasService vendasService;
	
	@RequestMapping(value = "/v1/vendas", method = RequestMethod.POST)	
	public ResponseEntity<Void> salvarVenda(@RequestBody Venda venda){
		System.out.println("processando bff salvarvenda");
		return vendasService.salvarVenda(venda);
	}
		
}
