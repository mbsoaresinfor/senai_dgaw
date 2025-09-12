package com.mbs.clienteServices.controller;

import java.util.ArrayList;
import java.util.List;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "http://localhost:9005")
public class ClienteControllerAPI {

	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	private static Integer id = 0;
	
	@Operation(summary = "Salva um cliente")
	@ApiResponses(value = 
			{@ApiResponse(responseCode = "200",description = "Cadastro com sucesso"),
			@ApiResponse(responseCode = "400",description = "Erro na validação dos campos")})
	@RequestMapping(value = "/v1/cliente",method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody Cliente cliente) {
		System.out.println("executando salvar " + cliente);
		
		// simples validacao de negocio
		if(cliente.getNome() == null || ( cliente.getNome() != null && cliente.getNome().length() <=2 )){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST). body("Nome do cliente deve ter no minimo 3 caracteres");
		}
		// cria um id para o cliente
		cliente.setId(++id);
		// adiciona na lista
		listaCliente.add(cliente);
		//retorna para o cliente o status ok e o id do cliente cadastrado.
		return ResponseEntity.ok(id.toString());
	}
	
	@Operation(summary = "Retorna uma listagem de todos os clientes cadastrados")
	@ApiResponses(value = 
			{@ApiResponse(responseCode = "200",description = "Lista de clientes")})
	@RequestMapping(value = "/v1/cliente",method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listar() {
		System.out.println("executando listar " );
		// retorna a lista de clientes
		return ResponseEntity.ok(listaCliente);
	}
	
	@Operation(summary = "Deletar um cliente pelo seu id")
	@ApiResponses(value = 
	{@ApiResponse(responseCode = "200",description = "Cliente deletado com sucesso"),
		@ApiResponse(responseCode = "400",description = "Não foi removido cliente")})
	@RequestMapping(value = "/v1/cliente/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		System.out.println("executando deletar de cliente id " + id );
		// deleta o cliente pelo id, caso ele exista
		boolean resultado = listaCliente.removeIf( (obj) ->  obj.getId().equals(id));
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
		for(Cliente c : listaCliente) {
			if(c.getId().equals(cliente.getId())) {
				c.setCep(cliente.getCep());
				c.setCpf(cliente.getCpf());
				c.setEmail(cliente.getEmail());
				c.setNome(cliente.getNome());
				return ResponseEntity.status(HttpStatus.OK).build();
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@Operation(summary = "Retorna true caso cliente exista ou false se não existir no sistema")
	@ApiResponses(value = 
			{@ApiResponse(responseCode = "200",description = "TRUE=existir ou FALSE=não existir")})
	@RequestMapping(value = "/v1/cliente/existe-cliente/{id}",method = RequestMethod.GET)
	public ResponseEntity<Boolean> existeCliente(@PathVariable Integer id) { 
		for(Cliente c : listaCliente) {
			if(c.getId().equals(id)) {
				return ResponseEntity.ok(Boolean.TRUE);				
			}
		}
		return ResponseEntity.ok(Boolean.FALSE);		
	}
	
	@Operation(summary = "Retorna um cliente pelo seu ID.")
	@ApiResponses(value = 
	{@ApiResponse(responseCode = "200",description = "Cliente retornado com sucesso"),
	@ApiResponse(responseCode = "204",description = "Não encontrado cliente")})
	@RequestMapping(value = "/v1/cliente/buscar-cliente/{id}",method = RequestMethod.GET)
	public ResponseEntity<Cliente> buscarCliente(@PathVariable Integer id) { 
		for(Cliente c : listaCliente) {
			if(c.getId().equals(id)) {
				return ResponseEntity.ok(c);				
			}
		}
		return ResponseEntity.noContent().build();		
	}


}
