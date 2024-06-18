package com.mbs.bff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.bff.comunicacao.ClienteService;

@RestController
public class BffClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/v1/cliente/existe-cliente/{id}",method = RequestMethod.GET)
	public ResponseEntity<Boolean> existeCliente(@PathVariable Long id){
		System.out.println("processando bff existe cliente " + id);
		return clienteService.existeCliente(id);
	}
	
	
}
