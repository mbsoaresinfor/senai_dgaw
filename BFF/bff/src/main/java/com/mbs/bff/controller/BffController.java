package com.mbs.bff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.bff.comunicacao.ClienteService;
import com.mbs.bff.comunicacao.VendasService;
import com.mbs.bff.entidades.Venda;

@RestController
public class BffController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private VendasService vendasService;
	
	// orquestramento de serviços
	@RequestMapping(value = "/v1/bff", method = RequestMethod.POST)	
	public ResponseEntity<Boolean> processarVenda(@RequestBody Venda venda){
		System.out.println("processando bff processarVenda");
		ResponseEntity<Boolean> respostaExisteCliente = 
				clienteService.existeCliente(venda.getCodCliente().longValue());
				
		if(respostaExisteCliente.getBody().equals(false)) {
			return ResponseEntity.ok(false);
		}
		
		vendasService.salvarVenda(venda);
		return ResponseEntity.ok(true);
	}
}
