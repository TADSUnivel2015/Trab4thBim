package br.supermercado.ModelTabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.supermercado.Produto;

public class TabelaProdutos extends AbstractTableModel{

	private List<Produto> produtos = new ArrayList<>();

	public TabelaProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String getColumnName(int column) {

		if (column == 0) 
			return "Id";
		if (column == 1) 
			return "Código de Barras";
		if (column == 2) 
			return "Categoria";
		if (column == 3) 
			return "Descrição";
		if (column == 4) 
			return "Unidade";
		if (column == 5) 
			return "Custo";
		if (column == 6) 
			return "Margem de Lucro %";
		if (column == 7)
			return "Valor final";
		return null;
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public int getRowCount() {
		return produtos.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0: return produtos.get(row).getId();
		case 1: return produtos.get(row).getCodBarras();
		case 2: return produtos.get(row).getCategoria();
		case 3: return produtos.get(row).getDescricao();
		case 4: return produtos.get(row).getUnidade();
		case 5: return produtos.get(row).getCusto();
		case 6: return produtos.get(row).getMargemLucro();
		case 7: return produtos.get(row).getValorFinal();
		}
		return null;
	}

}
