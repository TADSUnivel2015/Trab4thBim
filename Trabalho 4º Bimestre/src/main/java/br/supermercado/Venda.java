package br.supermercado;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
	
	private int idVenda;
	private String nomeCliente;
	private int idClinte;
	private String totalCompra;
	private Date data;
	private String hora;

	public Venda() {
		
	}

	public Venda(int idVenda, String nomeCliente, int idClinte,
			String totalCompra, Date data, String hora) {
		super();
		this.idVenda = idVenda;
		this.nomeCliente = nomeCliente;
		this.idClinte = idClinte;
		this.totalCompra = totalCompra;
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

	public String getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(String totalCompra) {
		this.totalCompra = totalCompra;
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