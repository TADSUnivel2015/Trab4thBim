package br.supermercado.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.supermercado.Produto;

public class ProdutoDAO implements EstrururaDAO<Produto>{

	private Connection con = null;
	
	@Override
	public void abrirConexao() throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/Trabalho4thBim";
		String user = "postgres";
		String pass = "tezza";
		
		con = DriverManager.getConnection(url, user, pass);
	}

	
	@Override
	public void gravar(Produto objeto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void atualizar(Produto objeto) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void excluir(int objeto) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public List<Produto> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void fecharConexao() throws SQLException {
		con.close();		
	}



}