package br.supermercado;

/**
 * 
 * @author Alex Tezza
 * Dia 27 de outubro de 2015
 * Horário: 20:05
 
  	Classe responsável por possuir todos os atributos de Cliente...
 */

public class Cliente {
	
	private int id;
	private String nome;
	private String telefone;
	private String endereco;
	private String cidade;
	private String estado;
	private String email;
	private String genero;
	
	public Cliente(){
		
	}
	
	
	public Cliente(String nome, String telefone, String endereco,
			String cidade, String estado, String email, String genero) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.email = email;
		this.genero = genero;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return nome + "         Id:       " + id;
	}
	
}
