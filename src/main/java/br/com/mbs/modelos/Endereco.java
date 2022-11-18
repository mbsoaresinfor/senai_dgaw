package br.com.mbs.modelos;

import java.io.Serializable;

public class Endereco implements Serializable {

	private String cep;
	private String nomeRua;
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNomeRua() {
		return nomeRua;
	}
	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}
	
	
}
