package br.supermercado.ModelTabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import br.supermercado.Cliente;

public class TabelaConsultaCliente extends AbstractTableModel {

	List<Cliente> cliente = new ArrayList<>();

	public TabelaConsultaCliente(List<Cliente> usuarios) {
		this.cliente = usuarios;
	}

	@Override
	public String getColumnName(int column) {

		if (column == 0) 
			return "Id Cliente";
		if (column == 1) 
			return "Nome Cliente";

		return null;
	}

	@Override
	public int getColumnCount() {

		return 2;
	}

	@Override
	public int getRowCount() {
		return cliente.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		switch (col) {
		case 0: return cliente.get(row).getId();
		case 1: return cliente.get(row).getNome();
		}
		return null;
		
	}
}
