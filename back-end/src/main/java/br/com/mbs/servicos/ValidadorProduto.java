package br.com.mbs.servicos;

import br.com.mbs.modelos.ProdutoModelo;

public class ValidadorProduto {

	public boolean 
		validar(ProdutoModelo produtoModelo) {
		
		if(produtoModelo.getNome().equals("")) {
			return false;
		}
		if(produtoModelo.getPreco() < 0 ||
				produtoModelo.getPreco() > 1000) {
			return false;
		}
		return true;
			
	}
}
