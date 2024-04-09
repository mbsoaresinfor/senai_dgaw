package com.mbs.clienteServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.clienteServices.entidades.Cliente;
import com.mbs.clienteServices.servicos.ClienteServico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ClienteControllerAPI {

	@Autowired
	private ClienteServico clienteServico;
	
	@Operation(summary = "Operação para salvar um cliente",
			description = "Salvar um cliente na API de Cliente")
	@ApiResponse(responseCode = "200", description = "Sucesso ao salvar")
	@RequestMapping(value = "/v1/cliente",method = RequestMethod.POST)
	public ResponseEntity<Long> salvar(@RequestBody Cliente cliente) {
		System.out.println("executando salvar " + cliente);
		Long id = clienteServico.salvar(cliente);
		return ResponseEntity.ok(id);
	}
	
	@Operation(summary = "Operação para buscar um cliente",
			description = "Buscar um cliente na API de Cliente")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200",
	        		description = "sucesso ao buscar"),
	        @ApiResponse(responseCode = "204", description = "Nao encontrado cliente pelo id")})
	@RequestMapping(value = "/v1/cliente/{id}",method = RequestMethod.GET)
	public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
		System.out.println("executando buscar pelo id " + id);
		Cliente cliente = clienteServico.buscar(id);
		if(cliente != null) {
			return ResponseEntity.ok(cliente);
		}else {
			return ResponseEntity
					.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@Operation(summary = "Operação para deletar um cliente",
			description = "Deletar um cliente na API de Cliente")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200",
	        		description = "sucesso ao remover"),
	        @ApiResponse(responseCode = "404", description = "Nao encontrado cliente pelo id")})
	@RequestMapping(value = "/v1/cliente/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> remover(@PathVariable Long id) {		
		System.out.println("executando remover pelo id " + id);
		Cliente cliente = clienteServico.buscar(id);
		if(cliente == null) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND).build();
		}
		boolean resultado = clienteServico.remover(id);
		return ResponseEntity.ok(resultado);
	}
	
	
	@Operation(summary = "Operação para atualizar um cliente",
			description = "Atualizar um cliente na API de Cliente")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200",
	        		description = "sucesso ao buscar"),
	        @ApiResponse(responseCode = "404", description = "Nao encontrado cliente pelo id")})
	@RequestMapping(value = "/v1/cliente",method = RequestMethod.PUT)
	public ResponseEntity<Boolean> atualizar(@RequestBody Cliente cliente) {
		System.out.println("executando atualizar pelo id " + cliente.getId());
		Cliente clienteBuscado = clienteServico.buscar(cliente.getId());
		if(clienteBuscado == null) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND).build();
		}
		clienteServico.atualizar(cliente);
		return ResponseEntity.ok(true);
	}
}
