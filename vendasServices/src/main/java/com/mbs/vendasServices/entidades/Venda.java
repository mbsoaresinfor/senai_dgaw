package com.mbs.vendasServices.entidades;

import java.util.Date;

public class Venda {

	private Integer numeroVenda;
	private Integer codCliente;
	private String nomeProduto;
	private Double precoProduto;
	private Date dataVenda;
	private Integer quantidade;
	
	public Integer getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public Integer getNumeroVenda() {
		return numeroVenda;
	}
	public void setNumeroVenda(Integer numeroVenda) {
		this.numeroVenda = numeroVenda;
	}
	public Double getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
	
	
}
