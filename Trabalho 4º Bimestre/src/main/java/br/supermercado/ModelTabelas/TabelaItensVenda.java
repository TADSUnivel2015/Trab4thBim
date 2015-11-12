package br.supermercado.ModelTabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.supermercado.ItemVenda;

public class TabelaItensVenda extends AbstractTableModel {
	
	List<ItemVenda> itensVenda = new ArrayList<ItemVenda>();
	
	
	
	public TabelaItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

	@Override
	public String getColumnName(int col) {
		
		switch (col) {
		case 0: return "Id";
		case 1: return "IdVenda";
		case 2: return "Descrição";
		case 3: return "Categoria";
		case 4: return "Valor Unidade";
		case 5: return "Quantidade";
		case 6: return "Valor Total";
		}
		
		return null;
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return itensVenda.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		switch (col) {
		case 0: return itensVenda.get(row).getIdItem();
		case 1: return itensVenda.get(row).getIdVenda();
		case 2: return itensVenda.get(row).getDescricao();
		case 3: return itensVenda.get(row).getCategoria();
		case 4: return itensVenda.get(row).getVlrUnidade();
		case 5: return itensVenda.get(row).getQtd();
		case 6: return itensVenda.get(row).getVlrTotal();
		}
		
		return null;
	}

}
