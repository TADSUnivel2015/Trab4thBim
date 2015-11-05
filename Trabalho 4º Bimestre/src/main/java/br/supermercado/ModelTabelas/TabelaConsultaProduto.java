package br.supermercado.ModelTabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import br.supermercado.Produto;

public class TabelaConsultaProduto extends AbstractTableModel {

	List<Produto> produtos = new ArrayList<>();

	public TabelaConsultaProduto(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String getColumnName(int column) {

		if (column == 0) 
			return "Id Produto";
		if (column == 1) 
			return "Nome Produto";
		if (column == 2)
			return "Valor";

		return null;
	}

	@Override
	public int getColumnCount() {

		return 3;
	}

	@Override
	public int getRowCount() {
		return produtos.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		switch (col) {
		case 0: return produtos.get(row).getId();
		case 1: return produtos.get(row).getDescricao();
		case 2: return produtos.get(row).getCusto();
		}
		return null;
		
	}
}
