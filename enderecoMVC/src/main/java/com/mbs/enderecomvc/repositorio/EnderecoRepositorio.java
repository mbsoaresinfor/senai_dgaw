package com.mbs.enderecomvc.repositorio;

import java.util.ArrayList;
import java.util.List;

import com.mbs.enderecomvc.entidades.Endereco;

public class EnderecoRepositorio {
	private static int id = 0;
	private List<Endereco> listaEndereco 
	= new ArrayList<Endereco>();
	
	public int salvar(Endereco endereco) {
		endereco.setCodigo(++id);
		listaEndereco.add(endereco);
		return id;
	}
	
	public List<Endereco> listar(){
		return listaEndereco;
	}
	
	public boolean remover(Integer id) {
		return listaEndereco.removeIf((obj)-> 
		obj.getCodigo()
		.equals(id));
	}
	
	public String buscar(Endereco endereco) {
		StringBuilder resultado = new StringBuilder();
		
		for (Endereco end : listaEndereco) {
			if(end.getCodigo()
					.equals(endereco.getCodigo())) {
				resultado
				.append("cod:")
				.append(end.getCodigo())
				.append("rua: ")
				.append(end.getRua())
				.append("-----");				
			}else if(end.getCep()
					.equals(endereco.getCep())) {
				resultado
				.append("cep:")
				.append(end.getCep())
				.append("rua: ")
				.append(end.getRua())
				.append("-----");
			}
		}
		return resultado.toString();
	}
	
}
