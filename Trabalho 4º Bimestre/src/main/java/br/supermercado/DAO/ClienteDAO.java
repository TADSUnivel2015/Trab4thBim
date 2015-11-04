package br.supermercado.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ClienteDAO implements EstrururaDAO{

	private Connection con = null;
	
	@Override
	public void abrirConexao() throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/Trabalho4thBim";
		String user = "postgres";
		String pass = "tezza";
		
		con = DriverManager.getConnection(url, user, pass);
		
	}

	@Override
	public void gravar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Object> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fecharConexao() throws SQLException {
		con.close();
	}

}