package br.supermercado;

public enum Estado {
	
	
	PR("Paran�"), //
	SP("S�o Paulo"), //
	SC("Santa Catarina"); //

	private String nome;

	public String getNome() {
		return nome;
	}

	private Estado(String nome) {
		this.nome = nome;
	}
}
