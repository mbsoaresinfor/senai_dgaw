package com.mbs.vendasServices.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.vendasServices.entidades.Venda;
import com.mbs.vendasServices.servico.VendasServico;

@RestController
public class VendasControllerAPI {

	@Autowired
	private VendasServico vendasService;
	
	
	@RequestMapping(value = "/v1/vendas", method = RequestMethod.POST)	
	public ResponseEntity<Void> salvarVenda(@RequestBody Venda venda) {		
		System.out.println("processando salvarVenda " + venda);
		vendasService.salvarVendas(venda);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/v1/vendas/", method = RequestMethod.GET)
	public ResponseEntity<List<Venda>> listarVendas() {
		System.out.println("processando listarVendas " );		
		return ResponseEntity.ok(vendasService.listarVendas());
	}
	
	@RequestMapping(value = "/v1/total_vendas", method = RequestMethod.GET)
	public ResponseEntity<Double>  totalVendas() {
		System.out.println("processando totalVendas " );
		return ResponseEntity.ok(vendasService.totalVendas());
	}
	
	
}