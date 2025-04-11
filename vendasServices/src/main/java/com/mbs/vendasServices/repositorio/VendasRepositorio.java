package com.mbs.vendasServices.repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mbs.vendasServices.entidades.Venda;

@Repository
public class VendasRepositorio {

	private static Integer id = 0;
	private HashMap<Integer,Venda> mapaVenda =
			new HashMap<Integer,Venda>();
	
	public Integer salvar(Venda venda) {
		Integer idNovo = id + 1;
		venda.setNumeroVenda(idNovo);
		mapaVenda.put(idNovo, venda);
		id = idNovo;
		return idNovo;
	}

	public List<Venda> listar() {		
		return new ArrayList<Venda>(mapaVenda.values());
	}
}
