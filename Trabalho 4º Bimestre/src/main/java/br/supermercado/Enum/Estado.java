package br.supermercado.Enum;

/**
 * 
 * @author Alex Tezza
 * Dia 27 de outubro de 2015
 * Hor�rio: 20:12
 
  	Enum que cont�m todos os estados Brasileiros, que seram utilizados
  	no momento de cadastrar o Cliente...
 */

public enum Estado {
	
	AC	("Acre"),
	AL	("Alagoas"),
	AP	("Amap�"),
	AM	("Amazonas"),
	BA	("Bahia"),
	CE	("Cear�"),
	DF	("Distrito Federal"),
	ES	("Esp�rito Santo"),
	GO	("Goi�s"),
	MA	("Maranh�o"),
	MT	("Mato Grosso"),
	MS	("Mato Grosso do Sul"),
	MG	("Minas Gerais"),
	PA	("Par�"),
	PB	("Para�ba"),
	PR	("Paran�"),
	PE	("Pernambuco"),
	PI	("Piau�"),
	RJ	("Rio de Janeiro"),
	RN	("Rio Grande do Norte"),
	RS	("Rio Grande do Sul"),
	RO	("Rond�nia"),
	RR	("Roraima"),
	SC	("Santa Catarina"),
	SP	("S�o Paulo"),
	SE	("Sergipe"),
	TO	("Tocantins");

	private String nome;

	public String getNome() {
		return nome;
	}

	private Estado(String nome) {
		this.nome = nome;
	}
}
