package com.mbs.clienteServices.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import com.mbs.clienteServices.entidades.Cliente;
import com.mbs.clienteServices.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

// camada de entrada (API)
@RestController
@CrossOrigin(origins = "http://localhost:9005")
public class ClienteControllerAPI {

	@Autowired
	private ClienteService clienteService;  // injeção de dependência.
	
	@Operation(summary = "Salva um cliente")
	@ApiResponses(value = 
			{@ApiResponse(responseCode = "200",description = "Cadastro com sucesso"),
			@ApiResponse(responseCode = "400",description = "Erro na validação dos campos")})
	@RequestMapping(value = "/v1/cliente",method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody Cliente cliente) {
		System.out.println("executando salvar na controler: " + cliente);
		
		try {
			String id = clienteService.salvar(cliente);
			//retorna para o cliente o status ok 
			// e o id do cliente cadastrado.
			return ResponseEntity.ok(id);
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	}
	
	@Operation(summary = "Retorna uma listagem de todos os clientes cadastrados")
	@ApiResponses(value = 
			{@ApiResponse(responseCode = "200",description = "Lista de clientes")})
	@RequestMapping(value = "/v1/cliente",method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> resultado = clienteService.listar();		
		return ResponseEntity.ok(resultado);
	}
	
	@Operation(summary = "Deletar um cliente pelo seu id")
	@ApiResponses(value = 
	{@ApiResponse(responseCode = "200",description = "Cliente deletado com sucesso"),
		@ApiResponse(responseCode = "400",description = "Não foi removido cliente")})
	@RequestMapping(value = "/v1/cliente/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		System.out.println("executando deletar de cliente id " + id );
		// deleta o cliente pelo id, caso ele exista
		boolean resultado = clienteService.deletar(id);
		if(resultado == true) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
				
		// retorna a lista de clientes
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@Operation(summary = "Atualiza um cliente")
	@ApiResponses(value = 
	{@ApiResponse(responseCode = "200",description = "Cliente atualizado com sucesso"),
		@ApiResponse(responseCode = "400",description = "Erro na atualização do cliente")})
	@RequestMapping(value = "/v1/cliente",method = RequestMethod.PUT)
	public ResponseEntity<String> atualizar(@RequestBody Cliente cliente) {
		
		boolean resultado = clienteService.atualizar(cliente);
		if(resultado == true) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}else {		
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@Operation(summary = "Retorna true caso cliente exista ou false se não existir no sistema")
	@ApiResponses(value = 
			{@ApiResponse(responseCode = "200",description = "TRUE=existir ou FALSE=não existir")})
	@RequestMapping(value = "/v1/cliente/existe-cliente/{id}",method = RequestMethod.GET)
	public ResponseEntity<Boolean> existeCliente(@PathVariable Integer id) { 
		System.out.println("executando existeCliente");
		boolean resultado = clienteService.existeCliente(id);
		return ResponseEntity.ok(resultado);		
	}
	
	@Operation(summary = "Retorna um cliente pelo seu ID.")
	@ApiResponses(value = 
	{@ApiResponse(responseCode = "200",description = "Cliente retornado com sucesso"),
	@ApiResponse(responseCode = "204",description = "Não encontrado cliente")})
	@RequestMapping(value = "/v1/cliente/buscar-cliente/{id}",method = RequestMethod.GET)
	public ResponseEntity<Cliente> buscarCliente(@PathVariable Integer id) { 
		
		Cliente resultado = clienteService.buscarCliente(id);
		if(resultado != null) {
			return ResponseEntity.ok(resultado);
		}else {		
			return ResponseEntity.noContent().build();
		}
	}
}
