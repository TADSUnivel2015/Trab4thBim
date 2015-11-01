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
	private BigDecimal codBarras;
	private String categoria;
	private String descricao;
	private String unidade;
	private BigDecimal custo;
	private BigDecimal margemLucro;
	private BigDecimal valorFinal;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(BigDecimal codBarras) {
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
	public BigDecimal getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}	

}
