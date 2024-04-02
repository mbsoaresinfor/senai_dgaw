package com.mbs.clienteServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.clienteServices.entidades.Cliente;
import com.mbs.clienteServices.servicos.ClienteServico;

@RestController
public class ClienteControllerAPI {

	@Autowired
	private ClienteServico clienteServico;
	
	@RequestMapping(value = "/v1/cliente",method = RequestMethod.POST)
	public ResponseEntity<Long> salvar(@RequestBody Cliente cliente) {
		System.out.println("executando salvar " + cliente);
		Long id = clienteServico.salvar(cliente);
		return ResponseEntity.ok(id);
	}
	
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
	
	public boolean remover(Integer id) {
		
		return true;
	}
	
	public boolean atualizar(Cliente cliente) {
		return true;
	}
}
