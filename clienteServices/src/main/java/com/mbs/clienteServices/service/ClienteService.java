package com.mbs.clienteServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mbs.clienteServices.entidades.Cliente;
import com.mbs.clienteServices.repository.ClienteRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;// injeção de dependência 
	
	public String salvar(Cliente cliente) throws Exception {
		System.out.println("executando salvar na service: " + cliente);
		
		// simples validacao de negocio
		if(cliente.getNome() == null || ( cliente.getNome() != null && cliente.getNome().length() <=2 )){
			throw new Exception("Nome do cliente deve ter "
					+ "no minimo 3 caracteres");
		}
		
		return clienteRepository.salvar(cliente);		
	}
		
	public List<Cliente> listar() {
		return clienteRepository.listar();
	}
	
	
	public boolean deletar(Integer id) {
		return clienteRepository.deletar(id);
	}
	
	
	public boolean atualizar(Cliente cliente) {
		return clienteRepository.atualizar(cliente);		
	}
	
	
	public Boolean existeCliente(Integer id) { 
		return clienteRepository.existeCliente(id);				
	}
	
	
	public Cliente buscarCliente(Integer id) { 
		return clienteRepository.buscarCliente(id);			
	}

}
