package br.com.mbs.servicos;

import java.util.ArrayList;
import java.util.List;

import br.com.mbs.modelos.Endereco;

public class EnderecoServico {

	List<Endereco> listaEndereco = new ArrayList<Endereco>();
	
	public boolean salvarEndereco(Endereco endereco) {
		
		if(endereco.getCep().equals("") ||
				   endereco.getNomeRua().equals("")) {
			System.out.println("ERROR AO SALVAR ENDERECO");
			return false;
		}else {			
			listaEndereco.add(endereco);
			System.out.println("SUCESSO AO SALVAR ENDERECO");
			return true;
		}
	}
	
}
