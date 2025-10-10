package com.mbs.vendasServices.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbs.vendasServices.entidades.Venda;
import com.mbs.vendasServices.repositorio.VendasRepositorio;

@Service
public class VendasService {

	@Autowired
	private VendasRepositorio vendasRepositorio;
	
	public Integer salvar(Venda venda) throws Exception {
		validacao(venda);
		venda.setDataVenda(new Date());
		return vendasRepositorio.salvar(venda);
	}

	private void validacao(Venda venda) throws Exception {
		// validacoes
		if(venda.getCodCliente() == null) {
			throw new Exception("cod cliente invalido");
		}
		if(venda.getNomeProduto() == null ||
			venda.getNomeProduto().equals("")){
			throw new Exception("nome produto invalido");
		}
		
		if(venda.getQuantidade() == null )	{
			throw new Exception("quantidadevenda invalido");
		}
		
		if(venda.getPrecoProduto() == null )	{
			throw new Exception("preco venda invalido");
		}
	}

	public List<Venda> listar() {		
		return vendasRepositorio.listar();
	}

	public Double totalValoresVenda() {
		Double somador = 0d;
		for(Venda venda : vendasRepositorio.listar()) {
			Double totalVenda = venda.getPrecoProduto() * 
								venda.getQuantidade();
			somador = somador + totalVenda;
			
		}
		return somador;
	}
}
