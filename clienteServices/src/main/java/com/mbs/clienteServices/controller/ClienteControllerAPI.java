package com.mbs.clienteServices.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mbs.clienteServices.entidades.Cliente;

@Controller
@CrossOrigin(origins = "http://localhost:9005")
public class ClienteControllerAPI {

	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	private static int id = 0;
	
	
	@RequestMapping(value = "/v1/cliente",method = RequestMethod.POST)
	public ResponseEntity<Integer> salvar(@RequestBody Cliente cliente) {
		System.out.println("executando salvar " + cliente);
		cliente.setId(++id);
		listaCliente.add(cliente);
		return ResponseEntity.ok(id);
	}
}
