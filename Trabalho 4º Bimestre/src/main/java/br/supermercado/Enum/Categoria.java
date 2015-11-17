package br.supermercado.Enum;

/**
 * 
 * @author Alex Tezza
 * Dia 27 de outubro de 2015
 * Horário: 21:00
 
  	Enum que contém todas as seções de um supermercado, que seram utilizadas
  	no momento de cadastrar o Produto...
 */

public enum Categoria {
	
	AÇOUGUE(""),
	VERDURA(""),
	FRUTA(""),
	FRIOS(""),
	LATICÍNIO(""),
	CONGELADO(""),
	MERCEARIA(""),
	LIMPEZA(""),
	HIGIENE(""),
	PERFUMARIA(""),
	BAZAR(""),
	BEBIDA(""),
	GÁS("");
	
	private Categoria(String nome) {
		this.nome = nome;
	}

	private String nome;

	public String getNome() {
		return nome;
	}


}
