package br.com.mbs.entrada;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.mbs.modelos.ProdutoModelo;
import br.com.mbs.servicos.ProdutoServico;

public class ProdutoView {

	public static void main(String[] args) {

		while (true) {
			String nome = JOptionPane.showInputDialog("Digite o nome do produto");

			String preco = JOptionPane.showInputDialog("Digite o preço do produto");

			ProdutoModelo produtoModelo = new ProdutoModelo();
			produtoModelo.setNome(nome);
			produtoModelo.setPreco(Float.parseFloat(preco));

			ProdutoServico servico = new ProdutoServico();
			servico.salvar(produtoModelo);

			ArrayList<ProdutoModelo> listagem = servico.listagem();
			for (ProdutoModelo produto : listagem) {
				System.out.println(produto.getNome());
				System.out.println(produto.getPreco());
			}

			for (int i = 0; i < listagem.size(); i++) {
				ProdutoModelo produto = listagem.get(i);
				System.out.println(produto.getNome());
				System.out.println(produto.getPreco());
			}

		}

	}

}
