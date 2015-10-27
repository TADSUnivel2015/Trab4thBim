package br.supermercado;

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
