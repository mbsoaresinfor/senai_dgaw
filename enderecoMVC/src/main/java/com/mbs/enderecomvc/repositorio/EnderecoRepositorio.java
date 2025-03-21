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
}
