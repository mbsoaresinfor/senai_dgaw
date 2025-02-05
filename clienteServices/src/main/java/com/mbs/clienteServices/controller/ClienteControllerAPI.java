package com.mbs.clienteServices.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.mbs.clienteServices.entidades.Cliente;

@Controller
public class ClienteControllerAPI {

	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	private static int id = 0;
	
	public ResponseEntity<Integer> salvar(@RequestBody Cliente cliente) {
		System.out.println("executando salvar " + cliente);
		cliente.setId(++id);
		listaCliente.add(cliente);
		return ResponseEntity.ok(id);
	}
}
