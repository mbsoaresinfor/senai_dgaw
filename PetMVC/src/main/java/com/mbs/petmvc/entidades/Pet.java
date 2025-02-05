package com.mbs.petmvc.entidades;

public class Pet {

	private Integer codPet;
	private String nome;
	private String raca;
	private int idade;
	public Integer getCodPet() {
		return codPet;
	}
	public void setCodPet(Integer codPet) {
		this.codPet = codPet;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
