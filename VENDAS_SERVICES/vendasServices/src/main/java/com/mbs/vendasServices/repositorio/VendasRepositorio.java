package com.mbs.vendasServices.repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mbs.vendasServices.entidades.Venda;

@Repository
public class VendasRepositorio {

	private Map<Integer,Venda> mapaVendas  = new HashMap<Integer, Venda>();
	private static int id;
	
	public void salvar(Venda venda) {
		System.out.println("repositorio: salvar venda");
		mapaVendas.put(id, venda);
		id++;
	}
	
	public ArrayList<Venda> listar(){
		return new ArrayList<Venda>(mapaVendas.values());
	}
}
