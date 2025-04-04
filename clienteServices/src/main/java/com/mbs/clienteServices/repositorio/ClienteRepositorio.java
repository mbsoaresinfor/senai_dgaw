package com.mbs.clienteServices.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mbs.clienteServices.entidades.Cliente;

@Repository
public class ClienteRepositorio {

	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	private static Integer id = 0;

	public Integer salvar(Cliente cliente) {
		cliente.setId(++id);
		listaCliente.add(cliente);
		return id;
	}

	public List<Cliente> listar() {
		return listaCliente;
	}

	public boolean deletar(Integer id) {
		boolean resultado = listaCliente.removeIf((obj) -> obj.getId().equals(id));
		return resultado;
	}

	public Boolean existeCliente(Integer id) {
		boolean resultado = listaCliente.stream().filter(obj -> obj.getId().equals(id)).findFirst().isPresent();
		return resultado;
	}

	public Cliente buscar(Integer id) {

		Optional<Cliente> resultado = listaCliente.stream().filter(obj -> obj.getId().equals(id)).findFirst();
		if (resultado.isEmpty()) {
			return null;
		}
		return resultado.get();
	}

	public void atualizar(Cliente cliente) {

		for (int i = 0; i < listaCliente.size(); i++) {
			Cliente cli = listaCliente.get(i);
			if (cli.getId().equals(cliente.getId())) {
				// atualiza cliente
				listaCliente.set(i, cliente);
			}
		}
	}
}
