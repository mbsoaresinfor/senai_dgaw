package com.mbs.enderecomvc.servico;

import java.util.List;

import com.mbs.enderecomvc.entidades.Endereco;
import com.mbs.enderecomvc.repositorio.EnderecoRepositorio;

public class EnderecoServico {

	private EnderecoRepositorio enderecoRepositorio =
			new EnderecoRepositorio();
	
	
	public String salvar(Endereco endereco) {
		if(endereco.getRua().trim().length() <=3 ) {
			return "Valor  invalido para campo rua";
		}
		if(endereco.getCep()
				.trim().contains("-")) {
			return "Cep invalido, não digite o caracter '-'";	
		}
		int resultado = enderecoRepositorio.salvar(endereco);
		if(resultado <= 0) {
			return "Erro ao salvar no banco de dados";
		}
		
		return "";
	}
	
	public List<Endereco> listar(){
		return enderecoRepositorio.listar();
	}
	
	public boolean remover(Integer id) {
		if(id == null) {
			return false;
		}
		return enderecoRepositorio.remover(id);		
	}
	
	public String buscar(Endereco endereco) {
		String resultado = enderecoRepositorio
				.buscar(endereco);
		if(resultado.isEmpty()) {
			return "NÃO FOI POSSIVEL "
					+ "LOCALIZAR NENHUM ENDERECO";
		}
		return resultado;
		
	}
	
}
