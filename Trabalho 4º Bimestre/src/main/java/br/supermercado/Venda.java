package br.supermercado;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Venda {
	
	private int idVenda;
	private String nomeCliente;
	private int idClinte;
	private BigDecimal totalCompra;
	private BigDecimal vlrPagamento;
	private BigDecimal VlrTroco;
	private Date data;
	private String hora;

	public Venda() {
		
	}

	public Venda(int idVenda, String nomeCliente, int idClinte,
			BigDecimal totalCompra, BigDecimal vlrPagamento,
			BigDecimal vlrTroco, Date data, String hora) {
		this.idVenda = idVenda;
		this.nomeCliente = nomeCliente;
		this.idClinte = idClinte;
		this.totalCompra = totalCompra;
		this.vlrPagamento = vlrPagamento;
		VlrTroco = vlrTroco;
		this.data = data;
		this.hora = hora;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
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

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
}