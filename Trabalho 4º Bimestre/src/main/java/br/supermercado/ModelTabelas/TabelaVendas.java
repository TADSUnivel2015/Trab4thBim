package br.supermercado.ModelTabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.supermercado.Venda;

public class TabelaVendas extends AbstractTableModel {

	
	List<Venda> lista = new ArrayList<>();
	
	public TabelaVendas(List<Venda> lista) {
		this.lista = lista;
	}
	
	@Override
	public String getColumnName(int col) {
		
		switch (col) {
		case 0: return "Id venda";
		case 1: return "Id cliente";
		case 2: return "Data da venda";
		case 3: return "Hora da venda";
		case 4: return "Valor total gasto";
		}

		return null;
	}	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		switch (col) {
		case 0: return lista.get(row).getIdVenda();
		case 1: return lista.get(row).getIdClinte();
		case 2: return lista.get(row).getData();
		case 3: return lista.get(row).getHora();
		case 4: return lista.get(row).getTotalCompra();
		}
		
		return null;
	}

}
