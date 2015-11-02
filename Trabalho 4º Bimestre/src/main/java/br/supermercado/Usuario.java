package br.supermercado;

/**
 * 
 * @author Alex Tezza
 * Dia 27 de outubro de 2015
 * Hor�rio: 20:08
 
  	Classe respons�vel por possuir atributos de Usu�rios, que seram adicionados aos atributos dos Clientes,
 	pois, todo Usu�rio � um Cliente...
 */

public class Usuario {
	
	private int id;
	private String idCliente;
	private String nomeCliente;
	private String senha;
	
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return this.nomeCliente;
	}
	

}
