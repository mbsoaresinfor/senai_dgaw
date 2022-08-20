package br.com.mbs.entrada;

import javax.swing.JOptionPane;

import br.com.mbs.modelos.ProdutoModelo;
import br.com.mbs.servicos.ProdutoServico;

public class ProdutoView {

	public static void main(String[] args) {
		
	String nome= JOptionPane.
		showInputDialog("Digite o nome do produto");
	
	String preco= JOptionPane.
			showInputDialog("Digite o preço do produto");
	
	ProdutoModelo produtoModelo = new ProdutoModelo();
	produtoModelo.setNome(nome);
	produtoModelo.setPreco(Float.parseFloat(preco));

	ProdutoServico servico = new ProdutoServico();
	servico.salvar(produtoModelo);
	
	}

}
