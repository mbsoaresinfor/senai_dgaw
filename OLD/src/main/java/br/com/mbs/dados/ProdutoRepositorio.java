package br.com.mbs.dados;

import java.util.ArrayList;

import br.com.mbs.modelos.ProdutoModelo;

public class ProdutoRepositorio {

	ArrayList<ProdutoModelo> lista = new ArrayList<>();
	
	public void salvar(ProdutoModelo produtoModelo) {
		lista.add(produtoModelo);
		System.out.println("produto salvo com sucesso");
	}
	
	public ArrayList<ProdutoModelo> listar(){
		return lista;
	}
	
}
