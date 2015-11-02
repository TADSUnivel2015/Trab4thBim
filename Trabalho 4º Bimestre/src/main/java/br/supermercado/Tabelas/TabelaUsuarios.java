package br.supermercado.Tabelas;

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
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
