package br.supermercado;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ItemVenda {
	
	private int idItem;
	private int idVenda;
	private int idProduto;
	private String descricao;
	private String categoria;
	private BigDecimal vlrUnidade;
	private int qtd;
	private BigDecimal vlrTotal;
	
	List<ItemVenda> itensVenda = new ArrayList<ItemVenda>();

	public ItemVenda() {

	}

	public ItemVenda(int idItem, int idVenda, int idProduto, String descricao,
			String categoria, BigDecimal vlrUnidade, int qtd, BigDecimal vlrTotal,
			List<ItemVenda> itensVenda) {
		super();
		this.idItem = idItem;
		this.idVenda = idVenda;
		this.idProduto = idProduto;
		this.descricao = descricao;
		this.categoria = categoria;
		this.vlrUnidade = vlrUnidade;
		this.qtd = qtd;
		this.vlrTotal = vlrTotal;
		this.itensVenda = itensVenda;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getVlrUnidade() {
		return vlrUnidade;
	}

	public void setVlrUnidade(BigDecimal vlrUnidade) {
		this.vlrUnidade = vlrUnidade;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public BigDecimal getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}	

}
