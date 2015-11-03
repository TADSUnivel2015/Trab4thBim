package br.supermercado.Enum;

/**
 * 
 * @author Alex Tezza
 * Dia 27 de outubro de 2015
 * Horário: 20:06
 
  	Enum que contém a informação de gênero do Cliente...
 */

public enum Genero {
	
	M("Maculino"),
	F("Feminino");
	
	private String nome;

	public String getNome() {
		return nome;
	}

	private Genero(String nome) {
		this.nome = nome;
	}

}
