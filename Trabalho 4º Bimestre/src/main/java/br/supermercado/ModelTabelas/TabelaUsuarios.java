package br.supermercado.ModelTabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.supermercado.Usuario;

/**
 * 
 * @author Alex Tezza
 * Dia 2 de novembro de 2015
 */

public class TabelaUsuarios extends AbstractTableModel{
	
	private List<Usuario> usuarios = new ArrayList<>();
	
	public TabelaUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	

	@Override
	public String getColumnName(int column) {
		
		switch (column) {
		case 0: return "Id";
		case 1: return "Nome Usuário";
		case 2: return "Id Cliente";
		case 3: return "Senha";
		}
		return null;
	}


	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return usuarios.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		switch (col) {
		case 0: return usuarios.get(row).getId();
		case 1: return usuarios.get(row).getNomeCliente();
		case 2: return usuarios.get(row).getIdCliente();
		case 3: return usuarios.get(row).getSenha();
		}
		return null;
	}

}
