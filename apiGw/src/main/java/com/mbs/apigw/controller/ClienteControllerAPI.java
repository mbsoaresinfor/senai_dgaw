package com.mbs.apigw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.apigw.comunicacao.ClienteServiceRoteamento;
import com.mbs.apigw.entidades.Cliente;

@RestController
@CrossOrigin(origins = "http://localhost:9005")
public class ClienteControllerAPI {

	@Autowired
	private ClienteServiceRoteamento 
		clienteServiceRoteamento;
	
	@RequestMapping(value = "/v1/cliente/existe_cliente/{id}",
			method = RequestMethod.GET)
	public ResponseEntity<Boolean> 
	existeCliente(@PathVariable Integer id){
		System.out.println("processando roteamento existeCliente " + id);
		return clienteServiceRoteamento
				.existeCliente(id);
	}
	
	@RequestMapping(value = "/v1/cliente",method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody Cliente cliente){
		System.out.println("processando roteamento salvar " );
		return clienteServiceRoteamento.salvar(cliente);
	}
	
	@RequestMapping(value = "/v1/cliente",method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listar() {
		System.out.println("processando roteamento listar " );
		return clienteServiceRoteamento.listar();
	}
	
	@RequestMapping(value = "/v1/cliente/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		System.out.println("processando roteamento deletar " );
		return clienteServiceRoteamento.deletar(id);
	}
	
}
