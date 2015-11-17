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
		case 1: return "IdProduto";
		case 2: return "IdVenda";
		case 3: return "Descrição";
		case 4: return "Categoria";
		case 5: return "Valor Unidade";
		case 6: return "Quantidade";
		case 7: return "Valor Total";
		}
		
		return null;
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public int getRowCount() {
		return itensVenda.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		switch (col) {
		case 0: return itensVenda.get(row).getId();
		case 1: return itensVenda.get(row).getIdProduto();
		case 2: return itensVenda.get(row).getIdVenda();
		case 3: return itensVenda.get(row).getDescricao();
		case 4: return itensVenda.get(row).getCategoria();
		case 5: return itensVenda.get(row).getVlrUnidade();
		case 6: return itensVenda.get(row).getQtd();
		case 7: return itensVenda.get(row).getVlrTotal();
		}
		
		return null;
	}

}
