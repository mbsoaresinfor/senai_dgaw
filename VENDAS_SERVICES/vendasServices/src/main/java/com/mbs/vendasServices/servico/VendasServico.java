package com.mbs.vendasServices.servico;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mbs.vendasServices.entidades.Venda;
import com.mbs.vendasServices.repositorio.VendasRepositorio;

@Service
public class VendasServico {

	@Autowired
	private VendasRepositorio vendasRepositorio;
	
	public void salvarVendas(Venda venda) {
		if(venda.getPreco() < 0) {
			// gerar um errro aqui
		}
		if(venda.getQuantidade() > 1000) {
			// gerar um erro devido a regra de negocio
		}
		System.out.println("Servico: salvar venda");
		vendasRepositorio.salvar(venda);
	}
	
	public ArrayList<Venda> listarVendas(){
		return vendasRepositorio.listar();
	}
	
	public Double totalVendas() {
		Double totalVenda = 0d;
		for(Venda item: vendasRepositorio.listar()) {
			totalVenda= totalVenda 
					+ item.getTotalVenda();
		}
		return totalVenda;
	}

	public Integer getMaiorVenda() {
		Double maior = 0d;
		Integer id = 0;
		for(Venda venda: vendasRepositorio.listar()) {
			if(maior < venda.getTotalVenda()) {
				maior = venda.getTotalVenda();
				id = venda.getCodCliente();
			}
		}
		return id;
	}
}
