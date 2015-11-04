package br.supermercado;

/**
 * 
 * @author Alex Tezza
 * Dia 27 de outubro de 2015
 * Hor�rio: 20:55
 
  	Classe respons�vel por possuir todos os atributos do Produto...
 */

import java.math.BigDecimal;

public class Produto {
	
	private int id;
	private String codBarras;
	private String categoria;
	private String descricao;
	private String unidade;
	private BigDecimal custo;
	private BigDecimal margemLucro;
	
	
	public Produto(){
		
	}
	
	
	public Produto(int id, String codBarras, String categoria,
			String descricao, String unidade, BigDecimal custo,
			BigDecimal margemLucro) {
		super();
		this.id = id;
		this.codBarras = codBarras;
		this.categoria = categoria;
		this.descricao = descricao;
		this.unidade = unidade;
		this.custo = custo;
		this.margemLucro = margemLucro;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String string) {
		this.categoria = string;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String string) {
		this.unidade = string;
	}
	public BigDecimal getCusto() {
		return custo;
	}
	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}
	public BigDecimal getMargemLucro() {
		return margemLucro;
	}
	public void setMargemLucro(BigDecimal margemLucro) {
		this.margemLucro = margemLucro;
	}
	@Override
	public String toString() {
		return descricao;
	}	

	
	
}
