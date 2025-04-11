package com.mbs.vendasServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.mbs.vendasServices.entidades.Venda;
import com.mbs.vendasServices.service.VendasService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin(origins = "http://localhost:9005")
@Controller
public class VendasControllerAPI {

	@Autowired
	private VendasService vendasService;
	
	@Operation(summary = "salvar uma venda")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", 
					description = "salvo com sucesso"),
			@ApiResponse(responseCode = "400",
			description = "erro de validação na venda")
	})	
	@RequestMapping(value = "/v1/venda",method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody Venda venda) {
		System.out.println("executando salvar " + venda);
		
		try {
			Integer id = vendasService.salvar(venda);
			return ResponseEntity.ok(id.toString());
		}catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	}
	
	@Operation(summary = "listar vendas")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", 
					description = "retorna uma lista de vendas")	})	
	@RequestMapping(value = "/v1/venda",method = RequestMethod.GET)
	public ResponseEntity<List<Venda>> listar() {
		
		System.out.println("executando listar " );
		return ResponseEntity
				.ok(vendasService.listar());
	}
	
	@Operation(summary = "retorna o total de vendas realizadas")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", 
					description = "retorna o total de vendas realizadas")})
	@RequestMapping(value = "/v1/venda/total_venda",
			method = RequestMethod.GET)
	public ResponseEntity<Integer> totalVenda() {
		System.out.println("total de venda ");		
		return ResponseEntity.ok(vendasService.listar().size());
	}
	
	@Operation(summary = "retorna o total em valores em reais das vendas realizadas")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", 
					description = "retorna o total em valores em reais das vendas realizadas")})
	@RequestMapping(value = "/v1/venda/total_valores_venda",
			method = RequestMethod.GET)
	public ResponseEntity<Double> totalValoresVenda() {
		System.out.println("totalValoresVenda ");		
		return ResponseEntity.ok(vendasService.totalValoresVenda());
	}
	
	
}
