package br.supermercado.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.supermercado.Produto;
import br.supermercado.Usuario;

public class UsuarioDAO implements EstrururaDAO<Usuario>{
	
	private Connection con = null;
	
	@Override
	public void abrirConexao() throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/Trabalho4thBim";
		String user = "postgres";
		String pass = "tezza";
		
		con = DriverManager.getConnection(url, user, pass);
		
	}

	
	@Override
	public void gravar(Usuario objeto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void atualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fecharConexao() throws SQLException {
		con.close();		
	}

}