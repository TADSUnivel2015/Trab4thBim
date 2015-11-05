package br.supermercado;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Venda {
	
	private int id;
	private String nomeCliente;
	private int idClinte;
	private String nomeProduto;
	private String idProduto;
	private BigDecimal totalCompra;
	private BigDecimal vlrPagamento;
	private BigDecimal VlrTroco;
	private Date data;
	
	private List<Venda> vendas;

	public Venda() {
		
	}

	public Venda(int id, String nomeCliente, int idClinte, String nomeProduto,
			String idProduto, BigDecimal totalCompra, BigDecimal vlrPagamento,
			BigDecimal vlrTroco, Date data, List<Venda> vendas) {
		
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.idClinte = idClinte;
		this.nomeProduto = nomeProduto;
		this.idProduto = idProduto;
		this.totalCompra = totalCompra;
		this.vlrPagamento = vlrPagamento;
		VlrTroco = vlrTroco;
		this.data = data;
		this.vendas = vendas;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getIdClinte() {
		return idClinte;
	}

	public void setIdClinte(int idClinte) {
		this.idClinte = idClinte;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public BigDecimal getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(BigDecimal totalCompra) {
		this.totalCompra = totalCompra;
	}

	public BigDecimal getVlrPagamento() {
		return vlrPagamento;
	}

	public void setVlrPagamento(BigDecimal vlrPagamento) {
		this.vlrPagamento = vlrPagamento;
	}

	public BigDecimal getVlrTroco() {
		return VlrTroco;
	}

	public void setVlrTroco(BigDecimal vlrTroco) {
		VlrTroco = vlrTroco;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

}