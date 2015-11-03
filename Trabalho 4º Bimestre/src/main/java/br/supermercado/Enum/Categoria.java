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
	
	ACOUGUE("Açougue"),
	VERDURA("Verduras"),
	FRUTA("Frutas"),
	FRIOeLATICINIO("Frios e Laticínios"),
	CONGELADO("Congelados"),
	MERCEARIA("Mercearia"),
	LIMPEZA("Limpeza"),
	HIGIENEePERFUMARIA("Higiene e Perfumaria"),
	BAZAR("Bazar"),
	BEBIDA("Bebidas"),
	GAS("Gás");
	
	private String nome;

	public String getNome() {
		return nome;
	}

	private Categoria(String nome) {
		this.nome = nome;
	}
	

}
