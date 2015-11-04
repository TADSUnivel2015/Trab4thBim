package br.supermercado.DAO;

import java.sql.SQLException;
import java.util.List;

public interface EstrururaDAO {
	
	public void abrirConexao() throws SQLException;
	
	public void gravar();
	
	public void atualizar();
	
	public void excluir();
	
	public List<Object> listar();
	
	public void fecharConexao() throws SQLException;

}
