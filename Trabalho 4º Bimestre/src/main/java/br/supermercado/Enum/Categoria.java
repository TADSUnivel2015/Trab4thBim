package br.supermercado.Enum;

/**
 * 
 * @author Alex Tezza
 * Dia 27 de outubro de 2015
 * Hor�rio: 21:00
 
  	Enum que cont�m todas as se��es de um supermercado, que seram utilizadas
  	no momento de cadastrar o Produto...
 */

public enum Categoria {
	
	A�OUGUE(""),
	VERDURA(""),
	FRUTA(""),
	FRIOS(""),
	LATIC�NIO(""),
	CONGELADO(""),
	MERCEARIA(""),
	LIMPEZA(""),
	HIGIENE(""),
	PERFUMARIA(""),
	BAZAR(""),
	BEBIDA(""),
	G�S("");
	
	private Categoria(String nome) {
		this.nome = nome;
	}

	private String nome;

	public String getNome() {
		return nome;
	}


}
