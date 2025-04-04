package com.mbs.clienteServices.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbs.clienteServices.entidades.Cliente;
import com.mbs.clienteServices.repositorio.ClienteRepositorio;

@Service
public class ClienteServico {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	public Integer salvar( Cliente cliente) 
		throws Exception{
		// simples validacao de negocio
		if(cliente.getNome() == null 
				|| ( cliente.getNome() != null 
				&& cliente.getNome().length() <=2 )){
			throw new Exception("Nome do cliente deve ter no minimo 3 caracteres");
		}
		 
		return clienteRepositorio.salvar(cliente);
		
	}
	
	
	public List<Cliente> listar() {		
		return clienteRepositorio.listar();
	}
	

	public boolean deletar( Integer id) {
		return clienteRepositorio.deletar(id);		
	}
	
	public Boolean existeCliente(Integer id) {		
		return clienteRepositorio.existeCliente(id);
	}
	
	
	public Cliente buscar( Integer id) {
		System.out.println("buscar cliente id " + id );
		return clienteRepositorio.buscar(id);		
	}
	
	
	public void atualizar( Cliente cliente) throws Exception{
		System.out.println("executando atualizar " + cliente);
		if(cliente.getId() == null) {
			throw new Exception("cliente deve ter um ID");
		}
		
		// simples validacao de negocio
		if(cliente.getNome() == null || ( cliente.getNome() != null && cliente.getNome().length() <=2 )){			
			throw new Exception("Nome do cliente deve ter no minimo 3 caracteres");
		}
		clienteRepositorio.atualizar(cliente);		
	}
}
