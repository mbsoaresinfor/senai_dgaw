package br.com.mbs.modelos;

import java.io.Serializable;

public class Pessoa implements Serializable {

	private  String id;
	private  String nome;
	private Float salario = 0f;
	
	public Float getSalario() {
		return salario;
	}
	public void setSalario(Float salario) {
		this.salario = salario;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
