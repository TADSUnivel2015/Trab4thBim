package br.supermercado;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Venda {
	
	private int id;
	private String nomeCliente;
	private String nomeProduto;
	private BigDecimal totalCompra;
	private BigDecimal vlrPagamento;
	private BigDecimal VlrTroco;
	
	private List<Venda> vendas;

}
