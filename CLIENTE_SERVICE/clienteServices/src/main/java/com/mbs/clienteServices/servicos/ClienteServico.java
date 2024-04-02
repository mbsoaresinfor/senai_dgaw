package com.mbs.clienteServices.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mbs.clienteServices.entidades.Cliente;
import com.mbs.clienteServices.repositorio.ClienteRepositorio;

@Service
public class ClienteServico {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	public Long salvar( Cliente cliente) {
		if(cliente.getNome().equals("")) {
			throw new IllegalArgumentException("nome esta vazio");
		}
		// poderia aqui ter outras validacoes
		return clienteRepositorio.salvar(cliente);
	}
	
	public Cliente buscar(Long id) {
		return clienteRepositorio.buscar(id);
	}
	
	public void remover(Integer id) {
		
	}
	
	public void atualizar(Cliente cliente) {
		
	}
	
}
