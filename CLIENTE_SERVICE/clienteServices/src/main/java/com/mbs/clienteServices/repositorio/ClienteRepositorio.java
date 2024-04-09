package com.mbs.clienteServices.repositorio;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.mbs.clienteServices.entidades.Cliente;

@Repository
public class ClienteRepositorio {

	private Map<Long,Cliente> mapa =
			new HashMap<Long, Cliente>();
	
	public Long salvar(Cliente cliente) {
		Long id = new Random().nextLong();
		cliente.setId(id);
		mapa.put(id, cliente);
		return id;
	}

	public Cliente buscar(Long id) {
		return mapa.get(id);
	}

	public Cliente remover(Long id) {
		return mapa.remove(id);
	}

	public void atualizar(Cliente cliente) {
		mapa.replace(cliente.getId(), cliente);
	}
	
	
}
