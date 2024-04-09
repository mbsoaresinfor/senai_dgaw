package com.mbs.vendasServices.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.vendasServices.entidades.Venda;
import com.mbs.vendasServices.servico.VendasServico;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API de controle de vendas")
@RestController
public class VendasControllerAPI {

	@Autowired
	private VendasServico vendasService;
	
	@Operation(summary = "Operação para salvar uma venda",
				description = "Salvar uma venda na API de Venda")
	@ApiResponse(responseCode = "200", description = "Sucesso ao salvar")
	@RequestMapping(value = "/v1/vendas", method = RequestMethod.POST)	
	public ResponseEntity<Void> salvarVenda(@RequestBody Venda venda) {		
		System.out.println("processando salvarVenda " + venda);
		vendasService.salvarVendas(venda);
		return ResponseEntity.ok().build();
	}
	
	@Operation(summary = "Operação para listar as vendas",
			description = "Listar todas as vendas")
	@ApiResponse(responseCode = "200", description = "lista de vendas")
	@RequestMapping(value = "/v1/vendas/", method = RequestMethod.GET)
	public ResponseEntity<List<Venda>> listarVendas() {
		System.out.println("processando listarVendas " );		
		return ResponseEntity.ok(vendasService.listarVendas());
	}
	
	@Operation(summary = "Retorna o total de vendas",
			description = "Um valor numerico que identifica "
					+ "o total de vendas")
	@ApiResponse(responseCode = "200", 
			description = "total das vendas")
	@RequestMapping(value = "/v1/total_vendas", method = RequestMethod.GET)
	public ResponseEntity<Double>  totalVendas() {
		System.out.println("processando totalVendas " );
		return ResponseEntity.ok(vendasService.totalVendas());
	}
	
	
}