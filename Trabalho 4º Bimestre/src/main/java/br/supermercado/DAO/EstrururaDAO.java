package br.supermercado.DAO;

import java.sql.SQLException;
import java.util.List;

import br.supermercado.Cliente;

public interface EstrururaDAO <T>{
	
	public void abrirConexao() throws SQLException, ClassNotFoundException;
	
	public void gravar(T objeto) throws SQLException;
	
	public void atualizar(T objeto) throws SQLException;
	
	public void excluir(int objeto) throws SQLException;
	
	public List<T> listar(String sql) throws SQLException;

}
