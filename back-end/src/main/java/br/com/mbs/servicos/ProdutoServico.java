package br.com.mbs.servicos;

import br.com.mbs.dados.ProdutoRepositorio;
import br.com.mbs.modelos.ProdutoModelo;

public class ProdutoServico {

	ValidadorProduto validadorProduto = 
				new ValidadorProduto();
	
	ProdutoRepositorio repositorio =
			new ProdutoRepositorio();
	
	public boolean salvar(ProdutoModelo produtoModelo) {
		
		boolean resultado = validadorProduto.
				validar(produtoModelo);
		if(resultado) {
			// cchmar a camada de dados.
			repositorio.salvar(produtoModelo);
			return true;
		}else {
			System.out.println("error ao salvar o produto");
			return false;
		}
	}
	
}
