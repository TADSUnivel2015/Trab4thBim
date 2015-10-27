package br.supermercado;

/**
 * 
 * @author Alex Tezza
 * Dia 27 de outubro de 2015
 * Hor�rio: 20:57
 
  	Enum que cont�m as unidades, que seram utilizados
  	no momento de cadastrar o Produto...
 */

public enum Unidade {
	
	KG("Kilograma"), 
	UN("Unidade"),
	PCT("Pacote"),
	CX("Caixa");
	
	private String nome;

	public String getNome() {
		return nome;
	}

	private Unidade(String nome) {
		this.nome = nome;
	}

}
