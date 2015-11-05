package br.supermercado.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.supermercado.Usuario;
import br.supermercado.Venda;

public class VendaDAO implements EstrururaDAO<Venda>{

	private Connection conexao = null;
	
	@Override
	public void abrirConexao() throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/Trabalho4thBim";
		String user = "postgres";
		String pass = "tezza";
		
		conexao = DriverManager.getConnection(url, user, pass);
		
	}

	
	@Override
	public void gravar(Venda venda) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void atualizar(Venda venda) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public List<Venda> listar(String sql) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void fecharConexao() throws SQLException {
		conexao.close();
	}
	
	

}