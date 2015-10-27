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
	
	private String id;
	private String idCliente;
	private String senha;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
