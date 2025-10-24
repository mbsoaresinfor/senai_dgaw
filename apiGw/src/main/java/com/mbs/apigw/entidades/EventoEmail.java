package com.mbs.apigw.entidades;

public class EventoEmail {

	private Venda venda;
	private Cliente cliente;
	private String tituloEmail;
	private String textoEmail;
	
	
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getTituloEmail() {
		return tituloEmail;
	}
	public void setTituloEmail(String tituloEmail) {
		this.tituloEmail = tituloEmail;
	}
	public String getTextoEmail() {
		return textoEmail;
	}
	public void setTextoEmail(String textoEmail) {
		this.textoEmail = textoEmail;
	}
	
	
}
