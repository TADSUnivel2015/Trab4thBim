package br.supermercado.ModelTabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import br.supermercado.Cliente;

/**
 * 
 * @author Alex Tezza
 * Dia 1 de novembro de 2015
 */

public class TabelaClientes extends AbstractTableModel{

	private static List<Cliente> clientes = new ArrayList<Cliente>();

	public TabelaClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


	@Override
	public String getColumnName(int column) {

		if (column == 0) 
			return "Id";
		if (column == 1) 
			return "Nome";
		if (column == 2) 
			return "Telefone";
		if (column == 3) 
			return "Endereço";
		if (column == 4) 
			return "Cidade";
		if (column == 5) 
			return "Estado";
		if (column == 6) 
			return "Email";
		if (column == 7) 
			return "Gênero";
		return null;
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public int getRowCount() {
		return clientes.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		switch (col) {
			case 0: return clientes.get(row).getId();
			case 1: return clientes.get(row).getNome();
			case 2: return clientes.get(row).getTelefone();
			case 3: return clientes.get(row).getEndereco();
			case 4: return clientes.get(row).getCidade();
			case 5: return clientes.get(row).getEstado();
			case 6: return clientes.get(row).getEmail();
			case 7: return clientes.get(row).getGenero();
		}
		return null;
	}

}
