package br.supermercado;

/**
 * 
 * @author Alex Tezza
 * Dia 27 de outubro de 2015
 * Horário: 20:08
 
  	Classe responsável por possuir atributos de Usuários, que seram adicionados aos atributos dos Clientes,
 	pois, todo Usuário é um Cliente...
 */

public class Usuario {
	
	private int id;
	private String nomeCliente;
	private int idCliente;	
	private String senha;
	
	
	public Usuario(){
		
	}
	
	public Usuario(String nomeCliente, int idCliente, String senha) {
		
		this.nomeCliente = nomeCliente;
		this.idCliente = idCliente;
		this.senha = senha;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
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
