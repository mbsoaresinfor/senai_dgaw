package com.mbs.clienteServices.servicos;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
	
	public boolean remover(Long id) {
		Cliente cliente =  clienteRepositorio.remover(id);
		if(Objects.isNull(cliente)) {
			return false;
		}else {
			return true;
		}
	}
	
	public void atualizar(Cliente cliente) {
		if(cliente.getNome().equals("")) {
			throw new IllegalArgumentException("nome esta vazio");
		}
		clienteRepositorio.atualizar(cliente);
	}
	
	public List<Cliente> buscarPorNome(String nome){
		return  clienteRepositorio
		.retornaLista()
		.stream()
		.filter(item -> item.getNome().equals(nome))
		.collect(Collectors.toList());
	}
	
}
