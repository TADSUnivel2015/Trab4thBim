package br.supermercado;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Venda {
	
	private int id;
	private String nomeCliente;
	private String nomeProduto;
	private BigDecimal totalCompra;
	private BigDecimal vlrPagamento;
	private BigDecimal VlrTroco;
	private Date data;
	
	private List<Venda> vendas;

}
