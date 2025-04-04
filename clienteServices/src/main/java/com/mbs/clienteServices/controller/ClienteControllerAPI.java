package com.mbs.clienteServices.controller;

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

import com.mbs.clienteServices.entidades.Cliente;
import com.mbs.clienteServices.servico.ClienteServico;

@Controller
@CrossOrigin(origins = "http://localhost:9005")
public class ClienteControllerAPI {

	@Autowired
	private ClienteServico clienteServico ;
	
	
	@RequestMapping(value = "/v1/cliente",method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody Cliente cliente) {
		System.out.println("executando salvar " + cliente);
		
		try {
			Integer id = clienteServico.salvar(cliente);
			return ResponseEntity.ok(id.toString());
		}catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/v1/cliente",method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listar() {
		
		System.out.println("executando listar " );
		return ResponseEntity
				.ok(clienteServico.listar());
	}
	
	@RequestMapping(value = "/v1/cliente/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		System.out.println("executando deletar de cliente id " + id );
		// deleta o cliente pelo id, caso ele exista
		
		boolean resultado = clienteServico.deletar(id);
		if(resultado == true) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		// retorna a lista de clientes
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	@RequestMapping(value = "/v1/cliente/existe_cliente/{id}",
			method = RequestMethod.GET)
	public ResponseEntity<Boolean> existeCliente(@PathVariable Integer id) {

		System.out.println("existe cliente id " + id );
		boolean resultado = clienteServico.existeCliente(id);
		return ResponseEntity.ok(resultado);
	}
	
	@RequestMapping(value = "/v1/cliente/{id}",
			method = RequestMethod.GET)
	public ResponseEntity<Cliente> buscar(@PathVariable Integer id) {

		System.out.println("buscar cliente id " + id );
		Cliente resultado = clienteServico.buscar(id);
		if(resultado != null) {
			return ResponseEntity.ok(resultado);
		}else {
			return ResponseEntity.
					status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@RequestMapping(value = "/v1/cliente",method = RequestMethod.PUT)
	public ResponseEntity<String> atualizar(@RequestBody Cliente cliente) {
		System.out.println("executando atualizar " + cliente);
		
		try {
			clienteServico.atualizar(cliente);
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	}

	
}
