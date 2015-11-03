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
	
	ACOUGUE("A�ougue"),
	VERDURA("Verduras"),
	FRUTA("Frutas"),
	FRIOeLATICINIO("Frios e Latic�nios"),
	CONGELADO("Congelados"),
	MERCEARIA("Mercearia"),
	LIMPEZA("Limpeza"),
	HIGIENEePERFUMARIA("Higiene e Perfumaria"),
	BAZAR("Bazar"),
	BEBIDA("Bebidas"),
	GAS("G�s");
	
	private String nome;

	public String getNome() {
		return nome;
	}

	private Categoria(String nome) {
		this.nome = nome;
	}
	

}
